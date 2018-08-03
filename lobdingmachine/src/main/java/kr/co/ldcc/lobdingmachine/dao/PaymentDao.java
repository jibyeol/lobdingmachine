package kr.co.ldcc.lobdingmachine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ldcc.lobdingmachine.model.common.JqGridParameter;
import kr.co.ldcc.lobdingmachine.model.payment.Payment;

@Mapper
public interface PaymentDao {

	List<Payment> getPaymentList(JqGridParameter param);

	int getTotalCount();
	
}
