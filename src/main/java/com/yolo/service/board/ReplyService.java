package com.yolo.service.board;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yolo.dao.board.inf.ReplyDaoInf;
import com.yolo.model.MemberVO;
import com.yolo.model.ReplyVO;

@Service
public class ReplyService implements ReplyServiceInf{

	@Resource
	ReplyDaoInf replyDao;
	

	@Override
	public int insertReply(ReplyVO reply, HttpSession session) {
		String mem_id = session.getAttribute("mem_id")+"";
		reply.setReply_member_id(mem_id);
		if(session.getAttribute("memberVO")!=null){
			MemberVO memVO = (MemberVO) session.getAttribute("memberVO");
			reply.setReply_img(memVO.getMem_profile());
		}
		return replyDao.insertReply(reply);
	}


	@Override
	public List<ReplyVO> selectReplyList(int link_int) {
		return replyDao.selectReplyList(link_int);
	}


	@Override
	public int updateReply(ReplyVO reply) {
		return replyDao.updateReply(reply);
	}


	@Override
	public int deleteReply(int reply_seq) {
		return replyDao.deleteReply(reply_seq);
	}

}
