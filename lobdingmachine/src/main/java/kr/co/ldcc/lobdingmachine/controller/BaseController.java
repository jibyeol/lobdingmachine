package kr.co.ldcc.lobdingmachine.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	
	@Value("${resource.url}") String resourceUrl;

	@ModelAttribute("resourcesUrl")
	protected String getResourcesUrl(){
		return this.resourceUrl;
	}
	
	protected int getTotalPage(int totalCount, int rows) {
		if(rows == 0) return 0;
		int result = totalCount / rows;
		if(totalCount % rows > 0) result ++;
		return result;
	}
	
}
