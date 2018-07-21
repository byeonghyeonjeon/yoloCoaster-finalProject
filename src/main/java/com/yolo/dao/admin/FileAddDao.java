package com.yolo.dao.admin;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.admin.inf.FileAddDaoInf;
import com.yolo.model.File_addVO;
@Repository
public class FileAddDao implements FileAddDaoInf{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 * Method : insertFile
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 :파일 첨부
	 */
	@Override
	public int insertFile(File_addVO fileList) {
		return sessionTemplate.insert("fileAdd.insertFile",fileList);
	}
	/**
	 * 
	 * Method : selectFile
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param add_seq
	 * @return
	 * Method 설명 :한개의 첨부파일 가져오기
	 */
	@Override
	public File_addVO selectFile(int add_seq) {
		return sessionTemplate.selectOne("fileAdd.selectFile",add_seq);
	}

	/**
	 * 
	 * Method : selectFileList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param parent_seq
	 * @return
	 * Method 설명 :여러개의 첨부파일 가져오기
	 */
	@Override
	public List<File_addVO> selectFileList(int parent_seq) {
		return sessionTemplate.selectList("fileAdd.selectFileList",parent_seq);
	}
	/**
	 * 
	 * Method : insertFileList
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @param fileList
	 * @return
	 * Method 설명 :리스트 저장하기
	 */
	@Override
	public int insertFileList(List<File_addVO> fileList) {
		int res = 0 ;
		for (File_addVO file_addVO : fileList) {
			res += sessionTemplate.insert("fileAdd.insertFile",file_addVO);
		}
		return res;
	}

	@Override
	public int deleteFile(int add_seq) {
		return sessionTemplate.delete("fileAdd.deleteFile",add_seq);
	}

	
	@Override
	public int insertFileAddVOList(List<File_addVO> fileList) {
		return sessionTemplate.insert("fileAdd.insertFile_add_Multi", fileList);
	}
	
	@Override
	public int insertFileInSort(File_addVO fileList) {
		return sessionTemplate.insert("fileAdd.insertFileInSort",fileList);
	}


	
}
