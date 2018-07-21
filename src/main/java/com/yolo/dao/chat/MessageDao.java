package com.yolo.dao.chat;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.MessageDaoInf;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.MessageVO;
@Repository
public class MessageDao implements MessageDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int sendMessage(MessageVO messageVO) {
		return sessionTemplate.insert("message.sendMessage", messageVO);
	}

	@Override
	public List<MessageVO> selectNotReadMessage(Chat_nameVO chatNameVO) {
		return sessionTemplate.selectList("message.selectNotReadMessage", chatNameVO);
	}

	@Override
	public List<MessageVO> selectBeforeMessage(MessageVO messageVO) {
		return sessionTemplate.selectList("message.selectBeforeMessage", messageVO);
	}

	@Override
	public int selectImgCount(Chat_nameVO chatNameVO) {
		return sessionTemplate.selectOne("message.selectImgCount", chatNameVO);
	}

	@Override
	public List<MessageVO> selectImgPaging(Map<String, Integer> map) {
		return sessionTemplate.selectList("message.selectImgPaging", map);
	}
	
}
