package com.yolo.service.schedule;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Bookmark_scheVO;
import com.yolo.model.Content_detailVO;
import com.yolo.model.MemberVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.Schedule_detailVO;

public interface ScheduleServiceInf {
	
	
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
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : in userId out bookmarkVO
	 */
	public List<Bookmark_areaVO> getBookmarkList(String mem_id);

	
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
	 * Method : insertContentDetail
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param contentVOList
	 * Method 설명 : 세부일정 내용 저장
	 * @return 
	 */
	public int insertContentDetail(Content_detailVO contentVOList);

	/**
	 * 
	 * Method : selectSchDetail
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param scheduleSeq
	 * @return
	 * Method 설명 : 스케쥴 번호 입력시 해당 스케쥴의 상세 일정 목록 조회
	 */
	public List<Schedule_detailVO> selectSchDetail(int scheduleSeq);

	/**
	 * 
	 * Method : selectContentDetailList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param detailSeq
	 * @return
	 * Method 설명 : 세부일정 번호 입력시 내용 리스트 출력
	 */
	public List<Content_detailVO> selectContentDetailList(int detailSeq);

	/**
	 * 
	 * Method : insertContent
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param contentList
	 * @param multipartRequest
	 * Method 설명 : multi row save method
	 */
	public void insertContent(List<Content_detailVO> contentList,
			MultipartHttpServletRequest multipartRequest, HttpSession session);

	
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
	 * Method : createScheDetail
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param scheDetail
	 * Method 설명 : 일정 상세 처음 생성
	 * @return 
	 */
	public int createScheDetail(Schedule_detailVO scheDetail);
	
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
	 * Method : getMaxStepNum
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param detail_seq_int
	 * @return
	 * Method 설명 : 일정리스트의 가장 큰 스텝값 반환 
	 */
	public int getMaxStepNum(int detail_seq_int);

	/**
	 * 
	 * Method : deleteDetail
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param detail_seq
	 * Method 설명 : 일정 삭제
	 * @return 
	 */
	public int deleteDetail(int detail_seq);
	
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
	 * Method : selectBookMarkSeq
	 * 최초작성일 : 2018. 7. 8.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param paramMap
	 * Method 설명 : 즐겨찾기 등록유무 조회 있으면 1 없으면 0
	 * @return 
	 */
	public int selectBookMarkSeq(Map<String, String> paramMap);

	/**
	 * 
	 * Method : insertBookMarkSeq
	 * 최초작성일 : 2018. 7. 8.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param insertParam
	 * Method 설명 : 일정 즐겨찾기 추가
	 */
	public int insertBookMarkSeq(Map<String, String> insertParam);

	/**
	 * 
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param contentList
	 * @return
	 * Method 설명 :해당 컨텐츠 리스트에서 bookmarkArea가져오기
	 */
	public List<Bookmark_areaVO> getBookmarkList(
			List<Content_detailVO> contentList,HttpSession session);

	/**
	 * 
	 * Method : getScheduleMemId
	 * 최초작성일 : 2018. 7. 16.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param schedule_seq
	 * @return
	 * Method 설명 :해당 스케쥴의 유저 아이디 가져오기
	 */
	public String getScheduleMemId(int schedule_seq);

	
	public List<Bookmark_areaVO> getBookmarkListStr(
			List<Content_detailVO> contentList, String mem_id);
	
	
}
