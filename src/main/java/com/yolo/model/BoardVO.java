/**
 * 
 */
package com.yolo.model;

import java.util.Date;


/**
 * BoardVO.java
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
public class BoardVO {
	
	private int board_seq;
	private int pboard_seq;
	private String board_notice;
	private String board_title;
	private String board_content;
	private String board_reply;
	private String board_private;
	private String board_mem_id;
	private Date board_dt;
	private int board_hit;
	private String board_st;
	
	public BoardVO(){
		super();
	}
	
	
	
	public BoardVO(int board_seq, int pboard_seq, String board_notice,
			String board_title, String board_content, String board_reply,
			String board_private, String board_mem_id, Date board_dt,
			int board_hit, String board_st) {
		super();
		this.board_seq = board_seq;
		this.pboard_seq = pboard_seq;
		this.board_notice = board_notice;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_reply = board_reply;
		this.board_private = board_private;
		this.board_mem_id = board_mem_id;
		this.board_dt = board_dt;
		this.board_hit = board_hit;
		this.board_st = board_st;
	}



	public int getBoard_seq() {
		return board_seq;
	}



	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}



	public int getPboard_seq() {
		return pboard_seq;
	}



	public void setPboard_seq(int pboard_seq) {
		this.pboard_seq = pboard_seq;
	}



	public String getBoard_notice() {
		return board_notice;
	}



	public void setBoard_notice(String board_notice) {
		this.board_notice = board_notice;
	}



	public String getBoard_title() {
		return board_title;
	}



	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}



	public String getBoard_content() {
		return board_content;
	}



	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}



	public String getBoard_reply() {
		return board_reply;
	}



	public void setBoard_reply(String board_reply) {
		this.board_reply = board_reply;
	}



	public String getBoard_private() {
		return board_private;
	}



	public void setBoard_private(String board_private) {
		this.board_private = board_private;
	}



	public String getBoard_mem_id() {
		return board_mem_id;
	}



	public void setBoard_mem_id(String board_mem_id) {
		this.board_mem_id = board_mem_id;
	}



	public Date getBoard_dt() {
		return board_dt;
	}



	public void setBoard_dt(Date board_dt) {
		this.board_dt = board_dt;
	}



	public int getBoard_hit() {
		return board_hit;
	}



	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}



	public String getBoard_st() {
		return board_st;
	}



	public void setBoard_st(String board_st) {
		this.board_st = board_st;
	}



	@Override
	public String toString() {
		return "BoardVO [board_seq=" + board_seq + ", pboard_seq=" + pboard_seq
				+ ", board_notice=" + board_notice + ", board_title="
				+ board_title + ", board_content=" + board_content
				+ ", board_reply=" + board_reply + ", board_private="
				+ board_private + ", board_mem_id=" + board_mem_id
				+ ", board_dt=" + board_dt + ", board_hit=" + board_hit
				+ ", board_st=" + board_st + "]";
	}
	
	

}
