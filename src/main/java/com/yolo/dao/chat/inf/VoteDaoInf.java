package com.yolo.dao.chat.inf;

import java.util.List;
import java.util.Map;

import com.yolo.model.MemberVO;
import com.yolo.model.VoteSeniorVO;
import com.yolo.model.VoteVO;
import com.yolo.model.Vote_optionVO;
import com.yolo.model.VoterVO;

public interface VoteDaoInf {
	
	/**
	 * 
	* Method : insertVote
	* 최초작성일 : 2018. 6. 26.
	* 작성자 : 전병현
	* 변경이력 :
	* @return
	* Method 설명 : vote insert
	 */
	public int insertVote(VoteVO voteVO);
	
	/**
	 * 
	* Method : insertVoteOption
	* 최초작성일 : 2018. 6. 26.
	* 작성자 : PC15
	* 변경이력 :
	* @param Vote_option
	* @return
	* Method 설명 :vote_option List insert
	 */
	public int insertVoteOption(List<Vote_optionVO> vote_optionList);
	
	/**
	 * 
	* Method : insertVoter
	* 최초작성일 : 2018. 6. 26.
	* 작성자 : PC15
	* 변경이력 :
	* @param voterList
	* @return
	* Method 설명 :voter List insert
	 */
	public int insertVoter(Map<String, Integer> voterMap);
	
	/**
	 * 
	* Method : voteSeniorVO
	* 최초작성일 : 2018. 6. 28.
	* 작성자 : PC15
	* 변경이력 :
	* @param voteVO
	* @return
	* Method 설명 : voteMain 페이지 조회 List
	 */
	public List<VoteSeniorVO> getVoteMain(VoteVO voteVO);
	
	/**
	 * 
	* Method : getVoteDetail
	* 최초작성일 : 2018. 6. 28.
	* 작성자 : PC15
	* 변경이력 :
	* @param vote_seq
	* @return
	* Method 설명 : voteDatil 정보 조회 
	 */
	public List<VoteSeniorVO> getVoteDetail(int vote_seq);
	
	/**
	 * 
	* Method : getVoter
	* 최초작성일 : 2018. 6. 29.
	* 작성자 : PC15
	* 변경이력 :
	* @param vote_seq
	* @return
	* Method 설명 :voteDetail 투표 참여자 조회
	 */
	public VoterVO getVoterDetail(VoterVO voterVO);
	
	/**
	 * 
	* Method : voterUpdate
	* 최초작성일 : 2018. 6. 29.
	* 작성자 : PC15
	* 변경이력 :
	* @param voterVO
	* @return
	* Method 설명 : voterVO 업데이트 요청
	 */
	public int voterUpdate(VoterVO voterVO);
	
	/**
	 * 
	* Method : voteOptionUpdate
	* 최초작성일 : 2018. 6. 29.
	* 작성자 : PC15
	* 변경이력 :
	* @param voterVO
	* @return
	* Method 설명 :voter_optionVO 업데이트 요청
	 */
	public int voteOptionUpdate(VoterVO voterVO);
	
	/**
	 * 
	* Method : voteOptionReset
	* 최초작성일 : 2018. 7. 2.
	* 작성자 : PC15
	* 변경이력 :
	* @param option_seq
	* @return
	* Method 설명 : vote_option_hit -1  요청
	 */
	public int voteOptionReset(Map<String, Integer> option_seqMap);

	/**
	* Method : getVoteMemberList
	* 최초작성일 : 2018. 7. 2.
	* 작성자 : PC15
	* 변경이력 :
	* @param option_seq
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
	* Method : getMemberImg
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
