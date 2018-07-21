package com.yolo.controller.user.schedule.detail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.ContentForm;
import com.yolo.model.Content_detailVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.Schedule_detailVO;
import com.yolo.service.admin.FileAddServiceInf;
import com.yolo.service.schedule.ScheduleDetailServiceInf;
import com.yolo.service.schedule.ScheduleServiceInf;

@RequestMapping("scheDetail")
@Controller
public class ScheDetailController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	ScheduleServiceInf scheService;

	@Resource
	FileAddServiceInf fileAddService;

	@Resource
	ScheduleDetailServiceInf detailService;
	
	@RequestMapping("selectListListSche")
	public String reSetting(@RequestBody Map<String, String> parameterMap,Model model,HttpSession session){
		if (parameterMap != null) {
			String rowNum = (String) parameterMap.get("rowNum");
			String mem_id = session.getAttribute("mem_id")+"";
			if(mem_id!=null){
				List<Bookmark_areaVO> res =  detailService.getBookmarkList(mem_id);
				model.addAttribute("bookmarkList",res);
				model.addAttribute("rowNum",rowNum);
				return "content/user/schedule/basic/shceLink";
			}
			
			}
		return null;
	}
	
	
	/**
	 * 
	 * Method : insertSche 최초작성일 : 2018. 6. 25. 작성자 : Brown 변경이력 :
	 * 
	 * @param session
	 * @param req
	 * @param model
	 * @param scheVO
	 * @return Method 설명 : 세부스케쥴 작성으로 이동
	 */
	@RequestMapping("insertSche")
	public String insertSche(HttpSession session, HttpServletRequest req,
			@RequestParam(value="detail_seq",required=false)String detail_seq,
			Model model, ScheduleVO scheVO) {
		
		session.setAttribute("detail_seq", detail_seq);
		model.addAttribute("detail_seq",detail_seq);
		log.debug("{},{}","detail_seq",detail_seq);
		String mem_id = session.getAttribute("mem_id")+"";
		log.debug("{},{}","mem_id",mem_id);
		
		//해당 세부일정 번호
		int detail_seq_int = Integer.parseInt(detail_seq);
		
		//TODO 글쓰기 or 작성하기할때 필요한 목록 조회
		
		
		//이전글 가져오기 없으면 안뿌려준다.
		List<Content_detailVO> detailList = scheService.selectContentDetailList(detail_seq_int);
			//리스트에 값이 있으면 뿌리고 없으면 안뿌린다.
		int maxNum =0;
			if(detailList.size()>0){
				log.debug("{},{}","detailList",detailList);
				model.addAttribute("detailList",detailList);
				//max num setting
				
				maxNum = detailList.size();
				log.debug("{},{}","maxNum",maxNum);
				model.addAttribute("maxNum",maxNum);
			}else{
				log.debug("{},{}","maxNum",maxNum);
				model.addAttribute("maxNum",maxNum);
			}
			
		// 해당 유저의 즐겨찾기 리스트 가져오기
		List<Bookmark_areaVO> bookmarkList = scheService.getBookmarkList(mem_id);
		log.debug("{},{}","bookmarkList",bookmarkList);
		if(bookmarkList.size()>0){
			model.addAttribute("bookmarkList",bookmarkList);
		}
			
			
		//multirow 쓰기위한 모델
		ContentForm contentForm = new ContentForm();
		List<Content_detailVO> list = new ArrayList<Content_detailVO>();
		contentForm.setList(list);
		model.addAttribute("list", contentForm);
		log.debug("{},{}","list",contentForm);
		
		return "insertSche";
	}

	// uuid생성
		public static String getUuid() {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}

	/**
	 * 
	 * Method : insertScheReg 최초작성일 : 2018. 6. 26. 작성자 : Brown 변경이력 :
	 * 
	 * @param session
	 * @param req
	 * @param model
	 * @param scheVO
	 * @return Method 설명 :
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("insertScheReg")
	public String insertScheReg(
			HttpSession session,
			Model model,
			HttpServletRequest request,
			@ModelAttribute ContentForm list,
			MultipartHttpServletRequest multipartRequest)
			throws IllegalStateException, IOException {
		List<Content_detailVO> paramContentList = list.getList();
		
		scheService.insertContent(paramContentList, multipartRequest,session);

		//세션에서 detail_seq 꺼내기
		String tempStr = session.getAttribute("detail_seq")+"";
		log.debug("{},{}","detail_seq",tempStr);
		int detail_seq = Integer.parseInt(tempStr);
		String tempStr2 = session.getAttribute("schedule_seq")+"";
		log.debug("{},{}","schedule_seq",tempStr2);
		int schedule_seq = Integer.parseInt(tempStr2);
		
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheService.selectSchDetail(schedule_seq);
		//세부일정 리스트
		List<Content_detailVO> contentList = scheService.selectContentDetailList(detail_seq);
		model.addAttribute("shceDetailList",shceDetailList);
		
		//내용 리스트
		model.addAttribute("contentList",contentList);
		List<Bookmark_areaVO> bookmarkList= scheService.getBookmarkList(contentList,session);
		model.addAttribute("bookmarkList",bookmarkList);
		return "ScheduleDetailPage";
	}

	@RequestMapping("scheDetailPage")
	public String selectScheDetail(
			HttpSession session, HttpServletRequest req,
			@RequestParam(value="detail_seq",required=false)String detail_seq,
			Model model,
			@ModelAttribute ContentForm list) {
		//세션에서 값꺼내기
		int schedule_seq = Integer.parseInt(session.getAttribute("schedule_seq")+"");
		int detail_seq_int = Integer.parseInt(detail_seq);
		log.debug("{},{}","schedule_seq",schedule_seq);
		log.debug("{},{}","detail_seq_int",detail_seq_int);
		//어떤 세부일정 가져올지 찾기(detail_seq:고유번호)
		List<Content_detailVO> contentList = scheService.selectContentDetailList(detail_seq_int);
		
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheService.selectSchDetail(schedule_seq);
		
		//세부일정 리스트
		model.addAttribute("shceDetailList",shceDetailList);
		log.debug("{},{}","shceDetailList",shceDetailList);
		//내용 리스트
		if(contentList.size()>0){
			model.addAttribute("contentList",contentList);
			log.debug("{},{}","contentList",contentList);
			List<Bookmark_areaVO> bookmarkList= scheService.getBookmarkList(contentList,session);
			model.addAttribute("bookmarkList",bookmarkList);
		}
		
//		model.addAttribute("detail_seq",detail_seq);
		
		
		//세션에 값담기
		session.setAttribute("detail_seq", detail_seq);
		model.addAttribute("detail_seq",detail_seq);
		session.setAttribute("schedule_seq", schedule_seq);
		model.addAttribute("schedule_seq",schedule_seq);
		
		return "ScheduleDetailPage";
	}

	
	
	
	
	//일정추가 버튼 
	@RequestMapping("btnScheDetailAdd")
	public String btnScheDetailAdd(
			HttpSession session, HttpServletRequest req,
			Model model,
			@ModelAttribute ContentForm list) {
		//세션에서 값꺼내기
		
		int detail_seq = Integer.parseInt(session.getAttribute("detail_seq")+"");
		int schedule_seq = Integer.parseInt(session.getAttribute("schedule_seq")+"");
		log.debug("{},{}","schedule_seq",schedule_seq);
		log.debug("{},{}","detail_seq_int",detail_seq);
		
		//세부일정의 스텝중 가장 큰값 가져오기
		int maxStepNum = scheService.getMaxStepNum(schedule_seq);
		log.debug("{},{}","maxStepNum",maxStepNum);
		//어떤 세부일정 가져올지 찾기(detail_seq:고유번호)
		List<Content_detailVO> contentList = scheService.selectContentDetailList(detail_seq);
		
		//새로운 세부일정 추가
		Schedule_detailVO detailVO = new Schedule_detailVO();
		detailVO.setSchedule_seq(schedule_seq);
		if(maxStepNum==0){
			detailVO.setDetail_step(maxStepNum+1);
			log.debug("{},{}","maxStepNum+1",maxStepNum);
		}else{
			detailVO.setDetail_step(maxStepNum);
			log.debug("{},{}","maxStepNum",maxStepNum);
			
		}
		scheService.createScheDetail(detailVO);
		
		contentList = scheService.selectContentDetailList(detail_seq);
		
		log.debug("{},{}","schedule_seq",schedule_seq);
		log.debug("{},{}","detail_seq",detail_seq);
		
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheService.selectSchDetail(schedule_seq);
		
		//세부일정 리스트
		model.addAttribute("shceDetailList",shceDetailList);
		log.debug("{},{}","shceDetailList",shceDetailList);
		//내용 리스트
		if(contentList.size()>0){
			model.addAttribute("contentList",contentList);
			log.debug("{},{}","contentList",contentList);
			List<Bookmark_areaVO> bookmarkList= scheService.getBookmarkList(contentList,session);
			model.addAttribute("bookmarkList",bookmarkList);
		}
//		model.addAttribute("detail_seq",detail_seq);
		
		
		//세션에 값담기
		session.setAttribute("detail_seq", detail_seq);
		model.addAttribute("detail_seq",detail_seq);
		session.setAttribute("schedule_seq", schedule_seq);
		model.addAttribute("schedule_seq",schedule_seq);
		
		return "ScheduleDetailPage";
	}
	
	//일정 삭제
	@RequestMapping("btnScheDetailDel")
	public String btnScheDetailDel(
			HttpSession session, HttpServletRequest req,
			@RequestParam(value="delDetailSeq",required=false)String delDetailSeq,
			Model model,
			@ModelAttribute ContentForm list) {
		//세션에서 값꺼내기
		
		int detail_seq = stringToInt(session,"detail_seq");
				//Integer.parseInt(session.getAttribute("detail_seq")+"");
		int schedule_seq = Integer.parseInt(session.getAttribute("schedule_seq")+"");
		log.debug("{},{}","schedule_seq",schedule_seq);
		log.debug("{},{}","detail_seq_int",detail_seq);
		//삭제
		scheService.deleteDetail(detail_seq);
		
		
		//어떤 세부일정 가져올지 찾기(detail_seq:고유번호)
		List<Content_detailVO> 	contentList = scheService.selectContentDetailList(detail_seq);
		
		log.debug("{},{}","schedule_seq",schedule_seq);
		log.debug("{},{}","detail_seq",detail_seq);
		
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheService.selectSchDetail(schedule_seq);
		
		//세부일정 리스트
		model.addAttribute("shceDetailList",shceDetailList);
		log.debug("{},{}","shceDetailList",shceDetailList);
		//내용 리스트
		if(contentList.size()>0){
			model.addAttribute("contentList",contentList);
			log.debug("{},{}","contentList",contentList);
			List<Bookmark_areaVO> bookmarkList= scheService.getBookmarkList(contentList,session);
			model.addAttribute("bookmarkList",bookmarkList);
		}
		
		return "ScheduleDetailPage";
	}
	
	
	
	public int stringToInt(HttpSession session,String Str){
		int res = 0;
		String before = session.getAttribute(Str)+"";
		res = Integer.parseInt(before);
		return res ;
	}
	

}
