package com.yolo.dao.chat;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yolo.dao.chat.inf.AccountDaoInf;
import com.yolo.model.AccountSearchVO;
import com.yolo.model.AccountSeniorVO;
import com.yolo.model.AccountVO;
import com.yolo.model.DutchVO;
@Repository("accountDao")
public class AccountDao implements AccountDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public int accountInsert(AccountVO accountVO) {
		return sessionTemplate.insert("account.accountInsert", accountVO);
	}

	@Override
	public int dutchInsert(List<DutchVO> dutchVOList) {
		return sessionTemplate.insert("account.dutchInsert",dutchVOList);
	}

	@Override
	public List<AccountVO> getAccountMain(int chat_seq) {	
		return sessionTemplate.selectList("account.getAccountMain", chat_seq);
	}

	@Override
	public List<AccountSeniorVO> getAccountDetil(int account_seq) {
		return sessionTemplate.selectList("account.getAccountDetail", account_seq);
												   
	}

	@Override
	public int accountDelete(int account_seq) {
		return sessionTemplate.delete("account.accountDelete", account_seq);
	}

	@Override
	public List<AccountVO> accountSearch(AccountSearchVO accountSearchVO) {
		return sessionTemplate.selectList("account.accountSearch", accountSearchVO);
	}
	
}
