package com.yolo.service.schedule;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.dao.admin.inf.FileAddDaoInf;
import com.yolo.dao.member.inf.BookmarkAreaDaoInf;
import com.yolo.dao.schedule.inf.ContentDetailDaoInf;
import com.yolo.dao.schedule.inf.ScheduleDaoInf;
import com.yolo.dao.schedule.inf.ScheduleDetailDaoInf;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Bookmark_scheVO;
import com.yolo.model.Content_detailVO;
import com.yolo.model.File_addVO;
import com.yolo.model.MemberVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.Schedule_detailVO;
import com.yolo.service.admin.FileAddServiceInf;
@Service
public class ScheduleService implements ScheduleServiceInf{
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/8.LastProject/workspace/yoloCoaster/src/main/webapp";
	private final String UPLOAD_PATH_NOT_REFLESH = "D:/A_TeachingMaterial/8.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/yoloCoaster";
	
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	ScheduleDaoInf scheduleDao;
	
	@Resource
	BookmarkAreaDaoInf bookmarkDao;

	@Resource
	ContentDetailDaoInf contentDao;
	
	@Resource
	ScheduleDetailDaoInf scheDetailDao;
	
	@Resource
	FileAddDaoInf fileAddDao;
	
	@Resource
	FileAddServiceInf fileAddService;
	// uuid생성
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
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
		return scheduleDao.insertSchedule(insert);
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
		return scheduleDao.getMemberScheduleList(mem_id);
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkList(String mem_id) {
		return bookmarkDao.getBookmarkList(mem_id);
	}

	/**
	 * Method : getScheduleDetail
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 :스케줄 한개의 정보를 조회 ( 일정 간단 수정하기 위한 메서드 )
	 */
	@Override
	public ScheduleVO getScheduleDetail(int seq) {
		return scheduleDao.getScheduleDetail(seq);
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
		return scheduleDao.modifyScheduleModal(vo);
	}

	/**
	 * Method : deleteScheduleModal
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 :모달창에서 삭제버튼을 통해 일정 삭제하는 메서드
	 */
	@Override
	public int deleteScheduleModal(int seq) {
		return scheduleDao.deleteScheduleModal(seq);
	}

	/**
	 * Method : dragScheduleModify
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 마이캘린더에서 드래그를통해 일정 일자를 수정
	 */
	@Override
	public int dragScheduleModify(ScheduleVO vo) {
		return scheduleDao.dragScheduleModify(vo);
	}

	/**
	 * 
	 * Method : insertContentDetail
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param contentVOList
	 * @return
	 * Method 설명 :일정 세부내용 입력
	 */
	@Override
	public int insertContentDetail(Content_detailVO contentVOList) {
		return contentDao.insertContentDetail(contentVOList);
	}

	/**
	 * 
	 * Method : selectSchDetail
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param scheduleSeq
	 * @return
	 * Method 설명 :일정 상세 목록 조회
	 */
	@Override
	public List<Schedule_detailVO> selectSchDetail(int scheduleSeq) {
		return scheDetailDao.selectSchDetail(scheduleSeq);
	}

	/**
	 * 
	 * Method : selectContentDetailList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param detailSeq
	 * @return
	 * Method 설명 :세부일정 번호 입력시 내용 리스트 출력
	 */
	@Override
	public List<Content_detailVO> selectContentDetailList(int detailSeq) {
		return scheDetailDao.selectContentDetailList(detailSeq);
	}

