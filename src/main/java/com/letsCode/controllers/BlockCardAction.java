//$Id$
package com.letsCode.controllers;

import com.letsCode.dao.CardsDao;
import com.opensymphony.xwork2.ActionSupport;

public class BlockCardAction extends ActionSupport{
	private int CardNumber ;

	@Override
	public String execute() throws Exception {
		int rowsAffected=CardsDao.BlockCard(getCardNumber());
		if( (rowsAffected)>0) {
		return SUCCESS;
		}
		return SUCCESS;
	}

	public int getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
}
