package com.yolo.dao.basicInfo.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.BasicinfoVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.TravelVO;

/**
 * travelOfMainDaoInf.java
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
public interface TravelOfMainDaoInf {
	
	/**
	 * Method : areaOfInterest
	 * 최초작성일 : 2018. 7. 7.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 관심지역 4개만 조회
	 */
	public List<TravelVO> areaOfInterest(String mem_id);
	
	/**
	 * Method : numberOfAreaOfInterest
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 관심지역 총 개수
	 */
	public int numberOfAreaOfInterest(String mem_id);

	
	/**
	 * Method : profileRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param subAddr1
	 * @return
	 * Method 설명 : 프로필 기반으로 4개의 여행지 조회
	 */
	public List<TravelVO> profileRecommend (String subAddr1);
	
	/**
	 * Method : areaRecommendPage
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 : 관심지역 더보기를 선택 후의 여행지 조회
	 */
	public List<TravelVO> areaRecommendPage(Map<String, String> map);
	
	/**
	 * Method : numberOfProfileRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param addr1
	 * @return
	 * Method 설명 : 프로필 기반 추천 여행지 개수
	 */
	public int numberOfProfileRecommend(String addr1);
	
	/**
	 * Method : profileRecommendPage
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 프로필 기반으로 여행지 추천 조회
	 */
	public List<TravelVO> profileRecommendPage(Map<String, String> map);
	
	/**
	 * Method : eventRecommendPage
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 지역축제 여행지 더보기 선택 후의 여행지 조회
	 */
	public List<TravelVO> eventRecommendPage(Map<String, String> map);
	
	/**
	 * Method : numberOfEventRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param addr1
	 * @return
	 * Method 설명 : 지역축제 여행지 총 개수
	 */
	public int numberOfEventRecommend(String addr1);
	
	/**
	 * Method : eventRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param addr1
	 * @return
	 * Method 설명 : 지역축제 추천 여행지 4개만 조회
	 */
	public List<TravelVO> eventRecommend(String addr1);
	
}
