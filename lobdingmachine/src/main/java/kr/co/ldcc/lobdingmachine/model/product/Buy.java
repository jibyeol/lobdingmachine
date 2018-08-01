package kr.co.ldcc.lobdingmachine.model.product;

import java.util.List;

import kr.co.ldcc.lobdingmachine.model.member.Member;

public class Buy {

	List<Product> productList;
	String phoneNumber;
	String cardNumber;
	Member member;
	
	public boolean isLotteCard() {
		return cardNumber.trim().equals("12345678");
	}
	
	// setter, getter
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
