package com.yolo.service.member;

import java.util.List;

import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;

public interface FriendServiceInf {
	
	/**
	 * Method : selectFriendList
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param memberVO 멤버아이디
	 * @return 친구목록
	 * Method 설명 : 친구 목록을 호출
	 */
	List<FriendMemberVO> selectFriendList(MemberVO memberVO);
	
	/**
	 * Method : searchFriend
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id 해당 유저 아이디
	 * @param searchMem_id 검색한 유저 아이디
	 * @return 멤버가 검색한 유저 목록을 반환
	 * Method 설명 : 사용자아이디와 검색할 id를 이용하여 유저목록을 반환
	 */
	List<FriendMemberVO> searchFriend(String mem_id, String searchMem_id);
	
	/**
	 * Method : deleteFriend
	 * 최초작성일 : 2018. 6. 24.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id 내아이디
	 * @param friend_id 친구아이디
	 * @return
	 * Method 설명 : 친구 테이블에서 삭제
	 */
	int deleteFriend(String mem_id, String friend_id);
	
	/**
	 * Method : addFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 친구 요청을 수락시
	 */
	int addFriend(String mem_id, String friend_id);
	
	/**
	 * Method : createFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 친구 요청시
	 */
	int createFriend(String mem_id, String friend_id);
	
	/**
	 * Method : cancelFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 친구 요청 취소시
	 */
	int cancelFriend(String mem_id, String friend_id);
	
	/**
	 * Method : refuseFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 친구 요청 거절시
	 */
	int refuseFriend(String mem_id, String friend_id);

	/**
	 * Method : startChat
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 채팅방 초대시
	 */
	int startChat(String mem_id, String friend_id);
	
	/**
	 * Method : checkChattingRoom
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return 채팅방번호 chat_seq
	 * Method 설명 : 채팅방 초대시 해당 채팅방이 있는지 체크
	 */
	int checkChattingRoom(String mem_id, String friend_id);
}
