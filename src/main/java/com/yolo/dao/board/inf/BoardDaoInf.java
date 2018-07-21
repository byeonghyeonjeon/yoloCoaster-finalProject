package com.yolo.dao.board.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.PageVO;
import com.yolo.model.ScheduleVO;

public interface BoardDaoInf {


	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param pboard
	 * @return
	 * Method 설명 : 해당 게시판 총 게시글
	 */
	public int selectBoardCnt(int pboard);

	/**
	 * 
	 * Method : getboardList
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 :페이지에 셋팅해서 넘기면 게시판 리스트 받기
	 */
	public List<BoardVO> getboardList(PageVO page);

	/**
	 * 
	 * Method : insertBoard
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param board
	 * @return
	 * Method 설명 : 글쓰기
	 */
	public int insertBoard(BoardVO board);

	/**
	 * 
	 * Method : selectBoard
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param boardNo
	 * @return
	 * Method 설명 : 게시글 하나 조회
	 * 
	 */
	public BoardVO selectBoard(int boardNo);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 리스트 총갯수 구하기
	 */
	public int selectBoardCnt(String mem_id);

	public List<Bookmark_areaVO> getBookmarkAreaPageList(Map<String, String> pageMap);

	/**
	 * 
	 * Method : updateHit
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link
	 * @return
	 * Method 설명 :게시글 조회시 조회수 증가
	 */
	public int updateHit(int link);
	
	/**
	 * Method : getBookmarkAreaByMem_idAndContentid
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param bookmark_areaVO
	 * @return
	 * Method 설명 : 즐겨찾기 추가시 해당 즐겨찾기가 해당 멤버에게 있는지 확인
	 */
	public int getBookmarkAreaByMem_idAndContentid(Bookmark_areaVO bookmark_areaVO);
	
	/**
	 * Method : insertBookmarkArea
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param bookmark_areaVO
	 * @return
	 * Method 설명 : 여행지 즐겨찾기에 추가
	 */
	public int insertBookmarkArea(Bookmark_areaVO bookmark_areaVO);
	
	/**
	 * Method : getBookmarkAreaRightBar
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageMap
	 * @return
	 * Method 설명 : 우측바 즐겨찾기 목록(페이징처리)
	 */
	public List<Bookmark_areaVO> getBookmarkAreaRightBar(Map<String, String> pageMap);

	/**
	 * 
	 * Method : deleteBoard
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link
	 * @return
	 * Method 설명 :게시글 삭제
	 */
	public int deleteBoard(String link);

	/**
	 * 
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 :게시글 수정
	 */
	public int updateBoard(BoardVO boardVO);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param i
	 * @param keyword
	 * @return
	 * Method 설명 : 게시판 내 검색
	 */
	public int selectBoardCnt(int i, String keyword);

	/**
	 * 
	 * Method : getboardList
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param page
	 * @param keyword
	 * @return
	 * Method 설명 : 게시판 검색결과 페이지
	 */
	public List<BoardVO> getboardList(PageVO page, String keyword);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @return
	 * Method 설명 :관리자용 페이지 네이션
	 */
	public int adminSelectBoardCnt(int param);

	/**
	 * 
	 * Method : adminSelectListboard
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 :관리자용 페이지 네이션
	 */
	public List<BoardVO> adminSelectListboard(PageVO page);

	/**
	 * 
	 * Method : todayRegBoard
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 관리자 게시판 통계
	 */
	public int todayRegBoard(Map<String, String> paramMap);

	/**
	 * 
	 * Method : adminBoardWait
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 관리자 테이블
	 */
	public int adminBoardWait(Map<String, String> paramMap);

	/**
	 * 
	 * Method : adminSelectBoardCnt
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 관리자 게시판 페이지네이션 총갯수
	 */
	public int adminSelectBoardCnt(Map<String, String> paramMap);

	/**
	 * 
	 * Method : adminSelectListboard
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 :관리자 검색 페이지네이션
	 */
	public List<BoardVO> adminSelectListboard(Map<String, String> paramMap);

	/**
	 * 
	 * Method : deleteDataBoard
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param i
	 * @return
	 * Method 설명 :게시글 완전삭제
	 */
	public int deleteDataBoard(int param);

	/**
	 * 
	 * Method : boardStReset
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 게시글 상태 재설정
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
