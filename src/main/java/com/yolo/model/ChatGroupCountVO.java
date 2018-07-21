package com.yolo.model;

/**
 * ChatGroupCountVO.java
 *
 * @author Jun
 * @since 2018. 7. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 12. Jun 최초 생성
 *
 * </pre>
 */
public class ChatGroupCountVO {
	private int chat_seq;
	private int chat_count;

	public int getChat_seq() {
		return chat_seq;
	}

	public void setChat_seq(int chat_seq) {
		this.chat_seq = chat_seq;
	}
	
	public int getChat_count() {
		return chat_count;
	}

	
	public void setChat_count(int chat_count) {
		this.chat_count = chat_count;
	}
	
	/**
	 * Method : toString
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	@Override
	public String toString() {
		return "ChatGroupCountVO [chat_seq=" + chat_seq + ", chat_count="
				+ chat_count + "]";
	}
}
