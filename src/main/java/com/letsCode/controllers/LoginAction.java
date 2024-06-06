//$Id$
package com.letsCode.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.Model.Accounts;
import com.letsCode.dao.AccountsDao;
import com.letsCode.dao.CardsDao;
import com.letsCode.service.EncryptionService;
import com.letsCode.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Accounts>, SessionAware{
	
    private Accounts account = new Accounts();
    private String AccountHolderName;
    private Map<String, Object> session;


    public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}
	
	public void validate() {
        int AccountNumber;
		try {
			AccountNumber=AccountsDao.getAccountNumber(account.getNetBankingUserId());
			if (!AccountsDao.getNetBankingPassword(AccountNumber).equals(EncryptionService.encrypt(account.getNetBankingPassword()))) {
				addFieldError("NetBankingPassword", "NetBanking Password is incorrect");
			    
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		

		
	}

	
	public String execute() throws Exception {
        LoginService loginService = new LoginService();
//        System.out.println(account.getNetBankingUserId());
//        System.out.println(account.getNetBankingPassword());

        if (loginService.authenticateUser(account.getNetBankingUserId(), account.getNetBankingPassword())) {
//        	System.out.println(account.getNetBankingUserId()); 
//        	AccountsDao accountsDao=new AccountsDao();
        	int accountNumber=AccountsDao.getAccountNumber(account.getNetBankingUserId());
//        	int accountNumber=123456;

            int balance = AccountsDao.getAccountBalance(accountNumber);
            session.put("balance", balance);
	            String EncryptedAccountNumber=EncryptionService.encrypt(String.valueOf(accountNumber));
	            String EncryptedNetBankingUserId=EncryptionService.encrypt(account.getNetBankingUserId());
	            System.out.println(EncryptedAccountNumber);
	            int dec=Integer.parseInt(EncryptionService.removePadding((EncryptionService.decrypt(EncryptedAccountNumber))));
//	            System.out.println(dec);
	            setAccountHolderName(AccountsDao.getAccountHolderName(accountNumber));
//        	System.out.println(EncryptionService.encrypt(EncryptionService.padAccountNumber(accountNumber)));
//        	System.out.println(EncryptionService.removePadding((EncryptionService.decrypt(acc))) );
	        
	        HttpSession httpsession = ServletActionContext.getRequest().getSession();
	        httpsession.setAttribute("NetBankingUserId", EncryptedNetBankingUserId);
	        httpsession.setAttribute("accountNumber", EncryptedAccountNumber);

	            System.out.println(httpsession);
	            System.out.println(httpsession.getAttribute("NetBankingUserId"));
	        session.put("NetBankingUserId", EncryptedNetBankingUserId);
            session.put("accountNumber", EncryptedAccountNumber);
//            session.put("loggedIn", true);
//            System.out.println("httpsession is  " + httpsession);
//            System.out.println("session is" + session);
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

	public String getAccountHolderName() {
		return AccountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}


}
