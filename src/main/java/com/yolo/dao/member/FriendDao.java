package com.yolo.dao.member;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.member.inf.FriendDaoInf;
import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;
@Repository
public class FriendDao implements FriendDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Method : selectFriendList
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param memberVO 멤버아이디
	 * @return
	 * Method 설명 : 멤버의 친구 목록을 반환
	 */
	@Override
	public List<FriendMemberVO> selectFriendList(MemberVO memberVO) {
		return sessionTemplate.selectList("friend.selectFriendList", memberVO);
	}

	/**
	 * Method : searchFriend
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap [mem_id, searchMem_id]
	 * @return 멤버가 검색한 유저 목록을 반환
	 * Method 설명 : 사용자아이디와 검색할 id를 이용하여 유저목록을 반환
	 */
	@Override
	public List<FriendMemberVO> searchFriend(Map<String, String> parameterMap) {
		return sessionTemplate.selectList("friend.searchFriend", parameterMap);
	}

	/**
	 * Method : deleteFriend
	 * 최초작성일 : 2018. 6. 24.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 테이블에서 삭제
	 */
	@Override
	public int deleteFriend(Map<String, String> map) {
		return sessionTemplate.delete("friend.deleteFriend", map);
	}
	
	/**
	 * Method : addFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 : foreach 사용
	 * @param list 회원아이디 및 친구아이디를 가진 맵을 가진 리스트
	 * Method 설명 : 친구 요청 수락시
	 * @return 
	 */
	@Override
	public int addFriend(List<Map<String, String>> list) {
		return sessionTemplate.insert("friend.addFriend", list);
	}
	
	/**
	 * Method : createFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 요청시
	 */
	@Override
	public int createFriend(Map<String, String> map) {
		return sessionTemplate.insert("friend.createFriend", map);
	}
	
	/**
	 * Method : cancelFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map 회원아이디 및 친구아이디를 가진 맵
	 * @return
	 * Method 설명 : 친구 요청 취소시
	 */
	@Override
	public int cancelFriend(Map<String, String> map) {
		return sessionTemplate.delete("friend.cancelFriend", map);
	}

	/**
	 * Method : refuseFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 친구 요청 거절시
	 */
	@Override
	public int refuseFriend(Map<String, String> map) {
		return sessionTemplate.delete("friend.refuseFriend", map);
	}
	
}
