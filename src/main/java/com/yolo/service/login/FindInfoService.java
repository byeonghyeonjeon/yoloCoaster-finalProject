package com.yolo.service.login;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yolo.dao.login.inf.FindInfoDaoInf;
import com.yolo.model.EmailVO;
import com.yolo.model.MemberVO;
@Service
public class FindInfoService implements FindInfoServiceInf{
	
	@Resource
	FindInfoDaoInf findInfoDao;
	
	
	@Override
	public int findMemId(MemberVO memVO) {
		// 해당 회원 인증번호 생성 
		return findInfoDao.findMemId(memVO);
	}
	
	@Override
	public List<String> getjoinCertify(MemberVO memVO) {
		// 인증 번호 받아오기
		return findInfoDao.getjoinCertify(memVO);
	}

	@Override
	public List<String> getMemIdList(MemberVO memVO) {
		// id리스트 가져오기
		return findInfoDao.getMemIdList(memVO);
	}
	
	@Override
	public int findMemPass(MemberVO memVO) {
		// 찾은 id의 joinInfo 테이블에 난수 추가
		return findInfoDao.findMemPass(memVO);
	}
	
	@Override
	public int resetMemberPass(MemberVO memVO) {
		// 비밀번호 변경하기
		return findInfoDao.resetMemberPass(memVO);
	}
	
	@Override
	public String getPassCertify(MemberVO memVO) {
		// 인증번호 일치여부 확인
		return findInfoDao.getPassCertify(memVO);
	}
	
	@Override
	public boolean sendMail(EmailVO mailVO){
		//메일보내기
		boolean result = false;
		
		String host = "smtp.gmail.com"; 
		final String username = "yolocoaster10"; 
		final String password = "!qaz12345";
		int port = 465; //포트번호  
		Properties props = System.getProperties();  
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		
		//Session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
			String un=username; 
			String pw=password; 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
				} 
			}); 
		session.setDebug(true); //for debug 
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 
		try {
			mimeMessage.setFrom(new InternetAddress("yolocoaster10@gmail.com"));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailVO.getReceiver())); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 
			mimeMessage.setSubject(mailVO.getSubject()); //제목셋팅 
			mimeMessage.setText(mailVO.getContent()); //내용셋팅 
			Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
			result = true;
			return result;
		} catch (MessagingException e) {
			e.printStackTrace();
			return result;
		} 
		
	}


}
