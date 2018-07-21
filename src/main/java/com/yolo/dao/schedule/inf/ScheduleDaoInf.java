package com.yolo.dao.schedule.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Bookmark_scheVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.ScheduleVO;

public interface ScheduleDaoInf {
	
	
	/**
	 * 
	 * Method : getMemberScheduleList
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param memberVO
	 * @return ScheduleVO 회원의 스케줄 목록
	 * Method 설명 : 회원의 정보를 받아서 회원의 스케쥴을 가져온다
	 */
	public List<ScheduleVO> getMemberScheduleList(String mem_id);
	
	
	/**
	 * 
	 * Method : insertSchedule
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param insert
	 * @return
	 * Method 설명 : 마이페이지 일정을 생성하는 메서드
	 */
	public int insertSchedule(ScheduleVO insert);
	
	/**
	 * 
	 * Method : getScheduleDetail
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 : 스케줄 한개의 정보를 조회 ( 일정 간단 수정하기 위한 메서드 )
	 */
	public ScheduleVO getScheduleDetail(int seq);
	
	/**
	 * Method : modifyScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return 리턴의 값은 성공하면 1 실패하면 0을 반환한다
	 * Method 설명 : 모달창의 수정버튼을 통해 업데이트 하는 메서드
	 */
	public int modifyScheduleModal(ScheduleVO vo);
	
	
	/**
	 * 
	 * Method : deleteScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return 삭제가 되면 1을 반환한다
	 * Method 설명 : 모달창에서 삭제버튼을 통해 일정 삭제하는 메서드
	 */
	public int deleteScheduleModal(int seq);

	/**
	 * 
	 * Method : dragScheduleModify
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더에서 드래그로 일정을 수정
	 */
	public int dragScheduleModify(ScheduleVO vo);
	
	
	/**
	 * 
	 * Method : getchatScheduleList
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return 해당 일정방에 대한 일정목록들을 가져온다
	 * Method 설명 : 채팅방의 채팅방 ID값을 받아서 ID에 대한 일정 목록을 가져오는 메서드
	 */
	public List<ScheduleVO> getchatScheduleList(ScheduleVO vo);
	
	
	/**
	 * 
	 * Method : insertChatScheduleModal
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param insert
	 * @return
	 * Method 설명 : 채팅방의 일정을 생성하는 메서드
	 */
	public int insertChatScheduleModal(ScheduleVO insert);

	
	/**
	 * 
	 * Method : chatModifyScheduleModal
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param update
	 * @return
	 * Method 설명 : 채팅방에서 일정을 수정하는 메서드
	 */
	public int chatModifyScheduleModal(ScheduleVO update);


	/**
	 * 
	 * Method : selectScheListForBoard
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 일정검색 게시판 리스트
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
	 * Method 설명 :스케쥴 페이지네이션
	 */
	public List<ScheduleVO> getSchePageList(PageVO page);
	
	/**
	 * 
	 * Method : deleteScheduleModal
	 * 최초작성일 : 2018. 7. 03.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return 삭제가 되면 1을 반환한다
	 * Method 설명 : 모달창에서 삭제버튼을 통해 일정 삭제하는 메서드
	 */
	public int chatDeleteScheduleModal(int seq);

	/**
	 * 
	 * Method : dragScheduleModify
	 * 최초작성일 : 2018. 7. 03.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더에서 드래그로 일정을 수정
	 */
	public int chatDragScheduleModify(ScheduleVO vo);
	
	
	/**
	 * 
	 * Method : myCalendarBookMarkList
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 로그인한 회원의 아이디로 북마크 즐겨찾기를 가져온다.
	 */
	public List<Bookmark_scheVO> myCalendarBookMarkList(String mem_id);
	
	
	/**
	 * 
	 * Method : bookMarkscheduleInsert
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더에서 일정 즐겨찾기를 캘린더에 추가하는 메서드
	 */
	public int bookMarkscheduleInsert(ScheduleVO vo);
	
	/**
	 * 
	 * Method : myCalendarBookMarkCheckDelete
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더 일정 즐겨찾기에서 즐겨찾기 제외 클릭시 일정 즐겨찾기 에서 삭제
	 */
	public int myCalendarBookMarkCheckDelete(Bookmark_scheVO delete);


	/**
	 * 
	 * Method : selectScheListForBoard
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : brown
	 * 변경이력 :
	 * @param pram
	 * @return
	 * Method 설명 : 일정검색
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
	 * Method 설명 : 일정 검색 페이지 네이션
	 */
	public List<ScheduleVO> getSchePageList(PageVO page, String param);


	/**
	 * 
	 * Method : selectBookMarkSeq
	 * 최초작성일 : 2018. 7. 8.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 즐겨찾기 조회 있으면 1 없으면 0
	 */
	public int selectBookMarkSeq(Map<String, String> paramMap);


	/**
	 * 
	 * Method : insertBookMarkSeq
	 * 최초작성일 : 2018. 7. 8.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param insertParam
	 * @return
	 * Method 설명 : 일정 즐겨찾기 추가
	 */
	public int insertBookMarkSeq(Map<String, String> insertParam);


	/**
	 * 
	 * Method : getScheduleMemId
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param schedule_seq
	 * @return
	 * Method 설명 :해당 유저 아이디 가져오기
	 */
	public String getScheduleMemId(int schedule_seq);
	
	
}
