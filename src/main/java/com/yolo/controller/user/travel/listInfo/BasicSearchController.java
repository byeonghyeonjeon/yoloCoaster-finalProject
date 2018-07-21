package com.yolo.controller.user.travel.listInfo;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yolo.model.PageVO;
import com.yolo.service.basicInfo.BasicInfoServiceInf;
import com.yolo.service.basicInfo.BasicSearchServiceInf;

/**
 * BasicSearchController.java
 *
 * @author Jun
 * @since 2018. 6. 16.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 16. Jun 최초 생성
 *
 * </pre>
 */
@RequestMapping("/travel")
@Controller
public class BasicSearchController {
	
	@Resource
	private BasicSearchServiceInf BasicSearchService;
	
	@Resource
	private BasicInfoServiceInf basicInfoService;
	
	/**
	 * Method : selectJsp 최초작성일 : 2018. 6. 16. 작성자 : Jun 변경이력 :
	 * 
	 * @param model
	 *            (키워드 및 태그인 경우 검색 내용을 받아줌)
	 * @param selected
	 *            검색할 항목
	 * @param searchText
	 *            검색 내용(키워드 및 태그인 경우)
	 * @param pageNo 태그검색 페이지 번호
	 * @return tiles Method 설명 : 검색 - 지역기반, 축제, 태그, 키워드 page받아줌
	 */
	@RequestMapping("/search")
	public String selectJsp(Model model,@RequestParam(defaultValue = "location") String selected,@RequestParam(required = false) String keyword, @RequestParam(defaultValue="1") String pageNo) {
		if (selected == null) {
			return "redirect:/main";
		}

		selected = selected.trim();
		//지역기반검색 또는 축제검색
		if (selected.equals("location") || selected.equals("event")) {
			model.addAttribute("selected", selected);
			
			//태그검색 또는 키워드 검색
		} else if (selected.equals("tag") || selected.equals("keyword")) {// 
			model.addAttribute("selected", selected);
			model.addAttribute("keyword", keyword.trim());
			
			if (selected.equals("tag")) {// 태그검색은 jsp 따로 만듬
				
				
				Map<String, Object> resultMap = basicInfoService.searchTag(keyword, pageNo);
				
				model.addAttribute("travelVOs", resultMap.get("travelVOs"));
				
				int pageNum = Integer.valueOf(pageNo);
				PageVO pageVO = new PageVO();
				pageVO.setPageNo(pageNum);
				//페이지 블록 사이즈
				pageVO.setBlockSize(10);
				//전체 게시물 수
				pageVO.setTotalCount((int)resultMap.get("totalCount"));
				//페이징객체 만들기
				pageVO.makePaging();
				
				model.addAttribute("page", pageVO);
				
				
				return "searchTag";
			}
		} else {
			return "redirect:/main";
		}

		return "searchBasic";
	}

	@RequestMapping("search/result")
	public String choiceMethod(Model model, @RequestBody Map<String, Object> parameterMap) {
		
		String selected = ((String) parameterMap.get("selected")).trim();
		String pageNo = ((String)parameterMap.get("pageNum")).trim();
		String areaCode = ((String) parameterMap.get("areaCode")).trim();
		
		
		switch (selected) {
		case "keyword"://키워드검색
			System.out.println("키워드 검색");
			String keyword = ((String) parameterMap.get("keyword")).trim();
			String keyContentTypeId = ((String) parameterMap.get("contentTypeId")).trim();
			
			Map<String, Object> resultKeyMap = BasicSearchService.searchByKeyword(keyword, pageNo, areaCode, keyContentTypeId);
			
			model.addAttribute("contentTypeId", keyContentTypeId);
			//결과값이 없거나 오류인 경우
			if (resultKeyMap == null) {
				model.addAttribute("travelVOs", null);
				model.addAttribute("totalCount", "0");
			} else {
				model.addAttribute("travelVOs", resultKeyMap.get("travelVOs"));
				model.addAttribute("totalCount", resultKeyMap.get("totalCount"));
			}
			
			
			break;
		case "location"://지역기반검색
			System.out.println("지역기반검색");
			
			String LocaContentTypeId = ((String) parameterMap.get("contentTypeId")).trim();
			
			Map<String, Object> resultLocaMap = BasicSearchService.searchByLocation(pageNo, areaCode, LocaContentTypeId);
			
			model.addAttribute("contentTypeId", LocaContentTypeId);
			//결과값이 없거나 오류인 경우
			if (resultLocaMap == null) {
				model.addAttribute("travelVOs", null);
				model.addAttribute("totalCount", "0");
			} else {
				model.addAttribute("travelVOs", resultLocaMap.get("travelVOs"));
				model.addAttribute("totalCount", resultLocaMap.get("totalCount"));
			}
			break;
			
		case "event"://축제검색
			System.out.println("축제검색");
			String eventStartDate = ((String) parameterMap.get("eventStartDate")).trim();
			String eventEndDate = ((String) parameterMap.get("eventEndDate")).trim();
			
			Map<String, Object> resultEventMap = BasicSearchService.searchByEvent(eventStartDate, eventEndDate, pageNo, areaCode);
			//결과값이 없거나 오류인 경우
			if (resultEventMap == null) {
				model.addAttribute("travelVOs", null);
				model.addAttribute("totalCount", "0");
			} else {
				model.addAttribute("travelVOs", resultEventMap.get("travelVOs"));
				model.addAttribute("totalCount", resultEventMap.get("totalCount"));
			}
			break;

		default:
			break;
		}
		
		int pageNum = Integer.valueOf(pageNo);
		PageVO pageVO = new PageVO();
		pageVO.setPageNo(pageNum);
		//페이지 블록 사이즈
		pageVO.setBlockSize(10);
		//전체 게시물 수
		pageVO.setTotalCount((int)(model.asMap().get("totalCount")));
		//페이징객체 만들기
		pageVO.makePaging();
		
		model.addAttribute("page", pageVO);
		return "content/user/travel/listInfo/searchResult";
	}

}
