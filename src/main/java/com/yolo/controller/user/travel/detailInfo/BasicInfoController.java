package com.yolo.controller.user.travel.detailInfo;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yolo.model.BasicinfoVO;
import com.yolo.model.Detailinfo_courseVO;
import com.yolo.model.Detailinfo_eventVO;
import com.yolo.model.Detailinfo_leportsVO;
import com.yolo.model.DetailinfocultureVO;
import com.yolo.model.DetailinfotourVO;
import com.yolo.model.File_addVO;
import com.yolo.model.MemberVO;
import com.yolo.model.NaverBlogVO;
import com.yolo.model.PageVO;
import com.yolo.model.RepeatInfo_courseVO;
import com.yolo.model.StarVO;
import com.yolo.service.admin.FileAddServiceInf;
import com.yolo.service.basicInfo.BasicInfoServiceInf;
import com.yolo.service.basicInfo.NaverSearchServiceInf;

/**
 * BasicInfoController.java
 *
 * @author JiHee
 * @since 2018. 6. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 25. JiHee 최초 생성
 *
 * </pre>
 */
@Controller("BasicInfoController")
@RequestMapping("/basicInfo")
public class BasicInfoController {
	
	@Resource
	private BasicInfoServiceInf basicInfoService;
	
	@Resource
	private NaverSearchServiceInf naverSearchService;
	
	@Resource
	private FileAddServiceInf fileAddService;
	
	/**
	 * Method : basicInfoForm
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 상세페이지 폼
	 */
	@RequestMapping("/basicInfo")
	public String basicInfo(HttpSession session, Model model, String contentid){
		Map<String,Object> resultMap = basicInfoService.detailPage(contentid);
		if(!resultMap.isEmpty()){
			BasicinfoVO basicinfoVO = (BasicinfoVO) resultMap.get("basicinfoVO");
			model.addAttribute("basicinfoVO", basicinfoVO);
			List<NaverBlogVO> blogs = naverSearchService.naverSearch(basicinfoVO.getTitle(), 1);
			model.addAttribute("naverBlogs", blogs);
			
			// 좋아요
			if(session.getAttribute("mem_id") == null){
				model.addAttribute("goodClass", "glyphicon glyphicon-heart-empty");
			}else{
				Boolean goodBool = basicInfoService.getGood(session, contentid);
				if(goodBool == true)
					model.addAttribute("goodClass", "glyphicon glyphicon-heart");
				else
					model.addAttribute("goodClass", "glyphicon glyphicon-heart-empty");
			}
			
		}else{
			model.addAttribute("basicinfoVO", null);
		}
		
		//사진첩 조회
		List<File_addVO> photoList = basicInfoService.selectImgAllOfContent(contentid);
		model.addAttribute("photoList", photoList);
		
		//별점 조회
		List<StarVO> starList = basicInfoService.selectStar(contentid);
		Collections.sort(starList);
		model.addAttribute("starList", starList);
		
		//별점 건수 및 평균점수
		int starListAll = 0;
		double starListAvg = 0.0;
		for (StarVO starVO : starList) {
			starListAll += starVO.getCount();
			starListAvg += starVO.getScore_point() * starVO.getCount();
		}
		starListAvg /= starListAll;
		
		if (starListAll == 0) {
			model.addAttribute("starListAvg", 0.00);
		} else {
			model.addAttribute("starListAvg", starListAvg);
		}
		model.addAttribute("starListAll", starListAll);
		
		//태그 정보 조회
		model.addAttribute("tagList", basicInfoService.selectTagCount(contentid));
		
		
		return "basicInfo";
	}
	
	 
	/**
	 * Method : nearbyTravel
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param model
	 * @param travelMap
	 * @return
	 * Method 설명 : 주변 여행지 정보 조회
	 */
	@RequestMapping("/nearbyTravel")
	@ResponseBody
	 public Map<String, Object> nearbyTravel(@RequestBody Map<String, Object> travelMap){
		 Map<String, Object> resultMap = basicInfoService.nearbyTravel(travelMap);
		 if(!resultMap.isEmpty()){
			 return resultMap;
		 }else{
			 return null;
		 }
		 
	 }
	
	/**
	 * Method : introTravel
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param intrpMap 
	 * @return
	 * Method 설명 : 관광지 소개 정보 조회
	 */
	@RequestMapping("/intro/12")
	public String introTour(Model model, @RequestBody Map<String, Object> introMap){
		String contentid = (String) introMap.get("contentid");
		String contenttypeid = (String) introMap.get("contenttypeid");
		
		DetailinfotourVO tourVO = basicInfoService.detailByTour(contentid, contenttypeid);
		
		model.addAttribute("contenttypeid" , contenttypeid);
		model.addAttribute("tourVO", tourVO);
		return "content/user/travel/detailInfo/InfoOfdetail";
	}
	
