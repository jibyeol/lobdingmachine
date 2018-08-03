package kr.co.ldcc.lobdingmachine.controller.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ldcc.lobdingmachine.dao.InventoryDao;
import kr.co.ldcc.lobdingmachine.dao.MemberDao;
import kr.co.ldcc.lobdingmachine.dao.ProductDao;
import kr.co.ldcc.lobdingmachine.model.common.ApiResult;
import kr.co.ldcc.lobdingmachine.model.member.Member;
import kr.co.ldcc.lobdingmachine.model.product.Buy;
import kr.co.ldcc.lobdingmachine.model.product.Product;
import kr.co.ldcc.lobdingmachine.service.TurnArduinoService;

@RestController
@RequestMapping("/app/product")
public class ProductController {

	@Autowired TurnArduinoService service;
	@Autowired ProductDao dao;
	@Autowired MemberDao memberDao;
	@Autowired InventoryDao inventoryDao;
	
	@RequestMapping("/getByCategoryIdx")
	public List<Product> getProductByCategoryIdx(Integer categoryIdx) {
		if(categoryIdx == null) return new ArrayList<>();
		/*List<Product> productList = dao.getProductByCategoryIdx(categoryIdx);
		List<Product> result = new ArrayList<>();
		for(Product p : productList) {
			result.add(getProductByIdx(p.getIdx()));
		}
		return result;*/
		return dao.getProductByCategoryIdx(categoryIdx);
	}
	
	@RequestMapping("/get")
	public Product getProductByIdx(int idx) {
		Product product = dao.getDetail(idx);
		product.setReviews(dao.getReviewByProductIdx(idx));
		/*int totalSize = product.getReviews() == null ? 0 : product.getReviews().size();
		int man;
		int woman;
		int 
		for(Review r : product.getReviews()) {
			
		}*/
		List<String> hashtag = new ArrayList<String>();
		hashtag.add("여자");
		hashtag.add("20대");
		hashtag.add("지성");
		product.setHashtag(hashtag);
		return product;
	}
	
	@RequestMapping("/buy")
	public ApiResult buyProduct(@RequestBody Buy buy)
	{
		int point = 0;
		int totalPrice = 0;
		for(Product p : buy.getProductList()) {
			// 상품 정보 로드하고, 재고가 있는지 확인
			p.setDetailInfo(dao.getDetail(p.getIdx()));
			totalPrice += (p.getPrice()*p.getBuyCount());
			if(!p.isBuyPosible() && !p.isSamplePosible()) {
				return new ApiResult(100, "상품 제고가 부족합니다.");
			}
		}
		for(Product p : buy.getProductList()) {
			// 구매하면 제고 소진
			p.setBuyValue();
			inventoryDao.updateRepository(p);
		}
		Member user = memberDao.getMemberByPhoneNumber(buy.getPhoneNumber());
		// 구매내역저장
		buy.setMember(user);
		dao.setbuyProduct(buy);
		// 카드번호 확인하여 적립될 포인트 확인
		if(user != null && buy.isLotteCard()) {
			point = (int)Math.floor(totalPrice * 15 / (double)100);
		} else if (user != null) {
			point = (int)Math.floor(totalPrice * 10 / (double)100);
		}
		// 포인트 적립해줌
		if(user != null) {
			user.setPoint(user.getPoint() + point);
			memberDao.update(user);
		}
		// 상품지급
		service.turn(1);
		return new ApiResult(0, "SUCCESS", point);
	}
	
	/**
	 * PostMan test
url : localhost:8080/lobdingmachine/buy
POST
header : key : Content-Type
         value : application/json
Body를 raw로 선택 후에 밑에 파라미터 입력!

{
	"productList" : [
		{
			"idx":1, "buyCount":2
		},
		{
			"idx":2, "buyCount":2
		}
	],
	"phoneNumber" : "123213213",
	"cardNumber" : "123213213"
}
	 */
	
	
}
