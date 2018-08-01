package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.image.Image;

@Mapper
public interface ImageDao {

	List<Image> getImageList(JqGridParameter param);

	void insert(Image image);
	
}
