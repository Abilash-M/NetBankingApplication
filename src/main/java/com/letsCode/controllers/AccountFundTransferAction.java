//$Id$
package com.letsCode.controllers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.TransactionsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountFundTransferAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private int ToAccountNumber;
	public int getToAccountNumber() {
		return ToAccountNumber;
	}



	public void setToAccountNumber(int toAccountNumber) {
		ToAccountNumber = toAccountNumber;
	}

	private int Amount;
	 
	
		@Override
		public String execute() throws Exception {
	        LocalDate today = LocalDate.now();
	        String todaysDate=today.toString();
	        int AccountNumber=Integer.parseInt((EncryptionService.decrypt(String.valueOf(session.get("accountNumber")) )));
	        int rows=TransactionsDao.transferFunds(AccountNumber, getToAccountNumber(), getAmount(), todaysDate);
			return SUCCESS;
		}

		

		public int getAmount() {
			return Amount;
		}

		public void setAmount(int amount) {
			Amount = amount;
		}

		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;		
			
		}
	
}
