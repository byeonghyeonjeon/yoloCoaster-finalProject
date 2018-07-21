package com.yolo.service.chat;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yolo.dao.admin.inf.FileAddDaoInf;
import com.yolo.dao.chat.inf.MessageDaoInf;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.File_addVO;
import com.yolo.model.MessageVO;
import com.yolo.model.PageVO;

@Service
@Transactional
public class MessageService implements MessageServiceInf{
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/8.LastProject/workspace/yoloCoaster/src/main/webapp";
	private final String UPLOAD_PATH_NOT_REFLESH = "D:/A_TeachingMaterial/8.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/yoloCoaster";
	
	@Resource
	private MessageDaoInf messageDao;
	
	@Resource
	private FileAddDaoInf fileAddDao;
	
	@Override
	public int sendMessage(MessageVO messageVO) {
		return messageDao.sendMessage(messageVO);
	}

	@Override
	public List<MessageVO> selectNotReadMessage(Chat_nameVO chatNameVO) {
		return messageDao.selectNotReadMessage(chatNameVO);
	}

	@Override
	public List<MessageVO> selectBeforeMessage(MessageVO messageVO) {
		return messageDao.selectBeforeMessage(messageVO);
	}
	
	@Override
	public MessageVO imageUpload(MultipartFile multipartFile, MessageVO messageVO) {
		int chat_seq = messageVO.getChat_seq();
		String mem_id = messageVO.getMessage_mem_id();
		
		File_addVO file_add = new File_addVO();
		
		String add_oriname = multipartFile.getOriginalFilename();
		String add_ex = getEx(add_oriname);
		String add_newname = getUUID() + add_ex;
		String add_path = UPLOAD_PATH + "/upload/chat/" + chat_seq;
		String file_path = add_path + "/" + add_newname;
		
		String add_path_not_reflesh = UPLOAD_PATH_NOT_REFLESH + "/upload/chat/" + chat_seq;
		String file_path_not_reflesh = add_path_not_reflesh + "/" + add_newname;
		
		
		file_add.setParent_seq(chat_seq);
		file_add.setAdd_oriname(add_oriname);
		file_add.setAdd_newname(add_newname);
		file_add.setAdd_mem_id(mem_id);
		file_add.setAdd_ex(add_ex);
		file_add.setAdd_path(add_path);
		
		File file = new File(file_path);
		File file_not_reflesh = new File(file_path_not_reflesh);
        if(!file.exists()){
            //디렉토리 생성 메서드
        	file.mkdirs();
        }
        if(!file_not_reflesh.exists()){
        	//디렉토리 생성 메서드
        	file_not_reflesh.mkdirs();
        }
        
        // 파일 저장
		try {
			multipartFile.transferTo(file);
			multipartFile.transferTo(file_not_reflesh);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		fileAddDao.insertFile(file_add);
		
		
		//메세지 저장
		String message_content = "upload/chat/" + chat_seq + "/" + add_newname;
		messageVO.setMessage_content(message_content);
		messageVO.setMessage_sort("02");
		messageDao.sendMessage(messageVO);
		
		return messageVO;
	}
	
	private String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	private String getEx(String add_oriname){
		return add_oriname.substring(add_oriname.lastIndexOf("."));
	}

	@Override
	public Map<String, Object> selectImgList(int pageNum, Chat_nameVO chatNameVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//1.총 개수 조회
		int totalCount = messageDao.selectImgCount(chatNameVO);
		
		//2.해당 페이지의 메세지 조회
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("chat_seq", chatNameVO.getChat_seq());
		parameterMap.put("pageNum", pageNum);
		List<MessageVO> messageVOList = messageDao.selectImgPaging(parameterMap);
		
		
		PageVO pageVO = new PageVO();
		pageVO.setPageNo(pageNum);
		//페이지 블록 사이즈
		pageVO.setBlockSize(10);
		//페이지 하나당 게시글수
		pageVO.setPageSize(9);
		//전체 게시물 수
		pageVO.setTotalCount(totalCount);
		//페이징객체 만들기
		pageVO.makePaging();
		
		resultMap.put("messageVOList", messageVOList);
		resultMap.put("pageVO", pageVO);
		
		return resultMap;
	}
	
}
