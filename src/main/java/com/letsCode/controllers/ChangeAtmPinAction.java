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
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
		int pin=AccountsDao.getAtmPin(AccountNumber,getCardNumber());
		System.out.println(pin);
		System.out.println(getOldPin());
		System.out.println(getNewPin());
		System.out.println(CardNumber);
		if(pin == getOldPin()) {
			
//			System.out.println(AccountsDao.ChangeAtmPin(AccountNumber,NewPin,CardNumber));
			if((AccountsDao.ChangeAtmPin(AccountNumber,NewPin,getCardNumber()))>0) {
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
