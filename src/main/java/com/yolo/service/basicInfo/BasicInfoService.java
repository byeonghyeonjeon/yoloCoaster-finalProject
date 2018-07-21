package com.yolo.service.basicInfo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yolo.dao.basicInfo.inf.BasicInfoDaoInf;
import com.yolo.dao.board.inf.BoardDaoInf;
import com.yolo.model.BasicinfoVO;
import com.yolo.model.Bookmark_areaVO;
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

@Service
public class BasicInfoService implements BasicInfoServiceInf {

	@Resource
	private BasicInfoDaoInf basicInfoDao;
	
	@Resource
	private BoardDaoInf boardDao;
	
	// 공공데이터포털에서 받은 인증키
	private static final String ServiceKey = "EtSF91PcyVZu75%2Fiy%2BCYg19wTdh2k0dPenZOTEQOmzLs7j5qm84mUVav2qJY5cM8dLMQWg2%2BSRXpCFD9DENPbw%3D%3D";
	private String numOfRows = "10";
	
	private final Gson gson = new Gson();
	
	/**
	 * Method : detailPage
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid 콘텐츠ID
	 * @param contenttypeid 관광타입ID
	 * @return
	 * Method 설명 : 상세 정보 전부 조회
	 */
	@Override
	public Map<String, Object> detailPage(String contentId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		BasicinfoVO result = basicInfoDao.getBasicInfo(contentId);
		resultMap.put("basicinfoVO", result);
		
		if (result == null) {
			BasicinfoVO basicinfoVO = new BasicinfoVO();
			
			// URL 만듬
			StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
			
			/*요청할 데이터*/
			try {
				urlBuilder.append(URLEncoder.encode("detailCommon", "UTF-8"));
				
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
				urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
				urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
				urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
				urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
				urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
				urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentId, "UTF-8")); /*콘텐츠ID*/
				urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*기본정보 조회*/
				urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*대표이미지 조회*/
				urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드 조회*/
				urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스분류코드 조회*/
				urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*주소 조회*/
				urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*좌표 조회*/
				urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*개요 조회*/
				urlBuilder.append("&" + "_type=json"); /*반환타입 json*/
				
				URL url = new URL(urlBuilder.toString());
				
				// URL을 이용한 연결
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				BufferedReader readResult;
				
				// url 연결의 응답 결과가 200 ~ 300 이내이면 통과
				// 그 이외인 경우 에러코드 출력 (예 : 404 에러)
				if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					readResult = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					readResult = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				StringBuilder resultJson = new StringBuilder();
				String line;
				while ((line = readResult.readLine()) != null) {
					resultJson.append(line);
				}
				readResult.close();
				conn.disconnect();
				
				//============================================================================
				//==결과(String)를 Json으로 저장===============================
				//============================================================================
				String json = resultJson.toString();
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(json);
				JsonElement response = element.getAsJsonObject().get("response");
				
				JsonElement response_header = response.getAsJsonObject().get("header");
				JsonElement response_header_resultCode = response_header.getAsJsonObject().get("resultCode");
				JsonElement response_header_resultMsg = response_header.getAsJsonObject().get("resultMsg");
				
				// 결과 코드가 정상(0000) 이 아닌 경우 반환 없음
				if (!response_header_resultCode.getAsString().equals("0000")) {
					System.out.println("결과값이 정상이 아닙니다");
					System.out.println("response_header_resultMsg : " + response_header_resultMsg);
					return null;
				}
				
				JsonElement response_body = response.getAsJsonObject().get("body");
				JsonElement response_body_items = response_body.getAsJsonObject().get("items");
				JsonElement response_body_items_item = response_body_items.getAsJsonObject().get("item");
				
				basicinfoVO = gson.fromJson(response_body_items_item, BasicinfoVO.class);
				
				basicInfoDao.insertBasicInfo(basicinfoVO);
				resultMap.put("basicinfoVO", basicinfoVO);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
		return resultMap;
	}

	/**
	 * Method : nearbyTravel
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param travelMap 
	 * @param contenttypeid : 관광타입
	 * @param contentid : 콘텐트 ID
	 * @return
	 * Method 설명 : 주변 관광지 정보 조회
	 */
	@Override
	public Map<String, Object> nearbyTravel(Map<String, Object> travelMap) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<BasicinfoVO> basicinfoVOs =  null;
		
