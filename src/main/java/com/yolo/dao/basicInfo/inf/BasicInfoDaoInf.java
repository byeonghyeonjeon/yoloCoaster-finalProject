package com.yolo.dao.basicInfo.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.BasicinfoVO;
import com.yolo.model.Detailinfo_courseVO;
import com.yolo.model.Detailinfo_eventVO;
import com.yolo.model.Detailinfo_leportsVO;
import com.yolo.model.DetailinfocultureVO;
import com.yolo.model.DetailinfotourVO;
import com.yolo.model.File_addVO;
import com.yolo.model.GoodVO;
import com.yolo.model.RepeatInfo_courseVO;
import com.yolo.model.RepeatInfo_ectVO;
import com.yolo.model.ReviewVO;
import com.yolo.model.StarVO;
import com.yolo.model.Star_scoreVO;
import com.yolo.model.TagCountVO;
import com.yolo.model.TagVO;
import com.yolo.model.TravelVO;

public interface BasicInfoDaoInf {

	/**
	 * Method : insertBasicInfo
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param basicinfoVO
	 * @return
	 * Method 설명 : 관광 api에서 조회한 여행지 정보를  디비에 저장
	 */
	public int insertBasicInfo(BasicinfoVO basicinfoVO);
	
	/**
	 * Method : getBasicInfo
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid 콘텐츠  ID
	 * @return
	 * Method 설명 : 여행지 상세 정보 조회 
	 */
	public BasicinfoVO getBasicInfo(String contentid);
	
	/**
	 * Method : insertDetailByTour
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param detailTourVO
	 * @return
	 * Method 설명 : 관광 api에서 조회한 관광지 정보를 디비에 저장
	 */
	public int insertDetailByTour(DetailinfotourVO detailTourVO);

	/**
	 * Method : getDetailByTour
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 관광지 소개 조회
	 */
	public DetailinfotourVO getDetailByTour(String contentid);

	/**
	 * Method : getCulture
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 문화시설 소개 조회
	 */
	public DetailinfocultureVO getCulture(String contentid);

	/**
	 * Method : insertCulture
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param cultureVO
	 * @return
	 * Method 설명 : 문화시설 소개 정보
	 */
	public int insertCulture(DetailinfocultureVO cultureVO);

	/**
	 * Method : getLeports
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 레포츠 소개 정보 조회
	 */
	public Detailinfo_leportsVO getLeports(String contentid);

	/**
	 * Method : insertLeports
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param leportsVO
	 * Method 설명 : 레포츠 소개 디비 저장
	 */
	public int insertLeports(Detailinfo_leportsVO leportsVO);

	/**
	 * Method : getCourse
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 여행코스 소개 정보 조회
	 */
	public Detailinfo_courseVO getCourse(String contentid);

	/**
	 * Method : insertCourse
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param courseVO
	 * Method 설명 : 여행코스 소개 디비 저장
	 */
	public int insertCourse(Detailinfo_courseVO courseVO);

	/**
	 * Method : getEvent
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 축제 소개 정보 조회
	 */
	public Detailinfo_eventVO getEvent(String contentid);

	/**
	 * Method : insertEvent
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param eventVO
	 * Method 설명 : 축제 소개 디비 저장
	 */
	public int insertEvent(Detailinfo_eventVO eventVO);

	/**
	 * Method : getGood
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid 
	 * @param string
	 * @return
	 * Method 설명 : 좋아요 조회
	 */
	public GoodVO getGood(Map<String, Object> goodMap);

	/**
	 * Method : insertGoodFilled
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param resultVO
	 * Method 설명 : 좋아요 추가
	 */
	public int insertGoodFilled(GoodVO resultVO);

	/**
	 * Method : deleteGood
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param mem_id
	 * Method 설명 : 좋아요 삭제
	 */
	public int deleteGood(Map<String, Object> goodVO);
	
