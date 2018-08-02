package kr.co.ldcc.lobdingmachine.model.member;

import java.io.Serializable;

public class Member implements Serializable {

	int idx;
	String name;
	String rrn;
	int point;
	String phoneNumber;
	int skinType;
	String rank; // SILVER, GOLD, VIP
	boolean man;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getSkinType() {
		return skinType;
	}
	public void setSkinType(int skinType) {
		this.skinType = skinType;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	
}
