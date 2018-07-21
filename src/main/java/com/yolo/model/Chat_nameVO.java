/**
 * 
 */
package com.yolo.model;


/**
 * Chat_nameVO.java
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
public class Chat_nameVO {

	private int chat_name_seq;
	private int chat_seq;
	private String name;
	private String mem_id;
	
	public Chat_nameVO(){
		super();
	}
	
	public Chat_nameVO(int chat_name_seq, int chat_seq, String name,
			String mem_id) {
		super();
		this.chat_name_seq = chat_name_seq;
		this.chat_seq = chat_seq;
		this.name = name;
		this.mem_id = mem_id;
	}


	public int getChat_name_seq() {
		return chat_name_seq;
	}
	public void setChat_name_seq(int chat_name_seq) {
		this.chat_name_seq = chat_name_seq;
	}
	public int getChat_seq() {
		return chat_seq;
	}
	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
	@Override
	public String toString() {
		return mem_id;
	}
	
	
	
}