	@Override
	public void insertContent(List<Content_detailVO> contentList,
			MultipartHttpServletRequest multipartRequest, HttpSession session) {
		for (int i = 0; i < contentList.size(); i++) {
			
			if (contentList.get(i).getDetail_seq() == 0) {
				contentList.remove(i);
			}
		}
		String detail_seq = session.getAttribute("detail_seq")+"";
		String mem_id = session.getAttribute("mem_id")+"";
		
		// 파일처리
		
		
		
		String path = UPLOAD_PATH + "/upload/imageFolder";
		String serverPath = UPLOAD_PATH_NOT_REFLESH+"/upload/imageFolder";

		List<File_addVO> insertFileList = new ArrayList<File_addVO>();

		if(multipartRequest.getFileNames()!=null){
			
		
		// MultipartHttpServletRequest 생성
		Iterator iter = multipartRequest.getFileNames();
		MultipartFile mfile = null;
		String fieldName = "";

		// 디레토리가 없다면 생성
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		File dirServer = new File(serverPath);
		if (!dirServer.isDirectory()) {
			dirServer.mkdirs();
		}
		
		List<String> fileName = new ArrayList<String>();
		// 값이 나올때까지
		while (iter.hasNext()) {
			fieldName = (String) iter.next();
			// 내용을 가져와서
			mfile = multipartRequest.getFile(fieldName);
			String origName="";
			try {
				origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			// 한글꺠짐 방지
			// 파일명이 없다면
			if ("".equals(origName)) {
				continue;
			}

			// 파일 명 변경(uuid로 암호화)
			String ext = origName.substring(origName.lastIndexOf('.'));
			// 확장자
			String saveFileName = getUuid() + ext;
			// 설정한 path에 파일저장
			File serverFile = new File(path + File.separator + saveFileName);
			File serverDirFile = new File(serverPath + File.separator + saveFileName);
			try {
				mfile.transferTo(serverFile);
				mfile.transferTo(serverDirFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//파일이름 리스트
			fileName.add(saveFileName);
			// 파일 저장
			File_addVO newfile = new File_addVO();
			newfile.setAdd_oriname(origName);
			newfile.setAdd_mem_id(mem_id);
			newfile.setParent_seq(Integer.parseInt(detail_seq));
			newfile.setAdd_newname(saveFileName);
			newfile.setAdd_path(path);
			newfile.setAdd_ex(ext);
			insertFileList.add(newfile);
			log.debug("{}{}","nameList",fileName.size());
			log.debug("{}{}","nameList",fileName.toString());
		
		}

			if(contentList!=null){
				
				
				log.debug("{}{}","insertFileList",contentList.size());
				log.debug("{}{}","fileAddService",insertFileList.size());
				int tempNum =0;
				for (int i = 0; i < contentList.size(); i++) {
					if(contentList.get(i).getContent_shape()!=null){
					
						if(contentList.get(i).getContent_shape().equals("04")){
							
							contentList.get(i).setContent_content(fileName.get(tempNum));
							log.debug("{}{}","tempNum",tempNum);
							tempNum++;
						};
					}
				}
			
				
				fileAddDao.insertFileList(insertFileList);
				// 해당 유저의 즐겨찾기 리스트 가져오기
			}
		}
			for (Content_detailVO content_detailVO2 : contentList) {
				contentDao.insertContentDetail(content_detailVO2);
			}
		
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
		return scheduleDao.getchatScheduleList(vo);
	}

	@Override
	public int createScheDetail(Schedule_detailVO scheDetail) {
		return scheDetailDao.createScheDetail(scheDetail);
		
	}

	/**
	 * Method : insertChatScheduleModal
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param insert
	 * @return
	 * Method 설명 :채팅방의 일정을 생성하는 메서드
	 */
	@Override
	public int insertChatScheduleModal(ScheduleVO insert) {
		int result = scheduleDao.insertChatScheduleModal(insert);
		return insert.getSchedule_seq();
	}

	@Override
	public int getMaxStepNum(int detail_seq_int) {
		int res = 0;
		List<Schedule_detailVO> resList =scheDetailDao.selectSchDetail(detail_seq_int);
		log.debug("{},{}","resList",resList);
		//0일때
		//1일때
		//2일때
		if(resList.size()>0){
			//사이즈가 1이면 0번째 인덱스의 스텝을 구해서 -1
			int listSize = resList.size()-1;
			log.debug("{}{}","listSize :",listSize);
			res= resList.get(listSize).getDetail_step()+1;
			log.debug("{},{}","listSize",res);
			
		}else{
			//사이즈가 0이면
			res = 0;
			log.debug("{},{}","res",res);
		}
		return res;
	}

	@Override
	public int deleteDetail(int detail_seq) {
		return scheDetailDao.deleteDetail(detail_seq);
		
	}
	
	/**
	 * Method : chatModifyScheduleModal
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param update
	 * @return
	 * Method 설명 : 채팅방에서 일정을 수정하는 메서드
	 */
	@Override
	public int chatModifyScheduleModal(ScheduleVO update) {
		return scheduleDao.chatModifyScheduleModal(update);
	}

	/**
	 * Method : chatDeleteScheduleModal
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param seq
	 * @return
	 * Method 설명 : 선택한 일정을 모달을 통해 삭제하는 메서드
	 */
	@Override
	public int chatDeleteScheduleModal(int seq) {
		return scheduleDao.chatDeleteScheduleModal(seq);
	}

	/**
	 * Method : chatDragScheduleModify
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 드래그를 통해 일정을 변경
	 */
	@Override
	public int chatDragScheduleModify(ScheduleVO vo) {
		return scheduleDao.chatDragScheduleModify(vo);
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
		
		log.debug("{}{}" , "bookMarkService seq_num : ", vo.getSchedule_seq());
		int insertNum = scheduleDao.bookMarkscheduleInsert(vo);
		
		return vo.getSchedule_seq();
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
		return scheduleDao.myCalendarBookMarkList(mem_id);
	}

	/**
	 * Method : myCalendarBookMarkCheckDelete
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : KGY
	 * 변경이력 :
	 * @param delete
	 * @return
	 * Method 설명 : 마이캘린더 일정 즐겨찾기에서 즐겨찾기 제외 클릭시 일정 즐겨찾기 에서 삭제
	 */
	@Override
	public int myCalendarBookMarkCheckDelete(Bookmark_scheVO delete) {
		return scheduleDao.myCalendarBookMarkCheckDelete(delete);
	}

	@Override
		public int selectBookMarkSeq(Map<String, String> paramMap) {
			return scheduleDao.selectBookMarkSeq(paramMap);
			
		}

	@Override
	public int insertBookMarkSeq(Map<String, String> insertParam) {
		return scheduleDao.insertBookMarkSeq(insertParam);
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkList(
			List<Content_detailVO> contentList,HttpSession session) {
		List<Bookmark_areaVO> res = new ArrayList<Bookmark_areaVO>();
		String mem_id = session.getAttribute("mem_id")+"";
		for (Content_detailVO content_detailVO : contentList) {
			if(content_detailVO.getContent_shape().equals("03")){
				res.add(bookmarkDao.selectBookmarkAreaList(content_detailVO.getContent_content(),mem_id));
			}
		}
		return res;
	}

	@Override
	public String getScheduleMemId(int schedule_seq) {
		return scheduleDao.getScheduleMemId(schedule_seq);
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkListStr(
			List<Content_detailVO> contentList,String mem_id) {
		List<Bookmark_areaVO> res = new ArrayList<Bookmark_areaVO>();
		for (Content_detailVO content_detailVO : contentList) {
			if(content_detailVO.getContent_shape().equals("03")){
				res.add(bookmarkDao.selectBookmarkAreaList(content_detailVO.getContent_content(),mem_id));
			}
		}
		return res;
	}
	
}
