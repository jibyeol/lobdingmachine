package kr.co.ldcc.lobdingmachine.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ldcc.lobdingmachine.controller.BaseController;

@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {
	
	@RequestMapping("/403")
	public String error403() {
		return "error/403";
	}
	
	@RequestMapping("/404")
	public String error404() {
		return "error/404";
	}
	
	@RequestMapping("/500")
	public String error500() {
		return "error/500";
	}

}
