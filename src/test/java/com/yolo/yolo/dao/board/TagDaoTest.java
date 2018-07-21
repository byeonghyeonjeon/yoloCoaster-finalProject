package com.yolo.yolo.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.basicInfo.inf.TagDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.TagVO;

public class TagDaoTest extends TestInit{

	@Resource
	TagDaoInf dao;
	
	@Test
	public void createTest() throws Exception {
		assertNotNull(dao);
	}

	@Test
	public void insertTagTest() throws Exception {
		int res = 1;
		TagVO tag = new TagVO();
		tag.setTag_content("테스트");
		tag.setMain_board_seq(0);
		tag.setContentid("0");
		int insertRes = dao.insertTag(tag);
		assertEquals(res, insertRes);
	}
	
	@Test
	public void selectTagList() throws Exception {
		int res = 2;
		List<TagVO> list = dao.selectTagList(158);
		assertEquals(res, list.size());
	}
	
	/**
	 * 
	 * Method : deleteTagList
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 :
	 */
	@Test
	public void deleteTagList() throws Exception {
		int res= dao.deleteTagList(182);
		
		assertEquals(1, res);
	}
}
