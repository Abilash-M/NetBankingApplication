//$Id$
package com.letsCode.controllers;

import java.util.Map;
 
import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.AccountsDao;
import com.letsCode.service.EncryptionService;
import com.letsCode.service.SessionService;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
	private String OldPassword;
	public String getOldPassword() {
		return OldPassword;
	}
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}
	private String NewPassword;
	public String getNewPassword() {
		return NewPassword;
	}
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}
	private String ConfirmNewPassword;
	public String getConfirmNewPassword() {
		return ConfirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		ConfirmNewPassword = confirmNewPassword;
	}
	@Override
	public String execute() throws Exception {
//		int AccountNumber=(int)session.get("accountNumber"); 
//        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt(String.valueOf(SessionService.getSessionAttribute("accountNumber")))));
		String password=AccountsDao.getNetBankingPassword(AccountNumber);
//		System.out.println(AccountNumber);
//		System.out.println(OldPassword);
//		System.out.println(NewPassword);
//		System.out.println(ConfirmNewPassword);
//		System.out.println(password);


		if(getNewPassword().equals(getConfirmNewPassword()) && password.equals(EncryptionService.encrypt(getOldPassword()))) {
			if((AccountsDao.ChangeNetBankingPassword(AccountNumber,EncryptionService.encrypt(getNewPassword())))>0) {
				return SUCCESS;
			}
		}
		return ERROR;
		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		

	}
}
