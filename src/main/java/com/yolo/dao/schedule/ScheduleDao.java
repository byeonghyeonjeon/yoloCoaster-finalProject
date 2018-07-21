package com.yolo.dao.schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.schedule.inf.ScheduleDaoInf;
import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Bookmark_scheVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.ScheduleVO;
@Repository
public class ScheduleDao implements ScheduleDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Method : insertSchedule
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param insert
	 * @return
	 * Method 설명 : 마이페이지 일정 생성하는 메서드
	 */
	@Override
	public int insertSchedule(ScheduleVO insert) {
		return sessionTemplate.insert("schedule.insertSchedule",insert);
	}

	/**
	 * Method : getMemberScheduleList
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param memberVO
	 * @return
	 * Method 설명 : 회원의 정보를 받아서 회원의 스케쥴을 가져온다
	 */
	@Override
	public List<ScheduleVO> getMemberScheduleList(String mem_id) {
		
		logger.debug("{}{}", "getMemberScheduleList(Dao)",mem_id);
		
		return sessionTemplate.selectList("schedule.getMemberScheduleList", mem_id);
	}

	/**
	 * Method : getScheduleDetail
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 : 스케줄 한개의 정보를 조회 ( 일정 간단 수정하기 위한 메서드 )
	 */
	@Override
	public ScheduleVO getScheduleDetail(int seq) {
		return sessionTemplate.selectOne("schedule.getScheduleDetail", seq);
	}

	/**
	 * Method : modifyScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return 리턴의 값은 성공하면 1 실패하면 0을 반환한다
	 * Method 설명 : 모달창의 수정버튼을 통해 업데이트 하는 메서드
	 */
	@Override
	public int modifyScheduleModal(ScheduleVO vo) {
		return sessionTemplate.update("schedule.modifyScheduleModal", vo);
	}

	/**
	 * Method : deleteScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 : 모달창에서 삭제버튼을 통해 일정 삭제하는 메서드
	 */
	@Override
	public int deleteScheduleModal(int seq) {
		return sessionTemplate.delete("schedule.deleteScheduleModal",seq);
	}

	/**
	 * Method : dragScheduleModify
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더에서 드래그를 통해 일정 일자를 수정
	 */
	@Override
	public int dragScheduleModify(ScheduleVO vo) {
		return sessionTemplate.update("schedule.dragScheduleModify", vo);
	}

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
	@Override
	public List<ScheduleVO> getchatScheduleList(ScheduleVO vo) {
		return sessionTemplate.selectList("schedule.getchatScheduleList",vo);
	}

	/**
	 * Method : insertChatScheduleModal
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param insert
	 * @return
	 * Method 설명 : 채팅방의 일정을 생성하는 메서드
	 */
	@Override
	public int insertChatScheduleModal(ScheduleVO insert) {
		return sessionTemplate.insert("schedule.insertChatScheduleModal",insert);
	}

	/**
	 * Method : chatModifyScheduleModal
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param update
	 * @return
	 * Method 설명 :채팅방에서 일정을 수정하는 메서드
	 */
	@Override
	public int chatModifyScheduleModal(ScheduleVO update) {
		return sessionTemplate.update("schedule.chatModifyScheduleModal",update);
	}

	/**
	 * 
	 * Method : selectScheListForBoard
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : brown
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	@Override
	public List<ScheduleVO> selectScheListForBoard() {
		return sessionTemplate.selectList("schedule.selectScheListForBoard");
	}
	
	
	@Override
	public List<ScheduleVO> getSchePageList(PageVO page){
		return sessionTemplate.selectList("schedule.getSchePageList",page);
	}

	/**
	 * Method : chatDeleteScheduleModal
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 :
	 */
	@Override
	public int chatDeleteScheduleModal(int seq) {
		return sessionTemplate.delete("schedule.chatDeleteScheduleModal",seq);
	}

	/**
	 * Method : chatDragScheduleModify
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 :
	 */
	@Override
	public int chatDragScheduleModify(ScheduleVO vo) {
		return sessionTemplate.update("schedule.chatDragScheduleModify",vo);
	}

	/**
	 * Method : bookMarkscheduleInsert
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더에서 일정 즐겨찾기를 캘린더에 추가하는 메서드
	 */
	@Override
	public int bookMarkscheduleInsert(ScheduleVO vo) {
		return sessionTemplate.insert("schedule.bookMarkscheduleInsert",vo);
	}

	/**
	 * Method : myCalendarBookMarkList
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 로그인한 회원의 아이디로 북마크 즐겨찾기를 가져온다.
	 */
	@Override
	public List<Bookmark_scheVO> myCalendarBookMarkList(String mem_id) {
		return sessionTemplate.selectList("schedule.myCalendarBookMarkList", mem_id);
	}

	/**
	 * Method : myCalendarBookMarkCheckDelete
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param delete
	 * @return
	 * Method 설명 :마이캘린더 일정 즐겨찾기에서 즐겨찾기 제외 클릭시 일정 즐겨찾기 에서 삭제
	 */
	@Override
	public int myCalendarBookMarkCheckDelete(Bookmark_scheVO delete) {
		return sessionTemplate.delete("schedule.myCalendarBookMarkCheckDelete", delete);
	}

	@Override
	public int selectScheListForBoard(String input) {
		String pram = "%"+input+"%";
		return sessionTemplate.selectOne("schedule.selectScheListForBoardStr",pram);
	}

	@Override
	public List<ScheduleVO> getSchePageList(PageVO page, String param) {
		Map<String, String> map = new HashMap<String, String>();
		String pageNo = page.getPageNo()+"";
		map.put("pageNo",pageNo);
		map.put("param","%"+param+"%");
		
		return sessionTemplate.selectList("schedule.getSchePageListStr", map);
	}

	@Override
	public int selectBookMarkSeq(Map<String, String> paramMap) {
		int res =0;
		if(sessionTemplate.selectOne("schedule.selectBookMarkSeq", paramMap)!=null){
			res=1;
		}else{
			
			res =0 ;
		}
		return res;
	}

	@Override
	public int insertBookMarkSeq(Map<String, String> insertParam) {
		return sessionTemplate.insert("schedule.insertBookMarkSeq", insertParam);
	}

	@Override
	public String getScheduleMemId(int schedule_seq) {
		return sessionTemplate.selectOne("schedule.getScheduleMemId",schedule_seq);
	}
	
	
	

}
