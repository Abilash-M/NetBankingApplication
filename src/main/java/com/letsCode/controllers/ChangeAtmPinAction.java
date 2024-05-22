//$Id$
package com.letsCode.controllers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.AccountsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeAtmPinAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private int CardNumber ;

	public int getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
	private int OldPin;

	public int getOldPin() {
		return OldPin;
	}
	public void setOldPin(int oldPin) {
		OldPin = oldPin;
	}
	private int NewPin;

	public int getNewPin() {
		return NewPin;
	}
	public void setNewPin(int newPin) {
		NewPin = newPin;
	}
	@Override
	public String execute() throws Exception {
		int AccountNumber=(int)session.get("accountNumber"); 
		int pin=AccountsDao.getAtmPin(AccountNumber);
		if( pin==getOldPin()) {
			if((AccountsDao.ChangeAtmPin(AccountNumber,NewPin))>0) {
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
