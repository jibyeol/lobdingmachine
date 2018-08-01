package kr.co.ldcc.lobdingmachine.model.product;

public class Product {

	int idx;
	String name;
	int categoryIdx;
	int price;
	String imgUrl;
	String description;
	
	// 제고 갯수 정보
	int sample; // 샘플 갯수
	int count; // 재고 갯수
	
	// 구매할 갯수
	int buyCount;
	int sampleCount;
	

	public void setDetailInfo(Product p) {
		this.name = p.getName();
		this.categoryIdx = p.getCategoryIdx();
		this.price = p.getPrice();
		this.imgUrl = p.getImgUrl();
		this.description = p.getDescription();
		this.sample = p.getSample();
		this.count = p.getCount();
	}
	public boolean isBuyPosible() {
		return count > buyCount;
	}
	public boolean isSamplePosible() {
		return sample > sampleCount;
	}
	public void setBuyValue() {
		this.sample = this.sample - this.sampleCount;
		this.count = this.count - this.buyCount;
	}
	
	// getter, setter
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
	public int getSample() {
		return sample;
	}
	public void setSample(int sample) {
		this.sample = sample;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
