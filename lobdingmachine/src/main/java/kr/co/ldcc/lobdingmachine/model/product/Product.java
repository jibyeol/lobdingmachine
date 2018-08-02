package kr.co.ldcc.lobdingmachine.model.product;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable {

	int idx;
	String company;
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
	
	// 리뷰 리스트
	List<Review> reviews;
	List<String> hashtag;
	

	public void setDetailInfo(Product p) {
		this.company = p.getCompany();
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public int getSampleCount() {
		return sampleCount;
	}
	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
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
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<String> getHashtag() {
		return hashtag;
	}
	public void setHashtag(List<String> hashtag) {
		this.hashtag = hashtag;
	}
	
}
