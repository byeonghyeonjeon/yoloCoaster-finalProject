package com.yolo.service.chat;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yolo.dao.chat.inf.AccountDaoInf;
import com.yolo.model.AccountSearchVO;
import com.yolo.model.AccountSeniorVO;
import com.yolo.model.AccountVO;
import com.yolo.model.DutchVO;

@Service("accountService")
public class AccountService implements AccountServiceInf{
	
	@Resource(name="accountDao")
	private AccountDaoInf accountDao;

	@Override
	public int accountInsert(Map<String, Object> accountInsertMap) {
				
		AccountVO accountVO= (AccountVO) accountInsertMap.get("accountVO");
		int accounetInsertCnt = accountDao.accountInsert(accountVO);
		
		
		List<DutchVO> dutchVOList = (List<DutchVO>) accountInsertMap.get("dutchVOList");
		// account_seq 설정
		for(DutchVO dutchVO : dutchVOList){
			dutchVO.setAccount_seq(accountVO.getAccount_seq());
		}
		
		int dutchInsertCnt = accountDao.dutchInsert(dutchVOList);
		
		//생성된 account_seq 반환
		return accountVO.getAccount_seq();
	}

	@Override
	public List<AccountVO> getAccountMain(int chat_seq) {		
		return accountDao.getAccountMain(chat_seq);
	}

	@Override
	public List<AccountSeniorVO> getAccountDetil(int account_seq) {
		return accountDao.getAccountDetil(account_seq);
	}

	@Override
	public int accountDelete(int account_seq) {
		return accountDao.accountDelete(account_seq);
	}

	@Override
	public List<AccountVO> accountSearch(AccountSearchVO accountSearchVO) {
		return accountDao.accountSearch(accountSearchVO);
	}

}
