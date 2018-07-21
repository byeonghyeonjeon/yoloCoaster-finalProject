package com.yolo.dao.basicInfo;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.basicInfo.inf.TagDaoInf;
import com.yolo.model.TagVO;
@Repository
public class TagDao implements TagDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertTag(TagVO tag) {
		return sessionTemplate.insert("board.insertTag",tag);
	}

	@Override
	public List<TagVO> selectTagList(int board_seq) {
		return sessionTemplate.selectList("board.selectTagList",board_seq);
	}

	@Override
	public int deleteTagList(int board_seq) {
		return sessionTemplate.delete("board.deleteTageList",board_seq);
	}
	
	
}
