package kr.co.ldcc.lobdingmachine.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.StatisticsDao;
import kr.co.ldcc.lobdingmachine.model.statistics.StatisticsData;

@Controller
@RequestMapping("/admin/statistics")
public class AdminStatisticsController extends BaseController {
	
	@Autowired StatisticsDao dao;

	@RequestMapping(value= {"", "/"})
	public String page() {
		return "admin/statistics/main";
	}
	
	@RequestMapping("test")
	public String test() {
		return "admin/statistics/test";
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public List<StatisticsData> getData(String day){
		List<StatisticsData> result = dao.getData(day);
		return result;
	}
	
}
