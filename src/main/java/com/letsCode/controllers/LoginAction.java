//$Id$
package com.letsCode.controllers;

import java.util.Map;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.Model.Accounts;
import com.letsCode.dao.AccountsDao;
import com.letsCode.service.EncryptionService;
import com.letsCode.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Accounts>, SessionAware{
	
    private Accounts account = new Accounts();
    private Map<String, Object> session;
    


    public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}
	


	
	public String execute() throws Exception {
        LoginService loginService = new LoginService();
//        System.out.println(account.getNetBankingUserId());
//        System.out.println(account.getNetBankingPassword());

        if (loginService.authenticateUser(account.getNetBankingUserId(), account.getNetBankingPassword())) {
        	System.out.println(account.getNetBankingUserId()); 
//        	AccountsDao accountsDao=new AccountsDao();
        	int accountNumber=AccountsDao.getAccountNumber(account.getNetBankingUserId());
//        	int accountNumber=123456;
        	 int balance = AccountsDao.getAccountBalance(accountNumber);
	            session.put("balance", balance);
	            String EncryptedAccountNumber=EncryptionService.encrypt(String.valueOf(accountNumber));
	            System.out.println(EncryptedAccountNumber);
	            int dec=Integer.parseInt(EncryptionService.removePadding((EncryptionService.decrypt(EncryptedAccountNumber))));
	            System.out.println(dec);
//        	System.out.println(EncryptionService.encrypt(EncryptionService.padAccountNumber(accountNumber)));
//        	System.out.println(EncryptionService.removePadding((EncryptionService.decrypt(acc))) );
            session.put("accountNumber", EncryptedAccountNumber);
            session.put("loggedIn", true);
            return "home";
        } else {
            return "login";
        }
    }

	@Override
	public Accounts getModel() {
		return account;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
}
