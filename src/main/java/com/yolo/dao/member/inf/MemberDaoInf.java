package com.yolo.dao.member.inf;

import com.yolo.model.MemberVO;

public interface MemberDaoInf {
	
	public MemberVO getMemberLogin(MemberVO member);
	
	/**
	 * 
	 * Method : selectMemberInfo
	 * 최초작성일 : 2018. 6. 18.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param member
	 * @return
	 * Method 설명 :회원 전체 정보 조회
	 */
	public MemberVO selectMemberInfo(MemberVO member);

	/**
	 * 
	 * Method : checkMemPass
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param member
	 * @return
	 * Method 설명 : 회원 비밀번호 확인
	 */
	public int checkMemPass(MemberVO member);
	
	/**
	 * 
	 * Method : updateMemberInfo
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param member
	 * @return
	 * Method 설명 :회원정보 수정
	 * 
	 */
	public int updateMemberInfo(MemberVO member);

	/**
	 * 
	 * Method : updateMemeberSt
	 * 최초작성일 : 2018. 7. 13.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 :회원탈퇴
	 */
	public int updateMemeberSt(String mem_id);

}
