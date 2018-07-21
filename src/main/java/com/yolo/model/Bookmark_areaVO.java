/**
 * 
 */
package com.yolo.model;

public class Bookmark_areaVO {
	
	private int bookmark_area_seq;
	private String mem_id;
	private String title;
	private String sigungucode;
	private String areacode;
	private String contentid;
	private String link;
	private String firstimage2;
	
	public Bookmark_areaVO(){
		super();
	}
	
	public Bookmark_areaVO(int bookmark_area_seq, String mem_id, String title,
			String sigungucode, String areacode, String contentid,
			String firstimage2, String link) {
		super();
		this.bookmark_area_seq = bookmark_area_seq;
		this.mem_id = mem_id;
		this.title = title;
		this.sigungucode = sigungucode;
		this.areacode = areacode;
		this.contentid = contentid;
		this.firstimage2 = firstimage2;
		this.link = link;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getBookmark_area_seq() {
		return bookmark_area_seq;
	}
	public void setBookmark_area_seq(int bookmark_area_seq) {
		this.bookmark_area_seq = bookmark_area_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSigungucode() {
		return sigungucode;
	}
	public void setSigungucode(String sigungucode) {
		this.sigungucode = sigungucode;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getFirstimage2() {
		return firstimage2;
	}
	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}

	@Override
	public String toString() {
		return "Bookmark_areaVO [bookmark_area_seq=" + bookmark_area_seq
				+ ", mem_id=" + mem_id + ", title=" + title + ", sigungucode="
				+ sigungucode + ", areacode=" + areacode + ", contentid="
				+ contentid + ", link=" + link + ", firstimage2=" + firstimage2
				+ "]";
	}
	
}
