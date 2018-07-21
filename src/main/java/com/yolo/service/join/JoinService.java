package com.yolo.service.join;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.join.Inf.JoinDaoInf;
import com.yolo.dao.member.inf.JoinInfoDaoInf;
import com.yolo.dao.member.inf.LikeAreaDaoInf;
import com.yolo.model.JoininfoVO;
import com.yolo.model.Like_areaVO;
import com.yolo.model.MemberVO;


@Service
public class JoinService implements JoinServiceInf{
	
	@Resource
	JoinDaoInf joinDao;
	
	@Resource
	JoinInfoDaoInf joinInfoDao;
	
	@Resource
	LikeAreaDaoInf likeAreaDao; 

	@Override
	public int insertMember(MemberVO memVO, ArrayList<String> like_area, String join_path) {
		JoininfoVO joininfoVO = new JoininfoVO();
		joininfoVO.setMem_id(memVO.getMem_id());
		joininfoVO.setJoin_path(join_path);
		
		//추가할 사항 가입경로(1,2,3)-페북이나 네이버로 가입햇는지? 정보 추가
		
		int memResult = joinDao.insertMember(memVO);	//member테이블 insert시 결과여부
		int joinInfoResult = joinInfoDao.insertMemberJoinInfo(joininfoVO);	//joinInfo테이블 insert시 결과여부	
		
		int areaResult = 0;
		Like_areaVO laVO = new Like_areaVO();
		if(like_area != null){ //값이 들어온 경우 insert
			for(int i=0; i <like_area.size();i++){
				laVO.setMem_id(memVO.getMem_id());
				laVO.setArea_code(like_area.get(i));
				areaResult += likeAreaDao.insertLikeArea(laVO);
			}
		}
		if(joinInfoResult==1 && memResult==1 && areaResult == like_area.size()){
			return 1;			
		}else{
			return 0;
		}
		
		
	}
	
	
}
