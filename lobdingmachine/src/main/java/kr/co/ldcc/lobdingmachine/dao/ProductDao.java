package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.ldcc.lobdingmachine.model.product.Buy;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@Mapper
public interface ProductDao {

	List<Product> getProductByCategoryIdx(int categoryIdx);
	List<Product> getProductByCategoryIdxLimit(@Param("categoryIdx") int categoryIdx, @Param("offset") int offset, @Param("rows") int rows);
	//todo: 로그인했을 때 id 받아오는것
	List<Product> setbuyProduct(Buy buy);
	int getTotalCount(int i);
	void insert(Product product);
	void update(Product product);
	void delete(int parseInt);
	Product getDetail(int idx);
}
