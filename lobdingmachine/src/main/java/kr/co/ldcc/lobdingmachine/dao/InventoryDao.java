package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@Mapper
public interface InventoryDao {

	List<Product> getProductRepository(JqGridParameter param);

	int getTotalCount();

	void insertRepository(Product product);

	void updateRepository(Product product);

	void deleteRepository(int productIdx);

}
