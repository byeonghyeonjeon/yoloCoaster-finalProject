/**
 * 
 */
package com.yolo.model;

/**
* ReplyVO.java
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
*	댓글 VO
* </pre>
*/
public class ReplyVO {
	private int reply_seq;			//댓글 시퀀스
	private int board_seq;			//게시판 시퀀스
	private String reply_member_id;	//댓글단 회원 아이디
	private String reply_dt;		//댓글 작성 시간
	private String reply_content;	//댓글 내용
	private int reply_group;		//댓글 수준 1= 본문댓글 2 = 댓글의 댓글
	private String reply_st;		//댓글 사용여부
	private int preply_seq;			//부모댓글
	private String reply_img;		//댓글 유저사진
	
	
	public String getReply_img() {
		return reply_img;
	}
	public void setReply_img(String reply_img) {
		this.reply_img = reply_img;
	}
	public int getPreply_seq() {
		return preply_seq;
	}
	public void setPreply_seq(int preply_seq) {
		this.preply_seq = preply_seq;
	}
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getReply_member_id() {
		return reply_member_id;
	}
	public void setReply_member_id(String reply_member_id) {
		this.reply_member_id = reply_member_id;
	}
	public String getReply_dt() {
		return reply_dt;
	}
	public void setReply_dt(String reply_dt) {
		this.reply_dt = reply_dt;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getReply_group() {
		return reply_group;
	}
	public void setReply_group(int reply_group) {
		this.reply_group = reply_group;
	}
	public String getReply_st() {
		return reply_st;
	}
	public void setReply_st(String reply_st) {
		this.reply_st = reply_st;
	}
	
	
	
	@Override
	public String toString() {
		return "ReplyVO [reply_seq=" + reply_seq + ", board_seq=" + board_seq
				+ ", reply_member_id=" + reply_member_id + ", reply_dt="
				+ reply_dt + ", reply_content=" + reply_content
				+ ", reply_group=" + reply_group + ", reply_st=" + reply_st
				+ ", preply_seq=" + preply_seq + ", reply_img=" + reply_img
				+ "]";
	}
	public ReplyVO(int reply_seq, int board_seq, String reply_member_id,
			String reply_dt, String reply_content, int reply_group,
			String reply_st, int preply_seq, String reply_img) {
		super();
		this.reply_seq = reply_seq;
		this.board_seq = board_seq;
		this.reply_member_id = reply_member_id;
		this.reply_dt = reply_dt;
		this.reply_content = reply_content;
		this.reply_group = reply_group;
		this.reply_st = reply_st;
		this.preply_seq = preply_seq;
		this.reply_img = reply_img;
	}
	public ReplyVO() {
		super();
	}
	

	
	
}
