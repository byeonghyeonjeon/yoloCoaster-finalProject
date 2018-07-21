/**
 * 
 */
package com.yolo.model;

/**
 * ChatVO.java
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
public class ChatVO {
	
	private int chat_seq;
	private String chat_st;
	private int chat_album;
	private int chat_book_total;
	
	public ChatVO(){
		super();
	}
	
	public ChatVO(int chat_seq, String chat_st, int chat_album,
			int chat_book_total) {
		super();
		this.chat_seq = chat_seq;
		this.chat_st = chat_st;
		this.chat_album = chat_album;
		this.chat_book_total = chat_book_total;
	}

	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public String getChat_st() {
		return chat_st;
	}
	public void setChat_st(String chat_st) {
		this.chat_st = chat_st;
	}
	public int getChat_album() {
		return chat_album;
	}
	public void setChat_album(int chat_album) {
		this.chat_album = chat_album;
	}
	public int getChat_book_total() {
		return chat_book_total;
	}
	public void setChat_book_total(int chat_book_total) {
		this.chat_book_total = chat_book_total;
	}
	
	
	@Override
	public String toString() {
		return "ChatVO [chat_seq=" + chat_seq + ", chat_st=" + chat_st
				+ ", chat_album=" + chat_album + ", chat_book_total="
				+ chat_book_total + "]";
	}
	
	

}
