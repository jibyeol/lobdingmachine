package kr.co.ldcc.lobdingmachine.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {

    @RequestMapping("/test")
    public String allTest(){
        return "test";
    }
    
    @RequestMapping("/test2")
    public Map<String, String> test2(){
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("key1", "value1");
    	result.put("key2", "value2");
    	result.put("key3", "value3");
    	result.put("key4", "value4");
    	return result;
    }

}
