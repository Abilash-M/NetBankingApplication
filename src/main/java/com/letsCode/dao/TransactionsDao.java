//$Id$
package com.letsCode.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsDao {
	public static List<Map<String, Object>> getTransactions(String FromDate,String ToDate,int AccountNumber) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM TransactionTable WHERE TransactionDate BETWEEN ? AND ? AND FromAccountNumber = ?";
    	

//    	System.out.println("After Date "+ FromDate);
//    	int accountNumber=0;
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,FromDate,ToDate,AccountNumber);

        return result;
    }
	
	public static int transferFunds(int FromAccountNumber,int ToAccountNumber,int Amount,String PresentDate) throws Exception {
		if(AccountsDao.debitAmountFromAccount(FromAccountNumber,Amount)) {
			AccountsDao.creditAmountToAccount(ToAccountNumber,Amount);
			Connection connection = DatabaseConnection.initializeDatabaseConnection();
	    	 Map<String,Object> values = new HashMap<>();
	         values.put("FromAccountNumber", FromAccountNumber);
	         values.put("ToAccountNumber", ToAccountNumber);
	         values.put("TransactionValue", Amount);
	         values.put("TransactionDate", PresentDate);
	         values.put("TransactionType", "transfer");
	         int rowsAffected= DatabaseConnection.insert(connection,"TransactionTable",values);
	        return rowsAffected;
		}
    	return 0;
    }
	
		
}
