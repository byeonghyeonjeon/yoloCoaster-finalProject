package com.yolo.service.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yolo.dao.chat.inf.VoteDaoInf;
import com.yolo.model.MemberVO;
import com.yolo.model.VoteSeniorVO;
import com.yolo.model.VoteTotalVO;
import com.yolo.model.VoteVO;
import com.yolo.model.Vote_optionVO;
import com.yolo.model.VoterVO;

@Service("voteService")
public class VoteService implements VoteServiceInf{
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "voteDao")
	private VoteDaoInf voteDao;
	
	/**
	 * voteCreate
	 */
	@Override
	public int insertVoteTotal(VoteVO voteVO, List<String> option_contentList) {
		logger.debug("{}","insertVoteTotal()");
		
		int chat_seq = voteVO.getChat_seq();
		//1.vote insert 요청
		int voteCnt =  voteDao.insertVote(voteVO);		
		int vote_seq = voteVO.getVote_seq();
		//2.vote_option insert
		//2.vote_option 설정 넣기
		List<Vote_optionVO> vote_optionList = new ArrayList<Vote_optionVO>();	
		for(int i =0; i <option_contentList.size(); i++){			
			Vote_optionVO vote_optionVO = new Vote_optionVO();
			vote_optionVO.setOption_content(option_contentList.get(i));
			vote_optionVO.setVote_seq(vote_seq);
			vote_optionVO.setOption_hit(0);			
			vote_optionVO.setOption_order(i+1);
			vote_optionList.add(vote_optionVO);			
		}		
		//2.vote_option insert 요청
		int vote_optionCnt = voteDao.insertVoteOption(vote_optionList);
		
		//3.voter insert	 
		Map<String, Integer> voterMap = new HashMap<String, Integer>();
		voterMap.put("chat_seq", chat_seq);
		voterMap.put("vote_seq", vote_seq);
		
		int voterCnt = voteDao.insertVoter(voterMap);
		
		return vote_optionCnt + voterCnt + voteCnt;
	}

	/**
	 * voteMain리스트 조회
	 */
	@Override
	public List<VoteSeniorVO> getVoteMain(VoteVO voteVO) {
				
		return voteDao.getVoteMain(voteVO);
	}

	@Override
	public List<VoteSeniorVO> getVoteDetail(int vote_seq) {
		
		return voteDao.getVoteDetail(vote_seq);
	}

	@Override
	public VoterVO getVoterDetail(VoterVO voterVO) {

		return voteDao.getVoterDetail(voterVO);
	}

	@Override
	public int voteUpdate(VoterVO voterVO) {
		
		int voterCnt = voteDao.voterUpdate(voterVO);
		
		int voterOptionCnt = voteDao.voteOptionUpdate(voterVO);
		
		return 0;
	}

	@Override
	public int voteOptionReset(Map<String, Integer> option_seqMap ) {
		return voteDao.voteOptionReset(option_seqMap);
	}

	@Override
	public List<VoteSeniorVO> getVoteMemberList(int option_seq) {
		return voteDao.getVoteMemberList(option_seq);
	}

	@Override
	public int voteEnd(int vote_seq) {
		return voteDao.voteEnd(vote_seq);
	}

	@Override
	public int voteDelete(int vote_seq_int) {
		return voteDao.voteDelete(vote_seq_int);
	}

	@Override
	public String getMemberImg(int vote_seq_int) {
		String memberImg = voteDao.getMemberImg(vote_seq_int);
		
		if(memberImg==null){
			memberImg = "/image/logo/noImage.png";
		}
		
		return memberImg;
	}

	
	@Override
	public List<MemberVO> getMemberImgList(int option_seq_int) {
		List<MemberVO> memberImgList= voteDao.getMemberImgList(option_seq_int);
		
		List<MemberVO> memberImgList_2 = new ArrayList<MemberVO>();
		for (MemberVO memberVO : memberImgList) {
			
			if(memberVO.getMem_profile()==null){
				memberVO.setMem_profile("/image/logo/noImage.png");				
				memberImgList_2.add(memberVO);
			}else{				
				memberImgList_2.add(memberVO);
			}
			
		}
		
		return memberImgList_2;
	}

	@Override
	public Vote_optionVO getVoteOption(int option_seq_int) {
		return voteDao.getVoteOption(option_seq_int);
	}

}
