package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.statistics.StatisticsData;

@Mapper
public interface StatisticsDao {

	List<StatisticsData> getData(String day);

}
