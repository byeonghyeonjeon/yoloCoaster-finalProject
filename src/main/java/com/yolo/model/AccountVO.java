/**
 * 
 */
package com.yolo.model;

/**
 * AccountVO.java
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
/**
 * @author PC15
 *
 */
public class AccountVO {
	
	private int account_seq;
	private int chat_seq;
	private int account_total;
	private String account_dt;
	private int account_cnt;
	private String account_num;
	private String account_info;
	private String account_memo;
	private String account_detail;
	private String mem_id;
	
	
	
	public AccountVO(){
		super();
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getAccount_detail() {
		return account_detail;
	}
	public void setAccount_detail(String account_detail) {
		this.account_detail = account_detail;
	}

	public int getAccount_seq() {
		return account_seq;
	}
	public void setAccount_seq(int account_seq) {
		this.account_seq = account_seq;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public int getAccount_total() {
		return account_total;
	}
	public void setAccount_total(int account_total) {
		this.account_total = account_total;
	}
	public String getAccount_dt() {
		return account_dt;
	}
	public void setAccount_dt(String account_dt) {
		this.account_dt = account_dt;
	}
	public int getAccount_cnt() {
		return account_cnt;
	}
	public void setAccount_cnt(int account_cnt) {
		this.account_cnt = account_cnt;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getAccount_info() {
		return account_info;
	}
	public void setAccount_info(String account_info) {
		this.account_info = account_info;
	}
	public String getAccount_memo() {
		return account_memo;
	}
	public void setAccount_memo(String account_memo) {
		this.account_memo = account_memo;
	}

	public AccountVO(int account_seq, int chat_seq, int account_total,
			String account_dt, int account_cnt, String account_num,
			String account_info, String account_memo, String account_detail, String mem_id) {
		super();
		this.account_seq = account_seq;
		this.chat_seq = chat_seq;
		this.account_total = account_total;
		this.account_dt = account_dt;
		this.account_cnt = account_cnt;
		this.account_num = account_num;
		this.account_info = account_info;
		this.account_memo = account_memo;
		this.account_detail = account_detail;
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "AccountVO [account_seq=" + account_seq + ", chat_seq="
				+ chat_seq + ", account_total=" + account_total
				+ ", account_dt=" + account_dt + ", account_cnt=" + account_cnt
				+ ", account_num=" + account_num + ", account_info="
				+ account_info + ", account_memo=" + account_memo
				+ ", account_detail=" + account_detail + ", mem_id=" + mem_id
				+ "]";
	}
	
	
	
	
	

}
