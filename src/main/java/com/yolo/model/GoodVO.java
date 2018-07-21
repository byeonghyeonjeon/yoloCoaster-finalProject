package com.yolo.model;


public class GoodVO {

	private int good_seq;
	private String contentid;
	private String good_mem_id;
	
	public GoodVO(){
		super();
	}
	
	public GoodVO(int good_seq, String contentid, String good_mem_id) {
		super();
		this.good_seq = good_seq;
		this.contentid = contentid;
		this.good_mem_id = good_mem_id;
	}


	public int getGood_seq() {
		return good_seq;
	}
	public void setGood_seq(int good_seq) {
		this.good_seq = good_seq;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getGood_mem_id() {
		return good_mem_id;
	}
	public void setGood_mem_id(String good_mem_id) {
		this.good_mem_id = good_mem_id;
	}
	
	
	@Override
	public String toString() {
		return "GoodVO [good_seq=" + good_seq + ", contentid=" + contentid
				+ ", good_mem_id=" + good_mem_id + "]";
	}
	
	
	
}
