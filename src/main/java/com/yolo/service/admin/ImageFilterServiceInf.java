/**
 * 
 */
package com.yolo.service.admin;

import java.io.IOException;
import java.util.List;

/**
 * @author PC15
 *
 */
public interface ImageFilterServiceInf {
	
	/**
	 * 
	* Method : imageFiltering
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC15
	* 변경이력 :
	* @param imagePath
	* @return
	* Method 설명 : 게시글에 등록되는 이미지 필터링
	 * @throws IOException 
	 */
	public String imageFiltering(String imagePath) throws IOException; 
}
