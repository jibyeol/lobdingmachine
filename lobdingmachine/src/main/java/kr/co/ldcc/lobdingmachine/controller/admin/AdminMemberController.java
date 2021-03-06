package kr.co.ldcc.lobdingmachine.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.MemberDao;
import kr.co.ldcc.lobdingmachine.model.common.JqGridData;
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
	@ResponseBody
	public JqGridData<Member> member(JqGridParameter param){
		List<Member> data = dao.getList(param);
		int totalPage = getTotalPage(dao.getTotalCount(), param.getRows());
		return new JqGridData<>(param, data, totalPage);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
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
