//$Id$
package com.letsCode.controllers;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.CardsDao;
import com.letsCode.service.EncryptionService;
import com.letsCode.service.SessionService;
import com.opensymphony.xwork2.ActionSupport;

public class FetchCardAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
    private List<Map<String, Object>> cards;
	@Override
	public String execute() throws Exception {
		System.out.println("new sssion"+session);
//        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt(String.valueOf(SessionService.getSessionAttribute("accountNumber")))));
		setCards(CardsDao.FindCardFromAccountNumber(AccountNumber)); 		
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Map<String, Object>> getCards() {
		return cards;
	}

	public void setCards(List<Map<String, Object>> cards) {
		this.cards = cards;
	}
}