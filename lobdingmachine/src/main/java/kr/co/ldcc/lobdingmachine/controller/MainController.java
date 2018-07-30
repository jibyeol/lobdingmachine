package kr.co.ldcc.lobdingmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController extends BaseController {
	
	@RequestMapping(value = {"/main", ""})
	public String main(){
		return "common/main";
	}

}
