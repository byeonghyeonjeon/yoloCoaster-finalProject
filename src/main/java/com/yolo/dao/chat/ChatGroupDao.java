package com.yolo.dao.chat;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.ChatGroupDaoInf;
import com.yolo.model.ChatGroupCountVO;
import com.yolo.model.Chat_groupVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.FriendMemberVO;
@Repository
public class ChatGroupDao implements ChatGroupDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Method : insertChat_group
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param list
	 * @return
	 * Method 설명 : 채팅방 처음 생성시 참여자 목록에 입력
	 */
	@Override
	public int insertChat_group(List<Chat_groupVO> list) {
		return sessionTemplate.insert("chatGroup.insertChat_group", list);
	}

	/**
	 * Method : checkChattingRoom
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 유저아이디(mem_id), 친구아이디(friend_id)
	 * @return
	 * Method 설명 : 아이디를 통해 채팅방의 번호를 반환
	 */
	@Override
	public int checkChattingRoom(Map<String, String> map) {
		List<ChatGroupCountVO> resultList = sessionTemplate.selectList("chatGroup.checkChattingRoom", map);
		if (resultList == null) {
			return 0;
		}
		
		for (ChatGroupCountVO result : resultList) {
			if (result.getChat_count() == 2) {
				return result.getChat_seq();
			}
		}
		
		return 0;
	}
	
	/**
	 * Method : deleteChattingRoom
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param chat_seq
	 * @return
	 * Method 설명 : 채팅방 나가기 (참여자목록에서 삭제)
	 */
	@Override
	public int deleteChattingRoom(Map<String, String> map) {
		return sessionTemplate.delete("chatGroup.deleteChattingRoom", map);
	}
	
	
	/**
	 * Method : updateMem_outtm
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return
	 * Method 설명 : disconnect시 채팅방 나간시간 업데이트
	 */
	@Override
	public int updateMem_outtm(Chat_groupVO chatGroupVO) {
		return sessionTemplate.update("chatGroup.updateMem_outtm", chatGroupVO);
	}

	@Override
	public List<FriendMemberVO> selectChattingRoomMember(Chat_groupVO chatGroupVO) {
		return sessionTemplate.selectList("chatGroup.selectChattingRoomMember", chatGroupVO);
	}

	@Override
	public List<FriendMemberVO> selectFriendNotInChattingRoom(Chat_groupVO chatGroupVO) {
		return sessionTemplate.selectList("chatGroup.selectFriendNotInChattingRoom", chatGroupVO);
	}

	@Override
	public int inviteChat_group(Chat_groupVO chatGroupVO) {
		return sessionTemplate.insert("chatGroup.inviteChat_group", chatGroupVO);
	}

	@Override
	public int inviteChat_name(Chat_nameVO chatNameVO) {
		return sessionTemplate.insert("chatGroup.inviteChat_name", chatNameVO);
	}
	
	
	
}