	/**
	 * Method : getGoodAndReviewCount
	 * 최초작성일 : 2018. 7. 4.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param travelVOs
	 * @return
	 * Method 설명 : 댓글 및 좋아요수를 가진 여행지 리스트 반환
	 */
	List<TravelVO> getGoodAndReviewCount(List<TravelVO> travelVOs);

	/**
	 * Method : insertReview
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param reviewVO
	 * @return
	 * Method 설명 : 리뷰 작성 - 리뷰 추가
	 */
	int insertReview(ReviewVO reviewVO);
	
	/**
	 * Method : insertTag
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param tagVO
	 * @return
	 * Method 설명 : 리뷰 작성 - 태그추가
	 */
	int insertTag(List<TagVO> tagVO);
	
	/**
	 * Method : selectReviewAll
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 해당 여행지의 모든 목록 조회
	 */
	int selectReviewAll(String contentid);
	
	/**
	 * Method : selectReviewPaging
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 페이지 번호, 여행지아이디
	 * @return
	 * Method 설명 : 페이징처리한 리뷰 리스트
	 */
	List<ReviewVO> selectReviewPaging(Map<String, String> map);
	
	/**
	 * Method : selectImgOfReview
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parent_seqs
	 * @return
	 * Method 설명 : 리뷰들의 이미지 조회
	 */
	List<File_addVO> selectImgOfReview(List<String> parent_seqs);
	
	/**
	 * Method : selectTagOfReview
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parent_seqs
	 * @return
	 * Method 설명 : 리뷰들의 태그 조회
	 */
	List<TagVO> selectTagOfReview(List<String> parent_seqs);
	
	/**
	 * Method : selectImgAllOfContent
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 해당 컨텐츠의 20개 사진 조회
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
	 * Method : deleteTag
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @return
	 * Method 설명 : 리뷰 내의 태그 함께 삭제
	 */
	int deleteTag(int review_seq);
	
	/**
	 * Method : selectStarByMember
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param starScoreVO
	 * @return
	 * Method 설명 : 해당 멤버의 별점 추가 여부 확인
	 */
	int selectStarByMember(Star_scoreVO starScoreVO);
	
	/**
	 * Method : insertStar
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param starScoreVO
	 * @return
	 * Method 설명 : 별점 추가
	 */
	int insertStar(Star_scoreVO starScoreVO);
	
	/**
	 * Method : updateStar
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param starScoreVO
	 * @return
	 * Method 설명 : 별점 수정
	 */
	int updateStar(Star_scoreVO starScoreVO);
	
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
	 * Method : selectSearchTagCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param keyword
	 * @return
	 * Method 설명 : 해당 태그와 관련된 여행지 총 개수 조회
	 */
	int selectSearchTagCount(String keyword);
	
	/**
	 * Method : selectSearchTagTravelVO
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map : tag_content, pageNo
	 * @return
	 * Method 설명 : 해당 태그와 관련된 여행지 페이지네이션 처리 및 조회
	 */
	List<TravelVO> selectSearchTagTravelVO(Map<String, String> map);

	/**
	 * Method : courseOfAddDetail
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 여행코스의 추가정보 조회
	 */
	List<RepeatInfo_courseVO> courseOfAddDetail(String contentid);

	/**
	 * Method : insertCourse
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param courseVO
	 * @return
	 * Method 설명 : 여행코스 추가정보 디비 저장
	 */
	int insertAddCourse(RepeatInfo_courseVO courseVO);

	/**
	 * Method : etcOfAddDetail
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 여행코스가 아닌 경우 추가정보 조회
	 */
	List<RepeatInfo_ectVO> etcOfAddDetail(String contentid);

	/**
	 * Method : insertAddEtc
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param gsonEtcVO
	 * @return
	 * Method 설명 : 여행코스가 아닌 경우 추가정보 디비 저장
	 */
	int insertAddEtc(RepeatInfo_ectVO etcVO);
}
