package com.yolo.controller.user.schedule.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.ContentForm;
import com.yolo.model.Content_detailVO;
import com.yolo.model.Schedule_detailVO;
import com.yolo.service.schedule.ScheduleServiceInf;
@RequestMapping("myScheController")
@Controller
public class MyScheController {

	@Resource
	ScheduleServiceInf scheService;
	
	/**
	 * 
	 * Method : insertBookmarkSche
	 * 최초작성일 : 2018. 7. 8.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param parameterMap
	 * @param session
	 * @param book_seq
	 * @return
	 * Method 설명 : 즐겨찾기 추가 성공1 실패0 이미 잇으면 2
	 */
	@RequestMapping("insertBookmarkSche")
	@ResponseBody
	public String insertBookmarkSche(@RequestBody Map<String, String> parameterMap,HttpSession session)
			{
		
		//db체크
		if (parameterMap != null) {
			
			String book_seq = parameterMap.get("sche_seq");
			if(session.getAttribute("mem_id")==null){
				//세션값이 없을경우
				return "3";
			}
			String mem_id = session.getAttribute("mem_id")+"";
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("mem_id", mem_id);
			paramMap.put("sche_seq", book_seq);
			int res = scheService.selectBookMarkSeq(paramMap);
			
			//즐겨찾기에 없네
			if(res==0){
				//저장하고
				scheService.insertBookMarkSeq(paramMap);
				return "0";
			}else{
				//즐겨찾기에  있네
				
				return "1";
			}
		}
		return null;
		
	}
	
	
	@RequestMapping("scheDetailPage")
	public String scheDetailPage(
			HttpSession session, HttpServletRequest req,
			@RequestParam(value="detail_seq",required=false)String detail_seq,
			Model model,
			@ModelAttribute ContentForm list) {
		//세션에서 값꺼내기
		int schedule_seq = Integer.parseInt(session.getAttribute("link")+"");
		int detail_seq_int = Integer.parseInt(detail_seq);

		//어떤 세부일정 가져올지 찾기(detail_seq:고유번호)
		List<Content_detailVO> contentList = scheService.selectContentDetailList(detail_seq_int);
		
		//세부 일정 조회
		List<Schedule_detailVO> shceDetailList =  scheService.selectSchDetail(schedule_seq);
		
		//세부일정 리스트
		model.addAttribute("shceDetailList",shceDetailList);
		//내용 리스트
		if(contentList.size()>0){
			model.addAttribute("contentList",contentList);
		}
		
//		model.addAttribute("detail_seq",detail_seq);
		
		
		//세션에 값담기
		session.setAttribute("detail_seq", detail_seq);
		model.addAttribute("detail_seq",detail_seq);
		session.setAttribute("schedule_seq", schedule_seq);
		model.addAttribute("schedule_seq",schedule_seq);
		
		return "ScheduleDetailReadOnlyPage";
	}
}
