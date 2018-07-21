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

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yolo.dao.basicInfo.inf.BasicInfoDaoInf;
import com.yolo.model.PageVO;
import com.yolo.model.TravelVO;

@Service
public class BasicSearchService implements BasicSearchServiceInf {
	@Resource
	private BasicInfoDaoInf basicInfoDao;

	// 공공데이터포털에서 받은 인증키
	private static final String ServiceKey = "EtSF91PcyVZu75%2Fiy%2BCYg19wTdh2k0dPenZOTEQOmzLs7j5qm84mUVav2qJY5cM8dLMQWg2%2BSRXpCFD9DENPbw%3D%3D";
	private String numOfRows = "10";
	
	
	/**
	 * Method : searchByKeyword
	 * 최초작성일 : 2018. 6. 21.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param keyword 키워드값
	 * @param pageNo 현재 페이지 번호
	 * @return 여행지 목록(travelVOs) 및 총 개수(totalCount)
	 * Method 설명 : 카테고리 이름으로 키워드 검색
	 */
	@Override
	public Map<String, Object> searchByKeyword(String keyword, String pageNo, String areaCode, String contentTypeId) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<TravelVO> travelVOs = null;
		
		resultMap.put("travelVOs", travelVOs);
		
		keyword = keyword.trim();
		
		//============================================================================
		//==URL을 이용한 연결 및 결과를 String으로 저장===============================
		//============================================================================
		// 요청 파라미터 및 파라미터에 대한 값 설정
    	
