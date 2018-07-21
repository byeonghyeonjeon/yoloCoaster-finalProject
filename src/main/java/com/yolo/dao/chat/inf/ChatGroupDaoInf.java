package com.yolo.dao.chat.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.Chat_groupVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.FriendMemberVO;

public interface ChatGroupDaoInf {

	/**
	 * Method : insertChat_group
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param list
	 * @return
	 * Method 설명 : 새로운 채팅방 참여자 목록 생성
	 */
	int insertChat_group(List<Chat_groupVO> list);
	
	/**
	 * Method : checkChattingRoom
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 유저아이디(mem_id), 친구아이디(friend_id)
	 * @return
	 * Method 설명 : 아이디를 통해 채팅방의 번호를 반환
	 */
	int checkChattingRoom(Map<String, String> map);

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
	int deleteChattingRoom(Map<String, String> map);
	
	/**
	 * Method : updateMem_outtm
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return
	 * Method 설명 : disconnect시 채팅방 나간시간 업데이트
	 */
	int updateMem_outtm(Chat_groupVO chatGroupVO);
	
	/**
	 * Method : selectChattingRoomMember
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return
	 * Method 설명 : 채팅방 멤버 목록 조회
	 */
	List<FriendMemberVO> selectChattingRoomMember(Chat_groupVO chatGroupVO);
	
	/**
	 * Method : selectFriendNotInChattingRoom
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return
	 * Method 설명 : 채팅방에 속하지 않은 친구 목록 조회
	 */
	List<FriendMemberVO> selectFriendNotInChattingRoom(Chat_groupVO chatGroupVO);
	
	/**
	 * Method : inviteChat_group
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return
	 * Method 설명 : 친구를 해당 채팅방으로 초대
	 */
	int inviteChat_group(Chat_groupVO chatGroupVO);
	
	/**
	 * Method : inviteChat_name
	 * 최초작성일 : 2018. 7. 2.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatNameVO
	 * @return
	 * Method 설명 : 해당 친구의 채팅방 이름 추가
	 */
	int inviteChat_name(Chat_nameVO chatNameVO);
}
