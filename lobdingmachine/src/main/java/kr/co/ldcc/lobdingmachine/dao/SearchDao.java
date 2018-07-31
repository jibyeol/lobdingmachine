package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.product.Product;
import kr.co.ldcc.lobdingmachine.model.search.PopularSearch;

@Mapper
public interface SearchDao {

	List<PopularSearch> getPopularSearch();
	List<Product> getProductSearch(String keyword);
}