    	// URL 만듬
    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
    	/*요청할 데이터*/
        try {
			urlBuilder.append(URLEncoder.encode("searchKeyword", "UTF-8"));
			
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*현재 페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /*지역코드(areaCode)*/
	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contentTypeId, "UTF-8")); /*관광타입ID(contentTypeId)*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
	        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")); /*정렬 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(keyword, "UTF-8")); /*요청 키워드*/
	    	urlBuilder.append("&" + "_type=json"); /*반환타입 json*/
        
	    	
	    	parseJsonToMap(urlBuilder.toString(), resultMap, travelVOs);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return resultMap;
	}

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
	@Override
	public Map<String, Object> searchByLocation(String pageNo, String areaCode, String contentTypeId) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<TravelVO> travelVOs = null;
		resultMap.put("travelVOs", travelVOs);
    	
    	// URL 만듬
    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
    	/*요청할 데이터*/
        try {
			urlBuilder.append(URLEncoder.encode("areaBasedList", "UTF-8"));
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*현재 페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /*지역코드(areaCode)*/
	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(contentTypeId, "UTF-8")); /*관광타입ID(contentTypeId)*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
	        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")); /*정렬 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분*/
	    	urlBuilder.append("&" + "_type=json"); /*반환타입 json*/
        
	    	parseJsonToMap(urlBuilder.toString(), resultMap, travelVOs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}


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
	@Override
	public Map<String, Object> searchByEvent(String eventStartDate, String eventEndDate, String pageNo, String areaCode) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<TravelVO> travelVOs = null;
		
		resultMap.put("travelVOs", travelVOs);
		
		//============================================================================
		//==URL을 이용한 연결 및 결과를 String으로 저장===============================
		//============================================================================
		// 요청 파라미터 및 파라미터에 대한 값 설정
    	
    	// URL 만듬
    	StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/
    	/*요청할 데이터*/
        try {
			urlBuilder.append(URLEncoder.encode("searchFestival", "UTF-8"));
			
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*현재 페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")); /*지역코드(areaCode)*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
	        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")); /*정렬 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("eventStartDate","UTF-8") + "=" + URLEncoder.encode(eventStartDate, "UTF-8")); /*목록 구분*/
	        urlBuilder.append("&" + URLEncoder.encode("eventEndDate","UTF-8") + "=" + URLEncoder.encode(eventEndDate, "UTF-8")); /*목록 구분*/
	    	urlBuilder.append("&" + "_type=json"); /*반환타입 json*/
		
	    	parseJsonToMap(urlBuilder.toString(), resultMap, travelVOs);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return resultMap;
	}

	
	/**
	 * Method : parseJsonToMap
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @param urlStr
	 * @param resultMap
	 * @param travelVOs
	 * @throws IOException
	 * Method 설명 : url을 이용하여 검색 후 결과값을 만든다
	 */
	private void parseJsonToMap(String urlStr, Map<String, Object> resultMap, List<TravelVO> travelVOs) throws IOException {
		// StringBuilder를 이용한 URL생성
    	URL url = new URL(urlStr);
    	
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
			return;
		}

    	JsonElement response_body = response.getAsJsonObject().get("body");
    	JsonElement response_body_numOfRows = response_body.getAsJsonObject().get("numOfRows");
    	JsonElement response_body_pageNo = response_body.getAsJsonObject().get("pageNo");
    	JsonElement response_body_totalCount = response_body.getAsJsonObject().get("totalCount");
    	
    	int totalCount = Integer.valueOf((response_body_totalCount.toString()));
    	int numOfRows = Integer.valueOf((response_body_numOfRows.toString()));
    	int pageNum = Integer.valueOf((response_body_pageNo.toString()));
    	resultMap.put("totalCount", totalCount);
    	
    	//결과가 없는 경우 null반환
    	if (totalCount == 0) {
			return;
		}
    	JsonElement response_body_items = response_body.getAsJsonObject().get("items");
    	JsonElement response_body_items_item = response_body_items.getAsJsonObject().get("item");
    	
    	travelVOs = new ArrayList<TravelVO>();
    	
    	if(response_body_items_item.isJsonArray() == true) {
    		JsonArray response_body_items_item_array = response_body_items_item.getAsJsonArray();
    		//총 개수가 한 행에 출력할 수보다 부족한 경우 총 개수만큼만 반복
    		for (int i = 0; i < response_body_items_item_array.size(); i++) {
    			
    			JsonObject result = response_body_items_item_array.get(i).getAsJsonObject();
    			
    			TravelVO travelVO = new TravelVO();
    			travelVO.setContentid(result.get("contentid").getAsString());
    			travelVO.setContenttypeid(result.get("contenttypeid").getAsString());
    			
    			
    			if (result.get("addr1") != null) {
    				travelVO.setAddr1(result.get("addr1").getAsString());
    			} else {
    				travelVO.setAddr1("없음");
    			}
    			if (result.get("firstimage") != null) {
    				travelVO.setFirstimage(result.get("firstimage").getAsString());
    			} else {
    				travelVO.setFirstimage("없음");
    			}
    			if (result.get("firstimage2") != null) {
    				travelVO.setFirstimage2(result.get("firstimage2").getAsString());
    			} else {
    				travelVO.setFirstimage2("없음");
    			}
    			if (result.get("title") != null) {
    				travelVO.setTitle(result.get("title").getAsString());
    			} else {
    				travelVO.setTitle("없음");
    			}
    			
    			//리스트에 추가
    			travelVOs.add(travelVO);
			}
    	} else {
			JsonObject result = response_body_items_item.getAsJsonObject();
			
			TravelVO travelVO = new TravelVO();
			travelVO.setContentid(result.get("contentid").getAsString());
			travelVO.setContenttypeid(result.get("contenttypeid").getAsString());
			
			
			if (result.get("addr1") != null) {
				travelVO.setAddr1(result.get("addr1").getAsString());
			} else {
				travelVO.setAddr1("없음");
			}
			if (result.get("firstimage") != null) {
				travelVO.setFirstimage(result.get("firstimage").getAsString());
			} else {
				travelVO.setFirstimage("없음");
			}
			if (result.get("firstimage2") != null) {
				travelVO.setFirstimage2(result.get("firstimage2").getAsString());
			} else {
				travelVO.setFirstimage2("없음");
			}
			if (result.get("title") != null) {
				travelVO.setTitle(result.get("title").getAsString());
			} else {
				travelVO.setTitle("없음");
			}
			
			//리스트에 추가
			travelVOs.add(travelVO);
		}
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
    	
    	resultMap.put("travelVOs", travelVOs);
	}

}
