package com.yolo.yolo.dao.board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.schedule.inf.ScheduleDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.PageVO;
import com.yolo.model.ScheduleVO;

public class ScheduleBoardTest extends TestInit{

	@Resource
	ScheduleDaoInf scheDao;
	
	/**
	 * 
	 * Method : createScheTest
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : brown
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void createScheTest() {
		assertNotNull(scheDao);
	}
	
	/**
	 * 
	 * Method : selectScheList
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 :
	 */
	@Test
	public void selectScheList() throws Exception {
		int res = 56;
		List<ScheduleVO> list = scheDao.selectScheListForBoard();
		int resList = list.size();
		assertEquals(res, resList);
	}
	
	/**
	 * 
	 * Method : searchScheduleListTest
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 :검색어 페이지네이션 총겟수 테스트
	 */
	@Test
	public void searchScheduleListTest() throws Exception {
		
		int res = 4;
		int queryRes = scheDao.selectScheListForBoard("테스트");
		assertEquals(res, queryRes);
	}

	/**
	 * 
	 * Method : searchSchedulePageListTest
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 일정검색 페이지 네이션 리스트 테스트
	 */
	@Test
	public void searchSchedulePageListTest() throws Exception {
		PageVO page = new PageVO();
		if(page!=null){
			page.setPageNo(page.getPageNo()); // 현재 페이지 번호
		}
		//페이지 블록 사이즈
		page.setBlockSize(10);
		page.setPageNo(1);
		//전체 게시물 수
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		
		int res = 4;
		
		List<ScheduleVO> scheList  = scheDao.getSchePageList(page,"테스트");
		assertEquals(res, scheList.size());
	}
	
	/**
	 * 
	 * Method : selectBookMarkSeq
	 * 최초작성일 : 2018. 7. 8.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 :일정 즐겨찾기 확인 테스트
	 */
	@Test
	public void selectBookMarkSeqTest() throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_id", "test");
		paramMap.put("sche_seq", "10");
		
		int res = scheDao.selectBookMarkSeq(paramMap);
		assertEquals(res, 1);
	}
	
	@Test
	public void selectBookMarkSeqEmptyTest() throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_id", "test");
		paramMap.put("sche_seq", "0");
		
		int res = scheDao.selectBookMarkSeq(paramMap);
		assertEquals(res, 0);
	}
	
	@Test
	public void insertBookmarkSche() throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_id", "test");
		paramMap.put("sche_seq", "833");
		
		int res = scheDao.insertBookMarkSeq(paramMap);
		assertEquals(res, 1);
	}
	

}
