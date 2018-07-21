package com.yolo.dao.admin.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.MemJoinInfoVO;
import com.yolo.model.MemberVO;

public interface MemInfoDaoInf {
	

	public List<MemJoinInfoVO> getMemberList(Map<String, String> paramMap);
	
	public int getMemberListCnt(Map<String, String>paramMap);

	public int todayRegMember();

	public int todayDropMember();

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

	/**
	 * 
	 * Method : selectBlackList
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 :블랙리스트 있는지 확인
	 */
	public int selectBlackList(String mem_id);
	
	/**
	 * 
	 * Method : insertBlackList
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 :블랙리스트 추가
	 */
	public int insertBlackList(String mem_id);

	public int updateMemSTBlack(Map<String, String> paramMap);
}
