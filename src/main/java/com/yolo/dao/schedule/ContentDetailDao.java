package com.yolo.dao.schedule;


import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.schedule.inf.ContentDetailDaoInf;
import com.yolo.model.Content_detailVO;

@Repository
public class ContentDetailDao implements ContentDetailDaoInf{
	
	
	public ContentDetailDao() {
	}
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int insertContentDetail(Content_detailVO contentVOList) {
		int res=0;
			logger.debug("{},{}","insertContentDetail",contentVOList);
			res = sessionTemplate.insert("schedule.insertContentDetail",contentVOList);
		return res;
	}
	
}
