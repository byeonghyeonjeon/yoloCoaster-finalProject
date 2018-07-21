package com.yolo.yolo.dao.chat;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.chat.inf.VoteDaoInf;
import com.yolo.init.TestInit;

public class VoteDaoTest extends TestInit{

	@Resource(name = "voteDao")
	private VoteDaoInf voteDao;
	
	@Test
	public void voteDaoInjentionTest() {
		assertNotNull(voteDao);		
	}

}
