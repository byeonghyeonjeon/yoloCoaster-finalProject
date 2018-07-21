package com.yolo.service.chat;

import java.util.List;
import java.util.Map;

import com.yolo.model.Chat_groupVO;
import com.yolo.model.FriendMemberVO;

public interface ChatGroupServiceInf {
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
	 * Method : selectChattingRoomMemberAndFriend
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return chattingRoomMemberList, chattingRoomFriendList
	 * Method 설명 : 채팅방내의 멤버 및 채팅방에 없는 친구 목록 반환
	 */
	Map<String, List<FriendMemberVO>> selectChattingRoomMemberAndFriend(Chat_groupVO chatGroupVO);
	
	/**
	 * Method : inviteChat
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param chatGroupVO
	 * @return
	 * Method 설명 : 친구를 해당 채팅방으로 초대
	 */
	int inviteChat(Chat_groupVO chatGroupVO);
}
