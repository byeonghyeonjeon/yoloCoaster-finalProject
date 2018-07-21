package com.yolo.model;


/**
 * DutchVO.java
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
public class DutchVO {
	
	private int dutch_seq;
	private int account_seq;
	private String dutch_mem_id;
	private int dutch_money;
	
	public DutchVO(){
		super();
	}
	public DutchVO(int dutch_seq, int account_seq, String dutch_mem_id,
			int dutch_money) {
		super();
		this.dutch_seq = dutch_seq;
		this.account_seq = account_seq;
		this.dutch_mem_id = dutch_mem_id;
		this.dutch_money = dutch_money;
	}


	public int getDutch_seq() {
		return dutch_seq;
	}
	public void setDutch_seq(int dutch_seq) {
		this.dutch_seq = dutch_seq;
	}
	public int getAccount_seq() {
		return account_seq;
	}
	public void setAccount_seq(int account_seq) {
		this.account_seq = account_seq;
	}
	public String getDutch_mem_id() {
		return dutch_mem_id;
	}
	public void setDutch_mem_id(String dutch_mem_id) {
		this.dutch_mem_id = dutch_mem_id;
	}
	public int getDutch_money() {
		return dutch_money;
	}
	public void setDutch_money(int dutch_money) {
		this.dutch_money = dutch_money;
	}
	
	
	@Override
	public String toString() {
		return "DutchVO [dutch_seq=" + dutch_seq + ", account_seq="
				+ account_seq + ", dutch_mem_id=" + dutch_mem_id
				+ ", dutch_money=" + dutch_money + "]";
	}
	
	
	
	

}
