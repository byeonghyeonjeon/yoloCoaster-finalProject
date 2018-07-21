package com.yolo.dao.member.inf;

import java.util.List;

import com.yolo.model.AreaVO;

public interface AreaDaoInf {

	/**
	 * 
	 * Method : selectArea
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param areaCode
	 * @return
	 * Method 설명 : 코드를 넣으면 지역이름 리턴
	 */
	public AreaVO selectArea(String areaCode);

	/**
	 * 
	 * Method : deleteLikeArea
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 :회원의 관심지역 전체 삭제
	 */
	public int deleteLikeArea(String mem_id);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 :회원 여행지 즐겨찾기 전체 개수 조회
	 */
	public int selectBoardCnt(String mem_id);

	/**
	 * 
	 * Method : selectAreaCode
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param string
	 * @return
	 * Method 설명 :input name output code
	 */
	public String selectAreaCode(String string);

}
