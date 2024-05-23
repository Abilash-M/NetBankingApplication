//$Id$
package com.letsCode.controllers;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.TransactionsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionSupport;

public class AccountStatementAction extends ActionSupport implements SessionAware{
//	private int accountNumber;
    private Map<String, Object> session;

    
	public List<Map<String, Object>> transactions;
    private String FromDate;
    public String getFromDate() {
		return FromDate;
	}

	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}

	private String ToDate;


    public String getToDate() {
		return ToDate;
	} 

	public void setToDate(String toDate) {
		ToDate = toDate;
	}

	public String execute() throws Exception {
        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));

        transactions = TransactionsDao.getTransactions(FromDate, ToDate,AccountNumber);
        System.out.println(FromDate);
        return SUCCESS;
    }

	@Override
	public void setSession(Map<String, Object> session) {
        this.session = session;
		
	}

}
