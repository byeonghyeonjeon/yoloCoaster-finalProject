package com.yolo.service.basicInfo;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yolo.model.NaverBlogVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * NaverSearchService.java
 *
 * @author Jun
 * @since 2018. 7. 1.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 1. Jun 최초 생성
 *
 * </pre>
 */
@Service
public class NaverSearchService implements NaverSearchServiceInf{
	/**
	 * Method : naverSearch
	 * 최초작성일 : 2018. 7. 1.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param searchName
	 * @return
	 * Method 설명 : 네이버 검색 API(관련 블로그 검색)
	 */
	@Override
	public List<NaverBlogVO> naverSearch(String searchName, int start) {
		String clientId = "tBELWPh_hKy9AINnRWHn";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "D_6zlmZhXk";//애플리케이션 클라이언트 시크릿값";
        String result = "";
        try {
        	String display = "10";
        	String sort = "sim";
        	
            StringBuilder sb = new StringBuilder();
            sb.append("https://openapi.naver.com/v1/search/blog");
            sb.append("?query=" + URLEncoder.encode(searchName, "UTF-8"));
            sb.append("&start=" + start);
            sb.append("&display=" + URLEncoder.encode(display, "UTF-8"));
            sb.append("&sort=" + URLEncoder.encode(sort, "UTF-8"));
            
            URL url = new URL(sb.toString());
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            result = response.toString();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    	JsonParser parser = new JsonParser();
    	JsonElement element = parser.parse(result);
    	JsonElement items = element.getAsJsonObject().get("items");
    	JsonArray itemsArray = items.getAsJsonArray();
    	
        Gson gson = new Gson();
        
        NaverBlogVO[] resultArray = gson.fromJson(itemsArray, NaverBlogVO[].class);
        List<NaverBlogVO> resultList = Arrays.asList(resultArray);
        
		return resultList;
	}
	
}
