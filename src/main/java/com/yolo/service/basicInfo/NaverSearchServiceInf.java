package com.yolo.service.basicInfo;

import java.util.List;

import com.yolo.model.NaverBlogVO;

/**
 * NaverSearchServiceInf.java
 *
 * @author Jun
 * @since 2018. 7. 1.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 1. Jun 최초 생성
 *
 * </pre>
 */
public interface NaverSearchServiceInf {
	List<NaverBlogVO> naverSearch(String searchName, int start);
}
