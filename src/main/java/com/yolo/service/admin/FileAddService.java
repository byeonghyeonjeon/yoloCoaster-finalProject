package com.yolo.service.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.dao.admin.inf.FileAddDaoInf;
import com.yolo.model.File_addVO;
import com.yolo.model.MessageVO;

@Service
public class FileAddService implements FileAddServiceInf{
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/8.LastProject/workspace/yoloCoaster/src/main/webapp"; //로컬
	private final String UPLOAD_PATH_NOT_REFLESH = "D:/A_TeachingMaterial/8.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/yoloCoaster"; //서버
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	FileAddDaoInf fileAddDao;
	
	@Resource(name="imageFilterService")
	private ImageFilterServiceInf imageFilterService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public int insertFileList(List<File_addVO> fileList) {
		return fileAddDao.insertFileList(fileList);
	}

	// uuid생성
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param multipartRequest,저장경로,parent_seq(부모게시판)
	 * Method 설명 : 파일 리스트 처리 / 
	 * @return : 저장된 파일 이름 (uuid)리스트 반환
	 * @throws IOException 
	 */
	@Override
	public List<String> insertFileList(MultipartHttpServletRequest multipartRequest,String dirPath,int parent_seq) throws IOException {
		
		// 파일처리
		String path = UPLOAD_PATH + dirPath;
		String serverPath = UPLOAD_PATH_NOT_REFLESH+dirPath;
				List<File_addVO> insertFileList = new ArrayList<File_addVO>();			
				
				// MultipartHttpServletRequest 생성
				Iterator iter = multipartRequest.getFileNames();
				MultipartFile mfile = null;

				// 디레토리가 없다면 생성
				File dir = new File(path);
				if (!dir.isDirectory()) {
					dir.mkdirs();
				}
				//서버 디렉토리 생성
				File dirServer = new File(serverPath);
				if (!dirServer.isDirectory()) {
					dirServer.mkdirs();
				}
				
				List<String> fileName = new ArrayList<String>();
				// 값이 나올때까지
				while (iter.hasNext()) {
					String fieldName = (String) iter.next();
					// 내용을 가져와서
					mfile = multipartRequest.getFile(fieldName);
					String origName="";
					try {
						origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
					// 한글꺠짐 방지
					// 파일명이 없다면
					if ("".equals(origName)) {
						continue;
					}
					// 파일 명 변경(uuid로 암호화)
					String ext = origName.substring(origName.lastIndexOf('.'));
					// 확장자
					String saveFileName = getUuid() + ext;
					// 설정한 path에 파일저장
					File serverFile = new File(path + File.separator + saveFileName);
					File serverDirFile = new File(serverPath + File.separator + saveFileName);
					try {
						mfile.transferTo(serverFile);
						mfile.transferTo(serverDirFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//파일이름 리스트
					fileName.add(dirPath+"/"+saveFileName);
					// 파일 저장
					File_addVO newfile = new File_addVO();
					newfile.setAdd_oriname(origName);
					log.debug("{},{}","origName",origName);
					newfile.setParent_seq(parent_seq);
					newfile.setAdd_newname(saveFileName);
					newfile.setAdd_path(dirPath+"/"+saveFileName);
					newfile.setAdd_ex(ext);					
					
					
					insertFileList.add(newfile);
				}
				
				fileAddDao.insertFileList(insertFileList);
				
		return fileName;
		
	}
	
	/**
	 * Method : fileDownload
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param filepath (예 : upload/chat/24/b62a7987f3884994a9327d3daf831cc3.jpg)
	 * @param response
	 * @param request
	 * Method 설명 : 파일다운로드
	 * @throws IOException 
	 */
	@Override
	public void fileDownload(String filepath, HttpServletResponse response,	HttpServletRequest request) throws IOException {
		File file = new File(UPLOAD_PATH + "/" + filepath);
		
		response.setHeader("Content-Disposition", "attachment; filename=" + filepath);
		response.setContentType("application/octet-stream");
		response.setContentLength((int)file.length());
		
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while( (len = fis.read(buffer)) != -1){
			sos.write(buffer, 0, len);
		}
		
		fis.close();
		sos.close();
		
	}
	
	private String getEx(String add_oriname){
		return add_oriname.substring(add_oriname.lastIndexOf("."));
	}
	
	@Override
	public int imageUpload(MultipartFile multipartFile, String dirPath,int parent_seq) throws IOException {
		int res=0;
		File_addVO file_add = new File_addVO();
		
		String add_oriname = multipartFile.getOriginalFilename();
		if(add_oriname!=""||!add_oriname.isEmpty()||!add_oriname.equals("")){
			
		
			String add_ex = getEx(add_oriname);
			String add_newname = getUuid() + add_ex;
			String add_path =dirPath +add_newname;
			
			
			String add_path_not_reflesh = dirPath + add_newname;
			
			
			file_add.setParent_seq(parent_seq);
			file_add.setAdd_oriname(add_oriname);
			file_add.setAdd_newname(add_newname);
			file_add.setAdd_mem_id("");
			file_add.setAdd_ex(add_ex);
			file_add.setAdd_path(dirPath+add_newname);
			
		
			
			File file = new File(UPLOAD_PATH+dirPath+File.separator+add_newname);
			File filePath = new File(UPLOAD_PATH+dirPath);
			File file_not_reflesh = new File(UPLOAD_PATH_NOT_REFLESH+dirPath+File.separator+add_newname);
			File file_not_refleshPath = new File(UPLOAD_PATH_NOT_REFLESH+dirPath);
	        if(!filePath.exists()){
	            //디렉토리 생성 메서드
	        	filePath.mkdirs();
	        }
	        if(!file_not_refleshPath.exists()){
	        	//디렉토리 생성 메서드
	        	file_not_refleshPath.mkdirs();
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
			
			/*이미지 검사*/
			String imageResult = imageFilterService.imageFiltering(UPLOAD_PATH+dirPath+add_newname);					
			if(imageResult.equals("BAD")){	
				
				file_add.setAdd_path(dirPath+"warning.png"); // 경고 이미지로 변경
			}					
			logger.debug("{}",imageResult);
			/* end 이미지 검사*/
			
			res = fileAddDao.insertFile(file_add);
		}
		
		return res;
	}

	@Override
	public int deleteFile(int add_seq) {
		return fileAddDao.deleteFile(add_seq);
	}
	
	@Override
	public int imageUpload(MultipartFile multipartFile, String dirPath,int parent_seq, String add_sort) throws IOException {
		int res=0;
		File_addVO file_add = new File_addVO();
		
		String add_oriname = multipartFile.getOriginalFilename();
		if(add_oriname!=""||!add_oriname.isEmpty()||!add_oriname.equals("")){
			
		
			String add_ex = getEx(add_oriname);
			String add_newname = getUuid() + add_ex;
			String add_path =dirPath +add_newname;
			
			
			String add_path_not_reflesh = dirPath + add_newname;
			
			
			file_add.setParent_seq(parent_seq);
			file_add.setAdd_oriname(add_oriname);
			file_add.setAdd_newname(add_newname);
			file_add.setAdd_mem_id("");
			file_add.setAdd_ex(add_ex);
			file_add.setAdd_path(dirPath+add_newname);
			file_add.setAdd_sort(add_sort);
			
			
			
			File file = new File(UPLOAD_PATH+dirPath+File.separator+add_newname);
			File filePath = new File(UPLOAD_PATH+dirPath);
			File file_not_reflesh = new File(UPLOAD_PATH_NOT_REFLESH+dirPath+File.separator+add_newname);
			File file_not_refleshPath = new File(UPLOAD_PATH_NOT_REFLESH+dirPath);
	        if(!filePath.exists()){
	            //디렉토리 생성 메서드
	        	filePath.mkdirs();
	        }
	        if(!file_not_refleshPath.exists()){
	        	//디렉토리 생성 메서드
	        	file_not_refleshPath.mkdirs();
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
			
			res = fileAddDao.insertFileInSort(file_add);
		}
		
		return res;
	}
	
}
