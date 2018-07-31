package kr.co.ldcc.lobdingmachine.controller.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ldcc.lobdingmachine.dao.ProductDao;
import kr.co.ldcc.lobdingmachine.model.product.Buy;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@RestController
public class ProductController {

	@Autowired ProductDao dao;
	
	@RequestMapping("/getProduct")
	public List<Product> getProductByCategoryIdx(Integer categoryIdx) {
		if(categoryIdx == null) return new ArrayList<>();
		return dao.getProductByCategoryIdx(categoryIdx);
	}
	
	@RequestMapping("/buy")
	public int buy(@RequestBody Buy buy) {
		System.out.println(buy.getCardNumber());
		System.out.println(buy.getPhoneNumber());
		System.out.println(buy.getProductList().size());
		return 1;
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
			"idx":1, "count":2
		},
		{
			"idx":2, "count":2
		}
	],
	"phoneNumber" : "123213213",
	"cardNumber" : "123213213"
}
	 */
	
	
}
