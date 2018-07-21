/**
 * 
 */
package com.yolo.yolo.dao.schedule;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.yolo.dao.schedule.inf.ScheduleDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;
import com.yolo.model.ScheduleVO;

/**
 * ChatScheduleTest.java
 *
 * @author KGY
 * @since 2018. 6. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 28. KGY 최초 생성
 *
 * </pre>
 */
public class ChatScheduleTest extends TestInit {

	@Resource
	public ScheduleDaoInf scheduleDao;
	
	MemberVO memberVO;
	
	@Before
	public void setup() {
		memberVO = new MemberVO();
		
	};
	
	/**
	 * 
	 * Method : chatScheduleDaoTest
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : Dao 연결 테스트
	 */
	@Test
	public void chatScheduleDaoTest() {
		/***Given***/
		//조건
		
		/***When***/
		//행동

		/***Then***/
		//예상결과
		assertNotNull(scheduleDao);
	}	
	
	
	
	/**
	 * 
	 * Method : chatScheduleListTest
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 채팅방의 일정을 가져오는 메서드 테스트
	 *
	 */
	@Test
	public void chatScheduleListTest(){
		/***Given***/
		//조건
		ScheduleVO scheduleVO = new ScheduleVO();
		
		scheduleVO.setChat_seq(18);;
		/***When***/
		//행동
		
		/***Then***/
		//예상결과
		assertEquals(6, scheduleDao.getchatScheduleList(scheduleVO).size());

	}
	
	
	/**
	 * 
	 * Method : insertChatScheduleModalTest
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 채팅방의 스케줄일정이 생성이 되는지 테스트
	 */
	@Test
	public void insertChatScheduleModalTest(){
		/***Given***/
		//조건
		ScheduleVO scheduleVO = new ScheduleVO();
		
		scheduleVO.setSchedule_mem_id("d001");
		scheduleVO.setSchedule_title("선경아 그 뮤비 야하다 노래 제목이 머냐");
		scheduleVO.setSchedule_start("2018-06-09");
		scheduleVO.setSchedule_end("2018-06-11");
		scheduleVO.setSchedule_label("949494");
		scheduleVO.setSchedule_private("Y");
		scheduleVO.setChat_seq(18);
		/***When***/
		//행동

		int insert = scheduleDao.insertChatScheduleModal(scheduleVO);
		
		/***Then***/
		//예상결과
		assertEquals(1, insert);
		
		
	}
	

}
