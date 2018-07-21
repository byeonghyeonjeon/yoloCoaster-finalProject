/**
 * 
 */
package com.yolo.model;

/**
* VoterVO.java
*
* @author PC09
* @since 2018. 6. 13.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 2018.06.19 BROWN 컬럼수정으로 인한 VO변경
* ---------- ------ ------------------------
* 2018. 6. 13. PC09 최초 생성
*
* </pre>
*/
public class VoterVO {
	private int voter_seq;
	private int option_seq;
	private String mem_id;
	private String voter_st;
	private int vote_seq;
	
	
	


	@Override
	public String toString() {
		return "VoterVO [voter_seq=" + voter_seq + ", option_seq=" + option_seq
				+ ", mem_id=" + mem_id + ", voter_st=" + voter_st
				+ ", vote_seq=" + vote_seq + "]";
	}


	/**
	 * @return the vote_seq
	 */
	public int getVote_seq() {
		return vote_seq;
	}


	/**
	 * @param vote_seq the vote_seq to set
	 */
	public void setVote_seq(int vote_seq) {
		this.vote_seq = vote_seq;
	}


	public int getVoter_seq() {
		return voter_seq;
	}


	public void setVoter_seq(int voter_seq) {
		this.voter_seq = voter_seq;
	}


	public int getOption_seq() {
		return option_seq;
	}


	public void setOption_seq(int option_seq) {
		this.option_seq = option_seq;
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


	/**
	 * 
	 */
	public VoterVO() {
		super();
	}
	
}
