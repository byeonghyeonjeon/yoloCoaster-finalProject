package com.yolo.controller.user.mypage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yolo.model.FriendMemberVO;
import com.yolo.model.MemberVO;
import com.yolo.service.member.FriendServiceInf;


@RequestMapping("/friend")
@Controller
public class FriendController {
	
	@Resource
	private FriendServiceInf friendService;
	
	/**
	 * Method : selectFriendList
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param model
	 * @param memberVO 멤버아이디
	 * @return
	 * Method 설명 : 멤버아이디를 이용하여 해당 친구 목록 및 친구 요청 목록과 함게 친구 목록 페이지로 이동
	 */
	@RequestMapping("/selectFriendList")
	public String selectFriendList(Model model, MemberVO memberVO, HttpSession session) {
		List<FriendMemberVO> friendList = new ArrayList<FriendMemberVO>();//친구 목록
		List<FriendMemberVO> friendRequestList = new ArrayList<FriendMemberVO>();//친구 요청 목록
		List<FriendMemberVO> friendAllList = null;//모든 친구 목록
		if (session.getAttribute("memberVO") != null) {
			if (memberVO != null) {
				if(memberVO.getMem_id() != null) {
					String mem_id_session = ((MemberVO)session.getAttribute("memberVO")).getMem_id();
					if (memberVO.getMem_id().equals(mem_id_session)) {
						//해당 아이디와 관련된 모든 친구목록 받음
						friendAllList = friendService.selectFriendList(memberVO);
						
						for (FriendMemberVO friendMemberVO : friendAllList) {
							//친구인 경우
							if (friendMemberVO.getFriend_request().equals("Y")) {
								friendList.add(friendMemberVO);
								System.out.println(friendMemberVO.getMem_profile());
							} else {//친구 요청인 경우
								friendRequestList.add(friendMemberVO);
							}
						}
					}
				}
			}
			model.addAttribute("friendList", friendList);
			model.addAttribute("friendRequestList", friendRequestList);
			return "friendList";
		}
		
		return "redirect:/main";
	}
	
	
	/**
	 * Method : searchFriend
	 * 최초작성일 : 2018. 6. 23.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param jsonData [mem_id 멤버아이디, searchMem_id 검색할 아이디]
	 * @return ajax로 jsp 반환
	 * Method 설명 : 멤버 검색(이미 친구인 사람은 안뜸)
	 */
	@RequestMapping("/searchFriend")
	public String searchFriend(@RequestBody Map<String, String> parameterMap, Model model){
		List<FriendMemberVO> searchFriendList = null;
		if (parameterMap != null) {
			searchFriendList = friendService.searchFriend(parameterMap.get("mem_id"), parameterMap.get("searchMem_id"));
		}
		model.addAttribute("searchFriendList", searchFriendList);
		
		return "content/user/mypage/friendSearchList";
	}
	
	/**
	 * Method : deleteFriend
	 * 최초작성일 : 2018. 6. 24.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id 내아이디
	 * @param friend_id 친구아이디
	 * @return
	 * Method 설명 : 친구 테이블에서 삭제 후 리로딩 메서드 호출
	 */
	@RequestMapping("/deleteFriend")
	public String deleteFriend(String mem_id, String friend_id){
		friendService.deleteFriend(mem_id, friend_id);
		return "redirect:/friend/selectFriendList?mem_id="+mem_id;
	}
	
	
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
	@RequestMapping("/addFriend")
	public String addFriend(String mem_id, String friend_id){
		friendService.addFriend(mem_id, friend_id);
		return "redirect:/friend/selectFriendList?mem_id="+mem_id;
	}
	
	
	/**
	 * Method : createFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap
	 * @param model
	 * @return
	 * Method 설명 : 친구 요청시
	 */
	@RequestMapping("/createFriend")
	public String createFriend(@RequestBody Map<String, String> parameterMap, Model model){
		if (parameterMap != null) {
			int result = friendService.createFriend(parameterMap.get("mem_id"), parameterMap.get("friend_id"));
		
			if (result > 0) {
				List<FriendMemberVO> searchFriendList = null;
				searchFriendList = friendService.searchFriend(parameterMap.get("mem_id"), parameterMap.get("searchMem_id"));
				model.addAttribute("searchFriendList", searchFriendList);
			}
		}
		
		return "content/user/mypage/friendSearchList";
	}
	
	
	/**
	 * Method : cancelFriend
	 * 최초작성일 : 2018. 6. 25.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap
	 * @param model
	 * @return
	 * Method 설명 : 친구 요청 취소시
	 */
	@RequestMapping("/cancelFriend")
	public String cancelFriend(@RequestBody Map<String, String> parameterMap, Model model){
		if (parameterMap != null) {
			int result = friendService.cancelFriend(parameterMap.get("mem_id"), parameterMap.get("friend_id"));
			
			if (result > 0) {
				List<FriendMemberVO> searchFriendList = null;
				searchFriendList = friendService.searchFriend(parameterMap.get("mem_id"), parameterMap.get("searchMem_id"));
				model.addAttribute("searchFriendList", searchFriendList);
			}
		}
		
		return "content/user/mypage/friendSearchList";
	}
	
	
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
	@RequestMapping("/refuseFriend")
	public String refuseFriend(String mem_id, String friend_id, HttpSession session){
		friendService.refuseFriend(mem_id, friend_id);
		return "redirect:/friend/selectFriendList?mem_id="+mem_id;
	}

	
	/**
	 * Method : startChat
	 * 최초작성일 : 2018. 6. 26.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param mem_id
	 * @param friend_id
	 * @return
	 * Method 설명 : 채팅방으로 초대시
	 */
	@RequestMapping("/startChat")
	public String startChat(String mem_id, String friend_id){
		int chat_seq = 0;
		
		chat_seq = friendService.checkChattingRoom(mem_id, friend_id);
		
		if (chat_seq == 0) {
			chat_seq = friendService.startChat(mem_id, friend_id);
		}
		//채팅방이 정상적으로 생성된 경우
		//리턴은 해당 채팅방으로
		return "redirect:/chat/main?chat_seq=" + chat_seq + "&mem_id=" + mem_id;
	}
}
