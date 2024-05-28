//$Id$
package com.letsCode.Model;

public class Accounts {
	private int AccountNumber;
	private String AccountHolderName;
	private int PhoneNumber;
	private String EmailId;
	private String ResidentialAddress;
	private String ResidentialCity;
	private String NetBankingUserId;
	private String NetBankingPassword;
	private String DateOfBirth;
	private int AccountBalance;
	private String TransactionPassword;
	

	public Accounts(int AccountNumber, String AccountHolderName, int PhoneNumber, String EmailId, String ResidentialAddress, String ResidentialCity, String NetBankingUserId, String NetBankingPassword, String DateOfBirth,int AccountBalance,String TransactionPassword) {
		this.AccountNumber = AccountNumber;
		this.AccountHolderName = AccountHolderName;
        this.PhoneNumber = PhoneNumber;
        this.EmailId = EmailId;
        this.ResidentialAddress = ResidentialAddress;
        this.ResidentialCity =ResidentialCity;
        this.NetBankingUserId =NetBankingUserId;
        this.NetBankingPassword =NetBankingPassword;
        this.DateOfBirth =DateOfBirth;
        this.AccountBalance=AccountBalance;
        this.TransactionPassword=TransactionPassword;

	}
	
	public Accounts(String AccountHolderName, int PhoneNumber, String EmailId, String ResidentialAddress, String ResidentialCity, String NetBankingUserId, String NetBankingPassword, String DateOfBirth,int AccountBalance,String TransactionPassword) {
		this.AccountNumber = 0;
		this.AccountHolderName = AccountHolderName;
        this.PhoneNumber = PhoneNumber;
        this.EmailId = EmailId;
        this.ResidentialAddress = ResidentialAddress;
        this.ResidentialCity =ResidentialCity;
        this.NetBankingUserId =NetBankingUserId;
        this.NetBankingPassword =NetBankingPassword;
        this.DateOfBirth =DateOfBirth;
        this.AccountBalance=AccountBalance;
        this.TransactionPassword=TransactionPassword;

	}
	
	public Accounts(String NetBankingUserId, String NetBankingPassword) {
        this.NetBankingUserId =NetBankingUserId;
        this.NetBankingPassword =NetBankingPassword;
		this.AccountNumber = 0;
		this.AccountHolderName = null;
        this.PhoneNumber = 0;
        this.EmailId = null;
        this.ResidentialAddress = null;
        this.ResidentialCity =null;
        this.DateOfBirth =null;
        this.AccountBalance=0;
        this.TransactionPassword=null;
	}
	public Accounts() {
		this.AccountNumber = 0;
		this.AccountHolderName = null;
        this.PhoneNumber = 0;
        this.EmailId = null;
        this.ResidentialAddress = null;
        this.ResidentialCity =null;
        this.NetBankingUserId =null;
        this.NetBankingPassword =null;
        this.DateOfBirth =null;
        this.AccountBalance=0;
        this.TransactionPassword=null;


	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}

	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getResidentialAddress() {
		return ResidentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		ResidentialAddress = residentialAddress;
	}

	public String getNetBankingUserId() {
		return NetBankingUserId;
	}
	public void setNetBankingUserId(String netBankingUserId) {
		NetBankingUserId = netBankingUserId;
	}
	public String getNetBankingPassword() {
		return NetBankingPassword;
	}
	public void setNetBankingPassword(String netBankingPassword) {
		NetBankingPassword = netBankingPassword;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getResidentialCity() {
		return ResidentialCity;
	}
	public void setResidentialCity(String residentialCity) {
		ResidentialCity = residentialCity;
	}

	public int getAccountBalance() {
		return AccountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		AccountBalance = accountBalance;
	}

	public String getTransactionPassword() {
		return TransactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		TransactionPassword = transactionPassword;
	}

}
