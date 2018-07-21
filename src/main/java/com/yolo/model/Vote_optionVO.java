/**
 * 
 */
package com.yolo.model;

/**
* Vote_optionVO.java
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
public class Vote_optionVO {
	private int option_seq;
	private int vote_seq;
	private int option_order;
	private String option_content;
	private int option_hit;
	
	public Vote_optionVO(int option_seq, int vote_seq, int option_order, String option_content, int option_hit) {
		super();
		this.option_seq = option_seq;
		this.vote_seq = vote_seq;
		this.option_order = option_order;
		this.option_content = option_content;
		this.option_hit = option_hit;
	}
	public int getOption_seq() {
		return option_seq;
	}
	public void setOption_seq(int option_seq) {
		this.option_seq = option_seq;
	}
	public int getVote_seq() {
		return vote_seq;
	}
	public void setVote_seq(int vote_seq) {
		this.vote_seq = vote_seq;
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
	@Override
	public String toString() {
		return "Vote_optionVO [option_seq=" + option_seq + ", vote_seq=" + vote_seq + ", option_order=" + option_order
				+ ", option_content=" + option_content + ", option_hit=" + option_hit + "]";
	}
	/**
	 * 
	 */
	public Vote_optionVO() {
		super();
	}
}
