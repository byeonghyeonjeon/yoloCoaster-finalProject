package com.yolo.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yolo.dao.admin.inf.TravelDaoInf;
import com.yolo.model.CategoryVO;
import com.yolo.model.PageVO;
import com.yolo.model.ReviewVO;
import com.yolo.model.TagCountVO;

/**
 * TravelDao.java
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
@Repository
public class TravelDao implements TravelDaoInf {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public int selectTotalReviewCount() {
		return sessionTemplate.selectOne("adminTravel.selectTotalReviewCount");
	}

	@Override
	public int selectTodayReviewCount() {
		return sessionTemplate.selectOne("adminTravel.selectTodayReviewCount");
	}

	@Override
	public int selectTotalTagCount() {
		return sessionTemplate.selectOne("adminTravel.selectTotalTagCount");
	}

	@Override
	public int selectTodayTagCount() {
		return sessionTemplate.selectOne("adminTravel.selectTodayTagCount");
	}

	@Override
	public int selectTotalMessageCount() {
		return sessionTemplate.selectOne("adminTravel.selectTotalMessageCount");
	}

	@Override
	public int selectTodayMessageCount() {
		return sessionTemplate.selectOne("adminTravel.selectTodayMessageCount");
	}

	@Override
	public List<ReviewVO> selectReview(PageVO pageVO) {
		return sessionTemplate.selectList("adminTravel.selectReview", pageVO);
	}

	@Override
	public ReviewVO selectReviewDetail(String review_seq) {
		return sessionTemplate.selectOne("adminTravel.selectReviewDetail", review_seq);
	}

	@Override
	public List<ReviewVO> searchReview(String review_title, PageVO pageVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("review_title", review_title);
		map.put("pageNo", pageVO.getPageNo());
		
		return sessionTemplate.selectList("adminTravel.searchReview", map);
	}

	@Override
	public int searchReviewCount(String review_title) {
		return sessionTemplate.selectOne("adminTravel.searchReviewCount", review_title);
	}

	@Override
	public List<TagCountVO> selectTag(PageVO pageVO) {
		return sessionTemplate.selectList("adminTravel.selectTag", pageVO);
	}
	
	@Override
	public int deleteTag(String tag_content) {
		return sessionTemplate.delete("adminTravel.deleteTag", tag_content);
	}

	@Override
	public int searchTagCount(String tag_content) {
		return sessionTemplate.selectOne("adminTravel.searchTagCount", tag_content);
	}

	@Override
	public List<TagCountVO> searchTag(String tag_content, PageVO pageVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tag_content", tag_content);
		map.put("pageNo", pageVO.getPageNo());
		
		return sessionTemplate.selectList("adminTravel.searchTag", map);
	}

	@Override
	public int selectTotalTagCountCount() {
		return sessionTemplate.selectOne("adminTravel.selectTotalTagCountCount");
	}

	@Override
	public int selectTotalCategory() {
		return sessionTemplate.selectOne("adminTravel.selectTotalCategory");
	}

	@Override
	public int selectTotalCategoryY() {
		return sessionTemplate.selectOne("adminTravel.selectTotalCategoryY");
	}

	@Override
	public int selectTotalCategoryN() {
		return sessionTemplate.selectOne("adminTravel.selectTotalCategoryN");
	}

	@Override
	public List<CategoryVO> selectCategory(PageVO pageVO) {
		return sessionTemplate.selectList("adminTravel.selectCategory", pageVO);
	}

	@Override
	public int searchCategoryCount(String cate_name) {
		return sessionTemplate.selectOne("adminTravel.searchCategoryCount", cate_name);
	}
	
	@Override
	public List<CategoryVO> searchCategory(String cate_name, PageVO pageVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cate_name", cate_name);
		map.put("pageNo", pageVO.getPageNo());
		
		return sessionTemplate.selectList("adminTravel.searchCategory", map);
	}

	@Override
	public int deleteCategory(CategoryVO categoryVO) {
		return sessionTemplate.delete("adminTravel.deleteCategory", categoryVO);
	}

	@Override
	public int updateCategoryToY(CategoryVO categoryVO) {
		return sessionTemplate.update("adminTravel.updateCategoryToY", categoryVO);
	}

	@Override
	public int updateCategoryToN(CategoryVO categoryVO) {
		return sessionTemplate.update("adminTravel.updateCategoryToN", categoryVO);
	}

	@Override
	public int selectCategoryByCateName(CategoryVO categoryVO) {
		return sessionTemplate.selectOne("adminTravel.selectCategoryByCateName", categoryVO);
	}

	@Override
	public int insertCategory(CategoryVO categoryVO) {
		return sessionTemplate.insert("adminTravel.insertCategory", categoryVO);
	}
	
}
