package com.yolo.service.basicInfo;

import java.util.Map;

/**
 * BasicSearchService.java
 *
 * @author JiHee
 * @since 2018. 6. 26.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 26. JiHee 최초 생성
 *
 * </pre>
 */
public interface BasicSearchServiceInf {
	
	/**
	 * Method : searchByKeyword
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param keyword 키워드값
	 * @param pageNo 현재 페이지 번호
	 * @param areaCode 지역코드
	 * @param contentTypeId 관광타입ID
	 * @return 여행지 목록 및 총 개수
	 * Method 설명 : 카테고리 이름으로 키워드 검색
	 */
	Map<String, Object> searchByKeyword(String keyword, String pageNo, String areaCode, String contentTypeId);
	
	/**
	 * Method : searchByLocation
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param pageNo 현재 페이지 번호
	 * @param areaCode 지역코드
	 * @param contentTypeId 관광타입ID
	 * @return
	 * Method 설명 : 지역기반 검색
	 */
	Map<String, Object> searchByLocation(String pageNo, String areaCode, String contentTypeId);

	/**
	 * Method : searchByEvent
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param eventStartDate 시작일
	 * @param eventEndDate 종료일
	 * @param pageNo 현재 페이지 번호
	 * @param areaCode 지역코드
	 * @return
	 * Method 설명 : 축제 검색
	 */
	Map<String, Object> searchByEvent(String eventStartDate, String eventEndDate, String pageNo, String areaCode);


}
