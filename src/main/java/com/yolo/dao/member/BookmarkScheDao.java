package com.yolo.dao.member;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.BookmarkScheDaoInf;
@Repository
public class BookmarkScheDao implements BookmarkScheDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
}
