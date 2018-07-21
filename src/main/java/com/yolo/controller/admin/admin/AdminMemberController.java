package com.yolo.controller.admin.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.MemJoinInfoVO;
import com.yolo.model.PageVO;
import com.yolo.service.admin.AdminBoardServiceInf;
import com.yolo.service.admin.MemInfoServiceInf;

@RequestMapping("adminMember")
@Controller
public class AdminMemberController {
	
	@Resource
	AdminBoardServiceInf adminBoardService;
	
	@Resource
	MemInfoServiceInf memInfoService;  

	
	
	// 블랙리스트 설정
	@RequestMapping("blackList")
	@ResponseBody
	public String blackList(@RequestBody Map<String, String> parameterMap,HttpSession session){
		if (parameterMap != null) {
			
			String mem_id = parameterMap.get("mem_id");
			String link = parameterMap.get("link");
			if(link==null||link.isEmpty()||link==""){
				link="N";
			}
			if(link.equals("Y")||link=="Y"){
				link="N";
			}else{
				link="Y";
			}
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("mem_id", mem_id);
			paramMap.put("link", link);
			int res = memInfoService.blackList(paramMap);
			if(res==1){
				return "1";
			}
		}
		return "0";
	}
	
	/**
	 * 
	 * Method : memInfoList
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : bsk
	 * 변경이력 :
	 * @return
	 * Method 설명 : 관리자, 회원정보 리스트 띄우기
	 */
	@RequestMapping("memInfoList")
	public String memInfoList(Model model, PageVO page,@RequestParam(required=false)String keyword){
		List<MemJoinInfoVO> memInfoList = null;
		///page 
		if(page.getPageNo() == 0){
			page.setPageNo(1); // 현재 페이지 번호
		}
		
		//페이지 블록 사이즈
		page.setBlockSize(10);
		
		Map<String, String> paramMap = new HashMap<String, String>();
			//게시판 선택
			paramMap.put("pageNo", page.getPageNo()+"");
			paramMap.put("keyword", "%%");
			if(keyword!=null){
				paramMap.put("keyword", "%"+keyword+"%");
			}
		
		//모델에 담기
		memInfoList = memInfoService.getMemberList(paramMap);
		model.addAttribute("memInfoList", memInfoList);
		//전체 게시물 수 (게시판번호)
		int totalCnt =memInfoService.getMemberListCnt(paramMap);
		
		//금일 가입자
		model.addAttribute("todayMember",memInfoService.todayRegMember());
		//페이지 출력 회원
		model.addAttribute("totalCnt",totalCnt);
		
		//페이지 출력 회원
		model.addAttribute("todatDrop",memInfoService.todatDrop());
		
		page.setTotalCount(totalCnt);
		//게시판선택(게시판번호): 페이지객체에 입력
		//페이징객체 만들기
		page.makePaging();
		//해당 페이지의 리스트 가져오기
		//end page
		System.out.println(page);
		//keyword 반환
		model.addAttribute("keyword", keyword);
		
		//page반환
		model.addAttribute("page", page);
		
		return "adminMember";
	}
	
	
	
}
