//$Id$
package com.letsCode.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.letsCode.service.EncryptionService;

public class AccountsDao {
	public boolean createAccount(int accountNumber, String accountHolderName, int phoneNumber, String email, String address, String city, String userId, String password,String DateOfBirth,int AccountBalance) throws Exception {
        try {
        	System.out.println();
            Connection connection = DatabaseConnection.initializeDatabaseConnection();
            Map<String, Object> values = new HashMap<>();
            values.put("AccountNumber", accountNumber);
            values.put("AccountHolderName", accountHolderName);
            values.put("PhoneNumber", phoneNumber);
            values.put("EmailId", email);
            values.put("ResidentialAddress", address);
            values.put("ResidentialCity", city);
            values.put("NetBankingUserId", userId);
            values.put("NetBankingPassword", EncryptionService.encrypt_password(password));
            values.put("DateOfBirth", DateOfBirth);
            values.put("AccountBalance", AccountBalance);
            int rowsInserted = DatabaseConnection.insert(connection, "AccountDetailsTable", values);
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
	public static int getAccountBalance(int accountNumber) throws Exception {
		Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM AccountDetailsTable WHERE AccountNumber=?";
    	int Balance=0;
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,accountNumber);
        for (Map<String, Object> row : result) {
            Balance=(int)row.get("AccountBalance");
            Integer accountBalanceInteger = (Integer) row.get("AccountBalance");
            if (accountBalanceInteger != null) {
                Balance = accountBalanceInteger.intValue();
            }
        }
        return Balance; 
    }

    public String getNetbankingPassword(int accountNumber) {
                return ""; 
    }
    
    public static int getAccountNumber(String NetBankingUserId) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM AccountDetailsTable WHERE NetBankingUserId=?";
    	int accountNumber=0;
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,NetBankingUserId);
        for (Map<String, Object> row : result) {
//            accountNumber=(int)row.get("AccountNumber");
        	Integer accountNumberInteger = (Integer) row.get("AccountNumber");
            if (accountNumberInteger != null) {
                accountNumber = accountNumberInteger.intValue();
            }
        
        }
        return accountNumber;
    }
    public static String getNetBankingPassword(int AccountNumber) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM AccountDetailsTable WHERE AccountNumber=?";
    	String password="";
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,AccountNumber);
        for (Map<String, Object> row : result) {
            password=(String)row.get("NetBankingPassword");
        	
        }
        return password;
    }
   
    public static int ChangeNetBankingPassword(int AccountNumber,String NewPassword) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	Map<String, Object> values = new HashMap<>();
        values.put("NetBankingPassword", NewPassword);
        values.put("AccountNumber", AccountNumber);
        int rowsAffected = DatabaseConnection.update(connection, "AccountDetailsTable", values, "AccountNumber");
        return rowsAffected;
    }
    
    public static int getAtmPin(int AccountNumber) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM DebitCreditCardTable WHERE AccountNumber=?";
    	int pin=0;
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,AccountNumber);
        for (Map<String, Object> row : result) {
            pin=(int)row.get("ATMPin");
        	
        }
        return pin;
    }
    
    public static int ChangeAtmPin(int AccountNumber,int NewPin) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	Map<String, Object> values = new HashMap<>();
        values.put("ATMPin", NewPin);
        values.put("AccountNumber", AccountNumber);
        int rowsAffected = DatabaseConnection.update(connection, "DebitCreditCardTable", values, "AccountNumber");
        return rowsAffected;
    }
    
	
}
