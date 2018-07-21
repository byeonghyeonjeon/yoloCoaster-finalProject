package com.yolo.dao.admin.inf;

import java.util.List;

import com.yolo.model.CategoryVO;
import com.yolo.model.PageVO;
import com.yolo.model.ReviewVO;
import com.yolo.model.TagCountVO;

/**
 * TravelDaoInf.java
 *
 * @author Jun
 * @since 2018. 7. 10.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 * 관리자용 리뷰 및 태그 관리 dao
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 10. Jun 최초 생성
 *
 * </pre>
 */
public interface TravelDaoInf {
	/**
	 * Method : selectTotalReviewCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 리뷰수
	 */
	int selectTotalReviewCount();
	
	/**
	 * Method : selectTodayReviewCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 오늘 등록된 리뷰 수
	 */
	int selectTodayReviewCount();
	
	/**
	 * Method : selectTotalTagCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 태그 수
	 */
	int selectTotalTagCount();
	
	/**
	 * Method : selectTodayTagCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 오늘 등록된 태그 수
	 */
	int selectTodayTagCount();
	
	/**
	 * Method : selectTotalMessageCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 메세지 수
	 */
	int selectTotalMessageCount();
	
	/**
	 * Method : selectTodayMessageCount
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 오늘 등록된 메세지 수
	 */
	int selectTodayMessageCount();
	
	/**
	 * Method : selectReview
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageNo
	 * @return
	 * Method 설명 : 리뷰 페이지네이션 처리 및 조회
	 */
	List<ReviewVO> selectReview(PageVO pageVO);
	
	/**
	 * Method : selectReviewDetail
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_seq
	 * @return
	 * Method 설명 : 리뷰 상세 조회
	 */
	ReviewVO selectReviewDetail(String review_seq);
	
	/**
	 * Method : searchReview
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_title
	 * @return
	 * Method 설명 : 리뷰 검색 조회
	 */
	List<ReviewVO> searchReview(String review_title, PageVO pageVO);
	
	/**
	 * Method : searchReviewCount
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param review_title
	 * @return
	 * Method 설명 : 리뷰 검색 조회 총 개수
	 */
	int searchReviewCount(String review_title);
	
	/**
	 * Method : selectTag
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 태그 조회 페이지네이션처리
	 */
	List<TagCountVO> selectTag(PageVO pageVO);
	
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
	 * Method : searchTagCount
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param tag_content
	 * @return
	 * Method 설명 : 태그 검색시 총 개수 조회
	 */
	int searchTagCount(String tag_content);
	
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
	 * Method : selectTotalTagCountCount
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 페이지 네이션용 총 개수 조회
	 */
	int selectTotalTagCountCount();
	
	/**
	 * Method : selectTotalCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 총 카테고리 수 조회
	 */
	int selectTotalCategory();
	
	/**
	 * Method : selectTotalCategoryY
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 활성화된 카테고리 수 조회
	 */
	int selectTotalCategoryY();
	
	/**
	 * Method : selectTotalCategoryN
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @return
	 * Method 설명 : 비활성화된 카테고리 수 조회
	 */
	int selectTotalCategoryN();
	
	/**
	 * Method : selectCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 카테고리 조회 및 페이지네이션 처리
	 */
	List<CategoryVO> selectCategory(PageVO pageVO);
	
	/**
	 * Method : searchCategoryCount
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param cate_name
	 * @return
	 * Method 설명 : 카테고리 검색시 총 개수 조회
	 */
	int searchCategoryCount(String cate_name);
	
	/**
	 * Method : searchCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param cate_name
	 * @param pageVO
	 * @return
	 * Method 설명 : 카테고리 검색 및 페이지네이션처리
	 */
	List<CategoryVO> searchCategory(String cate_name, PageVO pageVO);

	/**
	 * Method : deleteCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 삭제
	 */
	int deleteCategory(CategoryVO categoryVO);

	/**
	 * Method : updateCategoryToY
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 활성화
	 */
	int updateCategoryToY(CategoryVO categoryVO);
	
	/**
	 * Method : updateCategoryToN
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 비활성화
	 */
	int updateCategoryToN(CategoryVO categoryVO);
	
	/**
	 * Method : selectCategoryByCateName
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 해당 카테고리가 이미 있는지 조회
	 */
	int selectCategoryByCateName(CategoryVO categoryVO);

	/**
	 * Method : insertCategory
	 * 최초작성일 : 2018. 7. 12.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param categoryVO
	 * @return
	 * Method 설명 : 카테고리 추가
	 */
	int insertCategory(CategoryVO categoryVO);
	
}
