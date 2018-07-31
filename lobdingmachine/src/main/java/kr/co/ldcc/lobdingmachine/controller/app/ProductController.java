package kr.co.ldcc.lobdingmachine.controller.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ldcc.lobdingmachine.dao.ProductDao;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@RestController
public class ProductController {

	@Autowired ProductDao dao;
	
	@RequestMapping("/getProduct")
	public List<Product> getProductByCategoryIdx(Integer categoryIdx) {
		if(categoryIdx == null) return new ArrayList<>();
		return dao.getProductByCategoryIdx(categoryIdx);
	}
	
	
}
