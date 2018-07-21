package com.yolo.model;

import java.util.List;


/**
<<<<<<< .mine
 * Like_areaVO.java
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
public class Like_areaVO {
	
	private int area_seq;	//관심지역 스퀀시
	private String mem_id;	//회원 아이디
	private String area_code;	//관심지역 코드
	public Like_areaVO(){
		super();
	}
	public Like_areaVO(int area_seq, String mem_id, String area_code) {
		super();
		this.area_seq = area_seq;
		this.mem_id = mem_id;
		this.area_code = area_code;
	}


	public int getArea_seq() {
		return area_seq;
	}
	public void setArea_seq(int area_seq) {
		this.area_seq = area_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	
	
	@Override
	public String toString() {
		return "Like_areaVO [area_seq=" + area_seq + ", mem_id=" + mem_id
				+ ", area_code=" + area_code + "]";
	}
	
	

}
