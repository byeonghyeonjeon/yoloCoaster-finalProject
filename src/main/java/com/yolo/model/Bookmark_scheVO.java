package com.yolo.model;

/**
 * Bookmark_scheVO.java
 *
 * @author KGY
 * @since 2018. 6. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 14. KGY 최초 생성
 *
 * </pre>
 */
public class Bookmark_scheVO {
	
	private int bookmark_seq;
	private String mem_id;
	private int schedule_seq;
	private String schedule_title;
	
	

	public Bookmark_scheVO(){
		super();
	}
	
	public Bookmark_scheVO(int bookmark_seq, String mem_id, int schedule_seq) {
		super();
		this.bookmark_seq = bookmark_seq;
		this.mem_id = mem_id;
		this.schedule_seq = schedule_seq;
	}

	public int getBookmark_seq() {
		return bookmark_seq;
	}
	public void setBookmark_seq(int bookmark_seq) {
		this.bookmark_seq = bookmark_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getSchedule_seq() {
		return schedule_seq;
	}
	public void setSchedule_seq(int schedule_seq) {
		this.schedule_seq = schedule_seq;
	}
	public String getSchedule_title() {
		return schedule_title;
	}

	public void setSchedule_title(String schedule_title) {
		this.schedule_title = schedule_title;
	}

	@Override
	public String toString() {
		return "Bookmark_scheVO [bookmark_seq=" + bookmark_seq + ", mem_id="
				+ mem_id + ", schedule_seq=" + schedule_seq
				+ ", schedule_title=" + schedule_title + "]";
	}

	
	
	

}
