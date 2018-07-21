package com.yolo.service.schedule;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.member.inf.BookmarkAreaDaoInf;
import com.yolo.model.Bookmark_areaVO;

@Service
public class ScheduleDetailService implements ScheduleDetailServiceInf{

	@Resource
	BookmarkAreaDaoInf bookmarkDao;
	
	@Override
	public List<Bookmark_areaVO> getBookmarkList(String mem_id) {
		return bookmarkDao.getBookmarkList(mem_id);
	}

}
