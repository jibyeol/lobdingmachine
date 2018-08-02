package kr.co.ldcc.lobdingmachine.model.kakao;

public class Body {

	String msg_id;
	String dest_phone;
	String send_phone = "01045843552";
	String sender_key = "d6b73318d4927aa80df1022e07fecf06c55b44bf";
	String msg_body;
	String ad_flag = "N";
	
	public Body() {}
	public Body(String phoneNumber, String message) {
		this.msg_id = "kko_fk_" + phoneNumber;
		this.dest_phone = phoneNumber;
		this.msg_body = message;
	}
	
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getDest_phone() {
		return dest_phone;
	}
	public void setDest_phone(String dest_phone) {
		this.dest_phone = dest_phone;
	}
	public String getSend_phone() {
		return send_phone;
	}
	public void setSend_phone(String send_phone) {
		this.send_phone = send_phone;
	}
	public String getSender_key() {
		return sender_key;
	}
	public void setSender_key(String sender_key) {
		this.sender_key = sender_key;
	}
	public String getMsg_body() {
		return msg_body;
	}
	public void setMsg_body(String msg_body) {
		this.msg_body = msg_body;
	}
	public String getAd_flag() {
		return ad_flag;
	}
	public void setAd_flag(String ad_flag) {
		this.ad_flag = ad_flag;
	}
	
}
