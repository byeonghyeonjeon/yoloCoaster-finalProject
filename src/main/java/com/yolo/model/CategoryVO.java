/**
 * 
 */
package com.yolo.model;


public class CategoryVO {
	
	private int cate_seq;
	private String cate_name;
	private String cate_dt;
	private String cate_st;
	
	public CategoryVO(){
		super();
	}
	
	public CategoryVO(int cate_seq, String cate_name, String cate_dt,
			String cate_st) {
		super();
		this.cate_seq = cate_seq;
		this.cate_name = cate_name;
		this.cate_dt = cate_dt;
		this.cate_st = cate_st;
	}

	public int getCate_seq() {
		return cate_seq;
	}
	public void setCate_seq(int cate_seq) {
		this.cate_seq = cate_seq;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public String getCate_dt() {
		return cate_dt;
	}
	public void setCate_dt(String cate_dt) {
		this.cate_dt = cate_dt;
	}
	public String getCate_st() {
		return cate_st;
	}
	public void setCate_st(String cate_st) {
		this.cate_st = cate_st;
	}
	
	
	
	@Override
	public String toString() {
		return "CategoryVO [cate_seq=" + cate_seq + ", cate_name=" + cate_name
				+ ", cate_dt=" + cate_dt + ", cate_st=" + cate_st + "]";
	}
	
	

}
