package com.yolo.service.basicInfo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.Detailinfo_courseVO;
import com.yolo.model.Detailinfo_eventVO;
import com.yolo.model.Detailinfo_leportsVO;
import com.yolo.model.DetailinfocultureVO;
import com.yolo.model.DetailinfotourVO;
import com.yolo.model.File_addVO;
import com.yolo.model.RepeatInfo_courseVO;
import com.yolo.model.StarVO;
import com.yolo.model.TagCountVO;

public interface BasicInfoServiceInf {
	
	/**
	 * Method : detailPage
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid 콘텐츠ID
	 * @param contenttypeid 관광타입ID
	 * @return
	 * Method 설명 : 상세 정보 전부 조회
	 */
	Map<String, Object> detailPage(String contentid);
	
	/**
	 * Method : nearbyTravel
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param travelMap 
	 * @param contenttypeid : 관광타입
	 * @param contentid : 콘텐트 ID
	 * @return
	 * Method 설명 : 주변 관광지 정보 조회
	 */
	Map<String, Object> nearbyTravel(Map<String, Object> travelMap);

	/**
	 * Method : detailByTour
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 관광지의 소개 정보
	 */
	DetailinfotourVO detailByTour(String contentid,String contenttypeid);

	/**
	 * Method : detailByCultureVO
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 문화시설 소개 정보
	 */
	DetailinfocultureVO detailByCultureVO(String contentid, String contenttypeid);

	/**
	 * Method : detailByLeportsVO
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 레포츠 소개 정보
	 */
	Detailinfo_leportsVO detailByLeportsVO(String contentid, String contenttypeid);

	/**
	 * Method : detailByCourseVO
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 여행코스 소개 정보
	 */
	Detailinfo_courseVO detailByCourseVO(String contentid, String contenttypeid);

	/**
	 * Method : detailByEventVO
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 축제 소개 정보
	 */
	Detailinfo_eventVO detailByEventVO(String contentid, String contenttypeid);

	/**
	 * Method : insertGoodFilled
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param goodVO 
	 * @return
	 * Method 설명 : 좋아요 선택시
	 */
	Map<String,Object> goodFill(HttpSession session, String contentid);
	
	/**
	 * Method : getGood
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param session
	 * @return
	 * Method 설명 : 회원이 좋아요 선택했는지 확인
	 */
	Boolean getGood(HttpSession session, String contentid);


//	void addInfo(String contenttypeid, String contentid);
	
	/**
	 * Method : addBookmark
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param contentid
	 * Method 설명 : 즐겨찾기에 추가
	 */
	void addBookmark(String mem_id, String contentid, String link);
	
	/**
	 * Method : getBookmarkAreaRightBar
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param pageNo
	 * @return
	 * Method 설명 : 즐겨찾기 목록 페이징처리
	 */
	List<Bookmark_areaVO> getBookmarkAreaRightBar(String mem_id, int pageNo);
	
	/**
	 * Method : selectBookmarkCnt
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 해당 회원의 북마크 총 개수 조회
	 */
	int selectBookmarkCnt(String mem_id);
	
	/**
	 * Method : addReview
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param contentid
	 * @param review_title
	 * @param review_content
	 * @param tag_contents
	 * @return 리뷰아이디
	 * Method 설명 : 리뷰 추가
	 */
	String addReview(String mem_id, String contentid, String review_title, String review_content, List<String> tag_contents);
	
	/**
	 * Method : selectReview
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageNo
	 * @param contentid
	 * @return totalCount, reviewList
	 * Method 설명 : 리뷰 조회
	 */
	Map<String, Object> selectReview(String pageNo, String contentid);
	
	/**
	 * Method : selectImgAllOfContent
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 해당 컨텐츠의 리뷰 사진 조회
	 */
	List<File_addVO> selectImgAllOfContent(String contentid);
	
	/**
	 * Method : deleteReview
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @return
	 * Method 설명 : 리뷰 삭제
	 */
	int deleteReview(int review_seq);
	
	/**
	 * Method : insertStar
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param contentid
	 * @param score_point
	 * @param mem_id
	 * @return
	 * Method 설명 : 별점 추가
	 */
	int insertStar(String contentid, String score_point, String mem_id);
	
	/**
	 * Method : selectStar
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 모든 별점 조회
	 */
	List<StarVO> selectStar(String contentid);
	
	/**
	 * Method : selectTagCount
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 모든 태그 통계 조회
	 */
	List<TagCountVO> selectTagCount(String contentid);
	
	/**
	 * Method : searchTag
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param keyword
	 * @param pageNo
	 * @return
	 * Method 설명 : 태그 검색(페이지네이션 처리)
	 */
	Map<String, Object> searchTag(String keyword, String pageNo);

	/**
	 * Method : addDetailByCourse
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 여행 코스 추가 정보 조회
	 */
	Map<String, Object> addDetailByCourse(String contentid, String contenttypeid);

	/**
	 * Method : addDetailEtc
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 여행코스가 아닌경우 추가 정보 조회
	 */
	Map<String, Object> addDetailEtc(String contentid, String contenttypeid);
}
