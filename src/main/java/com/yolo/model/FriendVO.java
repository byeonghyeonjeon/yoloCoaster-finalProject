package com.yolo.model;


/**
 * FriendVO.java
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
public class FriendVO {
	
	private int friend_seq;
	private String mem_id;
	private String friend_id;
	private String friend_request;
	private String friend_st;
	
	public FriendVO(){
		super();
	}
	
	public int getFriend_seq() {
		return friend_seq;
	}
	public void setFriend_seq(int friend_seq) {
		this.friend_seq = friend_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}
	public String getFriend_st() {
		return friend_st;
	}
	public void setFriend_st(String friend_st) {
		this.friend_st = friend_st;
	}

	public String getFriend_request() {
		return friend_request;
	}

	public void setFriend_request(String friend_request) {
		this.friend_request = friend_request;
	}

	public FriendVO(int friend_seq, String mem_id, String friend_id,
			String friend_request, String friend_st) {
		super();
		this.friend_seq = friend_seq;
		this.mem_id = mem_id;
		this.friend_id = friend_id;
		this.friend_request = friend_request;
		this.friend_st = friend_st;
	}

	@Override
	public String toString() {
		return "FriendVO [friend_seq=" + friend_seq + ", mem_id=" + mem_id
				+ ", friend_id=" + friend_id + ", friend_request="
				+ friend_request + ", friend_st=" + friend_st + "]";
	}
	
}
