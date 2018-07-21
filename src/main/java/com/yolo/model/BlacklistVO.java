/**
 * 
 */
package com.yolo.model;



/**
 * BlacklistVO.java
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
public class BlacklistVO {

	private int black_seq;
	private String mem_id;
	private String black_cause;
	private String black_st;
	
	public BlacklistVO(){
		super();
	}
	
	
	public BlacklistVO(int black_seq, String mem_id, String black_cause,
			String black_st) {
		super();
		this.black_seq = black_seq;
		this.mem_id = mem_id;
		this.black_cause = black_cause;
		this.black_st = black_st;
	}


	public int getBlack_seq() {
		return black_seq;
	}
	public void setBlack_seq(int black_seq) {
		this.black_seq = black_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBlack_cause() {
		return black_cause;
	}
	public void setBlack_cause(String black_cause) {
		this.black_cause = black_cause;
	}
	public String getBlack_st() {
		return black_st;
	}
	public void setBlack_st(String black_st) {
		this.black_st = black_st;
	}
	
	
	@Override
	public String toString() {
		return "BlacklistVO [black_seq=" + black_seq + ", mem_id=" + mem_id
				+ ", black_cause=" + black_cause + ", black_st=" + black_st
				+ "]";
	}
	
	
	
}
