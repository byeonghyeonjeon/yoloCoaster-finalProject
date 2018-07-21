package com.yolo.model;


/**
<<<<<<< .mine
 * MessageVO.java
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
public class MessageVO {

	private int message_seq;	//메세지 시퀀시
	private int chat_seq;		//채팅 아이디
	private String message_mem_id;//회원 아이디
	private String message_content;//메세지 내용
	private String message_sort;	//메세지 분류 1=텍스트 2=사진 3= 동영상4=이모티콘
	private String message_dt;		//메세지 보낸 날짜
	
	public MessageVO(){
		super();
	}
	
	public MessageVO(int message_seq, int chat_seq, String message_mem_id,
			String message_content, String message_sort, String message_dt) {
		super();
		this.message_seq = message_seq;
		this.chat_seq = chat_seq;
		this.message_mem_id = message_mem_id;
		this.message_content = message_content;
		this.message_sort = message_sort;
		this.message_dt = message_dt;
	}


	public int getMessage_seq() {
		return message_seq;
	}
	public void setMessage_seq(int message_seq) {
		this.message_seq = message_seq;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public String getMessage_mem_id() {
		return message_mem_id;
	}
	public void setMessage_mem_id(String message_mem_id) {
		this.message_mem_id = message_mem_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getMessage_sort() {
		return message_sort;
	}
	public void setMessage_sort(String message_sort) {
		this.message_sort = message_sort;
	}
	public String getMessage_dt() {
		return message_dt;
	}
	public void setMessage_dt(String message_dt) {
		this.message_dt = message_dt;
	}
	
	@Override
	public String toString() {
		return "MessageVO [message_seq=" + message_seq + ", chat_seq="
				+ chat_seq + ", message_mem_id=" + message_mem_id
				+ ", message_content=" + message_content + ", message_sort="
				+ message_sort + ", message_dt=" + message_dt + "]";
	}
	
	
	
	
	
}
