//$Id$
package com.letsCode.controllers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.AccountsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BalanceEnquiryAction extends ActionSupport implements SessionAware{
//	private int accountNumber;
//    public int getAccountNumber() {
//		return accountNumber;
//	}
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	private Map<String, Object> session;
	public String execute() throws Exception {
		
//		 Map<String, Object> session = ActionContext.getContext().getSession();

//	        Object accountNumberObj = session.get("accountNumber");
//	        String accountNumberObj = (String)session.get("accountNumber");
//            int accountNumber=Integer.parseInt((EncryptionService.decrypt(accountNumberObj)));
            int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));

            int balance = AccountsDao.getAccountBalance(AccountNumber);
            session.put("balance", balance);
            return SUCCESS;

            
//	        if (accountNumberObj instanceof Integer) {
//	            accountNumber = (int) accountNumberObj;
//	            int balance = AccountsDao.getAccountBalance(accountNumber);
//	            session.put("balance", balance);
//	            return SUCCESS;
//	        } else {
//	            session.put("balance", 0);
//	            return SUCCESS;
//	        }
    }
	@Override
	public void setSession(Map<String, Object> session) {
        this.session = session;
		
	}
}
