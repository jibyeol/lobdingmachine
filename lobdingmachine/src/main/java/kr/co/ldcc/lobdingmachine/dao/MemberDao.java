package kr.co.ldcc.lobdingmachine.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.member.Member;

@Mapper
public interface MemberDao {

	Member getMemberByPhoneNumber(String phoneNumber);

	void update(Member user);
	
}
