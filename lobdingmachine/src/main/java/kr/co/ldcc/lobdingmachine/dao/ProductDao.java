package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.product.Buy;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@Mapper
public interface ProductDao {

	List<Product> getProductByCategoryIdx(int categoryIdx);
	//todo: 로그인했을 때 id 받아오는것
	List<Product> setbuyProduct(Buy buy);
}
