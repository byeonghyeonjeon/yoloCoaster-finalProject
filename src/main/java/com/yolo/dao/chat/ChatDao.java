package com.yolo.dao.chat;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.ChatDaoInf;
import com.yolo.model.ChatVO;
@Repository
public class ChatDao implements ChatDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertChat(ChatVO chatVO) {
		return sessionTemplate.insert("chat.insertChat", chatVO);
	}
	
}
