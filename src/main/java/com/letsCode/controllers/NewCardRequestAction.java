//$Id$
package com.letsCode.controllers;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.Model.Card;
import com.letsCode.dao.AccountsDao;
import com.letsCode.dao.CardsDao;
import com.letsCode.service.CardService;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionSupport;

public class NewCardRequestAction extends ActionSupport implements SessionAware{
	private String CardType;
	private Map<String, Object> session;
	@Override
	public String execute() throws Exception {
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
        System.out.println(CardsDao.FindCardFromAccountNumber(AccountNumber,CardType));
        if(CardsDao.FindCardFromAccountNumber(AccountNumber,CardType).isEmpty()) {
        	Card card=new Card(AccountNumber,CardService.generateRandomNumber(9),CardService.generateExpiryDate(),CardService.generateRandomNumber(3),AccountsDao.GetAccountHolderName(AccountNumber),CardService.generateRandomNumber(4),"Debit",0);
        	if(CardsDao.AllotNewDebitCard(card)) {
        		return SUCCESS;

        	}
        }
		return ERROR;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
}