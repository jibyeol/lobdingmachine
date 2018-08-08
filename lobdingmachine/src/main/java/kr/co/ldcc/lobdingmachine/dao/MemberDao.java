package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.member.Member;

@Mapper
public interface MemberDao {

	Member getMemberByPhoneNumber(String phoneNumber);

	void update(Member user);

	List<Member> getList(JqGridParameter param);

	void insert(Member member);

	void delete(int parseInt);
	
}
