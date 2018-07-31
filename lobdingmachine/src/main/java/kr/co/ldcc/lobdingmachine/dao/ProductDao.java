package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.product.Product;

@Mapper
public interface ProductDao {

	List<Product> getProductByCategoryIdx(int categoryIdx);
	
}
