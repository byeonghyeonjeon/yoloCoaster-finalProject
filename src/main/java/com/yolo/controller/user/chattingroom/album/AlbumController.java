package com.yolo.controller.user.chattingroom.album;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yolo.model.Chat_nameVO;
import com.yolo.model.MessageVO;
import com.yolo.model.PageVO;
import com.yolo.service.chat.MessageServiceInf;

/**
 * @author PC15
 *
 */
@RequestMapping(value="/chatAlbum")
@Controller
public class AlbumController {
	
	@Resource
	private MessageServiceInf messageService;
	
	/**
	 * Method : chatAlbumMain
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param parameterMap
	 * @param model
	 * @param session
	 * @return
	 * Method 설명 : 채팅방내의 사진첩 호출
	 */
	@RequestMapping(value="/main")
	public String chatAlbumMain(@RequestBody Map<String, Integer> parameterMap, Model model, HttpSession session){
		int pageNum = 1;
		if (parameterMap.get("pageNum") != null)
			pageNum = parameterMap.get("pageNum");
		
		if (session.getAttribute("chatNameVO") == null)
			return "redirect:/main";
		
		Chat_nameVO chatNameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		
		Map<String, Object> resultMap = messageService.selectImgList(pageNum, chatNameVO);
		PageVO pageVO = (PageVO) resultMap.get("pageVO");
		List<MessageVO> messageVOList = (List<MessageVO>) resultMap.get("messageVOList");
		
		model.addAttribute("page", pageVO);
		model.addAttribute("messageVOList", messageVOList);
		
		return "content/user/chattingroom/chatAlbum/chatAlbumMain";
	}
}
