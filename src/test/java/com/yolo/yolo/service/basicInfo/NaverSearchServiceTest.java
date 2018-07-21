package com.yolo.yolo.service.basicInfo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yolo.init.TestInit;
import com.yolo.model.NaverBlogVO;
import com.yolo.service.basicInfo.NaverSearchServiceInf;
/**
 * NaverSearchServiceTest.java
 *
 * @author Jun
 * @since 2018. 7. 2.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 2. Jun 최초 생성
 *
 * </pre>
 */
public class NaverSearchServiceTest extends TestInit {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	NaverSearchServiceInf service;

	@Test
	public void createServiceTest() {
		assertNotNull(service);
	}
	
	/**
	 * Method : naverSearchTest
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : Jun
	 * 변경이력 :
	 * Method 설명 : 네이버 블로그 검색 서비스 테스트
	 */
	@Test
	public void naverSearchTest() {
		String searchName = "한옥마을";
		int start = 1;
		List<NaverBlogVO> result = service.naverSearch(searchName, start);
		assertNotNull(result);
		logger.debug("{}", result);
		logger.debug("{}", result.get(0).getLink());
	}
	
	/**
	 * Method : regExTest
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : Jun
	 * 변경이력 :
	 * Method 설명 : NaverSearchVO 정규식 테스트
	 */
	@Test
	public void regExTest() {
		String regex = "http://blog.naver.com/([a-zA-Z0-9]*)\\?Redirect=Log&amp;logNo=([0-9]*)";
		String link = "http://blog.naver.com/mecinzer7?Redirect=Log&amp;logNo=221309844423";
		String expected = "https://blog.naver.com/mecinzer7/221309844423";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(link);
		assertTrue(m.matches());
		assertEquals(expected, link.replaceAll(regex, "https://blog.naver.com/$1/$2"));
		logger.debug("{}", link.replaceAll(regex, "https://blog.naver.com/$1/$2"));
	}
	
	/**
	 * Method : gsonTest
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : Jun
	 * 변경이력 :
	 * Method 설명 : gson 테스트
	 */
	@Test
	public void gsonTest() {
		String result = "{\"display\": 10,\"items\": [{\"title\": \"전주 <b>한옥마을</b> 교동고로케 맛은?\",\"link\": \"http://blog.naver.com/mecinzer7?Redirect=Log&amp;logNo=221309844423\"},{\"title\": \" AAA\",\"description\": \"설명문~!\"}]}";
		
		JsonParser parser = new JsonParser();
    	JsonElement element = parser.parse(result);
    	JsonElement items = element.getAsJsonObject().get("items");
    	JsonArray itemsArray = items.getAsJsonArray();
    	
        Gson gson = new Gson();
        
        NaverBlogVO[] resultArray = gson.fromJson(itemsArray, NaverBlogVO[].class);
        List<NaverBlogVO> resultList = Arrays.asList(resultArray);
        
		logger.debug("{}", resultList.size());
		logger.debug("{}", resultList.get(0).getTitle());
		logger.debug("{}", resultList.get(0).getLink());
		logger.debug("{}", resultList.get(0).getDescription());
		
		
	}
}
