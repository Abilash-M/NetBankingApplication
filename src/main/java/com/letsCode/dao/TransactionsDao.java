//$Id$
package com.letsCode.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class TransactionsDao {
	public static List<Map<String, Object>> getTransactions(String FromDate,String ToDate,int AccountNumber) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM TransactionTable WHERE TransactionDate BETWEEN ? AND ? AND FromAccountNumber = ?";

    	int accountNumber=0;
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,FromDate,ToDate,AccountNumber);

        return result;
    }
}
