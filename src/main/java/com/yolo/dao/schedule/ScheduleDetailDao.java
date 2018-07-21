package com.yolo.dao.schedule;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.schedule.inf.ScheduleDetailDaoInf;
import com.yolo.model.Content_detailVO;
import com.yolo.model.Schedule_detailVO;
@Repository
public class ScheduleDetailDao implements ScheduleDetailDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public List<Schedule_detailVO> selectSchDetail(int scheduleSeq) {
		logger.debug("{},{}","selectSchDetail(int scheduleSeq)  :",scheduleSeq);
		return sessionTemplate.selectList("scheDetail.selectSchDetail",scheduleSeq);
	}

	@Override
	public List<Content_detailVO> selectContentDetailList(int detailSeq) {
		logger.debug("{},{}","selectContentDetailList(int detailSeq)  :",detailSeq);
		return sessionTemplate.selectList("scheDetail.selectContentDetailList",detailSeq);
	}

	@Override
	public int createScheDetail(Schedule_detailVO detail) {
		logger.debug("{},{}","createScheDetail(testDetail)  :",detail.toString());
		return sessionTemplate.insert("scheDetail.createScheDetail",detail);
	}

	@Override
	public int deleteDetail(int detail_seq) {
		logger.debug("{},{}","deleteDetail(detail_seq)  :",detail_seq);
		return sessionTemplate.delete("scheDetail.deleteDetail",detail_seq);
	}
	
}
