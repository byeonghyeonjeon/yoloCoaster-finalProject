/**
 * 
 */
package com.yolo.model;

/**
* Schedule_detailVO.java
*
* @author PC09
* @since 2018. 6. 13.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 6. 13. PC09 최초 생성
*
* </pre>
*/
public class Schedule_detailVO {
	private int detail_seq;		//세부일정 시퀀스
	private int schedule_seq;	//부모 일정 시퀀스
	private int detail_step;	//세부일정 수준
	private String detail_title;//세부일정 제목
	private String detail_dt;	//세부일정 작성시간
	private String detail_private;//공개여부
	private String detail_st;		//세부일정 사용여부
	
	
	
	public Schedule_detailVO(int detail_seq, int schedule_seq, int detail_step, String detail_title, String detail_dt,
			String detail_private, String detail_st) {
		super();
		this.detail_seq = detail_seq;
		this.schedule_seq = schedule_seq;
		this.detail_step = detail_step;
		this.detail_title = detail_title;
		this.detail_dt = detail_dt;
		this.detail_private = detail_private;
		this.detail_st = detail_st;
	}
	public int getDetail_seq() {
		return detail_seq;
	}
	public void setDetail_seq(int detail_seq) {
		this.detail_seq = detail_seq;
	}
	public int getSchedule_seq() {
		return schedule_seq;
	}
	public void setSchedule_seq(int schedule_seq) {
		this.schedule_seq = schedule_seq;
	}
	public int getDetail_step() {
		return detail_step;
	}
	public void setDetail_step(int detail_step) {
		this.detail_step = detail_step;
	}
	public String getDetail_title() {
		return detail_title;
	}
	public void setDetail_title(String detail_title) {
		this.detail_title = detail_title;
	}
	public String getDetail_dt() {
		return detail_dt;
	}
	public void setDetail_dt(String detail_dt) {
		this.detail_dt = detail_dt;
	}
	public String getDetail_private() {
		return detail_private;
	}
	public void setDetail_private(String detail_private) {
		this.detail_private = detail_private;
	}
	public String getDetail_st() {
		return detail_st;
	}
	public void setDetail_st(String detail_st) {
		this.detail_st = detail_st;
	}
	/**
	 * 
	 */
	public Schedule_detailVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "Schedule_detailVO [detail_seq=" + detail_seq
				+ ", schedule_seq=" + schedule_seq + ", detail_step="
				+ detail_step + ", detail_title=" + detail_title
				+ ", detail_dt=" + detail_dt + ", detail_private="
				+ detail_private + ", detail_st=" + detail_st + "]";
	}
	
	
	
}
