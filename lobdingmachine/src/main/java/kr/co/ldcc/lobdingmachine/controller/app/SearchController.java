package kr.co.ldcc.lobdingmachine.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ldcc.lobdingmachine.dao.SearchDao;
import kr.co.ldcc.lobdingmachine.model.search.PopularSearch;

@RestController
public class SearchController {
	
	@Autowired SearchDao dao;

	/**
	 * 인기 검색어 리턴
	 */
	@RequestMapping("/search")
	public List<PopularSearch> search() {
		return dao.getPopularSearch();
	}
	
}
