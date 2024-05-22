//$Id$
package com.letsCode.Model;

public class Transactions {
	private int TransactionId;
	private int FromAccountNumber;
	private int ToAccountNumber;
	private int TransactionValue;
	private String TransactionDate;
	private String TransactionType;
	
	
	public Transactions(int TransactionId, int FromAccountNumber, int ToAccountNumber, int TransactionValue, String TransactionDate, String TransactionType) {
		this.TransactionId = TransactionId;
		this.FromAccountNumber = FromAccountNumber;
        this.ToAccountNumber = ToAccountNumber;
        this.TransactionValue = TransactionValue;
        this.TransactionDate = TransactionDate;
        this.TransactionType =TransactionType;
	}
	
	
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	public int getFromAccountNumber() {
		return FromAccountNumber;
	}
	public void setFromAccountNumber(int fromAccountNumber) {
		FromAccountNumber = fromAccountNumber;
	}
	public int getToAccountNumber() {
		return ToAccountNumber;
	}
	public void setToAccountNumber(int toAccountNumber) {
		ToAccountNumber = toAccountNumber;
	}
	public String getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	public int getTransactionValue() {
		return TransactionValue;
	}
	public void setTransactionValue(int transactionValue) {
		TransactionValue = transactionValue;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
}
