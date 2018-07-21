package com.yolo.model;


/**
<<<<<<< .mine
 * LoginInfoVO.java
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
public class LoginInfoVO {
	
	private int login_seq;	//고유번호 스퀀시
	private String mem_id;	//회원 아이디
	private int login_st;	//로그인상태
	private String login_dt;//로그인 날짜
	private String logout_dt;//로그아웃 날짜
	
	public LoginInfoVO(){
		super();
	}
	
	public LoginInfoVO(int login_seq, String mem_id, int login_st,
			String login_dt, String logout_dt) {
		super();
		this.login_seq = login_seq;
		this.mem_id = mem_id;
		this.login_st = login_st;
		this.login_dt = login_dt;
		this.logout_dt = logout_dt;
	}

	public int getLogin_seq() {
		return login_seq;
	}
	public void setLogin_seq(int login_seq) {
		this.login_seq = login_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getLogin_st() {
		return login_st;
	}
	public void setLogin_st(int login_st) {
		this.login_st = login_st;
	}
	public String getLogin_dt() {
		return login_dt;
	}
	public void setLogin_dt(String login_dt) {
		this.login_dt = login_dt;
	}
	public String getLogout_dt() {
		return logout_dt;
	}
	public void setLogout_dt(String logout_dt) {
		this.logout_dt = logout_dt;
	}
	
	
	@Override
	public String toString() {
		return "LoginInfoVO [login_seq=" + login_seq + ", mem_id=" + mem_id
				+ ", login_st=" + login_st + ", login_dt=" + login_dt
				+ ", logout_dt=" + logout_dt + "]";
	}
	
	
	

}
