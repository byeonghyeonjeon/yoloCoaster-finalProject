package com.yolo.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.board.inf.BoardDaoInf;
import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.PageVO;
import com.yolo.model.ScheduleVO;
@Repository
public class BoardDao implements BoardDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int selectBoardCnt(int pboard) {
		logger.debug("{},{}","selectBoardCnt_pboard",pboard);
		int res = sessionTemplate.selectOne("board.selectBoardCnt",pboard);
		logger.debug("{},{}","selectBoardCnt_res",res);
		return res;
	}
	
	@Override
	public List<BoardVO> getboardList(PageVO page){
		return sessionTemplate.selectList("board.getboardList",page);
	}

	@Override
	public int insertBoard(BoardVO board) {
		return sessionTemplate.insert("board.insertBoard",board);
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		return sessionTemplate.selectOne("board.selectBoard",boardNo);
	}

	@Override
	public int selectBoardCnt(String mem_id) {
		return sessionTemplate.selectOne("board.selectBoardCntStr",mem_id);
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkAreaPageList(
			Map<String, String> pageMap) {
		return sessionTemplate.selectList("board.getBookmarkAreaPageList",pageMap);
	}

	@Override
	public int updateHit(int link) {
		BoardVO paramBoard = new BoardVO();
		paramBoard.setBoard_seq(link);
		return sessionTemplate.update("board.updateHit",paramBoard);
	}

	@Override
	public int getBookmarkAreaByMem_idAndContentid(Bookmark_areaVO bookmark_areaVO) {
		return sessionTemplate.selectOne("board.getBookmarkAreaByMem_idAndContentid", bookmark_areaVO);
	}

	@Override
	public int insertBookmarkArea(Bookmark_areaVO bookmark_areaVO) {
		return sessionTemplate.insert("board.insertBookmarkArea", bookmark_areaVO);
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkAreaRightBar(
			Map<String, String> pageMap) {
		return sessionTemplate.selectList("board.getBookmarkAreaRightBar", pageMap);
	}

	@Override
	public int deleteBoard(String link) {
		return sessionTemplate.update("board.deleteBoard",link);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return sessionTemplate.update("board.updateBoard",boardVO);
	}

	@Override
	public int selectBoardCnt(int i, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pboard", i+"");
		map.put("keyword", "%"+keyword+"%");
		return sessionTemplate.selectOne("board.selectBoardCntKeyword",map);
	}

	@Override
	public List<BoardVO> getboardList(PageVO page, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pboard_seq", page.getPboard_seq()+"");
		map.put("pageNo", page.getPageNo()+"");
		map.put("keyword", "%"+keyword+"%");
		return sessionTemplate.selectList("board.getboardListKeyword",map);
	}

	@Override
	public int adminSelectBoardCnt(int param) {
		return sessionTemplate.selectOne("board.adminSelectBoardCnt",param);
	}

	@Override
	public List<BoardVO> adminSelectListboard(PageVO page) {
		return sessionTemplate.selectList("board.adminSelectListboard",page);
	}

	@Override
	public int todayRegBoard(Map<String, String> paramMap) {
		return sessionTemplate.selectOne("board.todayRegBoard",paramMap);
	}

	@Override
	public int adminBoardWait(Map<String, String> paramMap) {
		return sessionTemplate.selectOne("board.adminBoardWait",paramMap);
	}

	@Override
	public int adminSelectBoardCnt(Map<String, String> paramMap) {
		return sessionTemplate.selectOne("adminBoard.adminBoardPageCnt",paramMap);
	}

	@Override
	public List<BoardVO> adminSelectListboard(Map<String, String> paramMap) {
		return sessionTemplate.selectList("adminBoard.adminSelectListboard",paramMap);
	}

	@Override
	public int deleteDataBoard(int param) {
		return sessionTemplate.delete("adminBoard.deleteBoardData",param);
	}

	@Override
	public int boardStReset(Map<String, String> paramMap) {
		return sessionTemplate.update("adminBoard.boardStReset",paramMap);
	}

	@Override
	public int adminBoardStCnt(Map<String, String> paramMap) {
		return sessionTemplate.selectOne("adminBoard.adminBoardStCnt",paramMap);
	}

	
	
	
}
