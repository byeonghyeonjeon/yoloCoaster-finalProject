/**
 * 
 */
package com.yolo.yolo.dao.chat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.yolo.dao.chat.inf.AccountDaoInf;
import com.yolo.init.TestInit;
import com.yolo.model.DutchVO;

/**
 * @author PC15
 *
 */
public class AccountDaoTest extends TestInit{
	@Resource(name="accountDao")
	private AccountDaoInf accountDao; 

	@Test
	public void DutchInsertTest() {
		/**given**/
		List<DutchVO> dutchVOList = new ArrayList<DutchVO>();
		DutchVO dutchVO1 = new DutchVO();		
		dutchVO1.setAccount_seq(1);
		dutchVO1.setDutch_mem_id("하나");
		dutchVO1.setDutch_money(8000);
		
		DutchVO dutchVO21 = new DutchVO();		
		dutchVO21.setAccount_seq(1); 
		dutchVO21.setDutch_mem_id("둘");
		dutchVO21.setDutch_money(8000);
		
		dutchVOList.add(dutchVO1);
		dutchVOList.add(dutchVO21);		
		/**when**/
		int cnt = accountDao.dutchInsert(dutchVOList);
		/**assert**/
		assertNotNull(cnt);
		
	}

}
