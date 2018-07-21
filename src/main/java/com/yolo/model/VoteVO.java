/**
 * 
 */
package com.yolo.model;

/**
* VoteVO.java
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
public class VoteVO {
	private int vote_seq;
	private int chat_seq;
	private String vote_title;
	private String vote_end;
	private String vote_blind;
	private String vote_st;
	private String mem_id;
	
	public VoteVO() {
		super();
	}
	@Override
	public String toString() {
		return "VoteVO [vote_seq=" + vote_seq + ", chat_seq=" + chat_seq
				+ ", vote_title=" + vote_title + ", vote_end=" + vote_end
				+ ", vote_blind=" + vote_blind + ", vote_st=" + vote_st
				+ ", mem_id=" + mem_id + "]";
	}
	public int getVote_seq() {
		return vote_seq;
	}
	public void setVote_seq(int vote_seq) {
		this.vote_seq = vote_seq;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public String getVote_title() {
		return vote_title;
	}
	public void setVote_title(String vote_title) {
		this.vote_title = vote_title;
	}
	public String getVote_end() {
		return vote_end;
	}
	public void setVote_end(String vote_end) {
		this.vote_end = vote_end;
	}
	public String getVote_blind() {
		return vote_blind;
	}
	public void setVote_blind(String vote_blind) {
		this.vote_blind = vote_blind;
	}
	public String getVote_st() {
		return vote_st;
	}
	public void setVote_st(String vote_st) {
		this.vote_st = vote_st;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}
