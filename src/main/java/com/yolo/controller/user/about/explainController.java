package com.yolo.controller.user.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * compSummaryController.java
 *
 * @author JiHee
 * @since 2018. 6. 22.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 6. 22. JiHee 최초 생성
 *
 * </pre>
 */
@Controller()
@RequestMapping("/explain")
public class explainController {
	
	/**
	 * Method : compSummaryForm
	 * 최초작성일 : 2018. 6. 22.
	 * 작성자 : JiHee
	 * 변경이력 :
	 * @return
	 * Method 설명 : 회사 개요 폼
	 */
	@RequestMapping("/compSummary")
	public String compSummaryForm(){
		return "compSummary";
	}

}
