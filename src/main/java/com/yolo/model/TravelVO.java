package com.yolo.model;

import java.util.Date;

/**
 * TravelVO.java
 *
 * @author Jun
 * @since 2018. 6. 21.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 21. Jun 최초 생성
 *
 * </pre>
 */
public class TravelVO {
	private String contentid;
	private String contenttypeid;
	private String title;
	private String addr1;
	private String firstimage;
	private String firstimage2;
//	private Date eventstartdate;
//	private Date eventenddate;
	private int goodCount;
	private int reviewCount;

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}

	public String getContenttypeid() {
		return contenttypeid;
	}

	public void setContenttypeid(String contenttypeid) {
		this.contenttypeid = contenttypeid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getFirstimage() {
		return firstimage;
	}

	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}

	public String getFirstimage2() {
		return firstimage2;
	}

	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}

	public int getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

//	public Date getEventstartdate() {
//		return eventstartdate;
//	}
//
//	public void setEventstartdate(Date eventstartdate) {
//		this.eventstartdate = eventstartdate;
//	}
//
//	public Date getEventenddate() {
//		return eventenddate;
//	}
//
//	public void setEventenddate(Date eventenddate) {
//		this.eventenddate = eventenddate;
//	}

}
