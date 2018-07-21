package com.yolo.service.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.admin.inf.TravelDaoInf;
import com.yolo.dao.basicInfo.inf.BasicInfoDaoInf;
import com.yolo.model.CategoryVO;
import com.yolo.model.File_addVO;
import com.yolo.model.PageVO;
import com.yolo.model.ReviewVO;
import com.yolo.model.TagCountVO;
import com.yolo.model.TagVO;

/**
 * TravelService.java
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
@Service
public class TravelService implements TravelServiceInf {
	@Resource
	private TravelDaoInf travelDao;
	
	@Resource
	private BasicInfoDaoInf basicInfoDao;
	
	@Override
	public Map<String, Integer> getReviewPageStats() {
		int stat1 = travelDao.selectTotalReviewCount();
		int stat2 = travelDao.selectTodayReviewCount();
		int stat3 = travelDao.selectTotalMessageCount();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("stat1", stat1);
		map.put("stat2", stat2);
		map.put("stat3", stat3);
		
		return map;
	}

	@Override
	public List<ReviewVO> getReview(PageVO pageVO) {
		List<ReviewVO> reviewList = travelDao.selectReview(pageVO);
		List<String> parent_seqs = new ArrayList<String>();
		for (ReviewVO reviewVO : reviewList) {
			parent_seqs.add(reviewVO.getReview_seq()+"");
		}
		
		//pageVO 초기화
		pageVO.setBlockSize(10);
		pageVO.setTotalCount(travelDao.selectTotalReviewCount());
		pageVO.makePaging();
		
		return reviewList;
	}

	@Override
	public ReviewVO getReviewDetail(String review_seq) {
		ReviewVO reviewVO = travelDao.selectReviewDetail(review_seq);
		List<String> parent_seqs = new ArrayList<String>();
		parent_seqs.add(review_seq);
		
		//리뷰에 태그 셋
		List<TagVO> tagList = basicInfoDao.selectTagOfReview(parent_seqs);
		int parent_seq = reviewVO.getReview_seq();
		List<TagVO> review_tagList = new ArrayList<TagVO>();
		for (TagVO tagVO : tagList) {
			if(tagVO.getMain_board_seq() == parent_seq){
				review_tagList.add(tagVO);
			}
		}
		reviewVO.setReview_tagList(review_tagList);
		
		//리뷰에 이미지 셋
		List<File_addVO> fileList = basicInfoDao.selectImgOfReview(parent_seqs);
		List<File_addVO> review_imgList = new ArrayList<File_addVO>();
		for (File_addVO file_addVO : fileList) {
			if(file_addVO.getParent_seq() == parent_seq){
				review_imgList.add(file_addVO);
			}
		}
		reviewVO.setReview_imgList(review_imgList);
		
		return reviewVO;
	}

	@Override
	public int deleteReview(String review_seq) {
		int result = basicInfoDao.deleteReview(Integer.valueOf(review_seq));
		basicInfoDao.deleteTag(Integer.valueOf(review_seq));
		return result;
	}

	@Override
	public List<ReviewVO> searchReview(String review_title, PageVO pageVO) {
		//pageVO 초기화
		pageVO.setBlockSize(10);
		pageVO.setTotalCount(travelDao.searchReviewCount(review_title));//리뷰 검색 총 개수 조회
		pageVO.makePaging();
		
		//리뷰 검색 조회
		return travelDao.searchReview(review_title,pageVO);
	}

	@Override
	public Map<String, Integer> getTagPageStats() {
		int stat1 = travelDao.selectTotalTagCount();
		int stat2 = travelDao.selectTodayTagCount();
		int stat3 = travelDao.selectTodayMessageCount();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("stat1", stat1);
		map.put("stat2", stat2);
		map.put("stat3", stat3);
		
		return map;
	}

	@Override
	public List<TagCountVO> getTag(PageVO pageVO) {
		List<TagCountVO> tagList = travelDao.selectTag(pageVO);
		
		//pageVO 초기화
		pageVO.setBlockSize(10);
		pageVO.setTotalCount(travelDao.selectTotalTagCountCount());
		pageVO.makePaging();
		
		return tagList;
	}

	@Override
	public int deleteTag(String tag_content) {
		return travelDao.deleteTag(tag_content);
	}

	@Override
	public List<TagCountVO> searchTag(String tag_content, PageVO pageVO) {
		//pageVO 초기화
		pageVO.setBlockSize(10);
		pageVO.setTotalCount(travelDao.searchTagCount(tag_content));//태그 검색 총 개수 조회
		pageVO.makePaging();
		
		//태그 검색 조회
		return travelDao.searchTag(tag_content,pageVO);
	}

	@Override
	public Map<String, Integer> getCategoryPageStats() {
		int stat1 = travelDao.selectTotalCategory();
		int stat2 = travelDao.selectTotalCategoryY();
		int stat3 = travelDao.selectTotalCategoryN();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("stat1", stat1);
		map.put("stat2", stat2);
		map.put("stat3", stat3);
		
		return map;
	}

	@Override
	public List<CategoryVO> getCategory(PageVO pageVO) {
		List<CategoryVO> categoryList = travelDao.selectCategory(pageVO);
		
		//pageVO 초기화
		pageVO.setBlockSize(10);
		pageVO.setTotalCount(travelDao.selectTotalCategory());
		pageVO.makePaging();
		
		return categoryList;
	}

	@Override
	public List<CategoryVO> searchCategory(String cate_name, PageVO pageVO) {
		//pageVO 초기화
		pageVO.setBlockSize(10);
		pageVO.setTotalCount(travelDao.searchCategoryCount(cate_name));//카테고리 검색 총 개수 조회
		pageVO.makePaging();
		
		//카테고리 검색 조회
		return travelDao.searchCategory(cate_name,pageVO);
	}

	@Override
	public void deleteCategory(CategoryVO categoryVO) {
		travelDao.deleteCategory(categoryVO);
	}

	@Override
	public void updateCategoryToY(CategoryVO categoryVO) {
		travelDao.updateCategoryToY(categoryVO);
	}

	@Override
	public void updateCategoryToN(CategoryVO categoryVO) {
		travelDao.updateCategoryToN(categoryVO);
	}

	@Override
	public void insertCategory(CategoryVO categoryVO) {
		int result = travelDao.selectCategoryByCateName(categoryVO);
		if (result == 0) {
			travelDao.insertCategory(categoryVO);
		}
	}
	
}
