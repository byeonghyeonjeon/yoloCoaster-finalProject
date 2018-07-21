package com.yolo.dao.member.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;

public interface FriendDaoInf {
	
	/**
	 * Method : selectFriendList
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param memberVO 멤버아이디
	 * @return
	 * Method 설명 : 멤버의 친구 목록을 반환
	 */
	List<FriendMemberVO> selectFriendList(MemberVO memberVO);
	
	/**
	 * Method : searchFriend
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap [mem_id, searchMem_id]
	 * @return 멤버가 검색한 유저 목록을 반환
	 * Method 설명 : 사용자아이디와 검색할 id를 이용하여 유저목록을 반환
	 */
	List<FriendMemberVO> searchFriend(Map<String, String> parameterMap);
	
	/**
	 * Method : deleteFriend
	 * 최초작성일 : 2018. 6. 24.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param Map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 테이블에서 삭제
	 */
	int deleteFriend(Map<String, String> list);
	
	/**
	 * Method : addFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 : foreach 사용
	 * @param map 회원아이디 및 친구아이디를 가진 맵을 가진 리스트
	 * Method 설명 : 친구 요청 수락시
	 */
	int addFriend(List<Map<String, String>> list);
	
	/**
	 * Method : createFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 요청시
	 */
	int createFriend(Map<String, String> map);
	
	/**
	 * Method : cancelFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 요청 취소시
	 */
	int cancelFriend(Map<String, String> map);
	
	/**
	 * Method : refuseFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 요청 거절시
	 */
	int refuseFriend(Map<String, String> map);
}
