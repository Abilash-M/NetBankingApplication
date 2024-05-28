//$Id$
package com.letsCode.controllers;

import com.letsCode.Model.Accounts;
import com.letsCode.dao.AccountsDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OpenAccountsAction extends ActionSupport implements ModelDriven<Accounts>{
	
		private Accounts accounts=new Accounts();
//	 private String accountHolderName;
//	    private String phoneNumber;
//	    private String email;
//	    private String address;
//	    private String city;
//	    private String userId;
//	    private String password;

		
		@Override
		public void validate() {
//			if(!accounts.equals(null)) {

			if (accounts.getAccountHolderName() == null || accounts.getAccountHolderName().trim().isEmpty()) {
				addFieldError("AccountHolderName", "Account Holder Name is required");
	            
	        }
			if (accounts.getPhoneNumber() == 0) {
	            addFieldError("PhoneNumber", "Phone Number is required");	            
	        }
			if (accounts.getEmailId() == null || accounts.getEmailId().trim().isEmpty()) {
	            addFieldError("EmailId", "Email Id is required");	            
	        }
			if (accounts.getResidentialAddress() == null || accounts.getResidentialAddress().trim().isEmpty()) {
	            addFieldError("ResidentialAddress", "Residential Address is required");	            
	        }
			if (accounts.getResidentialCity() == null || accounts.getResidentialCity().trim().isEmpty()) {
	            addFieldError("ResidentialCity", "Residential City is required");	            
	        }
			if (accounts.getNetBankingUserId() == null || accounts.getNetBankingUserId().trim().isEmpty()) {
	            addFieldError("NetBankingUserId", "Netbanking UserId is required");
	        }
			if (accounts.getNetBankingPassword() == null || accounts.getNetBankingPassword().trim().isEmpty()) {
	            addFieldError("NetBankingPassword", "NetBanking Password is required");	            
	        }
			if (accounts.getTransactionPassword() == null || accounts.getTransactionPassword().trim().isEmpty()) {
	            addFieldError("TransactionPassword", "TransactionPassword is required");	            
	        }
			if (accounts.getDateOfBirth() == null ) {
	            addFieldError("DateOfBirth", "Date Of Birth is required");	            
	        }
			if (accounts.getAccountBalance() == 0 ) {
	            addFieldError("AccountBalance", "Please specify an Opening balance");	            
	        }}

		//}
		
	    public Accounts getAccounts() {
			return accounts;
		}


		public void setAccounts(Accounts accounts) {
			this.accounts = accounts;
		}


		public String execute() throws Exception {
	        AccountsDao accountsDao = new AccountsDao();
	        if(accountsDao.createAccount(accounts.getAccountHolderName(), accounts.getPhoneNumber(), accounts.getEmailId(), accounts.getResidentialAddress(), accounts.getResidentialCity(), accounts.getNetBankingUserId(), accounts.getNetBankingPassword(),accounts.getDateOfBirth(),accounts.getAccountBalance(),accounts.getTransactionPassword())) {
	            return SUCCESS; 
	        } else {
	            return ERROR; 
	        }
	    }


		@Override
		public Accounts getModel() {
			return accounts;

		}
}
