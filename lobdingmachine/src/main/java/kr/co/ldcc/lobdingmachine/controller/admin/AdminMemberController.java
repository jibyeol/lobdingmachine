package kr.co.ldcc.lobdingmachine.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.MemberDao;
import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.member.Member;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController extends BaseController {

	@Autowired MemberDao dao;
	
	@RequestMapping(value= {"", "/"})
	public String memberPage() {
		return "admin/member/main";
	}
	
	@RequestMapping("/getData")
	public List<Member> member(JqGridParameter param){
		return dao.getList(param);
	}
	
	@RequestMapping("/edit")
	public String editMember(Member member, String oper, String id) {
		member.setRank("GOLD");
		member.setSkinType(1);
		if(oper.trim().equals("add")) {
			dao.insert(member);
		} else if(oper.trim().equals("edit")) {
			member.setIdx(Integer.parseInt(id));
			dao.update(member);
		} else if(oper.trim().equals("del")) {
			dao.delete(Integer.parseInt(id));
		}
		return "SUCCESS";
	}
	
}
