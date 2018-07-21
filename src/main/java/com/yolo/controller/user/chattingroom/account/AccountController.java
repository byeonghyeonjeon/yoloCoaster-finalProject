/**
 * 
 */
package com.yolo.controller.user.chattingroom.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yolo.model.AccountSearchVO;
import com.yolo.model.AccountSeniorVO;
import com.yolo.model.AccountVO;
import com.yolo.model.Chat_nameVO;
import com.yolo.model.DutchVO;
import com.yolo.model.MemberVO;
import com.yolo.service.chat.AccountServiceInf;

/**
 * @author PC15
 *
 */
@RequestMapping(value="/chatAccount")
@Controller
public class AccountController {
	
	@Resource(name="accountService")
	private AccountServiceInf accountService;
	
	@RequestMapping(value="/main")
	public String chatAccountMain(HttpSession session, Model model){
		
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq();
		
		List<AccountVO> accountVOList = accountService.getAccountMain(chat_seq);
		model.addAttribute("accountVOList",accountVOList);
		
		return "content/user/chattingroom/chatAccount/chatAccountMain";
	}
	
	@RequestMapping(value="/main/search")
	public String search(@RequestBody Map<String, Object> accountMap, HttpSession session, Model model){
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq();		
		
		String accountSearchStart = (String) accountMap.get("accountSearchStart");
		String accountSearchEnd  = (String) accountMap.get("accountSearchEnd");
		/*String selectContent  = (String) accountMap.get("selectContent");*/
		String searchAccountText = (String) accountMap.get("searchAccountText");		
		
		AccountSearchVO accountSearchVO = new AccountSearchVO();
		accountSearchVO.setChat_seq(chat_seq);
		accountSearchVO.setAccountSearchStart(accountSearchStart);
		accountSearchVO.setAccountSearchEnd(accountSearchEnd);
		accountSearchVO.setSearchAccountText(searchAccountText);
		/*accountSearchVO.setSelectContent(selectContent);*/
		
		List<AccountVO> accountVOList = accountService.accountSearch(accountSearchVO);
		
		model.addAttribute("accountVOList",accountVOList );
		
		return "content/user/chattingroom/chatAccount/chatAccountTable";
	}
	

	@RequestMapping(value="/main/create")
	public String insertAcc(){
		
		return "content/user/chattingroom/chatAccount/insertAcc";
	}
	
	@RequestMapping(value="/create/insert")
	@ResponseBody
	public  Map<String, Object> insertAccReg(@RequestBody Map<String, Object> accountMap, HttpSession session, Model model){
		
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq(); 
		//mem_id 가져오기
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String mem_id = memberVO.getMem_id();
		
		//accountVO 요청 정보 
		String account_detail = (String) accountMap.get("account_detail");
		String account_total = (String) accountMap.get("account_total");
		int account_total_int = Integer.parseInt(account_total);
		
		String account_num = (String) accountMap.get("account_num");
		int account_cnt = (int) accountMap.get("account_cnt");
		/*int account_cnt_int = Integer.parseInt(account_cnt);*/
		String account_dt = (String) accountMap.get("account_dt");
		String account_info = (String) accountMap.get("account_info");
		String account_memo = (String) accountMap.get("account_memo");
		
		//accountVO 요청 정보 설정
		AccountVO accountVO = new AccountVO();
		accountVO.setAccount_cnt(account_cnt);
		accountVO.setAccount_info(account_info);
		accountVO.setAccount_dt(account_dt);
		accountVO.setAccount_memo(account_memo);
		accountVO.setAccount_total(account_total_int);
		accountVO.setAccount_detail(account_detail);
		accountVO.setAccount_num(account_num);
		accountVO.setChat_seq(chat_seq);
		accountVO.setMem_id(mem_id);	
		
		Map<String, Object>  accountInsertMap = new HashMap<String, Object>();	
		
		//dutchVO 요청 정보
		List<String> account_MoneyList = (List<String>) accountMap.get("dutchMoneyList");
		List<String> account_MemberList = (List<String>) accountMap.get("dutchMemberList");
		
		//dutchVO insert요청 정보 설정
		List<DutchVO> dutchVOList = new ArrayList<DutchVO>();
		for(int i =0; i<account_MoneyList.size(); i++){
			DutchVO dutchVO = new DutchVO();
			dutchVO.setDutch_money(Integer.parseInt(account_MoneyList.get(i)));
			dutchVO.setDutch_mem_id(account_MemberList.get(i));	
			dutchVOList.add(dutchVO);
		}		
		
		accountInsertMap.put("accountVO", accountVO);
		accountInsertMap.put("dutchVOList", dutchVOList);	
		accountInsertMap.put("mem_id", mem_id);	
		
		int insertCnt = accountService.accountInsert(accountInsertMap);		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		return  resultMap;
	}

