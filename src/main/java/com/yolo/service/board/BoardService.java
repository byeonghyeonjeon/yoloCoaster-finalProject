package com.yolo.service.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.yolo.dao.admin.inf.FileAddDaoInf;
import com.yolo.dao.basicInfo.inf.TagDaoInf;
import com.yolo.dao.board.inf.BoardDaoInf;
import com.yolo.dao.schedule.inf.ScheduleDaoInf;
import com.yolo.model.BoardVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.File_addVO;
import com.yolo.model.PageVO;
import com.yolo.model.PboardVO;
import com.yolo.model.ScheduleVO;
import com.yolo.model.TagVO;

@Service
public class BoardService implements BoardServiceInf {

	@Resource
	BoardDaoInf boardDao;
	
	@Resource
	ScheduleDaoInf ScheDao;
	
	@Resource
	TagDaoInf tagDao;
	
	@Resource
	FileAddDaoInf fileService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public int selectBoardCnt(int pboard){
		return boardDao.selectBoardCnt(pboard);
	}
	
	@Override
	public List<BoardVO> getboardList(PageVO page){
		List<BoardVO> res = boardDao.getboardList(page);
	
		return res; 
	}

	@Override
	public int insertBoard(BoardVO board) {
		return boardDao.insertBoard(board);
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		return boardDao.selectBoard(boardNo);
	}

	@Override
	public List<ScheduleVO> selectScheListForBoard() {
		return ScheDao.selectScheListForBoard();
	}
	
	@Override
	public List<ScheduleVO> getSchePageList(PageVO page){
		return ScheDao.getSchePageList(page);
	}

	@Override
	public int selectBoardCnt(String pageMap) {
		return boardDao.selectBoardCnt(pageMap);
	}

	@Override
	public List<Bookmark_areaVO> getBookmarkAreaPageList(
			Map<String, String> pageMap) {
		return boardDao.getBookmarkAreaPageList(pageMap);
	}

	@Override
	public BoardVO updateHit(int link) {
		boardDao.updateHit(link);
		return boardDao.selectBoard(link);
		
	}

	@Override
	public int insertTag(TagVO tagVO,int board_seq) {
		
		log.debug("{/travelInsert/tagVO},{}","",tagVO);
		String[] tagList = tagVO.getTag_content().split(",");
		List<TagVO> resList = new ArrayList<TagVO>();
		if(tagList.length>0){
			for (String tagContent : tagList) {
				TagVO newTagVO = new TagVO();
				newTagVO.setTag_content(tagContent);
				log.debug("{},{}","setTag_content(tagContent)",tagContent);
				newTagVO.setMain_board_seq(board_seq);
				log.debug("{},{}","boardVO.getBoard_seq()",board_seq);
				resList.add(newTagVO);
			}
			
		}
		int res = 0;
		for (TagVO tagUnit : resList) {
			res+=tagDao.insertTag(tagUnit);
		}
		return res;
	}

	@Override
	public List<TagVO> selectTagList(int board_seq) {
		return tagDao.selectTagList(board_seq);
	}

	@Override
	public List<File_addVO> selectImageList(int link_int) {
		return fileService.selectFileList(link_int);
	}

	@Override
	public int deleteBoard(String link) {
		return boardDao.deleteBoard(link);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDao.updateBoard(boardVO);
	}

	@Override
	public int deleteTagList(int board_seq) {
		return tagDao.deleteTagList(board_seq);
	}

	@Override
	public int selectBoardCnt(int i, String keyword) {
		return boardDao.selectBoardCnt(i,keyword);
	}

	@Override
	public List<BoardVO> getboardList(PageVO page, String keyword) {
		return boardDao.getboardList(page,keyword);
	}

	@Override
	public int selectScheListForBoard(String pram) {
		return ScheDao.selectScheListForBoard(pram);
	}

	@Override
	public List<ScheduleVO> getSchePageList(PageVO page, String pram) {
		return ScheDao.getSchePageList(page,pram);
	}

	@Override
	public int adminSelectBoardCnt(int param) {
		return boardDao.adminSelectBoardCnt(param);
	}

	@Override
	public List<BoardVO> adminSelectListboard(PageVO page) {
		List<BoardVO> res = boardDao.adminSelectListboard(page);
	
		return res;
	}

	@Override
	public int todayRegBoard(Map<String, String> paramMap) {
		return boardDao.todayRegBoard(paramMap);
	}

	@Override
	public int adminBoardWait(Map<String, String> paramMap) {
		return  boardDao.adminBoardWait(paramMap);
	}

	
	
}
