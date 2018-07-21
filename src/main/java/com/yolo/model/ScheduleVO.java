/**
 * 
 */
package com.yolo.model;

import java.util.Date;

/**
* ScheduleVO.java
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
* 일정 VO
* </pre>
*/
public class ScheduleVO {
	private int schedule_seq;			//일정 시퀀스
	private String schedule_mem_id;		//일정 소유 회원
	private int chat_seq;				//일정 소유 채팅방
	private String schedule_title;		//일정 이름
	private String schedule_start;		//일정 시작일
	private String schedule_end;		//일정 종료일
	private String schedule_private;	//일정 공개여부
	private String schedule_label;		//일정 라벨 색상
	private String schedule_date;		//일정 
	private String schedule_count;		//일정 방문지 개수
	

	

	public String getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}

	public String getSchedule_count() {
		return schedule_count;
	}

	public void setSchedule_count(String schedule_count) {
		this.schedule_count = schedule_count;
	}

	public int getSchedule_seq() {
		return schedule_seq;
	}

	public void setSchedule_seq(int schedule_seq) {
		this.schedule_seq = schedule_seq;
	}

	public String getSchedule_mem_id() {
		return schedule_mem_id;
	}

	public void setSchedule_mem_id(String schedule_mem_id) {
		this.schedule_mem_id = schedule_mem_id;
	}

	public int getChat_seq() {
		return chat_seq;
	}

	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}

	public String getSchedule_title() {
		return schedule_title;
	}

	public void setSchedule_title(String schedule_title) {
		this.schedule_title = schedule_title;
	}

	public String getSchedule_start() {
		return schedule_start;
	}

	public void setSchedule_start(String schedule_start) {
		this.schedule_start = schedule_start;
	}

	public String getSchedule_end() {
		return schedule_end;
	}

	public void setSchedule_end(String schedule_end) {
		this.schedule_end = schedule_end;
	}

	public String getSchedule_private() {
		return schedule_private;
	}

	public void setSchedule_private(String schedule_private) {
		this.schedule_private = schedule_private;
	}

	public String getSchedule_label() {
		return schedule_label;
	}

	public void setSchedule_label(String schedule_label) {
		this.schedule_label = schedule_label;
	}


	
	/**
	 * @param schedule_seq
	 * @param schedule_mem_id
	 * @param chat_seq
	 * @param schedule_title
	 * @param schedule_start
	 * @param schedule_end
	 * @param schedule_private
	 * @param schedule_label
	 */
	public ScheduleVO(int schedule_seq, String schedule_mem_id, int chat_seq,
			String schedule_title, String schedule_start, String schedule_end,
			String schedule_private, String schedule_label) {
		super();
		this.schedule_seq = schedule_seq;
		this.schedule_mem_id = schedule_mem_id;
		this.chat_seq = chat_seq;
		this.schedule_title = schedule_title;
		this.schedule_start = schedule_start;
		this.schedule_end = schedule_end;
		this.schedule_private = schedule_private;
		this.schedule_label = schedule_label;
	}

	public ScheduleVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ScheduleVO [schedule_seq=" + schedule_seq
				+ ", schedule_mem_id=" + schedule_mem_id + ", chat_seq="
				+ chat_seq + ", schedule_title=" + schedule_title
				+ ", schedule_start=" + schedule_start + ", schedule_end="
				+ schedule_end + ", schedule_private=" + schedule_private
				+ ", schedule_label=" + schedule_label + "]";
	}
	
	
}
