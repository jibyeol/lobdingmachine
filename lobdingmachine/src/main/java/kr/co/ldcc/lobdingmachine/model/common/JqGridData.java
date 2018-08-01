package kr.co.ldcc.lobdingmachine.model.common;

import java.util.List;

public class JqGridData <T> {

	int page;
	int total; // 총 페이지수
	int records;
	List<T> rows;
	
	public JqGridData(){}
	public JqGridData(JqGridParameter param, List<T> data, int totalPage){
		this.rows = data;
		this.page = param.getPage();
		this.records = data.size();
		this.total = totalPage;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
