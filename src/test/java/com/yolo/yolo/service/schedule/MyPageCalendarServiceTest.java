/**
 * 
 */
package com.yolo.yolo.service.schedule;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.init.TestInit;
import com.yolo.model.ScheduleVO;
import com.yolo.service.schedule.ScheduleServiceInf;

/**
 * MyPageCalendarServiceTest.java
 *
 * @author KGY
 * @since 2018. 7. 6.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 6. KGY 최초 생성
 *
 * </pre>
 */
public class MyPageCalendarServiceTest extends TestInit{

	
	@Resource
	private ScheduleServiceInf scheduleService;
	
	
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
		
		int res = scheduleService.bookMarkscheduleInsert(scheduleVO);
		
		/***Then***/
		//예상결과
		assertEquals(795, res);
		
	}

}
