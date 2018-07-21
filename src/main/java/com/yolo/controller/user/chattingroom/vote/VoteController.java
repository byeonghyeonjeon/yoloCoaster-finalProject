package com.yolo.controller.user.chattingroom.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.dao.chat.ChatNameDao;
import com.yolo.dao.chat.inf.VoteDaoInf;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.MemberVO;
import com.yolo.model.VoteSeniorVO;
import com.yolo.model.VoteTotalVO;
import com.yolo.model.VoteVO;
import com.yolo.model.Vote_optionVO;
import com.yolo.model.VoterVO;
import com.yolo.service.chat.VoteServiceInf;

@RequestMapping(value="/chatVote")
@Controller
public class VoteController {
	Logger logger = LoggerFactory.getLogger("VoteController");
	
	
	@Resource(name = "voteService")
	private VoteServiceInf voteService;
	
	//메인 화면
	@RequestMapping(value="/main")
	public String chatVoteMain(HttpSession session, Model model){
		logger.debug("{}","chatVoteMain()");
		
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq(); 
		//mem_id 가져오기
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String mem_id = memberVO.getMem_id();
		
		//voteVO에 설정 넣기
		VoteVO voteVO = new VoteVO();
		voteVO.setChat_seq(chat_seq);
		voteVO.setMem_id(mem_id);
		
		//voteMain 리스트 요청
		List<VoteSeniorVO> voteSeniorVOList =  voteService.getVoteMain(voteVO);
		//voteMain으로 출력
		model.addAttribute(voteSeniorVOList);
		
		return "content/user/chattingroom/chatVote/chatVoteMain";
	}
	//메인화면에서 생성화면
	@RequestMapping(value="/main/create")
	public String chatVoteMainCreate(){
		
		return "content/user/chattingroom/chatVote/chatVoteCreate";
	}
	
	//vote 생성하기 
	@RequestMapping(value="/voteCreating", produces={"application/json"})
	@ResponseBody
	public Map<String, Integer> chatvoteCreateing(@RequestBody Map<String, Object> voteMap, HttpSession session, Model model){
		logger.debug("{}","chatvoteCreateing");
		
		//map에서 받아오기
		String chat_seq = (String)voteMap.get("chat_seq");
		String vote_title = (String) voteMap.get("vote_title");
		String vote_blind = (String) voteMap.get("vote_blind");
		String vote_end = (String) voteMap.get("vote_end");
		List<String> option_contentList = (List<String>)voteMap.get("option_contentList");
				
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String mem_id = memberVO.getMem_id();
		
		//voteVO에 설정 넣기		
		int chat_seq_int =Integer.parseInt(chat_seq);
		
		VoteVO voteVO = new VoteVO();
		voteVO.setChat_seq(chat_seq_int);
		voteVO.setMem_id(mem_id);
		voteVO.setVote_blind(vote_blind);
		voteVO.setVote_title(vote_title);
		voteVO.setVote_end(vote_end);
		voteVO.setVote_st("Y");
		
		//insert voteService 요청
		int insertCnt = voteService.insertVoteTotal(voteVO, option_contentList);
		
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("insertCnt", insertCnt);
		
		return resultMap;
		//return "redirect:/chatVote/main";
	}
	
