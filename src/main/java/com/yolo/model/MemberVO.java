package com.yolo.model;


/**
<<<<<<< .mine
 * MemberVO.java
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
public class MemberVO {

	private int mem_seq;	//고유번호
	private String mem_id;	//회원 아이디
	private String mem_mail;//회원 메일
	private String mem_pass;//회원 비밀번호
	private String mem_add1;//회원 주소
	private String mem_add2;//회원 상세주소
	private String mem_tel;//회원 전화번호
	private String mem_age;//나이
	private String mem_gen;//성별
	private String mem_name;//이름
	private String mem_nick;//닉네임
	private String mem_warn;//경고
	private String mem_profile;//프로필사진
	private String mem_st;//회원 사용여부
	public int getMem_seq() {
		return mem_seq;
	}
	public void setMem_seq(int mem_seq) {
		this.mem_seq = mem_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_add1() {
		return mem_add1;
	}
	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}
	public String getMem_add2() {
		return mem_add2;
	}
	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_age() {
		return mem_age;
	}
	public void setMem_age(String mem_age) {
		this.mem_age = mem_age;
	}
	public String getMem_gen() {
		return mem_gen;
	}
	public void setMem_gen(String mem_gen) {
		this.mem_gen = mem_gen;
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
	public String getMem_warn() {
		return mem_warn;
	}
	public void setMem_warn(String mem_warn) {
		this.mem_warn = mem_warn;
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
	@Override
	public String toString() {
		return "MemberVO [mem_seq=" + mem_seq + ", mem_id=" + mem_id
				+ ", mem_mail=" + mem_mail + ", mem_pass=" + mem_pass
				+ ", mem_add1=" + mem_add1 + ", mem_add2=" + mem_add2
				+ ", mem_tel=" + mem_tel + ", mem_age=" + mem_age
				+ ", mem_gen=" + mem_gen + ", mem_name=" + mem_name
				+ ", mem_nick=" + mem_nick + ", mem_warn=" + mem_warn
				+ ", mem_profile=" + mem_profile + ", mem_st=" + mem_st + "]";
	}
	
	public MemberVO(int mem_seq, String mem_id, String mem_mail,
			String mem_pass, String mem_add1, String mem_add2, String mem_tel,
			String mem_age, String mem_gen, String mem_name, String mem_nick,
			String mem_warn, String mem_profile, String mem_st) {
		super();
		this.mem_seq = mem_seq;
		this.mem_id = mem_id;
		this.mem_mail = mem_mail;
		this.mem_pass = mem_pass;
		this.mem_add1 = mem_add1;
		this.mem_add2 = mem_add2;
		this.mem_tel = mem_tel;
		this.mem_age = mem_age;
		this.mem_gen = mem_gen;
		this.mem_name = mem_name;
		this.mem_nick = mem_nick;
		this.mem_warn = mem_warn;
		this.mem_profile = mem_profile;
		this.mem_st = mem_st;
	}
	public MemberVO() {
		super();
	}
	
}
