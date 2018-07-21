package com.yolo.service.admin;

import java.util.List;
import java.util.Map;

import com.yolo.model.CategoryVO;
import com.yolo.model.PageVO;
import com.yolo.model.ReviewVO;
import com.yolo.model.TagCountVO;

/**
 * TravelServiceInf.java
 *
 * @author Jun
 * @since 2018. 7. 10.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 10. Jun 최초 생성
 *
 * </pre>
 */
public interface TravelServiceInf {
	
	/**
	 * Method : getReviewPage
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 리뷰 관리 페이지의 통계자료 조회
	 */
	Map<String, Integer> getReviewPageStats();
	
	/**
	 * Method : getReview
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 페이지에 맞는 리뷰 조회
	 */
	List<ReviewVO> getReview(PageVO pageVO);
	
	/**
	 * Method : getReviewDetail
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @return
	 * Method 설명 : 리뷰 상세조회
	 */
	ReviewVO getReviewDetail(String review_seq);
	
	/**
	 * Method : deleteReview
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @return
	 * Method 설명 : 리뷰 삭제
	 */
	int deleteReview(String review_seq);
	
	/**
	 * Method : searchReview
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_title
	 * @param pageVO
	 * @return
	 * Method 설명 : 리뷰 검색 조회
	 */
	List<ReviewVO> searchReview(String review_title, PageVO pageVO);
	
	/**
	 * Method : getTagPageStats
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 태그 관리 페이지의 통계자료 조회
	 */
	Map<String, Integer> getTagPageStats();
	
	/**
	 * Method : getTag
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 페이지에 해당하는 태그 목록 조회
	 */
	List<TagCountVO> getTag(PageVO pageVO);
	
	/**
	 * Method : deleteTag
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param tag_content
	 * @return
	 * Method 설명 : 태그 삭제
	 */
	int deleteTag(String tag_content);
	
	/**
	 * Method : searchTag
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param tag_content
	 * @param pageVO
	 * @return
	 * Method 설명 : 태그 검색 및 페이지네이션 처리
	 */
	List<TagCountVO> searchTag(String tag_content, PageVO pageVO);
	
	/**
	 * Method : getCategoryPageStats
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 카테고리 페이지 통계 조회
	 */
	Map<String, Integer> getCategoryPageStats();
	
	/**
	 * Method : getCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 카테고리 조회 및 페이지네이션 처리
	 */
	List<CategoryVO> getCategory(PageVO pageVO);
	
	/**
	 * Method : searchCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param cate_name
	 * @param pageVO
	 * @return
	 * Method 설명 : 카테고리 검색 및 페이지네이션 처리
	 */
	List<CategoryVO> searchCategory(String cate_name, PageVO pageVO);
	
	/**
	 * Method : deleteCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * Method 설명 : 카테고리 삭제
	 */
	void deleteCategory(CategoryVO categoryVO);

	/**
	 * Method : updateCategoryToY
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * Method 설명 : 카테고리 활성화
	 */
	void updateCategoryToY(CategoryVO categoryVO);
	
	/**
	 * Method : updateCategoryToN
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * Method 설명 : 카테고리 비활성화
	 */
	void updateCategoryToN(CategoryVO categoryVO);
	
	/**
	 * Method : insertCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * Method 설명 : 카테고리 추가
	 */
	void insertCategory(CategoryVO categoryVO);
	
}
