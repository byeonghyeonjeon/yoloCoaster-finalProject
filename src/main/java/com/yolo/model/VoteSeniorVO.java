/**
 * 
 */
package com.yolo.model;

/**
 * @author PC15
 *
 */
public class VoteSeniorVO {
	private int chat_seq;
	private int vote_seq;
	private int option_seq;
	private int voter_seq;
	//작성자 아이디
	private String mem_id;
	
	private String vote_title;
	private String vote_end;
	private String vote_blind;
	private String vote_st;
	private String voter_st;
	
	private int option_order;
	private String option_content;
	private int option_hit;
	
	public VoteSeniorVO(){
		super();
	}	
	
	/**
	 * @param chat_seq
	 * @param vote_seq
	 * @param option_seq
	 * @param voter_seq
	 * @param mem_id
	 * @param voter_st
	 * @param vote_title
	 * @param vote_end
	 * @param vote_blind
	 * @param vote_st
	 * @param option_order
	 * @param option_content
	 * @param option_hit
	 */
	public VoteSeniorVO(int chat_seq, int vote_seq, int option_seq,
			int voter_seq, String mem_id, String voter_st, String vote_title,
			String vote_end, String vote_blind, String vote_st,
			int option_order, String option_content, int option_hit) {
		super();
		this.chat_seq = chat_seq;
		this.vote_seq = vote_seq;
		this.option_seq = option_seq;
		this.voter_seq = voter_seq;
		this.mem_id = mem_id;
		this.voter_st = voter_st;
		this.vote_title = vote_title;
		this.vote_end = vote_end;
		this.vote_blind = vote_blind;
		this.vote_st = vote_st;
		this.option_order = option_order;
		this.option_content = option_content;
		this.option_hit = option_hit;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public int getVote_seq() {
		return vote_seq;
	}
	public void setVote_seq(int vote_seq) {
		this.vote_seq = vote_seq;
	}
	public int getOption_seq() {
		return option_seq;
	}
	public void setOption_seq(int option_seq) {
		this.option_seq = option_seq;
	}
	public int getVoter_seq() {
		return voter_seq;
	}
	public void setVoter_seq(int voter_seq) {
		this.voter_seq = voter_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getVoter_st() {
		return voter_st;
	}
	public void setVoter_st(String voter_st) {
		this.voter_st = voter_st;
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
	public int getOption_order() {
		return option_order;
	}
	public void setOption_order(int option_order) {
		this.option_order = option_order;
	}
	public String getOption_content() {
		return option_content;
	}
	public void setOption_content(String option_content) {
		this.option_content = option_content;
	}
	public int getOption_hit() {
		return option_hit;
	}
	public void setOption_hit(int option_hit) {
		this.option_hit = option_hit;
	}
	

}
