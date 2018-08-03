package kr.co.ldcc.lobdingmachine.controller.app;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import kr.co.ldcc.lobdingmachine.dao.InventoryDao;
import kr.co.ldcc.lobdingmachine.dao.MemberDao;
import kr.co.ldcc.lobdingmachine.dao.ProductDao;
import kr.co.ldcc.lobdingmachine.dao.SampleDao;
import kr.co.ldcc.lobdingmachine.model.common.ApiResult;
import kr.co.ldcc.lobdingmachine.model.kakao.Body;
import kr.co.ldcc.lobdingmachine.model.kakao.Result;
import kr.co.ldcc.lobdingmachine.model.member.Member;
import kr.co.ldcc.lobdingmachine.model.product.Product;
import kr.co.ldcc.lobdingmachine.service.TurnArduinoService;

@RestController
@RequestMapping("/app/sample")
public class SampleController {

	@Autowired TurnArduinoService service;
	@Autowired RestTemplate restTemplate;
	@Autowired MemberDao memberDao;
	@Autowired SampleDao sampleDao;
	@Autowired ProductDao productDao;
	@Autowired InventoryDao inventoryDao;
	
	@RequestMapping("/auth")
	public ApiResult<Integer> authKakao(String phoneNumber, int productIdx) {
		Member member = memberDao.getMemberByPhoneNumber(phoneNumber);
		if(member == null)
			return new ApiResult<>(100, "등록되지 않은 계정입니다.");
		Product p = productDao.getDetail(productIdx);
		if(p.getSample() <= 0)
			return new ApiResult<>(200, "샘플이 소진되었습니다.");
		int totalSampleCoupon = getTotalSampleCoupon(member.getRank(), sampleDao.getUsedSampleCoupon(member.getIdx()));
		if(totalSampleCoupon <= 0)
			return new ApiResult<>(300, "받을 수 있는 샘플 갯수를 초과하였습니다.");
		int code = getRandomCode();
		sendKakao(phoneNumber, "[롭딩머신] 인증번호 : " + code);
		return new ApiResult<>(0, "SUCCESS", code);
	}

	private void sendKakao(String phoneNumber, String message) {
		restTemplate.exchange
		 ("http://210.93.181.229:9090/v1/send/kakao-friend", HttpMethod.POST, new HttpEntity<Body>(new Body(phoneNumber, message), createHeaders("class", "secret12!@")), Result.class);
	}
	
	HttpHeaders createHeaders(String username, String password){
		return new HttpHeaders() {{
			String auth = username + ":" + password;
			byte[] encodedAuth = Base64.encodeBase64(
					auth.getBytes(Charset.forName("US-ASCII")) );
			String authHeader = "Basic " + new String( encodedAuth );
			set( "Authorization", authHeader );
			}};
	}

	private int getRandomCode() {
		String numStr = "1";
	    String plusNumStr = "1";
	 
	    for (int i = 0; i < 6; i++) {
	        numStr += "0";
	 
	        if (i != 5) {
	            plusNumStr += "0";
	        }
	    }
	 
	    Random random = new Random();
	    int result = random.nextInt(Integer.parseInt(numStr)) + Integer.parseInt(plusNumStr);
	 
	    if (result > Integer.parseInt(numStr)) {
	        result = result - Integer.parseInt(plusNumStr);
	    }
	 
	    return result;
	}

	private int getTotalSampleCoupon(String rank, int usedSampleCoupon) {
		if(rank.trim().equals("SILVER")) {
			return 1 - usedSampleCoupon;
		} else if(rank.trim().equals("GOLD")) {
			return 3 - usedSampleCoupon;
		} else {
			return 5 - usedSampleCoupon;
		}
	}
	
	@RequestMapping("/send")
	public ApiResult<String> sendSample(String phoneNumber, int productIdx) {
		Member member = memberDao.getMemberByPhoneNumber(phoneNumber);
		if(member == null)
			return new ApiResult<>(100, "등록되지 않은 계정입니다.");
		Product p = productDao.getDetail(productIdx);
		if(p.getSample() <= 0)
			return new ApiResult<>(200, "샘플이 소진되었습니다.");
		int totalSampleCoupon = getTotalSampleCoupon(member.getRank(), sampleDao.getUsedSampleCoupon(member.getIdx()));
		if(totalSampleCoupon <= 0)
			return new ApiResult<>(300, "받을 수 있는 샘플 갯수를 초과하였습니다.");
		sampleDao.useSampleCoupon(member.getIdx()); 
		service.turn(2);
		p.setSample(p.getSample() - 1);
		inventoryDao.updateRepository(p);
		return new ApiResult<>(0, "SUCCESS");
	}
	
	@RequestMapping("/test")
	public String test(int val) {
		service.turn(val);
		return "SUCCESS";
	}
	
}