	/**
	 * Method : introCulture
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param introMap
	 * @return
	 * Method 설명 : 문화 시설 소개 정보 조회
	 */
	@RequestMapping("/intro/14")
	public String introCulture(Model model, @RequestBody Map<String, Object> introMap){
		String contentid = (String) introMap.get("contentid");
		String contenttypeid = (String) introMap.get("contenttypeid");
		
		DetailinfocultureVO cultureVO = basicInfoService.detailByCultureVO(contentid, contenttypeid);
		
		model.addAttribute("contenttypeid" , contenttypeid);
		model.addAttribute("cultureVO", cultureVO);
		return "content/user/travel/detailInfo/InfoOfdetail";
	}
	
	/**
	 * Method : introEvent
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param introMap
	 * @return
	 * Method 설명 : 레포츠 소개 정보 조회
	 */
	@RequestMapping("/intro/28")
	public String introLeports(Model model, @RequestBody Map<String, Object> introMap){
		String contentid = (String) introMap.get("contentid");
		String contenttypeid = (String) introMap.get("contenttypeid");
		
		Detailinfo_leportsVO leportsVO = basicInfoService.detailByLeportsVO(contentid, contenttypeid);
		
		model.addAttribute("contenttypeid" , contenttypeid);
		model.addAttribute("leportsVO", leportsVO);
		
		return "content/user/travel/detailInfo/InfoOfdetail";
	}
	
	/**
	 * Method : introCourse
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param introMap
	 * @return
	 * Method 설명 : 여행코스 소개 정보  조회
	 */
	@RequestMapping("/intro/25")
	public String introCourse(Model model, @RequestBody Map<String, Object> introMap){
		String contentid = (String) introMap.get("contentid");
		String contenttypeid = (String) introMap.get("contenttypeid");
		
		Detailinfo_courseVO courseVO = basicInfoService.detailByCourseVO(contentid, contenttypeid);
		model.addAttribute("contenttypeid" , contenttypeid);
		model.addAttribute("courseVO", courseVO);
		
		return "content/user/travel/detailInfo/InfoOfdetail";
	}
	
	/**
	 * Method : introLeports
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param introMap
	 * @return
	 * Method 설명 : 축제 소개 정보 조회
	 */
	@RequestMapping("/intro/15")
	public String introEvent(Model model, @RequestBody Map<String, Object> introMap){
		String contentid = (String) introMap.get("contentid");
		String contenttypeid = (String) introMap.get("contenttypeid");
		
		Detailinfo_eventVO eventVO = basicInfoService.detailByEventVO(contentid, contenttypeid);
		model.addAttribute("contenttypeid" , contenttypeid);
		model.addAttribute("eventVO", eventVO);
		
		return "content/user/travel/detailInfo/InfoOfdetail";
	}
	
	/**
	 * Method : introEvent
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param model
	 * @param introMap
	 * @return
	 * Method 설명 : 추가 정보
	 */
	@RequestMapping("/addInfo")
	public String addInfo(Model model, @RequestBody Map<String, Object> introMap){
		String contentid = (String) introMap.get("contentid");
		String contenttypeid = (String) introMap.get("contenttypeid");
		
		// 여행 코스인 경우
		if(contenttypeid.contains("25")){
			// 여행 코스의 추가정보 조회
			Map<String, Object> courseMap = basicInfoService.addDetailByCourse(contentid, contenttypeid);
			model.addAttribute("courseVOs", courseMap.get("courseVOs"));
			model.addAttribute("contenttypeid", contenttypeid);
			return "content/user/travel/detailInfo/course";
		}else{
			Map<String, Object> etcMap = basicInfoService.addDetailEtc(contentid, contenttypeid);
			model.addAttribute("etcVOs", etcMap.get("etcVOs"));
			model.addAttribute("contenttypeid", contenttypeid);
			return "content/user/travel/detailInfo/etc";
		}
		
	}
	
	/**
	 * Method : goodFill
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 좋아요 채우기
	 */
	@RequestMapping("/good")
	@ResponseBody
	public Map<String,Object> goodFill(HttpSession session, @RequestBody Map<String,Object> contentid_map){
		String contentid = (String) contentid_map.get("contentid");
		
		// 좋아요 선택시 
		Map<String,Object> resultBool = basicInfoService.goodFill(session, contentid);
		return resultBool;
	}
	
