/**
 * 
 */
package com.yolo.yolo.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.yolo.init.TestInit;
import com.yolo.model.VoteTotalVO;
import com.yolo.model.VoteVO;
import com.yolo.model.Vote_optionVO;

/**
 * @author PC15
 *
 */
@WebAppConfiguration
@ContextConfiguration(locations={
		"classpath:com/yolo/spring/servlet-context.xml"
		})
public class VoteControllerTest extends TestInit {
	

	@Resource
	private WebApplicationContext wax;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wax).build();
	}
	
	
	@Test
	public void voteCreatingTest() throws Exception {
		/***Given***/		
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("mem_id", "test");
		session.setAttribute("chat_seq", 1);
		
		MvcResult result = mockMvc.perform(post("/chatVote/voteCreating").session(session)
																		 .param("option_content", "1", "2", "3")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		List<String> vote_optionVO = (List<String>) mav.getModel().get("option_contentList");
		/***Then***/	
	
		assertNotNull(vote_optionVO);
		assertEquals(3, vote_optionVO.size());
		assertEquals("2", vote_optionVO.get(1));
		
		/*assertNotNull(vote_optionList);
		assertEquals(3, vote_optionList.size());*/
	}
	
	@Test
	public void voteCreatingVOTest() throws Exception {
		/***Given***/		
		MockHttpSession session = new MockHttpSession();
		
		MvcResult result = mockMvc.perform(post("/chatVote/voteCreating").param("vote_title", "투표제목 테스트")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		VoteVO voteVO= (VoteVO) mav.getModel().get("voteVO");
	
		/***Then***/	
	
		assertNotNull(voteVO);
	
		
	}
	@Test
	public void voteCreatingcheckBoxTest() throws Exception {
		/***Given***/		
		MockHttpSession session = new MockHttpSession();		
		VoteVO voteVO = new VoteVO();
		voteVO.setVote_title("투표제목 테스트");		
		MvcResult result = mockMvc.perform(post("/chatVote/voteCreating").param("vote_blind", "String")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		voteVO= (VoteVO) mav.getModel().get("voteVO");
		
		
		/***Then***/	
		assertNotNull(voteVO);
		
	
		
	}

}
