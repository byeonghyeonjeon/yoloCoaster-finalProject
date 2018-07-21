package com.yolo.controller.admin.file;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yolo.service.admin.FileAddServiceInf;

@RequestMapping(value = "/file")
@Controller
public class FileController {
	@Resource
	private FileAddServiceInf fileAddService;
	
	/**
	 * Method : imageDownload
	 * 최초작성일 : 2018. 6. 29.
	 * 작성자 : Jun
	 * 변경이력 :
	 * @param filepath 파일경로 및 이름
	 * @param response
	 * @param request
	 * Method 설명 : 파일다운로드
	 */
	@RequestMapping("/imageDownload")
	public void imageDownload(String filepath, HttpServletResponse response, HttpServletRequest request) {
		try {
			fileAddService.fileDownload(filepath, response, request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