	/**
	 * Method : addBookmark
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param session
	 * @param contentidMap
	 * Method 설명 : 즐겨찾기에 추가
	 */
	@RequestMapping("/addBookmark")
	@ResponseBody
	public void addBookmark(HttpSession session, @RequestBody Map<String, String> contentidMap){
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		if (memberVO != null) {
			String mem_id = memberVO.getMem_id();
			String contentid = contentidMap.get("contentid");
			String link = contentidMap.get("link");
			basicInfoService.addBookmark(mem_id, contentid, link);
		}
	}
	
	/**
	 * Method : mainBasicInfo
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * Method 설명 : 메인 상세 정보 조회
	 */
	@RequestMapping("/mainInfo")
	public String mainBasicInfo(Model model, @RequestBody Map<String, Object> map){
		String contentid = (String) map.get("contentid");
		Map<String,Object> resultMap = basicInfoService.detailPage(contentid);
		BasicinfoVO basicinfoVO = (BasicinfoVO) resultMap.get("basicinfoVO");
		model.addAttribute("basicinfoVO", basicinfoVO);
		
		return "content/user/travel/detailInfo/infoOfBasic";
	}
	
	/**
	 * Method : addReview
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param session
	 * @param parameterMap
	 * Method 설명 : 리뷰 작성 - 리뷰 추가, 태그 추가
	 */
	@RequestMapping("/addReview")
	@ResponseBody
	public String addReview(HttpSession session, @RequestBody Map<String, Object> parameterMap){
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		if (memberVO != null) {
			String mem_id = memberVO.getMem_id();
			String contentid = (String)parameterMap.get("contentid");
			String review_title = (String)parameterMap.get("review_title");
			String review_content = (String)parameterMap.get("review_content");
			List<String> tag_contents = (List)parameterMap.get("tag_content");
			return basicInfoService.addReview(mem_id, contentid, review_title, review_content, tag_contents);
		}
		return "";
	}
	
	/**
	 * Method : summaryInfo
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 개요 정보 조회
	 */
	@RequestMapping("/summary")
	@ResponseBody
	public Map<String, Object> summaryInfo(@RequestBody Map<String, Object> map){
		String contentid = (String) map.get("contentid");
		System.out.println("contentid " + contentid);
		Map<String,Object> resultMap = basicInfoService.detailPage(contentid);
		System.out.println("resultMap + " + resultMap.toString());
		return resultMap;
	}
	
	/**
	 * Method : imageUpload
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param multipartFileList
	 * @param parent_seq
	 * Method 설명 : 포토리뷰 작성시 이미지 업로드
	 * @throws IOException 
	 */
	@RequestMapping("/imageUpload")
	@ResponseBody
	public void imageUpload(@RequestPart("file") List<MultipartFile> multipartFileList, String parent_seq) throws IOException{
		int parent_seqNum = Integer.valueOf(parent_seq);
		for (MultipartFile multipartFile : multipartFileList) {
			fileAddService.imageUpload(multipartFile, "/upload/review/", parent_seqNum, "04");
		}
	}
	
	@RequestMapping("/reviewInfo")
	public String reviewInfo(@RequestBody Map<String, String> parameterMap, Model model){
		String contentid = parameterMap.get("contentid");
		String pageNo = parameterMap.get("pageNo");
		
		//총개수 및 리뷰 조회
		Map<String, Object> map = basicInfoService.selectReview(pageNo, contentid);
		model.addAttribute("reviewList", map.get("reviewList"));
		
		int pageNum = Integer.valueOf(pageNo);
		PageVO pageVO = new PageVO();
		pageVO.setPageNo(pageNum);
		//페이지 블록 사이즈
		pageVO.setBlockSize(10);
		pageVO.setPageSize(2);
		
		//전체 게시물 수
		pageVO.setTotalCount((int)(map.get("totalCount")));
		//페이징객체 만들기
		pageVO.makePaging();
		
		model.addAttribute("page", pageVO);
		
		return "content/user/travel/detailInfo/review";
	}
	
	/**
	 * Method : reviewDelete
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @param contentid
	 * @param contentTypeId
	 * @return
	 * Method 설명 : 리뷰 삭제
	 */
	@RequestMapping("/reviewDelete")
	public String reviewDelete(int review_seq, String contentid, String contentTypeId){
		basicInfoService.deleteReview(review_seq);
		
		String parameter = "?contentid="+contentid+"&contentTypeId="+contentTypeId;
		return "redirect:/basicInfo/basicInfo"+parameter;
	}
	
	
	@RequestMapping("/insertStar")
	@ResponseBody
	public String insertStar(HttpSession session, @RequestBody Map<String,String> map){
		String contentid = map.get("contentid");
		String score_point = map.get("score_point");
		String mem_id = (String) session.getAttribute("mem_id");
		
		return basicInfoService.insertStar(contentid, score_point, mem_id)+"";
	}
}
