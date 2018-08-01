package kr.co.ldcc.lobdingmachine.model.image;

public class Image {

	int idx;
	String url;
	
	public Image(String url) {
		this.url = url;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
