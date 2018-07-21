
package com.yolo.service.admin;

import java.util.List;
import java.util.Map;

import com.yolo.model.MemJoinInfoVO;
import com.yolo.model.MemberVO;

public interface MemInfoServiceInf {

	public List<MemJoinInfoVO> getMemberList(Map<String, String> paramMap);
	public int getMemberListCnt(Map<String, String>paramMap);
	/**
	 * 
	 * Method : todayRegMember
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @return
	 * Method 설명 : 하루동안 가입한 인원 출력
	 */
	public int todayRegMember();
	/**
	 * 
	 * Method : todatDrop
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	public int todatDrop();
	
	/**
	 * 
	 * Method : blackList
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 블랙리스트 관리
	 */
	public int blackList(Map<String, String> paramMap);
	
}
