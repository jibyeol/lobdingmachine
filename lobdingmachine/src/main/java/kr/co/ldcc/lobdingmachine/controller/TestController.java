package kr.co.ldcc.lobdingmachine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {

    @RequestMapping("/test")
    public String allTest(){
        return "test";
    }

}
