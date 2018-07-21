package com.yolo.dao.basicInfo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.basicInfo.inf.BasicInfoDaoInf;
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

@Repository   
public class BasicInfoDao implements BasicInfoDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertBasicInfo(BasicinfoVO basicinfoVO) {
		return sessionTemplate.insert("travel.insertBasicInfo", basicinfoVO);
	}

	@Override
	public BasicinfoVO getBasicInfo(String contentid) {
		return sessionTemplate.selectOne("travel.getBasicInfo", contentid);
	}

	@Override
	public int insertDetailByTour(DetailinfotourVO detailTourVO) {
		return sessionTemplate.insert("travel.insertDetailByTour", detailTourVO);
	}

	@Override
	public DetailinfotourVO getDetailByTour(String contentid) {
		return sessionTemplate.selectOne("travel.getDetailByTour", contentid);
	}

	@Override
	public DetailinfocultureVO getCulture(String contentid) {
		return sessionTemplate.selectOne("travel.getCulture", contentid);
	}

	@Override
	public int insertCulture(DetailinfocultureVO cultureVO) {
		return sessionTemplate.insert("travel.insertCulture", cultureVO);
	}

	@Override
	public Detailinfo_leportsVO getLeports(String contentid) {
		return sessionTemplate.selectOne("travel.getLeports", contentid);
	}

	@Override
	public int insertLeports(Detailinfo_leportsVO leportsVO) {
		return sessionTemplate.insert("travel.insertLeports", leportsVO);
	}

	@Override
	public Detailinfo_courseVO getCourse(String contentid) {
		return sessionTemplate.selectOne("travel.getCourse", contentid);
	}

	@Override
	public int insertCourse(Detailinfo_courseVO courseVO) {
		return sessionTemplate.insert("travel.insertCourse", courseVO);
	}

	@Override
	public Detailinfo_eventVO getEvent(String contentid) {
		return sessionTemplate.selectOne("travel.getEvent", contentid);
	}

	@Override
	public int insertEvent(Detailinfo_eventVO eventVO) {
		return sessionTemplate.insert("travel.insertEvent", eventVO);
	}

	@Override
	public GoodVO getGood(Map<String, Object> goodMap) {
		return sessionTemplate.selectOne("good.getGood", goodMap);
	}

	@Override
	public int insertGoodFilled(GoodVO resultVO) {
		return sessionTemplate.insert("good.insertGoodFilled", resultVO);
	}

	@Override
	public int deleteGood(Map<String, Object> goodMap) {
		return sessionTemplate.delete("good.deleteGood", goodMap);
	}

	@Override
	public List<TravelVO> getGoodAndReviewCount(List<TravelVO> travelVOs) {
		return sessionTemplate.selectList("travel.getGoodAndReviewCount", travelVOs);
	}

	@Override
	public int insertReview(ReviewVO reviewVO) {
		return sessionTemplate.insert("travel.insertReview", reviewVO);
	}

	@Override
	public int insertTag(List<TagVO> tagVO) {
		return sessionTemplate.insert("travel.insertTag", tagVO);
	}

	@Override
	public int selectReviewAll(String contentid) {
		return sessionTemplate.selectOne("travel.selectReviewAll", contentid);
	}

	@Override
	public List<ReviewVO> selectReviewPaging(Map<String, String> map) {
		return sessionTemplate.selectList("travel.selectReviewPaging", map);
	}

	@Override
	public List<File_addVO> selectImgOfReview(List<String> parent_seqs) {
		return sessionTemplate.selectList("travel.selectImgOfReview", parent_seqs);
	}

	@Override
	public List<TagVO> selectTagOfReview(List<String> parent_seqs) {
		return sessionTemplate.selectList("travel.selectTagOfReview", parent_seqs);
	}

	@Override
	public List<File_addVO> selectImgAllOfContent(String contentid) {
		return sessionTemplate.selectList("travel.selectImgAllOfContent", contentid);
	}

	@Override
	public int deleteReview(int review_seq) {
		return sessionTemplate.delete("travel.deleteReview", review_seq);
	}

	@Override
	public int deleteTag(int review_seq) {
		return sessionTemplate.delete("travel.deleteTag", review_seq);
	}

	@Override
	public int selectStarByMember(Star_scoreVO starScoreVO) {
		return sessionTemplate.selectOne("travel.selectStarByMember", starScoreVO);
	}

	@Override
	public int insertStar(Star_scoreVO starScoreVO) {
		return sessionTemplate.insert("travel.insertStar", starScoreVO);
	}

	@Override
	public int updateStar(Star_scoreVO starScoreVO) {
		return sessionTemplate.update("travel.updateStar", starScoreVO);
	}

	@Override
	public List<StarVO> selectStar(String contentid) {
		return sessionTemplate.selectList("travel.selectStar", contentid);
	}

	@Override
	public List<TagCountVO> selectTagCount(String contentid) {
		return sessionTemplate.selectList("travel.selectTagCount", contentid);
	}

	@Override
	public int selectSearchTagCount(String keyword) {
		return sessionTemplate.selectOne("travel.selectSearchTagCount", keyword);
	}

	@Override
	public List<TravelVO> selectSearchTagTravelVO(Map<String, String> map) {
		return sessionTemplate.selectList("travel.selectSearchTagTravelVO", map);
	}

	@Override
	public List<RepeatInfo_courseVO> courseOfAddDetail(String contentid) {
		return sessionTemplate.selectList("travel.courseOfAddDetail", contentid);
	}

	@Override
	public int insertAddCourse(RepeatInfo_courseVO courseVO) {
		return sessionTemplate.insert("travel.insertAddCourse", courseVO);
	}

	@Override
	public List<RepeatInfo_ectVO> etcOfAddDetail(String contentid) {
		return sessionTemplate.selectList("travel.etcOfAddDetail", contentid);
	}

	@Override
	public int insertAddEtc(RepeatInfo_ectVO etcVO) {
		return sessionTemplate.insert("travel.insertAddEtc", etcVO);
	}

	
	
	
}
