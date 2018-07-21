package com.yolo.yolo.service.chat;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.init.TestInit;
import com.yolo.service.chat.VoteServiceInf;

public class VoteServiceTest extends TestInit{

	@Resource(name = "voteService")
	private VoteServiceInf voteService;
	
	@Test
	public void voteServiceInjectionTest() {
		assertNotNull(voteService);
	}

}
