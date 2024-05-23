//$Id$
package com.letsCode.controllers;

import java.time.LocalDate;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.AccountsDao;
import com.letsCode.dao.TransactionsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionSupport;

public class MobileNumberFundTransferAction extends ActionSupport implements SessionAware{
	private int ToPhoneNumber;
	private int Amount;
	public int getToPhoneNumber() {
		return ToPhoneNumber;
	}

	public void setToPhoneNumber(int toPhoneNumber) {
		ToPhoneNumber = toPhoneNumber;
	}

	Map<String, Object> session;
	@Override
	public String execute() throws Exception {
        LocalDate today = LocalDate.now();
        String todaysDate=today.toString();
		 int ToAccountNumber=AccountsDao.getAccountNumberFromPhoneNumber(getToPhoneNumber());
         int AccountNumber=Integer.parseInt((EncryptionService.decrypt(String.valueOf(session.get("accountNumber")) )));
         int rows=TransactionsDao.transferFunds(AccountNumber, ToAccountNumber, getAmount(), todaysDate);

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
}
