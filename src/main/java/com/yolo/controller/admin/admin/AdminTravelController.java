package com.yolo.controller.admin.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.CategoryVO;
import com.yolo.model.PageVO;
import com.yolo.model.ReviewVO;
import com.yolo.model.TagCountVO;
import com.yolo.service.admin.TravelServiceInf;

@RequestMapping("adminTravel")
@Controller
public class AdminTravelController {
	
	@Resource
	private TravelServiceInf travelService;

	
	/**
	 * Method : adminTravel
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 관리자 여행지 관리
	 */
	@RequestMapping("/adminReview")
	public String adminReview(Model model, PageVO pageVO){
		if (pageVO.getPageNo() == 0) {
			pageVO.setPageNo(1);
		}
		
		//통계 가져옴
		Map<String, Integer> statMap = travelService.getReviewPageStats();
		model.addAllAttributes(statMap);
		
		//해당 페이지에 해당하는 review 가져옴
		List<ReviewVO> reviewList = travelService.getReview(pageVO);
		model.addAttribute("reviewList", reviewList);
		
		model.addAttribute("page", pageVO);
		
		return "adminTravel";
	}
	
	/**
	 * Method : adminReviewDetail
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap
	 * @return
	 * Method 설명 : 리뷰 모달창에 넘기는 정보
	 */
	@RequestMapping("/adminReviewDetail")
	@ResponseBody
	public ReviewVO adminReviewDetail(@RequestBody Map<String, String> parameterMap){
		ReviewVO reviewVO = travelService.getReviewDetail(parameterMap.get("review_seq"));
		return reviewVO;
	}
	
	/**
	 * Method : adminReviewDelete
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @return
	 * Method 설명 : 리뷰 삭제
	 */
	@RequestMapping("/adminReviewDelete")
	public String adminReviewDelete(String review_seq){
		travelService.deleteReview(review_seq);
		return "redirect:/adminTravel/adminReview";
	}
	
	/**
	 * Method : adminReviewSearch
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_title
	 * @param pageVO
	 * @param model
	 * @return
	 * Method 설명 : 리뷰 검색 및 페이지네이션 처리
	 */
	@RequestMapping("/adminReviewSearch")
	public String adminReviewSearch(@RequestParam(value="keyword") String review_title, PageVO pageVO, Model model){
		if (pageVO.getPageNo() == 0) {
			pageVO.setPageNo(1);
		}
		
		//통계 가져옴
		Map<String, Integer> statMap = travelService.getReviewPageStats();
		model.addAllAttributes(statMap);
		
		//해당 페이지에 해당하고 검색된 review 가져옴
		List<ReviewVO> reviewList = travelService.searchReview(review_title, pageVO);
		model.addAttribute("reviewList", reviewList);
		
		model.addAttribute("page", pageVO);
		
		model.addAttribute("review_title", review_title);
		return "adminTravel";
	}
	
	/**
	 * Method : adminTag
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @return
	 * Method 설명 : 태그관리
	 */
	@RequestMapping("/adminTag")
	public String adminTag(PageVO pageVO, Model model){
		if (pageVO.getPageNo() == 0) {
			pageVO.setPageNo(1);
		}
		
		//통계 가져옴
		Map<String, Integer> statMap = travelService.getTagPageStats();
		model.addAllAttributes(statMap);
		
		//해당 페이지에 해당하는 tag 가져옴
		List<TagCountVO> tagList = travelService.getTag(pageVO);
		model.addAttribute("tagList", tagList);
		
		model.addAttribute("page", pageVO);
		
		return "adminTag";
	}
	
	/**
	 * Method : adminTagDelete
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param tag_content
	 * @return
	 * Method 설명 : 리뷰 삭제
	 */
	@RequestMapping("/adminTagDelete")
	public String adminTagDelete(String tag_content){
		travelService.deleteTag(tag_content);
		return "redirect:/adminTravel/adminTag";
	}
	