		resultMap.put("basicinfoVOs", basicinfoVOs);
		
		String contenttypeid = (String) travelMap.get("contenttypeid");
		String mapy = (String) travelMap.get("mapy");
		String mapx = (String) travelMap.get("mapx");
		
		// URL 만듬
    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
    	/*요청할 데이터*/
        try {
			urlBuilder.append(URLEncoder.encode("locationBasedList", "UTF-8"));
			
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contenttypeid, "UTF-8")); /*관광타입ID(contentTypeId)*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
	        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")); /*정렬 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("mapX","UTF-8") + "=" + URLEncoder.encode(mapx, "UTF-8")); /*X좌표*/
	        urlBuilder.append("&" + URLEncoder.encode("mapY","UTF-8") + "=" + URLEncoder.encode(mapy, "UTF-8")); /*Y좌표*/
	        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*거리 반경*/
	    	urlBuilder.append("&" + "_type=json"); /*반환타입 json*/

	    	URL url = new URL(urlBuilder.toString());
	    	
	    	// URL을 이용한 연결
	    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    	conn.setRequestMethod("GET");
	    	conn.setRequestProperty("Content-type", "application/json");
	    	BufferedReader readResult;
	    	
	    	// url 연결의 응답 결과가 200 ~ 300 이내이면 통과
	    	// 그 이외인 경우 에러코드 출력 (예 : 404 에러)
	    	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	    		readResult = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    	} else {
	    		readResult = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	    	}
	    	StringBuilder resultJson = new StringBuilder();
	    	String line;
	    	while ((line = readResult.readLine()) != null) {
	    		resultJson.append(line);
	    	}
	    	readResult.close();
	    	conn.disconnect();
	    	
	    	//============================================================================
	        //==결과(String)를 Json으로 저장===============================
	        //============================================================================
	        String json = resultJson.toString();
	    	JsonParser parser = new JsonParser();
	    	JsonElement element = parser.parse(json);
	    	JsonElement response = element.getAsJsonObject().get("response");
	    	
	    	JsonElement response_header = response.getAsJsonObject().get("header");
	    	JsonElement response_header_resultCode = response_header.getAsJsonObject().get("resultCode");
	    	JsonElement response_header_resultMsg = response_header.getAsJsonObject().get("resultMsg");
	    	
	    	// 결과 코드가 정상(0000) 이 아닌 경우 반환 없음
	    	if (!response_header_resultCode.getAsString().equals("0000")) {
				System.out.println("결과값이 정상이 아닙니다");
				System.out.println("response_header_resultMsg : " + response_header_resultMsg);
				return null;
			}
	    	
	    	
	    	JsonElement response_body = response.getAsJsonObject().get("body");
	    	JsonElement response_body_items = response_body.getAsJsonObject().get("items");
	    	JsonElement response_body_items_item = response_body_items.getAsJsonObject().get("item");
	    	
	    	// json요소를 String으로 변환
	    	// null인 경우 처리
	    	
	    	basicinfoVOs = new ArrayList<BasicinfoVO>();
	    	
	    	if(response_body_items_item.isJsonArray()){
	    		JsonArray response_body_items_item_array = response_body_items_item.getAsJsonArray();
	    		
	    		for (int i = 0; i < response_body_items_item_array.size(); i++) {
	    			BasicinfoVO basicinfoVO = gson.fromJson(response_body_items_item_array.get(i), BasicinfoVO.class);
	    			// 리스트에 추가
	    			basicinfoVOs.add(basicinfoVO);
	    		}
	    	}else{
	    		BasicinfoVO basicinfoVO = gson.fromJson(response_body_items_item, BasicinfoVO.class);
    			// 리스트에 추가
    			basicinfoVOs.add(basicinfoVO);
	    	}
	    	resultMap.put("basicinfoVOs", basicinfoVOs);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return resultMap;
	}

	/**
	 * Method : detailByTour
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @return
	 * Method 설명 : 관광지 소개 정보
	 */
	@Override
	public DetailinfotourVO detailByTour(String contentid,String contenttypeid) {
		
		DetailinfotourVO detailTourVO =  new DetailinfotourVO();
		// 관광 api
		JsonElement response_body_items_item = parsejsonMap(contentid, contenttypeid);

		detailTourVO = gson.fromJson(response_body_items_item, DetailinfotourVO.class);
    	
    	// 해당 관광지 소개 정보 조회
    	DetailinfotourVO resultTourVO = basicInfoDao.getDetailByTour(detailTourVO.getContentid());
    	
    	
    	// 디비에 여행 정보가 있는지 확인
		if(resultTourVO != null){
			System.out.println("resultTourVO : " +resultTourVO.getUsetime());
			System.out.println("resultTourVO : " +resultTourVO.getChkpet());
			System.out.println("resultTourVO : " +resultTourVO.getExpguide());
			return resultTourVO;
		}
    	
    	// 관광지 소개 정보를 디비 저장 
    	basicInfoDao.insertDetailByTour(detailTourVO);
		
    	return detailTourVO;
	    	
	}

	/**
	 * Method : detailByCultureVO
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 문화시설 소개 정보
	 */
	@Override
	public DetailinfocultureVO detailByCultureVO(String contentid, String contenttypeid) {
		
		DetailinfocultureVO cultureVO =  new DetailinfocultureVO();
		
		// 관광 api
		JsonElement response_body_items_item = parsejsonMap(contentid, contenttypeid);
		
		cultureVO = gson.fromJson(response_body_items_item, DetailinfocultureVO.class);
		
		// 해당 문화시설 소개 정보 조회
		DetailinfocultureVO resultCultureVO = basicInfoDao.getCulture(cultureVO.getContentid());
		
		// 디비에 여행 정보가 있는지 확인
		if(resultCultureVO != null){
			return resultCultureVO;
		}
		
		// 문화시설 소개 정보를 디비 저장 
		basicInfoDao.insertCulture(cultureVO);
		
		return cultureVO;
	}
	
	/**
	 * Method : detailByLeportsVO
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 레포츠 소개 정보
	 */
	@Override
	public Detailinfo_leportsVO detailByLeportsVO(String contentid, String contenttypeid) {
		
		Detailinfo_leportsVO leportsVO =  new Detailinfo_leportsVO();
		
		// 관광 api
		JsonElement response_body_items_item = parsejsonMap(contentid, contenttypeid);
		
		leportsVO = gson.fromJson(response_body_items_item, Detailinfo_leportsVO.class);
		
		// 해당 레포츠 소개 정보 조회
		Detailinfo_leportsVO resultLeportsVO = basicInfoDao.getLeports(leportsVO.getContentid());
		
		// 디비에 여행 정보가 있는지 확인
		if(resultLeportsVO != null){
			return resultLeportsVO;
		}
    	
		// 레포츠 소개 정보를 디비 저장 
		basicInfoDao.insertLeports(leportsVO);
		
		return leportsVO;
	}

	/**
	 * Method : detailByCourseVO
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 여행코스 소개 정보
	 */
	@Override
	public Detailinfo_courseVO detailByCourseVO(String contentid, String contenttypeid) {
		
		Detailinfo_courseVO courseVO =  new Detailinfo_courseVO();
		
		// 관광 api
		JsonElement response_body_items_item = parsejsonMap(contentid, contenttypeid);
		
		courseVO = gson.fromJson(response_body_items_item, Detailinfo_courseVO.class);
		
		// 해당 여행코스 소개 정보 조회
		Detailinfo_courseVO resultCourseVO = basicInfoDao.getCourse(courseVO.getContentid());
		
		// 디비에 여행 정보가 있는지 확인
		if(resultCourseVO != null){
			return resultCourseVO;
		}
    	
		// 여행코스 소개 정보를 디비 저장 
		basicInfoDao.insertCourse(courseVO);
		
		return courseVO;
	}
	
	/**
	 * Method : detailByEventVO
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : 축제 소개 정보
	 */
	@Override
	public Detailinfo_eventVO detailByEventVO(String contentid, String contenttypeid) {
		
		Detailinfo_eventVO eventVO =  new Detailinfo_eventVO();
		
		// 관광 api
		JsonElement response_body_items_item = parsejsonMap(contentid, contenttypeid);
		
		eventVO = gson.fromJson(response_body_items_item, Detailinfo_eventVO.class);
		
		// 해당 축제 소개 정보 조회
		Detailinfo_eventVO resulteventVO = basicInfoDao.getEvent(eventVO.getContentid());
		
		// 디비에 여행 정보가 있는지 확인
		if(resulteventVO != null){
			return resulteventVO;
		}
    	
		// 축제 소개 정보를 디비 저장
		basicInfoDao.insertEvent(eventVO);
		
		return eventVO;
	}
	
	/**
	 * Method : parsejsonMap
	 * 최초작성일 : 2018. 6. 30.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param contentid
	 * @param contenttypeid
	 * @return
	 * Method 설명 : api연결
	 */
	private JsonElement parsejsonMap(String contentid, String contenttypeid) {
		// URL 만듬
    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
    	/*요청할 데이터*/
        try {
			urlBuilder.append(URLEncoder.encode("detailIntro", "UTF-8"));
			
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명*/
	        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentid, "UTF-8")); /*콘텐츠ID*/
	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contenttypeid, "UTF-8")); /*콘텐츠ID*/
	        urlBuilder.append("&" + URLEncoder.encode("introYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*소개정보 조회*/
	    	urlBuilder.append("&" + "_type=json"); /*반환타입 json*/

	    	URL url = new URL(urlBuilder.toString());
	    	
	    	// URL을 이용한 연결
	    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    	conn.setRequestMethod("GET");
	    	conn.setRequestProperty("Content-type", "application/json");
	    	BufferedReader readResult;
	    	
	    	// url 연결의 응답 결과가 200 ~ 300 이내이면 통과
	    	// 그 이외인 경우 에러코드 출력 (예 : 404 에러)
	    	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	    		readResult = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    	} else {
	    		readResult = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	    	}
	    	StringBuilder resultJson = new StringBuilder();
	    	String line;
	    	while ((line = readResult.readLine()) != null) {
	    		resultJson.append(line);
	    	}
	    	readResult.close();
	    	conn.disconnect();
	    	
	    	//============================================================================
	        //==결과(String)를 Json으로 저장===============================
	        //============================================================================
	        String json = resultJson.toString();
	    	JsonParser parser = new JsonParser();
	    	JsonElement element = parser.parse(json);
	    	JsonElement response = element.getAsJsonObject().get("response");
	    	
	    	JsonElement response_header = response.getAsJsonObject().get("header");
	    	JsonElement response_header_resultCode = response_header.getAsJsonObject().get("resultCode");
	    	JsonElement response_header_resultMsg = response_header.getAsJsonObject().get("resultMsg");
	    	
	    	// 결과 코드가 정상(0000) 이 아닌 경우 반환 없음
	    	if (!response_header_resultCode.getAsString().equals("0000")) {
				System.out.println("결과값이 정상이 아닙니다");
				System.out.println("response_header_resultMsg : " + response_header_resultMsg);
				return null;
			}
	    	
	    	
	    	JsonElement response_body = response.getAsJsonObject().get("body");
	    	JsonElement response_body_items = response_body.getAsJsonObject().get("items");
	    	JsonElement response_body_items_item = response_body_items.getAsJsonObject().get("item");
	    	
	    	// json요소를 String으로 변환
	    	// null인 경우 처리
//	    	JsonObject result = response_body_items_item.getAsJsonObject();
	    	return response_body_items_item;
	    	
        } catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method : insertGoodFilled
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 좋아요 선택시
	 */
	@Override
	public Map<String,Object> goodFill(HttpSession session, String contentid) {

		GoodVO goodVO = new GoodVO();
		// 리턴 값
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String mem_id = session.getAttribute("mem_id").toString();
		
		// 좋아요 조회
		Map<String, Object> goodMap = new HashMap<String, Object>();
		goodMap.put("good_mem_id", mem_id);
		goodMap.put("contentid", contentid);
		
		GoodVO resultVO = basicInfoDao.getGood(goodMap);
		
		// 디비에 사용자의 정보가 없을 경우 저장
		if(resultVO == null){
			goodVO.setGood_mem_id(mem_id);
			goodVO.setContentid(contentid);
			basicInfoDao.insertGoodFilled(goodVO);
			resultMap.put("resultBool", true);
		}else{
			basicInfoDao.deleteGood(goodMap);
			resultMap.put("resultBool", false);
		}
		
		System.out.println(resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * Method : getGood
	 * 최초작성일 : 2018. 7. 3.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param session
	 * @return
	 * Method 설명 : 회원이 좋아요 선택했는지 확인
	 */
	@Override
	public Boolean getGood(HttpSession session, String contentid){
		
		GoodVO goodVO = new GoodVO();
		
		String mem_id = session.getAttribute("mem_id").toString();
		
		Map<String, Object> goodMap = new HashMap<String, Object>();
		
		goodMap.put("good_mem_id", mem_id);
		goodMap.put("contentid", contentid);
		
		goodVO = basicInfoDao.getGood(goodMap);
		
		if(goodVO != null)
			return true;
		else
			return false;
	}


	@Override
	public void addBookmark(String mem_id, String contentid, String link) {
		Bookmark_areaVO bookmark_areaVO = new Bookmark_areaVO();
		bookmark_areaVO.setMem_id(mem_id);
		bookmark_areaVO.setContentid(contentid);
		
		int result = boardDao.getBookmarkAreaByMem_idAndContentid(bookmark_areaVO);
		
		if (result == 0) {
			BasicinfoVO basicinfoVO = basicInfoDao.getBasicInfo(contentid);
			bookmark_areaVO.setAreacode(basicinfoVO.getAreacode());
			bookmark_areaVO.setFirstimage2(basicinfoVO.getFirstimage2());
			bookmark_areaVO.setSigungucode(basicinfoVO.getSigungucode());
			bookmark_areaVO.setTitle(basicinfoVO.getTitle());
			bookmark_areaVO.setLink(link);
			boardDao.insertBookmarkArea(bookmark_areaVO);
		}
		
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkAreaRightBar(String mem_id, int pageNo) {
		Map<String, String> pageMap = new HashMap<String, String>();
		pageMap.put("mem_id", mem_id);
		pageMap.put("pageNo", pageNo+"");
		return boardDao.getBookmarkAreaRightBar(pageMap);
	}

	@Override
	public int selectBookmarkCnt(String mem_id) {
		return boardDao.selectBoardCnt(mem_id);
	}

	@Override
	public String addReview(String mem_id, String contentid, String review_title, String review_content, List<String> tag_contents) {
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setContentid(contentid);
		reviewVO.setReview_content(review_content);
		reviewVO.setReview_mem_id(mem_id);
		reviewVO.setReview_title(review_title);
		
		basicInfoDao.insertReview(reviewVO);
		
		List<TagVO> tagVOs = new ArrayList<TagVO>();
		for (String tag_content : tag_contents) {
			TagVO tagVO = new TagVO();
			tagVO.setContentid(contentid);
			tagVO.setMain_board_seq(reviewVO.getReview_seq());
			tagVO.setTag_content(tag_content);
			tagVOs.add(tagVO);
		}
		if (tagVOs.size() != 0) {
			basicInfoDao.insertTag(tagVOs);
		}
		return reviewVO.getReview_seq()+"";
	}

	@Override
	public Map<String, Object> selectReview(String pageNo, String contentid) {
		int totalCount = basicInfoDao.selectReviewAll(contentid);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("pageNo", pageNo);
		map.put("contentid", contentid);
		List<ReviewVO> reviewList = basicInfoDao.selectReviewPaging(map);
		List<String> parent_seqs = new ArrayList<String>();
		for (ReviewVO reviewVO : reviewList) {
			parent_seqs.add(reviewVO.getReview_seq()+"");
		}
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if (parent_seqs.size() != 0) {
			//리뷰의 이미지 조회
			List<File_addVO> imgList = basicInfoDao.selectImgOfReview(parent_seqs);
			
			//리뷰에 이미지 셋
			for (ReviewVO reviewVO : reviewList) {
				int parent_seq = reviewVO.getReview_seq();
				List<File_addVO> review_imgList = new ArrayList<File_addVO>();
				for (File_addVO file_addVO : imgList) {
					if(file_addVO.getParent_seq() == parent_seq){
						review_imgList.add(file_addVO);
					}
				}
				reviewVO.setReview_imgList(review_imgList);
			}
			
			
			//리뷰의 태그 조회
			List<TagVO> tagList = basicInfoDao.selectTagOfReview(parent_seqs);
			
			//리뷰의 태그 셋
			for (ReviewVO reviewVO : reviewList) {
				int parent_seq = reviewVO.getReview_seq();
				List<TagVO> review_tagList = new ArrayList<TagVO>();
				for (TagVO tagVO : tagList) {
					if (tagVO.getMain_board_seq() == parent_seq) {
						review_tagList.add(tagVO);
					}
				}
				reviewVO.setReview_tagList(review_tagList);
			}
			
			resultMap.put("totalCount", totalCount);
			resultMap.put("reviewList", reviewList);
			
		} else {
			resultMap.put("totalCount", 0);
			resultMap.put("reviewList", reviewList);
		}
		
		
		return resultMap;
	}

	@Override
	public List<File_addVO> selectImgAllOfContent(String contentid) {
		return basicInfoDao.selectImgAllOfContent(contentid);
	}

	@Override
	public int deleteReview(int review_seq) {
		int result = basicInfoDao.deleteReview(review_seq);
		result += basicInfoDao.deleteTag(review_seq);
		return result;
	}

	@Override
	public int insertStar(String contentid, String score_point, String mem_id) {
		Star_scoreVO starScoreVO = new Star_scoreVO();
		starScoreVO.setContentid(contentid);
		starScoreVO.setScore_mem_id(mem_id);
		starScoreVO.setScore_point(Integer.valueOf(score_point));
		
		int selectResult = basicInfoDao.selectStarByMember(starScoreVO);
		int result = 0;
		if (selectResult == 0) {
			result = basicInfoDao.insertStar(starScoreVO);
		} else {
			result = basicInfoDao.updateStar(starScoreVO);
		}
		
		return result;
	}

	@Override
	public List<StarVO> selectStar(String contentid) {
		return basicInfoDao.selectStar(contentid);
	}

	@Override
	public List<TagCountVO> selectTagCount(String contentid) {
		return basicInfoDao.selectTagCount(contentid);
	}

	@Override
	public Map<String, Object> searchTag(String keyword, String pageNo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int totalCount = basicInfoDao.selectSearchTagCount(keyword);
		resultMap.put("totalCount", totalCount);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("pageNo", pageNo);
		
		List<TravelVO> travelVOs = basicInfoDao.selectSearchTagTravelVO(map);
		resultMap.put("travelVOs", travelVOs);
		
		return resultMap;
	}

	@Override
	public Map<String, Object> addDetailByCourse(String contentid, String contenttypeid) {
		
		// 정보 조회할 때 필요
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<RepeatInfo_courseVO> courseVOs =  null;

		// 추가 정보 조회
		List<RepeatInfo_courseVO> resultCourseVOs = basicInfoDao.courseOfAddDetail(contentid);
		// 디비에 여행 정보가 있는지 확인
		if(resultCourseVOs.size() != 0){
			resultMap.put("courseVOs", resultCourseVOs);
			return resultMap;
		}
		
		// 관광 api
		JsonElement response_body_items_item = parsejsonMapCourse(contentid, contenttypeid);
		
		courseVOs = new ArrayList<RepeatInfo_courseVO>();
    	
    	if(response_body_items_item.isJsonArray()){
    		JsonArray response_body_items_item_array = response_body_items_item.getAsJsonArray();
    		
    		for (int i = 0; i < response_body_items_item_array.size(); i++) {
    			RepeatInfo_courseVO gsonCourseVO = gson.fromJson(response_body_items_item_array.get(i), RepeatInfo_courseVO.class);
    			// 코스 추가 정보를 디비 저장
    			basicInfoDao.insertAddCourse(gsonCourseVO);
    			// 리스트에 추가
    			courseVOs.add(gsonCourseVO);
    		}
    	}else{
    		RepeatInfo_courseVO gsonCourseVO = gson.fromJson(response_body_items_item, RepeatInfo_courseVO.class);
    		// 코스 추가 정보를 디비 저장
    		basicInfoDao.insertAddCourse(gsonCourseVO);
			// 리스트에 추가
    		courseVOs.add(gsonCourseVO);
    	}
    	resultMap.put("courseVOs", courseVOs);
    	
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> addDetailEtc(String contentid, String contenttypeid) {
		// 정보 조회할 때 필요
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<RepeatInfo_ectVO> etcVOs =  null;

		// 추가 정보 조회
		List<RepeatInfo_ectVO> resultEtcVOs = basicInfoDao.etcOfAddDetail(contentid);
		// 디비에 여행 정보가 있는지 확인
		if(resultEtcVOs.size() != 0){
			resultMap.put("etcVOs", resultEtcVOs);
			return resultMap;
		}
		
		// 관광 api
		JsonElement response_body_items_item = parsejsonMapCourse(contentid, contenttypeid);
		
		if(response_body_items_item != null){
			etcVOs = new ArrayList<RepeatInfo_ectVO>();
	    	
	    	if(response_body_items_item.isJsonArray()){
	    		JsonArray response_body_items_item_array = response_body_items_item.getAsJsonArray();
	    		
	    		for (int i = 0; i < response_body_items_item_array.size(); i++) {
	    			RepeatInfo_ectVO gsonEtcVO = gson.fromJson(response_body_items_item_array.get(i), RepeatInfo_ectVO.class);
	    			// 코스 추가 정보를 디비 저장
	    			basicInfoDao.insertAddEtc(gsonEtcVO);
	    			// 리스트에 추가
	    			etcVOs.add(gsonEtcVO);
	    		}
	    	}else{
	    		RepeatInfo_ectVO gsonEtcVO = gson.fromJson(response_body_items_item, RepeatInfo_ectVO.class);
	    		// 코스 추가 정보를 디비 저장
	    		basicInfoDao.insertAddEtc(gsonEtcVO);
				// 리스트에 추가
	    		etcVOs.add(gsonEtcVO);
	    	}
	    	resultMap.put("etcVOs", etcVOs);
		}else{
			resultMap.put("etcVOs", "없음");
		}
		
		return resultMap;
	}

	private JsonElement parsejsonMapCourse(String contentid, String contenttypeid) {
		
		// URL 만듬
    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
    	/*요청할 데이터*/
        try {
			urlBuilder.append(URLEncoder.encode("detailInfo", "UTF-8"));
			
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명*/
	        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentid, "UTF-8")); /*콘텐츠ID*/
	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contenttypeid, "UTF-8")); /*콘텐츠ID*/
	        urlBuilder.append("&" + URLEncoder.encode("detailYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*반복정보 조회*/
	    	urlBuilder.append("&" + "_type=json"); /*반환타입 json*/

	    	URL url = new URL(urlBuilder.toString());
	    	
	    	// URL을 이용한 연결
	    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    	conn.setRequestMethod("GET");
	    	conn.setRequestProperty("Content-type", "application/json");
	    	BufferedReader readResult;
	    	
	    	// url 연결의 응답 결과가 200 ~ 300 이내이면 통과
	    	// 그 이외인 경우 에러코드 출력 (예 : 404 에러)
	    	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	    		readResult = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    	} else {
	    		readResult = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	    	}
	    	StringBuilder resultJson = new StringBuilder();
	    	String line;
	    	while ((line = readResult.readLine()) != null) {
	    		resultJson.append(line);
	    	}
	    	readResult.close();
	    	conn.disconnect();
	    	
	    	//============================================================================
	        //==결과(String)를 Json으로 저장===============================
	        //============================================================================
	        String json = resultJson.toString();
	    	JsonParser parser = new JsonParser();
	    	JsonElement element = parser.parse(json);
	    	JsonElement response = element.getAsJsonObject().get("response");
	    	
	    	JsonElement response_header = response.getAsJsonObject().get("header");
	    	JsonElement response_header_resultCode = response_header.getAsJsonObject().get("resultCode");
	    	JsonElement response_header_resultMsg = response_header.getAsJsonObject().get("resultMsg");
	    	
	    	// 결과 코드가 정상(0000) 이 아닌 경우 반환 없음
	    	if (!response_header_resultCode.getAsString().equals("0000")) {
				System.out.println("결과값이 정상이 아닙니다");
				System.out.println("response_header_resultMsg : " + response_header_resultMsg);
				return null;
			}
	    	
	    	
	    	JsonElement response_body = response.getAsJsonObject().get("body");
	    	JsonElement response_body_totalCount = response_body.getAsJsonObject().get("totalCount");
	    	
	    	if(!response_body_totalCount.toString().equals("0")){
	    		JsonElement response_body_items = response_body.getAsJsonObject().get("items");
	    		JsonElement response_body_items_item = response_body_items.getAsJsonObject().get("item");
	    		return response_body_items_item;
	    	}
	    	
	    	return null;
	    	
        } catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	
}


