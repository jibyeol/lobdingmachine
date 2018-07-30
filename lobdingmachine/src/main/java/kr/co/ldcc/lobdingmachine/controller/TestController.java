package kr.co.ldcc.lobdingmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @RequestMapping("/all")
    public String allTest(){
        return "test/all";
    }

    @RequestMapping("/general")
    public String generalTest(){
        return "test/general";
    }

    @RequestMapping("/admin")
    public String adminTest(){
        return "test/admin";
    }
    
    @RequestMapping("/chart")
    public String chartTest(){
    	return "test/chart";
    }

}
