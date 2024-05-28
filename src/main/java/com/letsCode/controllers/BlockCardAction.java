//$Id$
package com.letsCode.controllers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.AccountsDao;
import com.letsCode.dao.CardsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionSupport;

public class BlockCardAction extends ActionSupport implements SessionAware{
	private int CardNumber ;
	private Map<String, Object> session;

	private String TransactionPassword;

	@Override
	public String execute() throws Exception {
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
		if(AccountsDao.getTransactionPassword(AccountNumber).equals(EncryptionService.encrypt(getTransactionPassword()))) {

		int rowsAffected=CardsDao.BlockCard(getCardNumber());
		if( (rowsAffected)>0) {
		return SUCCESS;
		}
		}
		return SUCCESS;
	}

	public int getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}

	public String getTransactionPassword() {
		return TransactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		TransactionPassword = transactionPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
}
