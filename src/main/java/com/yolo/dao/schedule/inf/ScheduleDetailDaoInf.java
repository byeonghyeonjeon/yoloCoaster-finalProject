package com.yolo.dao.schedule.inf;

import java.util.List;

import com.yolo.model.Content_detailVO;
import com.yolo.model.Schedule_detailVO;

public interface ScheduleDetailDaoInf {

	/**
	 * 
	 * Method : selectSchDetail
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param scheduleSeq
	 * @return
	 * Method 설명 : 일정 seq 입력시 해당 일정의 세부일정 리스트 받아오기
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
	 * Method 설명 :세부일정 번호 입력시 해당내용 리스트 출력
	 */
	public List<Content_detailVO> selectContentDetailList(int detailSeq);

	/**
	 * 
	 * Method : createScheDetail
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param testDetail
	 * Method 설명 :상세일정이 하나도 없는 경우 생성
	 * @return 
	 */
	public int createScheDetail(Schedule_detailVO ScheDetailVO);

	/**
	 * 
	 * Method : deleteDetail
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param detail_seq
	 * @return
	 * Method 설명 : 세부 일정 삭제
	 */
	public int deleteDetail(int detail_seq);

}
