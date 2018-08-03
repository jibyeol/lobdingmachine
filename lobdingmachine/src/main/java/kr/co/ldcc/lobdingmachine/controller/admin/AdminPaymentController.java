package kr.co.ldcc.lobdingmachine.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.PaymentDao;
import kr.co.ldcc.lobdingmachine.model.common.JqGridData;
import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.payment.Payment;

@Controller
@RequestMapping("/admin/payment")
public class AdminPaymentController extends BaseController {
	
	@Autowired PaymentDao dao;

	@RequestMapping(value= {"", "/"})
	public String paymentPage() {
		return "admin/payment/main";
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public JqGridData<Payment> getData(JqGridParameter param){
		List<Payment> result = dao.getPaymentList(param);
		int totalPage = getTotalPage(dao.getTotalCount(), param.getRows());
		return new JqGridData<>(param, result, totalPage);
	}
	
}
