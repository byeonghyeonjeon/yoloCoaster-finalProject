package com.yolo.dao.admin.inf;

import java.util.List;

import com.yolo.model.File_addVO;

public interface FileAddDaoInf {

	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 :파일 리스트 추가
	 */
	int insertFile(File_addVO fileList);

	/**
	 * 
	 * Method : selectFile
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param i
	 * @return
	 * Method 설명 :해당 게시글의 번호 입력시 첨부파일 가져오기
	 */
	public File_addVO selectFile(int index);

	/**
	 * 
	 * Method : selectFileList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param parent_seq
	 * @return
	 * Method 설명 :게시글 번호 입력시 리스트 가져오기
	 */
	public List<File_addVO> selectFileList(int parent_seq);

	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 :파일 리스트 추가
	 */
	public int insertFileList(List<File_addVO> fileList);


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
	int deleteFile(int add_seq);




	
	/**
	 * Method : insertFileAddVOList
	 * 최초작성일 : 2018. 7. 5.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 : 파일 리스트로 추가
	 */
	int insertFileAddVOList(List<File_addVO> fileList);

	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 :파일 리스트 추가(분류 있는 경우)
	 */
	int insertFileInSort(File_addVO fileList);
}
