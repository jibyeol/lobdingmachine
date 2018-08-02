package kr.co.ldcc.lobdingmachine.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleDao {

	int getUsedSampleCoupon(int memberIdx);
	void useSampleCoupon(int memberIdx);
	
}
