package kr.co.ldcc.lobdingmachine.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.InventoryDao;
import kr.co.ldcc.lobdingmachine.model.common.JqGridData;
import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@Controller
@RequestMapping("/admin/repository")
public class AdminRepositoryController extends BaseController {
	
	@Autowired InventoryDao dao;
	
	@RequestMapping(value= {"", "/"})
	public String repositoryPage() {
		return "admin/repository/main";
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public JqGridData<Product> getRepository(JqGridParameter param) {
		List<Product> data = dao.getProductRepository(param);
		int totalPage = getTotalPage(dao.getTotalCount(), param.getRows());
		return new JqGridData<>(param, data, totalPage);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editRepositoryInfo(Product product, String oper, String id) {
		if(oper.trim().equals("add")) {
			dao.insertRepository(product);
		} else if(oper.trim().equals("edit")) {
			product.setIdx(Integer.parseInt(id));
			dao.updateRepository(product);
		} else if(oper.trim().equals("del")) {
			dao.deleteRepository(Integer.parseInt(id));
		}
		return "SUCCESS";
	}

}
