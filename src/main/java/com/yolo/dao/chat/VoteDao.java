package com.yolo.dao.chat;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.VoteDaoInf;
import com.yolo.model.MemberVO;
import com.yolo.model.VoteSeniorVO;
import com.yolo.model.VoteVO;
import com.yolo.model.Vote_optionVO;
import com.yolo.model.VoterVO;
@Repository("voteDao")
public class VoteDao implements VoteDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertVote(VoteVO voteVO) {
		
		return sessionTemplate.insert("vote.insertVote", voteVO);
	}

	@Override
	public int insertVoteOption(List<Vote_optionVO> vote_optionList) {
		return sessionTemplate.insert("vote.insertVoteOption", vote_optionList);
	}

	@Override
	public int insertVoter(Map<String, Integer> voterMap) {
		return sessionTemplate.insert("vote.insertVoter", voterMap);
	}

	@Override
	public List<VoteSeniorVO> getVoteMain(VoteVO voteVO) {
		
		return sessionTemplate.selectList("vote.getVoteMain", voteVO);
	}

	@Override
	public List<VoteSeniorVO> getVoteDetail(int vote_seq) {
		return sessionTemplate.selectList("vote.getVoteDetail", vote_seq);
	}

	@Override
	public VoterVO getVoterDetail(VoterVO voterVO) {
		return sessionTemplate.selectOne("vote.getVoterDetail", voterVO);
	}

	@Override
	public int voterUpdate(VoterVO voterVO) {
		return sessionTemplate.update("vote.voterUpdate", voterVO);
	}

	@Override
	public int voteOptionUpdate(VoterVO voterVO) {
		return sessionTemplate.update("vote.voteOptionUpdate", voterVO);
	}

	@Override
	public int voteOptionReset(Map<String, Integer> option_seqMap) {
		return sessionTemplate.update("vote.voteOptionReset",option_seqMap);
	}

	@Override
	public List<VoteSeniorVO> getVoteMemberList(int option_seq) {
		return sessionTemplate.selectList("vote.getVoteMemberList", option_seq);
	}

	@Override
	public int voteEnd(int vote_seq) {
		return sessionTemplate.update("vote.voteEnd",vote_seq);
	}

	@Override
	public int voteDelete(int vote_seq_int) {
		return sessionTemplate.delete("vote.voteDelete", vote_seq_int);
	}

	@Override
	public String getMemberImg(int vote_seq_int) {
		return sessionTemplate.selectOne("vote.getMemberImg", vote_seq_int);
	}

	@Override
	public List<MemberVO> getMemberImgList(int option_seq_int) {
		return sessionTemplate.selectList("vote.getMemberImgList",option_seq_int);
	}

	@Override
	public Vote_optionVO getVoteOption(int option_seq_int) {
		return sessionTemplate.selectOne("vote.getVoteOption",option_seq_int);
	}
	
	
}
