package com.yolo.service.board;

import java.util.List;
import java.util.Map;

import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.File_addVO;
import com.yolo.model.PageVO;
import com.yolo.model.PboardVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.TagVO;

public interface BoardServiceInf {

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
	 * Method 설명 :  글쓰기
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
	 * Method 설명 : 게시글 하나 가져오기
	 */
	public BoardVO selectBoard(int boardNo);

	/**
	 * 
	 * Method : selectScheListForBoard
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 스케쥴 게시판 내용 가져오기
	 */
	public List<ScheduleVO> selectScheListForBoard();

	/**
	 * 
	 * Method : getSchePageList
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 :
	 */
	public List<ScheduleVO> getSchePageList(PageVO page);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 :
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
	 * Method 설명 :게시글 조회시 조회수 증가
	 * @return 
	 */
	public BoardVO updateHit(int link);

	/**
	 * 
	 * Method : insertTag
	 * 최초작성일 : 2018. 7. 4.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param tagVO
	 * Method 설명 : 태그 리스트 추가
	 * @return 
	 */
	public int insertTag(TagVO tagVO,int board_seq);

	/**
	 * 
	 * Method : selectTagList
	 * 최초작성일 : 2018. 7. 4.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 : 태그 가져오기
	 */
	public List<TagVO> selectTagList(int board_seq);

	/**
	 * 
	 * Method : selectImageList
	 * 최초작성일 : 2018. 7. 4.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link_int
	 * @return
	 * Method 설명 : 이미지 리스트 가져오기
	 */
	public List<File_addVO> selectImageList(int link_int);

	/**
	 * 
	 * Method : deleteBoard
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link
	 * Method 설명 : 게시글 상태 변경
	 * @return 
	 */
	public int deleteBoard(String link);

	/**
	 * 
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param boardVO
	 * Method 설명 : 게시글 수정
	 * @return 
	 */
	public int updateBoard(BoardVO boardVO);

	/**
	 * 
	 * Method : deleteTagList
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param link_int
	 * Method 설명 :해당글의 태그 다 지우기
	 */
	public int deleteTagList(int link_int);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param i 게시판 인덱스
	 * @param keyword 검색어
	 * @return
	 * Method 설명 : 게시판검색
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
	 * Method 설명 :게시판 검색 페이지
	 */
	public List<BoardVO> getboardList(PageVO page, String keyword);

	/**
	 * 
	 * Method : selectScheListForBoard
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : brown
	 * 변경이력 :
	 * @param pram
	 * @return
	 * Method 설명 : 스케쥴 일정 검색
	 */
	public int selectScheListForBoard(String pram);

	/**
	 * 
	 * Method : getSchePageList
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param page
	 * @param pram
	 * @return
	 * Method 설명 :검색어 페이지 네이션
	 */
	public List<ScheduleVO> getSchePageList(PageVO page, String pram);

	/**
	 * 
	 * Method : selectBoardCnt
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @return
	 * Method 설명 : 관리자용 게시판 페이지 네이션 총겟수
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
	 * Method 설명 :관리자용 통계
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
	 * Method 설명 : 관리자 통계 답변을 기다리는 게시판
	 */
	public int adminBoardWait(Map<String, String> paramMap);

	
}
