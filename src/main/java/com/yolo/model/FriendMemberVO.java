/**
 * 
 */
package com.yolo.model;

/**
 * FriendMemberVO.java
 *
 * @author Jun
 * @since 2018. 6. 22.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 22. Jun 최초 생성
 * 프로필 조회용 vo
 * </pre>
 */
public class FriendMemberVO {
	private String mem_id; // 회원 아이디
	private String mem_name;// 이름
	private String mem_nick;// 닉네임
	private String mem_profile;// 프로필사진 파일이름 및 확장자
	private String mem_st;// 회원 사용여부
	private String friend_request;// 친구 요청 상태
	private String friend_st;// 접속 상태

	public FriendMemberVO(String mem_id, String mem_name, String mem_nick,
			String mem_profile, String mem_st, String friend_request,
			String friend_st) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_nick = mem_nick;
		this.mem_profile = mem_profile;
		this.mem_st = mem_st;
		this.friend_request = friend_request;
		this.friend_st = friend_st;
	}

	public FriendMemberVO() {
		super();
	}

	@Override
	public String toString() {
		return "FriendMemberVO [mem_id=" + mem_id + ", mem_name=" + mem_name
				+ ", mem_nick=" + mem_nick + ", mem_profile=" + mem_profile
				+ ", mem_st=" + mem_st + ", friend_request=" + friend_request
				+ ", friend_st=" + friend_st + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getMem_profile() {
		return mem_profile;
	}

	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}

	public String getMem_st() {
		return mem_st;
	}

	public void setMem_st(String mem_st) {
		this.mem_st = mem_st;
	}

	public String getFriend_request() {
		return friend_request;
	}

	public void setFriend_request(String friend_request) {
		this.friend_request = friend_request;
	}

	public String getFriend_st() {
		return friend_st;
	}

	public void setFriend_st(String friend_st) {
		this.friend_st = friend_st;
	}

}