	/*@ResponseBody*/
	@RequestMapping(value="/main/detail", produces={"application/json"})	
	public String chatVoteMainDetail(@RequestBody Map<String, Object> voteMap, Model model, HttpSession session) {
		//main에서 Detail일결우 vote_seq OR Detail에서 업데이트 할경우 조건
		String vote_seq =(String) voteMap.get("vote_seq");
		
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");		
		String user_id = memberVO.getMem_id();		//로그인한 회원의 아이디
		int vote_seq_int = Integer.parseInt(vote_seq);
		
		//vote_seq로 vote, voter, vote_option 가져오기	
		//voteSeniorVO List 요청
		List<VoteSeniorVO> voteSeniorVOList = voteService.getVoteDetail(vote_seq_int);
		
		//투표 작성자 이미지 가져오기
		String memberImg= voteService.getMemberImg(vote_seq_int);
		
		//voterVO 정보 설정
		VoterVO voterVO = new VoterVO();	
		voterVO.setMem_id(user_id);
		voterVO.setVote_seq(vote_seq_int);

		
		//voteSeniorVOList >> voteVO 정보 가져오기
		VoteSeniorVO voteSenior_VoteVO  = voteSeniorVOList.get(0);
		VoteVO voteVO = new VoteVO();
		voteVO.setVote_blind(voteSenior_VoteVO.getVote_blind());
		voteVO.setVote_end(voteSenior_VoteVO.getVote_end());
		voteVO.setVote_seq(voteSenior_VoteVO.getVote_seq());
		voteVO.setVote_st(voteSenior_VoteVO.getVote_st());
		voteVO.setVote_title(voteSenior_VoteVO.getVote_title());
		voteVO.setMem_id(voteSenior_VoteVO.getMem_id());
		
		//voteSeniorVOList >> vote_optionVO 리스트 정보 가져오기
		List<Vote_optionVO> vote_optionVOList = new ArrayList<Vote_optionVO>();
		for (VoteSeniorVO voteSeniorVO : voteSeniorVOList) {			
			Vote_optionVO vote_optionVO = new Vote_optionVO();
			vote_optionVO.setOption_content(voteSeniorVO.getOption_content());
			vote_optionVO.setOption_order(voteSeniorVO.getOption_order());
			vote_optionVO.setOption_seq(voteSeniorVO.getOption_seq());
			vote_optionVO.setOption_hit(voteSeniorVO.getOption_hit());		
			
			vote_optionVOList.add(vote_optionVO);
		}
		
		//voter 요청
		VoterVO voteUserVO = voteService.getVoterDetail(voterVO);
		
		//작성자 프로필 사진 요청
		/* 대기 */		
		
		model.addAttribute("voteUserVO",voteUserVO );
		model.addAttribute("vote_seq", vote_seq_int);              
		model.addAttribute("voteVO", voteVO);                     
		model.addAttribute("vote_optionVOList", vote_optionVOList);		
		model.addAttribute("memberImg", memberImg);                     
		
		return "content/user/chattingroom/chatVote/chatVoteDetail";
	}	
	
	
	
	
 	//투표하기, 다시 투표하기 update
	@RequestMapping(value="/detail/votting")
	public String chatVoteMainDetailVotting(@RequestBody Map<String, Object> voteMap, HttpSession session, Model model){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String user_id = memberVO.getMem_id();		//로그인한 회원의 아이디
		
		String option_seq = (String)voteMap.get("option_seq");
		String vote_seq = (String) voteMap.get("vote_seq");
		int vote_seq_int = Integer.parseInt(vote_seq);
		int option_seq_int = Integer.parseInt(option_seq);
		//투표여부 
		String voter_st = (String)voteMap.get("voter_st");	
		
		//다시 투표할경우 기존 Option_hit 크기 -1
		if(voter_st.equals("Y")){
			
			//service만들기
			String userOption_seq = (String)voteMap.get("userOption_seq");
			int userOption_seq_int = Integer.parseInt(userOption_seq);
			
			//update Service
			Map<String, Integer> option_seqMap = new HashMap<String, Integer>();
			option_seqMap.put("option_seq", userOption_seq_int);
			int voteOptionResetCnt = voteService.voteOptionReset(option_seqMap);			
		}
		
		//voter 정보 입력
		VoterVO voterVO = new VoterVO();
		voterVO.setMem_id(user_id);
		voterVO.setVote_seq(vote_seq_int);
		voterVO.setOption_seq(option_seq_int);
		
		//voteService 데이터 업데이트 
		int voteUpdateCnt = voteService.voteUpdate(voterVO);
		
		return chatVoteMainDetail(voteMap,  model,  session);
	}
	

	//상세화면에서 멤버리스트 화면
	@RequestMapping(value="/detail/memberList")
	public String chatVoteDetailMemberList(@RequestBody Map<String, Object> voteMap, HttpSession session, Model model){
		String option_seq = (String)voteMap.get("option_seq");
		int option_seq_int = Integer.parseInt(option_seq);
		
		//vote_option정보 가져오기
		Vote_optionVO vote_optionVO = voteService.getVoteOption(option_seq_int);		
		model.addAttribute("vote_optionVO", vote_optionVO);
		
		//투표자 이미지 요청
		List<MemberVO> memberImgList = voteService.getMemberImgList(option_seq_int);		
		if(memberImgList.size() !=0 ){		
			
			//memberList.jsp에 출력		
			model.addAttribute("memberImgList", memberImgList); // 투표자 이미지 속성
		}
	
		
		return "content/user/chattingroom/chatVote/chatVoteMemberList";
	}	
	
	
	//투표 마감하기
	@RequestMapping(value="/detail/endVote")
	public String chatVoteMainDetailEndVote(@RequestBody Map<String, Object> voteMap, HttpSession session, Model model){
		String vote_seq = (String) voteMap.get("vote_seq");
		int vote_seq_int = Integer.parseInt(vote_seq);
		
		int voteEndCnt = voteService.voteEnd(vote_seq_int);
		
		return chatVoteMainDetail(voteMap, model, session);
	}
	
	//투표 삭제하기
	@RequestMapping(value="/detail/delete")
	public String chatVoteMainDetailDelete(@RequestBody Map<String, Object> voteMap, HttpSession session, Model model){
		String vote_seq = (String) voteMap.get("vote_seq");
		int vote_seq_int = Integer.parseInt(vote_seq);
		
		int voteDelete = voteService.voteDelete(vote_seq_int); 
		
		return chatVoteMain(session,  model);
	}
	
	
	
}
