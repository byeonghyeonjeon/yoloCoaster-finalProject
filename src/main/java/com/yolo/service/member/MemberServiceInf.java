package com.yolo.service.member;

import java.util.List;

import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.MemberVO;

public interface MemberServiceInf {

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
	 * Method : selectMemberInfoNonBlind
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param member
	 * @return
	 * Method 설명 :개인정보 수정에 사용되는 회원정보
	 */
	public MemberVO selectMemberInfoNonBlind(MemberVO member);

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
	 * Method : selectBookmarkArea
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 :회원의 즐겨찾기 여행지 리스트 불러오기
	 */
	public List<Bookmark_areaVO> selectBookmarkArea(String mem_id);

	/**
	 * 
	 * Method : deleteBookmarkArea
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link
	 * @return
	 * Method 설명 : 여행지 즐겨찾기 삭제
	 */
	public int deleteBookmarkArea(int link);

	/**
	 * 
	 * Method : updateMemeberSt
	 * 최초작성일 : 2018. 7. 13.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * Method 설명 :회원탈퇴
	 */
	public void updateMemeberSt(String mem_id);
}