	/**
	 * Method : adminTagSearch
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param tag_content
	 * @param pageVO
	 * @param model
	 * @return
	 * Method 설명 : 태그 검색 및 페이지네이션 처리
	 */
	@RequestMapping("/adminTagSearch")
	public String adminTagSearch(@RequestParam(value="keyword") String tag_content, PageVO pageVO, Model model){
		if (pageVO.getPageNo() == 0) {
			pageVO.setPageNo(1);
		}
		
		//통계 가져옴
		Map<String, Integer> statMap = travelService.getTagPageStats();
		model.addAllAttributes(statMap);
		
		//해당 페이지에 해당하고 검색된 태그 가져옴
		List<TagCountVO> tagList = travelService.searchTag(tag_content, pageVO);
		model.addAttribute("tagList", tagList);
		
		model.addAttribute("page", pageVO);
		
		model.addAttribute("tag_content", tag_content);
		return "adminTag";
	}
	
	/**
	 * Method : adminCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageVO
	 * @param model
	 * @return
	 * Method 설명 : 카테고리 관리 페이지 및 페이지네이션 처리
	 */
	@RequestMapping("/adminCategory")
	public String adminCategory(PageVO pageVO, Model model){
		if (pageVO.getPageNo() == 0) {
			pageVO.setPageNo(1);
		}
		
		//통계 가져옴
		Map<String, Integer> statMap = travelService.getCategoryPageStats();
		model.addAllAttributes(statMap);
		
		//해당 페이지에 해당하는 Category 가져옴
		List<CategoryVO> categoryList = travelService.getCategory(pageVO);
		model.addAttribute("categoryList", categoryList);
		
		model.addAttribute("page", pageVO);
		
		return "adminCategory";
	}
	
	/**
	 * Method : adminCategorySearch
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param cate_name
	 * @param pageVO
	 * @param model
	 * @return
	 * Method 설명 : 카테고리 검색 조회 및 페이지네이션 처리
	 */
	@RequestMapping("/adminCategorySearch")
	public String adminCategorySearch(@RequestParam(value="keyword") String cate_name, PageVO pageVO, Model model){
		if (pageVO.getPageNo() == 0) {
			pageVO.setPageNo(1);
		}
		
		//통계 가져옴
		Map<String, Integer> statMap = travelService.getCategoryPageStats();
		model.addAllAttributes(statMap);
		
		//해당 페이지에 해당하고 검색된 카테고리 가져옴
		List<CategoryVO> categoryList = travelService.searchCategory(cate_name, pageVO);
		model.addAttribute("categoryList", categoryList);
		
		model.addAttribute("page", pageVO);
		
		model.addAttribute("cate_name", cate_name);
		
		return "adminCategory";
	}
	
	/**
	 * Method : adminCategoryDelete
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 삭제
	 */
	@RequestMapping("/adminCategoryDelete")
	public String adminCategoryDelete(CategoryVO categoryVO){
		travelService.deleteCategory(categoryVO);
		return "redirect:/adminTravel/adminCategory";
	}
	
	/**
	 * Method : adminCategoryUpdateY
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 활성화로 업데이트
	 */
	@RequestMapping("/adminCategoryUpdateY")
	public String adminCategoryUpdateY(CategoryVO categoryVO){
		travelService.updateCategoryToY(categoryVO);
		return "redirect:/adminTravel/adminCategory";
	}
	
	/**
	 * Method : adminCategoryUpdateN
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 비활성화로 업데이트
	 */
	@RequestMapping("/adminCategoryUpdateN")
	public String adminCategoryUpdateN(CategoryVO categoryVO){
		travelService.updateCategoryToN(categoryVO);
		return "redirect:/adminTravel/adminCategory";
	}
	
	/**
	 * Method : adminCategoryInsert
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 추가
	 */
	@RequestMapping("/adminCategoryInsert")
	public String adminCategoryInsert(CategoryVO categoryVO){
		travelService.insertCategory(categoryVO);
		return "redirect:/adminTravel/adminCategory";
	}
	
	
}
