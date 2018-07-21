package com.yolo.service.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.board.inf.BoardDaoInf;
import com.yolo.model.BoardVO;
import com.yolo.service.board.BoardServiceInf;

@Service
public class AdminBoardService implements AdminBoardServiceInf{

	@Resource
	BoardDaoInf boardDao;
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		BoardVO inputBoardVO = boardDao.selectBoard(boardVO.getBoard_seq());
		inputBoardVO.setBoard_reply(boardVO.getBoard_reply());
		return boardDao.updateBoard(inputBoardVO);
	}

	@Override
	public int adminSelectBoardCnt(Map<String, String> paramMap) {
		String toLike = paramMap.get("keyword");
		String keyword = "%"+toLike+"%";
		paramMap.put("keyword", keyword);
		return boardDao.adminSelectBoardCnt(paramMap);
	}

	@Override
	public List<BoardVO> adminSelectListboard(Map<String, String> paramMap) {
		
		String toLike = paramMap.get("keyword");
		String keyword = "%"+toLike+"%";
		paramMap.put("keyword", keyword);
		return boardDao.adminSelectListboard(paramMap);
	}

	@Override
	public int deleteDataBoard(String link) {
		int param = Integer.parseInt(link);
		return boardDao.deleteDataBoard(param);
	}

	@Override
	public int boardStReset(Map<String, String> paramMap) {
		return boardDao.boardStReset(paramMap);
	}

	@Override
	public int adminBoardStCnt(Map<String, String> paramMap) {
		return boardDao.adminBoardStCnt(paramMap);
	}

}
