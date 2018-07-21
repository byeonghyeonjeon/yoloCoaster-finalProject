package com.yolo.service.member;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yolo.dao.member.inf.AreaDaoInf;
import com.yolo.dao.member.inf.BookmarkAreaDaoInf;
import com.yolo.dao.member.inf.MemberDaoInf;
import com.yolo.model.AreaVO;
import com.yolo.model.Bookmark_areaVO;
import com.yolo.model.MemberVO;

@Service
public class MemberService implements MemberServiceInf{

	@Resource
	MemberDaoInf memberDao;
	
	@Resource
	BookmarkAreaDaoInf bookmarkAreaDao;
	
	@Resource
	AreaDaoInf areaDao;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public MemberVO getMemberLogin(MemberVO member) {
		return memberDao.getMemberLogin(member);
	}

	/**
	 * 마이페이지 회원정보 조회
	 * Method : selectMemberInfo
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param member
	 * @return
	 * Method 설명 :
	 */
	@Override
	public MemberVO selectMemberInfo(MemberVO member) {
		MemberVO res = memberDao.selectMemberInfo(member);
		
		//지역변환
		AreaVO areaVO = areaDao.selectArea(res.getMem_add1());
		res.setMem_add1(areaVO.getAreaname());
		
		 
		//remove pass & tel
		int passLeng = res.getMem_pass().length();
		String blindPass = "";
		for (int i = 0; i < passLeng; i++) {
			blindPass+="*";
		}
		res.setMem_pass(blindPass);
		log.debug("{},{}","res.setMem_pass(blindPass);",blindPass);
		log.debug("{},{}","res.getMem_tel()",res.getMem_tel());
		if (res.getMem_tel() != null) {
			int telLeng = res.getMem_tel().length();
			log.debug("{},{}","telLeng",telLeng);
			String blindTell = res.getMem_tel().substring(0, telLeng-2);
			blindTell+="**";
			res.setMem_tel(blindTell);
		}
		
		if(res.getMem_profile()==null){
			res.setMem_profile("/image/logo/noImage.png");
		}
		return res;
	}

	@Override
	public int checkMemPass(MemberVO member) {
		return memberDao.checkMemPass(member);
	}

	
	@Override
	public MemberVO selectMemberInfoNonBlind(MemberVO member) {
		
		MemberVO res = memberDao.selectMemberInfo(member);
		
		//지역변환
		AreaVO areaVO = areaDao.selectArea(res.getMem_add1());
		res.setMem_add1(areaVO.getAreaname());
		
		if(res.getMem_profile()==null){
			res.setMem_profile("/image/logo/noImage.png");
		}
		return res;
		
		
	}

	@Override
	public int updateMemberInfo(MemberVO member) {
		String param = member.getMem_add1();
		String StringToCode  = areaDao.selectAreaCode(param);
		member.setMem_add1(StringToCode);
		return memberDao.updateMemberInfo(member);
	}

	@Override
	public List<Bookmark_areaVO> selectBookmarkArea(String mem_id) {
		return bookmarkAreaDao.getBookmarkList(mem_id);
	}

	@Override
	public int deleteBookmarkArea(int link) {
		return bookmarkAreaDao.deleteBookmarkArea(link);
	}

	@Override
	public void updateMemeberSt(String mem_id) {
		memberDao.updateMemeberSt(mem_id);
	}

	
	
}
