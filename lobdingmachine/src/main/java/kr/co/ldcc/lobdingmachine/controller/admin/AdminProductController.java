package kr.co.ldcc.lobdingmachine.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.ProductDao;
import kr.co.ldcc.lobdingmachine.model.common.JqGridData;
import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.product.Product;

@Controller
@RequestMapping("/admin")
public class AdminProductController extends BaseController {
	
	@Autowired ProductDao dao;

	@RequestMapping("/product")
	public String productPage() {
		return "admin/product/main";
	}
	
	@RequestMapping("/getProductList")
	@ResponseBody
	public JqGridData<Product> getProductList(JqGridParameter param){
		List<Product> data = dao.getProductByCategoryIdxLimit(-1, param.getOffset(), param.getRows());
		int totalPage = getTotalPage(dao.getTotalCount(-1), param.getRows());
		return new JqGridData<>(param, data, totalPage);
	}

	@RequestMapping("/editProduct")
	@ResponseBody
	public String editProduct(Product product, String oper, String id) {
		if(oper.trim().equals("add")) {
			dao.insert(product);
		} else if(oper.trim().equals("edit")) {
			product.setIdx(Integer.parseInt(id));
			dao.update(product);
		} else if(oper.trim().equals("del")) {
			dao.delete(Integer.parseInt(id));
		}
		return "SUCCESS";
	}
	
}
