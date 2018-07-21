/**
 * 
 */
package com.yolo.yolo.dao.schedule;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.yolo.dao.schedule.inf.ScheduleDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.MemberVO;
import com.yolo.model.ScheduleVO;

/**
 * MyScheduleInsertTest.java
 *
 * @author KGY
 * @since 2018. 6. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 23. KGY 최초 생성
 *
 * </pre>
 */
public class MyPageCalendarTest extends TestInit{

	
	@Resource
	public ScheduleDaoInf scheduleDao;
	
	MemberVO memberVO;
	
	@Before
	public void setup() {
		memberVO = new MemberVO();
		
	};
	
	/**
	 * 
	 * Method : myPageCalendarDaoTest
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : Dao 연결이 되는지 테스트
	 */
	@Test
	public void myPageCalendarDaoTest() {
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
	 * Method : scheduleListCountTest
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 마이페이지 일정 개수 가져오기
	 */
	@Test
	public void scheduleLiWstCountTest(){
		/***Given***/
		//조건
		
		/***When***/
		//행동
		
		
		/***Then***/
		//예상결과
		assertEquals(7, scheduleDao.getMemberScheduleList("scheduleTest").size());
		assertEquals("scheduleTest",scheduleDao.getMemberScheduleList("scheduleTest").get(0).getSchedule_mem_id());
		assertEquals("마이크로닷과 함께하는 여행2",scheduleDao.getMemberScheduleList("scheduleTest").get(0).getSchedule_title());
		assertEquals("선경이와 함께하는 여행",scheduleDao.getMemberScheduleList("scheduleTest").get(5).getSchedule_title());
	}
	
	
	/**
	 * 
	 * Method : insertScheduleTest
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 일정 생성되는 메서드
	 */
	@Test
	public void insertScheduleTest() {
		/***Given***/
		//조건
		ScheduleVO scheduleVO = new ScheduleVO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse("2018-06-28");
			endDate = sdf.parse("2018-07-02");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		scheduleVO.setSchedule_mem_id("scheduleTest");
		scheduleVO.setChat_seq(1);
		scheduleVO.setSchedule_title("지희와 함께하는 여행");
//		scheduleVO.setSchedule_start(startDate);
//		scheduleVO.setSchedule_end(endDate);
		scheduleVO.setSchedule_start("2018-07-08");
		scheduleVO.setSchedule_end("2018-07-08");;
		scheduleVO.setSchedule_private("Y");
		scheduleVO.setSchedule_label("EEFF66");
		
		
		/***When***/
		//행동
		
		int insert = scheduleDao.insertSchedule(scheduleVO);

		/***Then***/
		//예상결과
//		일정이 생성 되는지 확인 일정 생성 되었으면 1 생성이 안되면 0
		assertEquals(1, insert);
	}
	
	
	@Test
	public void getScheduleDetailTest(){
		/***Given***/
		//조건
		
		/***When***/
		//행동
		
		/***Then***/
		//예상결과
		assertEquals(5, scheduleDao.getScheduleDetail(5).getSchedule_seq());
		assertEquals("마이크로닷과 함께하는 여행2", scheduleDao.getScheduleDetail(5).getSchedule_title());
	}
	
	
	/**
	 * 
	 * Method : modifyScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 모달창에서 수정버튼을 클랙했을때의 테스트
	 */
	@Test
	public void modifyScheduleModal(){
		/***Given***/
		//조건
		
		ScheduleVO scheduleVO = new ScheduleVO();
		
		scheduleVO.setSchedule_title("후범이와 함께하는 여행");
		scheduleVO.setSchedule_start("2018-07-10");
		scheduleVO.setSchedule_end("2018-07-10");
		scheduleVO.setSchedule_label("E3F6CE");
		scheduleVO.setSchedule_private("Y");
		scheduleVO.setSchedule_seq(5);
		
		/***When***/
		//행동
		
		int update = scheduleDao.modifyScheduleModal(scheduleVO);

		/***Then***/
		//예상결과
		assertEquals(1, update);
		
	}
	
	/**
	 * 
	 * Method : deleteScheduleModalTest
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 모달창에서 삭제버튼을 클릭했을때 일정이 삭제되는 메서드 테스트
	 */
	@Test
	public void deleteScheduleModalTest(){
		/***Given***/
		//조건
		
		/***When***/
		//행동
		int delete = scheduleDao.deleteScheduleModal(2);
		/***Then***/
		//예상결과
		assertEquals(1, delete);
		
	}
	
	/**
	 * 
	 * Method : bookMarkscheduleInsertTest
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * Method 설명 : 마이페이지 캘린더에서 일정 즐겨찾기가 되는지 확인
	 */
	@Test
	public void bookMartscheduleInsertTest() {
		/***Given***/
		//조건
		
		ScheduleVO scheduleVO = new ScheduleVO();
		
		scheduleVO.setSchedule_mem_id("scheduleTest");
		scheduleVO.setSchedule_title("북마크 등록 테스트");
		scheduleVO.setSchedule_start("2018-07-13");
		scheduleVO.setSchedule_end("2018-07-13");
		
		
		/***When***/
		//행동
		
		int res = scheduleDao.bookMarkscheduleInsert(scheduleVO);
		
		/***Then***/
		//예상결과
		assertEquals(1, res);
		
	}
	
	@Test
	public void myCalendarBookMarkListTest(){
		/***Given***/
		//조건
		
		/***When***/
		//행동
			
		/***Then***/
		//예상결과
			assertEquals(7, scheduleDao.myCalendarBookMarkList("scheduleTest").size());
			assertEquals("선경이와 함께하는 여행", scheduleDao.myCalendarBookMarkList("scheduleTest").get(0).getSchedule_title());
	}
	

}
