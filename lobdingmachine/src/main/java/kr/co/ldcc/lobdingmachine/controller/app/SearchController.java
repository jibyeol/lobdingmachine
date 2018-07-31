package kr.co.ldcc.lobdingmachine.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ldcc.lobdingmachine.dao.SearchDao;
import kr.co.ldcc.lobdingmachine.model.product.Product;
import kr.co.ldcc.lobdingmachine.model.search.PopularSearch;

@RestController
public class SearchController {
	
	@Autowired SearchDao dao;

	/**
	 * 인기 검색어 리턴
	 */
	
	@RequestMapping("/popularKeyword")
	public List<PopularSearch> popularKeyword() {
		return dao.getPopularSearch();
	}
	
	
	/**
	 * 상품 검색어 리턴
	 */
	@RequestMapping("/product")
	public List<Product> product(String keyword	){
		dao.insertSearchHistory(keyword);
		return dao.getProductSearch(keyword);
	}
	
}
