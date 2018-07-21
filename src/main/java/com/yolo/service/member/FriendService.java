package com.yolo.service.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.chat.inf.ChatDaoInf;
import com.yolo.dao.chat.inf.ChatGroupDaoInf;
import com.yolo.dao.chat.inf.ChatNameDaoInf;
import com.yolo.dao.member.inf.FriendDaoInf;
import com.yolo.model.ChatVO;
import com.yolo.model.Chat_groupVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;

@Service
public class FriendService implements FriendServiceInf{
	
	@Resource
	private FriendDaoInf friendDao;
	
	@Resource
	private ChatDaoInf chatDao;
	
	@Resource
	private ChatGroupDaoInf chatGroupDao;
	
	@Resource
	private ChatNameDaoInf chatNameDao;
	
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
		return friendDao.selectFriendList(memberVO);
	}
	
	
	@Override
	public List<FriendMemberVO> searchFriend(String mem_id, String searchMem_id) {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("mem_id", mem_id);
		parameterMap.put("searchMem_id", searchMem_id);
		return friendDao.searchFriend(parameterMap);
	}

	
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
	@Override
	public int deleteFriend(String mem_id, String friend_id) {
		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("friend_id", friend_id);
		result = friendDao.deleteFriend(map);
		
		return result;
	}


	/**
	 * Method : addFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * Method 설명 : 친구 요청을 수락시
	 */
	@Override
	public int addFriend(String mem_id, String friend_id) {
		int result = 0;

		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("mem_id", mem_id);
		map1.put("friend_id", friend_id);
		
		friendDao.deleteFriend(map1);
		
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("mem_id", friend_id);
		map2.put("friend_id", mem_id);
		
		list.add(map1);
		list.add(map2);
		
		result = friendDao.addFriend(list);
		
		return result;
	}

	
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
	@Override
	public int createFriend(String mem_id, String friend_id) {
		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("friend_id", friend_id);
		result = friendDao.createFriend(map);
		
		return result;
	}

	
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
	@Override
	public int cancelFriend(String mem_id, String friend_id) {
		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("friend_id", friend_id);
		result = friendDao.cancelFriend(map);
		
		return result;
	}

	
	/**
	 * Method : refuseFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 친구요청 거절시
	 */
	@Override
	public int refuseFriend(String mem_id, String friend_id) {
		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("friend_id", friend_id);
		result = friendDao.refuseFriend(map);
		
		return result;
	}

	
	/**
	 * Method : startChat
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return 채팅방번호 chat_seq
	 * Method 설명 : 채팅방 초대시
	 */
	@Override
	public int startChat(String mem_id, String friend_id) {
		List<String> idList = new ArrayList<String>();
		idList.add(mem_id);
		idList.add(friend_id);
		
		//1.새로운 채팅방 생성
		ChatVO chatVO = new ChatVO();
		chatVO.setChat_st("Y");
		int result = chatDao.insertChat(chatVO);
		//트랜잭션을 이용하여 잘못된 결과인 경우 rollback처리
		if (result != 1)
			new Exception("새로운 채팅방 생성 에러");
		
		
		int chat_seq = chatVO.getChat_seq();
		
		//2.각각의 새로운 채팅방 이름 생성
		List<Chat_nameVO> chatNameList = new ArrayList<Chat_nameVO>();
		String[] name = new String[idList.size()];
		idList.toArray(name);
		for (String id : idList) {
			Chat_nameVO chatNameVO = new Chat_nameVO();
			chatNameVO.setChat_seq(chat_seq);
			chatNameVO.setMem_id(id);
			chatNameVO.setName(Arrays.toString(name));
			chatNameList.add(chatNameVO);
		}
		result = chatNameDao.insertChat_name(chatNameList);
		//트랜잭션을 이용하여 잘못된 결과인 경우 rollback처리
		if (result != 2)
			new Exception("새로운 채팅방 이름 생성 에러");
		
		
		//3.각각의 새로운 채팅방 참여자 목록 생성
		List<Chat_groupVO> chatGroupList = new ArrayList<Chat_groupVO>();
		for (String id : idList) {
			Chat_groupVO chatGroupVO = new Chat_groupVO();
			chatGroupVO.setChat_seq(chat_seq);
			chatGroupVO.setMem_id(id);
			chatGroupVO.setMem_outtm(null);
			chatGroupList.add(chatGroupVO);
		}
		result = chatGroupDao.insertChat_group(chatGroupList);
		//트랜잭션을 이용하여 잘못된 결과인 경우 rollback처리
		if (result != 2)
			new Exception("새로운 채팅방 참여자 목록 생성 에러");
		
		return chat_seq;
	}


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
	@Override
	public int checkChattingRoom(String mem_id, String friend_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("friend_id", friend_id);
		return chatGroupDao.checkChattingRoom(map);
	}

}
