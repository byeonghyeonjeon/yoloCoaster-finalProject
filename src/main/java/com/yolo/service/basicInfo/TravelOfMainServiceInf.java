package com.yolo.service.basicInfo;

import java.util.List;
import java.util.Map;

import com.yolo.model.BasicinfoVO;
import com.yolo.model.MemberVO;
import com.yolo.model.PageVO;
import com.yolo.model.TravelVO;

/**
 * travelOfMainServiceInf.java
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
public interface TravelOfMainServiceInf {

	
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
	 * @param subOfAddr
	 * @return
	 * Method 설명 : 프로필 기반으로 4개만 여행지 추천
	 */
	public List<TravelVO> profileRecommend(MemberVO memberVO);
	
	/**
	 * Method : getAllprofileRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param memberVO
	 * @return
	 * Method 설명 : 프로필 기반으로 전부 조회
	 */
	public List<TravelVO> getAllprofileRecommend(PageVO pageVO, MemberVO memberVO);
	
	/**
	 * Method : areaRecommendPage
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param page
	 * @param memberVO 
	 * @return
	 * Method 설명 : 관심지역 더보기 페이지네이션
	 */
	public List<TravelVO> areaRecommendPage(PageVO page, String mem_id);
	
	/**
	 * Method : numberOfProfileRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param addr1
	 * @return
	 * Method 설명 : 프로필 기반 추천 여행지 개수
	 */
	public int numberOfProfileRecommend(MemberVO memberVO);
	
	/**
	 * Method : eventRecommendPage
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 지역축제 여행지 더보기 선택 후의 여행지 조회
	 */
	public List<TravelVO> eventRecommendPage(PageVO page, MemberVO memberVO);
	
	/**
	 * Method : numberOfEventRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param addr1
	 * @return
	 * Method 설명 : 지역축제 여행지 총 개수
	 */
	public int numberOfEventRecommend(MemberVO memberVO);
	
	/**
	 * Method : eventRecommend
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param addr1
	 * @return
	 * Method 설명 : 지역축제 추천 여행지 4개만 조회
	 */
	public List<TravelVO> eventRecommend(MemberVO memberVO);
}
