package com.yolo.yolo.dao.schedule;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yolo.dao.member.inf.BookmarkAreaDaoInf;
import com.yolo.dao.schedule.inf.ScheduleDetailDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Content_detailVO;
import com.yolo.model.Schedule_detailVO;
import com.yolo.service.schedule.ScheduleServiceInf;

/**
 * 
 * ScheduleDetailTest.java
 *
 * @author Brown
 * @since 2018. 6. 27.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 27. Brown 최초 생성
 *
 * </pre>
 */
public class ScheduleDetailTest extends TestInit {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	ScheduleDetailDaoInf ScheDetailDao;

	@Resource
	BookmarkAreaDaoInf bookAreaDao;
	
	@Test
	public void createScheDetailDaoTest() throws Exception {
		assertNotNull(ScheDetailDao);
	}
	
	/**
	 * 
	 * Method : shceDetailListTest 최초작성일 : 2018. 6. 27. 작성자 : Brown 변경이력 :
	 * Method 설명 : 일정 눌렀을때 세부일정 리스트 받아오기
	 */
	@Test
	public void shceDetailListTest() {
		int scheduleSeq = 16;
		// 세부 일정 조회
		List<Schedule_detailVO> shceDetailList = ScheDetailDao.selectSchDetail(scheduleSeq);
		assertEquals(1, shceDetailList.size());
	}

	/**
	 * 
	 * Method : selectContentDetailList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 세부일정 번호 입력시 해당내용 리스트 출력
	 */
	@Test
	public void selectContentDetailList() throws Exception {
		int detailSeq = 1;
		List<Content_detailVO> detailList = ScheDetailDao.selectContentDetailList(detailSeq);
		assertEquals(16, detailList.size());
	}
	
	/**
	 * 
	 * Method : createScheDetail
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 :
	 */
	@Test
	public void createScheDetail() throws Exception {
		Schedule_detailVO testDetail = new Schedule_detailVO();
		
		testDetail.setSchedule_seq(57);
		testDetail.setDetail_step(1);
		
		int res = ScheDetailDao.createScheDetail(testDetail);
		assertEquals(57, res);
	}
	
	/**
	 * 
	 * Method : deleteDetailScheduleTest
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 :세부일정 하나 삭제하는 메서드
	 */
	@Test
	public void deleteDetailScheduleTest() throws Exception {
		int detail_seq =14;
		int res = ScheDetailDao.deleteDetail(detail_seq);
		assertEquals(1, res);
	}
	
	/**
	 * 
	 * Method : selectBookMarkAreaSelectOneTest
	 * 최초작성일 : 2018. 7. 14.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 세부일정 리스트의 즐겨찾기 조회
	 */
	@Test
	public void selectBookMarkAreaSelectOneTest() throws Exception {
		String param  = "1258353";
//		 Bookmark_areaVO resVO =  bookAreaDao.selectBookmarkAreaList(param);
//		 String res =resVO.getContentid();
//		 assertEquals(param, res);
//		 assertEquals("test", resVO.getMem_id());
	}
	
}