	@RequestMapping(value="/main/detail")
	public String selectAcc(@RequestBody Map<String, Object> accountMap, HttpSession session, Model model){
		//account_seq 가져오기
		String account_seq = (String) accountMap.get("account_seq");
		int account_seq_int = Integer.parseInt(account_seq);		
		//mem_id 가져오기
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String user_id = memberVO.getMem_id();
		
		List<AccountSeniorVO> accountSeniorList = accountService.getAccountDetil(account_seq_int);
		//accountVO에 정보 설정
		AccountSeniorVO accountVO = new AccountSeniorVO();
		accountVO.setAccount_cnt(accountSeniorList.get(0).getAccount_cnt());
		accountVO.setAccount_total(accountSeniorList.get(0).getAccount_total());
		accountVO.setAccount_dt(accountSeniorList.get(0).getAccount_dt());
		accountVO.setAccount_num(accountSeniorList.get(0).getAccount_num());
		accountVO.setAccount_memo(accountSeniorList.get(0).getAccount_memo());
		accountVO.setAccount_info(accountSeniorList.get(0).getAccount_info());
		accountVO.setAccount_detail(accountSeniorList.get(0).getAccount_detail());
		accountVO.setAccount_seq(accountSeniorList.get(0).getAccount_seq());
		accountVO.setMem_id(accountSeniorList.get(0).getMem_id());
		
		//DutchList에 정보 설정
		List<DutchVO> dutchVOList = new ArrayList<DutchVO>();
		for(int i =0; i<accountSeniorList.size(); i++){
			
			DutchVO dutchVO = new DutchVO();
			dutchVO.setDutch_mem_id(accountSeniorList.get(i).getDutch_mem_id());
			dutchVO.setDutch_money(accountSeniorList.get(i).getDutch_money());
			dutchVOList.add(dutchVO);			
		}
		//accountDetail 호출
		model.addAttribute("accountVO", accountVO);
		model.addAttribute("dutchVOList", dutchVOList);
		model.addAttribute("user_id", user_id);
		
		//더치페이 조회 화면으로 이동
		return "content/user/chattingroom/chatAccount/selectAcc";
	}
	
	@RequestMapping(value="detail/delete")
	public String deleteAcc(@RequestBody Map<String, Object> accountMap, HttpSession session, Model model){
		String account_seq = (String) accountMap.get("account_seq");
		int account_seq_int =Integer.parseInt(account_seq);
		
		int accountDeleteCnt = accountService.accountDelete(account_seq_int);
		
		//업데이트 화면으로 이동
		return chatAccountMain(session, model);
	}
	
	@RequestMapping(value="detail/update")
	public String updateAccReg(@RequestBody Map<String, Object> accountMap, HttpSession session, Model model){
		
		//chat_seq 가져오기
		Chat_nameVO chat_nameVO = (Chat_nameVO) session.getAttribute("chatNameVO");
		int chat_seq = chat_nameVO.getChat_seq();		
		
		//account_seq 가져오기
		String account_seq = (String) accountMap.get("account_seq");
		int account_seq_int = Integer.parseInt(account_seq);	
		
		//mem_id 가져오기
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");		
		String user_id = memberVO.getMem_id();
		
		//삭제 요청 ***
		int accountDeleteCnt = accountService.accountDelete(account_seq_int);
		
		//accountVO 요청 정보 
		String account_detail = (String) accountMap.get("account_detail");
		String account_total = (String) accountMap.get("account_total");
		int account_total_int = Integer.parseInt(account_total);
		
		String account_num = (String) accountMap.get("account_num");
		int account_cnt = (int) accountMap.get("account_cnt");
		/*int account_cnt_int = Integer.parseInt(account_cnt);*/
		String account_dt = (String) accountMap.get("account_dt");
		String account_info = (String) accountMap.get("account_info");
		String account_memo = (String) accountMap.get("account_memo");
		
		//accountVO 요청 정보 설정
		AccountVO accountVO = new AccountVO();
		accountVO.setAccount_cnt(account_cnt);
		accountVO.setAccount_info(account_info);
		accountVO.setAccount_dt(account_dt);
		accountVO.setAccount_memo(account_memo);
		accountVO.setAccount_total(account_total_int);
		accountVO.setAccount_detail(account_detail);
		accountVO.setAccount_num(account_num);
		accountVO.setChat_seq(chat_seq);
		accountVO.setMem_id(user_id);	
		
		Map<String, Object>  accountInsertMap = new HashMap<String, Object>();	
		
		//dutchVO 요청 정보
		List<String> account_MoneyList = (List<String>) accountMap.get("dutchMoneyList");
		List<String> account_MemberList = (List<String>) accountMap.get("dutchMemberList");
		
		//dutchVO insert요청 정보 설정
		List<DutchVO> dutchVOList = new ArrayList<DutchVO>();
		for(int i =0; i<account_MoneyList.size(); i++){
			DutchVO dutchVO = new DutchVO();
			dutchVO.setDutch_money(Integer.parseInt(account_MoneyList.get(i)));
			dutchVO.setDutch_mem_id(account_MemberList.get(i));	
			dutchVOList.add(dutchVO);
		}		
		
		accountInsertMap.put("accountVO", accountVO);
		accountInsertMap.put("dutchVOList", dutchVOList);	
		accountInsertMap.put("user_id", user_id);
		
		//생성 요청
		int accountBefore_seq = accountService.accountInsert(accountInsertMap);
		
		//업데이트 완료 후 조회 페이지 이동
		return chatAccountMain(session, model);
	}
	
}
