package com.yolo.dao.chat;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.BookIncomeDaoInf;
@Repository
public class BookIncomeDao implements BookIncomeDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
}
