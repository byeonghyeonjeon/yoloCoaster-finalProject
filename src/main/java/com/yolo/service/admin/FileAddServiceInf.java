package com.yolo.service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yolo.model.File_addVO;

public interface FileAddServiceInf {

	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 : 저장처리는 따로하고 fileAddVO만 저장하는 메서드
	 */
	public int insertFileList(List<File_addVO> fileList);

	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 28.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param multipartRequest,저장경로,parent_seq(부모게시판)
	 * Method 설명 :form에서 넘어온 MultipartHttpServletRequest 리스트 넘기면 저장해주는 서비스
	 * @throws IOException 
	 */
	public List<String> insertFileList(MultipartHttpServletRequest multipartRequest,String dirPath,int parent_seq) throws IOException;

	/**
	 * Method : fileDownload
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param filepath 파일명 및 경로
	 * Method 설명 : 파일 다운로드 서비스
	 */
	public void fileDownload(String filepath, HttpServletResponse response, HttpServletRequest request) throws IOException;
	
	
	/**
	 * Method : imageUpload
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param multipartFile
	 * @param dirPath
	 * @param parent_seq
	 * @return
	 * Method 설명 : 파일 업로드(분류 없는 경우)
	 * @throws IOException 
	 */
	public int imageUpload(MultipartFile multipartFile, String dirPath,int parent_seq) throws IOException;

	/**
	 * 
	 * Method : deleteFile
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param add_seq
	 * @return
	 * Method 설명 : 파일삭제
	 */
	public int deleteFile(int add_seq);
	
	/**
	 * Method : imageUpload
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param multipartFile
	 * @param dirPath
	 * @param parent_seq
	 * @return
	 * Method 설명 : 파일 업로드(분류 있는 경우)
	 * @throws IOException 
	 */
	public int imageUpload(MultipartFile multipartFile, String dirPath,int parent_seq, String add_sort) throws IOException;
	
}
