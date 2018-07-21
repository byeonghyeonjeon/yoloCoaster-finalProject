package com.yolo.service.chat;

import java.util.List;
import java.util.Map;

import com.yolo.model.AccountSearchVO;
import com.yolo.model.AccountSeniorVO;
import com.yolo.model.AccountVO;

public interface AccountServiceInf {

	/**
	* Method : accountInsert
	* 최초작성일 : 2018. 7. 4.
	* 작성자 : PC15
	* 변경이력 :
	* @param accountInsertMap
	* Method 설명 :
	 * @return 
	*/
	int accountInsert(Map<String, Object> accountInsertMap);
	
	/**
	 * 
	* Method : getAccountMain
	* 최초작성일 : 2018. 7. 5.
	* 작성자 : PC15
	* 변경이력 :
	* @param chat_seq
	* @return
	* Method 설명 : AccountMain List 조회
	 */
	List<AccountVO> getAccountMain (int chat_seq);
	
	/**
	 * 
	* Method : getAccountDetil
	* 최초작성일 : 2018. 7. 5.
	* 작성자 : PC15
	* 변경이력 :
	* @param account_seq
	* @return
	* Method 설명 : accountDetail List 조회
	 */
	List<AccountSeniorVO> getAccountDetil(int account_seq);

	/**
	 * 
	* Method : accountDelete
	* 최초작성일 : 2018. 7. 5.
	* 작성자 : PC15
	* 변경이력 :
	* @param account_seq
	* @return
	* Method 설명 : accountVO 삭제 요청
	 */
	int accountDelete (int account_seq);

	/**
	* Method : accountSearch
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param accountSearchVO
	* @return
	* Method 설명 :
	*/
	List<AccountVO> accountSearch(AccountSearchVO accountSearchVO);
}
