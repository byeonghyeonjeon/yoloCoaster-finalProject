package com.yolo.yolo.service.file;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.init.TestInit;
import com.yolo.service.admin.FileAddServiceInf;

public class FileAddServiceTest extends TestInit{

	@Resource
	FileAddServiceInf fileService;
	
	/**
	 * 
	 * Method : createFileServiceTest
	 * 최초작성일 : 2018. 6. 27.
	 * 작성자 : Brown
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void createFileServiceTest() {
		assertNotNull(fileService);
		
	}
	

}
