package com.rockontrol.pojo;

public class Page {
	private Integer page;
	private Integer rows;
	private Integer total;
	
	public Page() {
		super();
	}

	public Page(Integer page, Integer rows) {
		super();
		this.page = page;
		this.rows = rows;
	}



	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Integer getStart() {
		return page * rows;
	}
}
