//$Id$
package com.letsCode.controllers;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.service.EncryptionService;
import com.letsCode.service.SessionService;
import com.opensymphony.xwork2.ActionSupport;


public class CardRequestAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String CardType;
	@Override
	public String execute() throws Exception {

//        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt(String.valueOf(SessionService.getSessionAttribute("accountNumber")))));
        String CardType=getCardType();
        if(CardType.equals("Debit")) {
        	
        }
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	public String getCardType() {
		return CardType;
	}

	public void setCardType(String cardType) {
		CardType = cardType;
	}
}