/**
 * 
 */
package com.yolo.model;


/**
 * Book_incomeVO.java
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
public class BookVO {
	
	private int book_seq;
	private int chat_seq;
	private String book_dt;		//yyyy.mm.dd
	private String book_time;	//hh:mi
	private String book_cate;
	private int book_money;
	private String book_detail;
	private String book_method;
	private String book_memo;
	private String book_mem_id;
	private String book_inout;
	

	public BookVO(){		
		super();
	}
	
	public BookVO(int book_seq, int chat_seq, String book_dt, String book_time,
			String book_cate, int book_money, String book_detail,
			String book_method, String book_memo, String book_mem_id,
			String book_inout) {
		super();
		this.book_seq = book_seq;
		this.chat_seq = chat_seq;
		this.book_dt = book_dt;
		this.book_time = book_time;
		this.book_cate = book_cate;
		this.book_money = book_money;
		this.book_detail = book_detail;
		this.book_method = book_method;
		this.book_memo = book_memo;
		this.book_mem_id = book_mem_id;
		this.book_inout = book_inout;
	}	

	@Override
	public String toString() {
		return "BookVO [book_seq=" + book_seq + ", chat_seq=" + chat_seq
				+ ", book_dt=" + book_dt + ", book_time=" + book_time
				+ ", book_cate=" + book_cate + ", book_money=" + book_money
				+ ", book_detail=" + book_detail + ", book_method="
				+ book_method + ", book_memo=" + book_memo + ", book_mem_id="
				+ book_mem_id + ", book_inout=" + book_inout + "]";
	}
	
	
	public String getBook_inout() {
		return book_inout;
	}
	
	public void setBook_inout(String book_inout) {
		this.book_inout = book_inout;
	}
	
	public int getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public String getBook_dt() {
		return book_dt;
	}
	public void setBook_dt(String book_dt) {
		this.book_dt = book_dt;
	}
	public String getBook_time() {
		return book_time;
	}
	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}
	public String getBook_cate() {
		return book_cate;
	}
	public void setBook_cate(String book_cate) {
		this.book_cate = book_cate;
	}
	public int getBook_money() {
		return book_money;
	}
	public void setBook_money(int book_money) {
		this.book_money = book_money;
	}
	public String getBook_detail() {
		return book_detail;
	}
	public void setBook_detail(String book_detail) {
		this.book_detail = book_detail;
	}
	public String getBook_method() {
		return book_method;
	}
	public void setBook_method(String book_method) {
		this.book_method = book_method;
	}
	public String getBook_memo() {
		return book_memo;
	}
	public void setBook_memo(String book_memo) {
		this.book_memo = book_memo;
	}
	public String getBook_mem_id() {
		return book_mem_id;
	}
	public void setBook_mem_id(String book_mem_id) {
		this.book_mem_id = book_mem_id;
	}
	
	
		

}
