package kr.co.ldcc.lobdingmachine.model.product;

public class Product {

	int idx;
	String name;
	int categoryIdx;
	int price;
	String imgUrl;
	String description;
	
	// 제고 갯수 정보
	int smaple; // 샘플 갯수
	int count; // 재고 갯수
	
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
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSmaple() {
		return smaple;
	}
	public void setSmaple(int smaple) {
		this.smaple = smaple;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
