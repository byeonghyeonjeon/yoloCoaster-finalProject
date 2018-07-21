/**
 * 
 */
package com.yolo.model;

import java.util.List;

/**
 * @author PC15
 *
 */
public class VoteTotalVO {
	
	private VoteVO voteVO;
	private List<Vote_optionVO> vote_optionVO;
	private List<VoterVO> voterVO;
	
	public VoteTotalVO(){
		super();
	}
	
	
	public VoteTotalVO(VoteVO voteVO, List<Vote_optionVO> vote_optionVO,
			List<VoterVO> voterVO) {
		super();
		this.voteVO = voteVO;
		this.vote_optionVO = vote_optionVO;
		this.voterVO = voterVO;
	}


	public VoteVO getVoteVO() {
		return voteVO;
	}

	public void setVoteVO(VoteVO voteVO) {
		this.voteVO = voteVO;
	}

	public List<Vote_optionVO> getVote_optionVO() {
		return vote_optionVO;
	}

	public void setVote_optionVO(List<Vote_optionVO> vote_optionVO) {
		this.vote_optionVO = vote_optionVO;
	}

	public List<VoterVO> getVoterVO() {
		return voterVO;
	}

	public void setVoterVO(List<VoterVO> voterVO) {
		this.voterVO = voterVO;
	}	
	
	}
