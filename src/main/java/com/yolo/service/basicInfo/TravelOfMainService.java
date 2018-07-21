package com.yolo.service.basicInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.basicInfo.inf.BasicInfoDaoInf;
import com.yolo.dao.basicInfo.inf.TravelOfMainDaoInf;
import com.yolo.model.BasicinfoVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.TravelVO;

/**
 * travelOfMainService.java
 *
 * @author JiHee
 * @since 2018. 7. 7.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 7. JiHee 최초 생성
 *
 * </pre>
 */
@Service
public class TravelOfMainService implements TravelOfMainServiceInf{
	
	@Resource
	private TravelOfMainDaoInf travelOfMainDao;
	
	@Resource
	private BasicInfoDaoInf basicInfoDao;

	/**
	 * Method : areaOfInterest
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 관심지역 조회
	 */
	@Override
	public List<TravelVO> areaOfInterest(String mem_id) {
		
		List<TravelVO> travelVOs = travelOfMainDao.areaOfInterest(mem_id);
		if(travelVOs.size() != 0) {
			List<TravelVO> goodAndReviewTravelVOs = basicInfoDao.getGoodAndReviewCount(travelVOs);
			for (TravelVO travelVO : goodAndReviewTravelVOs) {
				for (TravelVO travelVO2 : travelVOs) {
					if (travelVO.getContentid().equals(travelVO2.getContentid())) {
						travelVO2.setGoodCount(travelVO.getGoodCount());
						travelVO2.setReviewCount(travelVO.getReviewCount());
						break;
					}
				}
			}
		}
		
		return travelVOs;
	}

	@Override
	public int numberOfAreaOfInterest(String mem_id) {
		return travelOfMainDao.numberOfAreaOfInterest(mem_id);
	}

	@Override
	public List<TravelVO> profileRecommend(MemberVO memberVO) {
		// 프로필 기반으로 여행지 추천
		List<TravelVO> travelVOs = travelOfMainDao.profileRecommend(memberVO.getMem_id());
		
		List<TravelVO> goodAndReviewTravelVOs = basicInfoDao.getGoodAndReviewCount(travelVOs);
    	for (TravelVO travelVO : goodAndReviewTravelVOs) {
			for (TravelVO travelVO2 : travelVOs) {
				if (travelVO.getContentid().equals(travelVO2.getContentid())) {
					travelVO2.setGoodCount(travelVO.getGoodCount());
					travelVO2.setReviewCount(travelVO.getReviewCount());
					break;
				}
			}
		}
		return travelVOs;
	}


	@Override
	public List<TravelVO> areaRecommendPage(PageVO page, String mem_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pboard_seq", page.getPboard_seq()+"");
		map.put("pageNo", page.getPageNo()+"");
		map.put("mem_id", mem_id);
		
		List<TravelVO> travelVOs = travelOfMainDao.areaRecommendPage(map);
		
		List<TravelVO> goodAndReviewTravelVOs = basicInfoDao.getGoodAndReviewCount(travelVOs);
    	for (TravelVO travelVO : goodAndReviewTravelVOs) {
			for (TravelVO travelVO2 : travelVOs) {
				if (travelVO.getContentid().equals(travelVO2.getContentid())) {
					travelVO2.setGoodCount(travelVO.getGoodCount());
					travelVO2.setReviewCount(travelVO.getReviewCount());
					break;
				}
			}
		}
		
		
		return travelVOs;
	}

	@Override
	public List<TravelVO> getAllprofileRecommend(PageVO page, MemberVO memberVO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pboard_seq", page.getPboard_seq()+"");
		map.put("pageNo", page.getPageNo()+"");
		map.put("mem_id", memberVO.getMem_id());
		
		// 프로필 기반의 여행지 추천 조회
		List<TravelVO> travelVOs = travelOfMainDao.profileRecommendPage(map);
		
		List<TravelVO> goodAndReviewTravelVOs = basicInfoDao.getGoodAndReviewCount(travelVOs);
    	for (TravelVO travelVO : goodAndReviewTravelVOs) {
			for (TravelVO travelVO2 : travelVOs) {
				if (travelVO.getContentid().equals(travelVO2.getContentid())) {
					travelVO2.setGoodCount(travelVO.getGoodCount());
					travelVO2.setReviewCount(travelVO.getReviewCount());
					break;
				}
			}
		}
		
		return travelVOs;
	}
	
	@Override
	public int numberOfProfileRecommend(MemberVO memberVO) {
		return travelOfMainDao.numberOfProfileRecommend(memberVO.getMem_id());
	}

	@Override
	public List<TravelVO> eventRecommendPage(PageVO page, MemberVO memberVO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pboard_seq", page.getPboard_seq()+"");
		map.put("pageNo", page.getPageNo()+"");
		map.put("mem_id", memberVO.getMem_id());
		
		List<TravelVO> travelVOs = travelOfMainDao.eventRecommendPage(map);
		
		List<TravelVO> goodAndReviewTravelVOs = basicInfoDao.getGoodAndReviewCount(travelVOs);
    	for (TravelVO travelVO : goodAndReviewTravelVOs) {
			for (TravelVO travelVO2 : travelVOs) {
				if (travelVO.getContentid().equals(travelVO2.getContentid())) {
					travelVO2.setGoodCount(travelVO.getGoodCount());
					travelVO2.setReviewCount(travelVO.getReviewCount());
					break;
				}
			}
		}
		
		return travelVOs;
	}

	@Override
	public int numberOfEventRecommend(MemberVO memberVO) {
		return travelOfMainDao.numberOfEventRecommend(memberVO.getMem_id());
	}

	@Override
	public List<TravelVO> eventRecommend(MemberVO memberVO) {
		// 프로필 기반으로 축제 추천
		List<TravelVO> travelVOs = travelOfMainDao.eventRecommend(memberVO.getMem_id());
		
		List<TravelVO> goodAndReviewTravelVOs = basicInfoDao.getGoodAndReviewCount(travelVOs);
    	for (TravelVO travelVO : goodAndReviewTravelVOs) {
			for (TravelVO travelVO2 : travelVOs) {
				if (travelVO.getContentid().equals(travelVO2.getContentid())) {
					travelVO2.setGoodCount(travelVO.getGoodCount());
					travelVO2.setReviewCount(travelVO.getReviewCount());
					break;
				}
			}
		}
		return travelVOs;
	}
	
	
	
	
	
}
