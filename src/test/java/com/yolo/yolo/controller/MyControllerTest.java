package com.yolo.yolo.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.yolo.controller.user.mypage.MypageController;
import com.yolo.init.TestInit;
import com.yolo.model.ScheduleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/yolo/spring/servlet-context.xml"
								,"classpath:com/yolo/spring/application-context.xml"
								, "classpath:com/yolo/spring/context-datasource.xml"
								, "classpath:com/yolo/spring/context-transaction.xml"
								})
@WebAppConfiguration
public class MyControllerTest {
	
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Autowired
	private MockHttpSession session;
	
	
	@Resource
	private MypageController mypageController;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void beanInjectionTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(mypageController);
	}
	
	
	@Test
	public void getTboardList() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/myPage/main"))
										.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***When***/
		
		/***Then***/
		assertNotNull(mypageController);
		assertEquals("myPage", mav.getViewName());
	}
	

	
	
}
