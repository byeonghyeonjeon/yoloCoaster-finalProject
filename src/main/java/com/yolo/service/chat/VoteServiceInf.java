package com.yolo.service.chat;

import java.util.List;
import java.util.Map;

import com.yolo.model.MemberVO;
import com.yolo.model.VoteSeniorVO;
import com.yolo.model.VoteVO;
import com.yolo.model.Vote_optionVO;
import com.yolo.model.VoterVO;


public interface VoteServiceInf {
	
	public int insertVoteTotal(VoteVO voteVO, List<String> option_contentList);
	
	public List<VoteSeniorVO> getVoteMain(VoteVO voteVO);
	
	public List<VoteSeniorVO> getVoteDetail(int vote_seq);
	
	public VoterVO getVoterDetail(VoterVO voterVO);
	
	public int voteUpdate(VoterVO voterVO);
	
	public int voteOptionReset(Map<String, Integer> option_seqMap);

	/**
	* Method : getVoteMemberList
	* 최초작성일 : 2018. 7. 2.
	* 작성자 : PC15
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	public List<VoteSeniorVO> getVoteMemberList(int option_seq);

	/**
	* Method : voteEnd
	* 최초작성일 : 2018. 7. 2.
	* 작성자 : PC15
	* 변경이력 :
	* @param vote_seq
	* @return
	* Method 설명 :
	*/
	public int voteEnd(int vote_seq);

	/**
	* Method : voteDelete
	* 최초작성일 : 2018. 7. 2.
	* 작성자 : PC15
	* 변경이력 :
	* @param vote_seq_int
	* @return
	* Method 설명 :
	*/
	public int voteDelete(int vote_seq_int);

	/**
	* Method : getVoteMember
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @param vote_seq_int
	* @return
	* Method 설명 :
	*/
	public String getMemberImg(int vote_seq_int);

	/**
	* Method : getMemberImgList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @param option_seq_int
	* @return
	* Method 설명 :
	*/
	public List<MemberVO> getMemberImgList(int option_seq_int);

	/**
	* Method : getVoteOption
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC15
	* 변경이력 :
	* @param option_seq_int
	* @return
	* Method 설명 :
	*/
	public Vote_optionVO getVoteOption(int option_seq_int);
}
