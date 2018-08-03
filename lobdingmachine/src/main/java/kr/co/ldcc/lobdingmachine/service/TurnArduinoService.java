package kr.co.ldcc.lobdingmachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kr.co.ldcc.lobdingmachine.model.kakao.Result;

@Service
public class TurnArduinoService {

	@Autowired RestTemplate restTemplate;

	public void turn(int val) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "16911f87-9cb8-a1c2-2cb0-8a8327a7f6e3");
		headers.set("X-M2M-RI", "2626");
		headers.set("X-M2M-Origin", "/S0000000000000000_01045155793");
		restTemplate.exchange
		 ("http://lottehotel.koreacentral.cloudapp.azure.com:38080/education/base/controller-0000000000000000_01045155793" 
				 , HttpMethod.PUT
				 , new HttpEntity<String>(getArduinoPlatformParameter(val), headers), Object.class);
	}

	private String getArduinoPlatformParameter(int val) {
		return "{  \r\n" + 
				"    \"m2m:mgc\" : {\r\n" + 
				"        \"cmt\" : 4,\r\n" + 
				"        \"exra\" : {\r\n" + 
				"        \"any\" : [ {\r\n" + 
				"            \"nm\": \"turn\" ,\r\n" + 
				"            \"val\": \""+val+"\"\r\n" + 
				"            } ]\r\n" + 
				"        },\r\n" + 
				"        \"exm\" : 1,\r\n" + 
				"        \"exe\" : true,\r\n" + 
				"        \"pexinc\" : false\r\n" + 
				"    }\r\n" + 
				"}";
	}
	
}
