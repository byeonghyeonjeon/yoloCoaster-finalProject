package com.yolo.yolo.dao.file;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.dao.support.DaoSupport;

import com.yolo.dao.admin.inf.FileAddDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.File_addVO;

public class FileUploadTest extends TestInit{

	@Resource
	FileAddDaoInf fileAddDao;
	
	/**
	 * 
	 * Method : createFileAddDaoTest
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * Method 설명 : 다오 생성 테스트
	 */
	@Test
	public void createFileAddDaoTest() {
		assertNotNull(fileAddDao);
	}

	/**
	 * 
	 * Method : selectFileTest
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 파일 하나 가져오기 테스트
	 */
	@Test
	public void selectFileTest() throws Exception {
		File_addVO newFile = new File_addVO();
		//add seq 입력시 하나 가져오기
		newFile = fileAddDao.selectFile(1);
		assertEquals("test", newFile.getAdd_newname());
	}
	
	/**
	 * 
	 * Method : selectFileListTest
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : 리스트 가져오기 테스트
	 */
	@Test
	public void selectFileListTest() throws Exception {
		int parent_seq = 0;
		List<File_addVO> fileList = fileAddDao.selectFileList(parent_seq);
		assertEquals(1, fileList.size());
	}
	
	@Test
	public void insertFileTest() throws Exception {
		File_addVO newFile = new File_addVO();
		newFile.setAdd_mem_id("test");
		newFile.setAdd_newname("test");
		newFile.setAdd_oriname("test");
		newFile.setAdd_path("테스트");
		int res = fileAddDao.insertFile(newFile);
		assertEquals(1, res);
	}
	
	@Test
	public void fileDeleteTest() throws Exception {
		int res = fileAddDao.deleteFile(200);
		assertEquals(1, res);
	}
}
