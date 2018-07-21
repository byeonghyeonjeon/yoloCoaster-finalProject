package com.yolo.service.admin;

import java.util.List;
import java.util.Map;

import com.yolo.model.BoardVO;

public interface AdminBoardServiceInf {

	/**
	 * 
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 :qna 답변달기
	 */
	public int updateBoard(BoardVO boardVO);

	/**
	 * 
	 * Method : adminSelectBoardCnt
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 :게시판 검색
	 */
	public int adminSelectBoardCnt(Map<String, String> paramMap);

	/**
	 * 
	 * Method : adminSelectListboard
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap2
	 * @return
	 * Method 설명 :검색 페이지네이션
	 */
	public List<BoardVO> adminSelectListboard(Map<String, String> paramMap);

	/**
	 * 
	 * Method : deleteDataBoard
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link
	 * @return
	 * Method 설명 :게시글 완전삭제
	 */
	public int deleteDataBoard(String link);

	/**
	 * 
	 * Method : boardStReset
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 게시글 재설정
	 */
	public int boardStReset(Map<String, String> paramMap);

	/**
	 * 
	 * Method : adminBoardStCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 :활성화중인 게시글
	 */
	public int adminBoardStCnt(Map<String, String> paramMap);

}
