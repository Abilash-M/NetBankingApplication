//$Id$
package com.letsCode.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.letsCode.Model.Card;
import com.letsCode.service.EncryptionService;

public class CardsDao {

    
//    public static List<Map<String, Object>> FindCardFromAccountNumber(int accountNumber) throws Exception {
//    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
//    	String sql = "SELECT * FROM DebitCreditCardTable WHERE AccountNumber=?";
//
//        List<Map<String, Object>>result = DatabaseConnection.select(connection, sql,accountNumber);
//
//        return result;
//    }
    public static List<Map<String, Object>> FindCardFromAccountNumber(int accountNumber) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM DebitCreditCardTable WHERE AccountNumber=?";
        List<Map<String, Object>>result = DatabaseConnection.select(connection, sql,accountNumber);
        return result;
    }
    
    public static List<Map<String, Object>> FindCardFromAccountNumber(int accountNumber,String cardType) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM DebitCreditCardTable WHERE AccountNumber=? && CardType=?";
        List<Map<String, Object>>result = DatabaseConnection.select(connection, sql,accountNumber,cardType);
        return result;
    }
   
    public static int BlockCard(int CardNumber) throws Exception {
    	    
    	    Connection connection = DatabaseConnection.initializeDatabaseConnection();
        	Map<String, Object> values = new HashMap<>();
    	    values.put("CardNumber",CardNumber);
            values.put("CardStatus", "Blocked");
            values.put("CardNumber", CardNumber);
            int rowsAffected = DatabaseConnection.update(connection, "DebitCreditCardTable", values, "CardNumber");



        return rowsAffected;
    }
    
    public static boolean AllotNewCard(Card card) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
        Map<String, Object> values = new HashMap<>();
        values.put("AccountNumber",card.getAccountNumber());
        values.put("CardNumber",card.getCardNumber());
        values.put("ExpiryDate",card.getExpiryDate());
        values.put("Cvv",card.getCvv());
        values.put("NameOnCard",card.getNameOnCard());
        values.put("ATMPin",card.getATMPIn());
        values.put("CardType",card.getCardType());
      values.put("CreditLimit",card.getCreditLimit());
        int rowsInserted = DatabaseConnection.insert(connection,"DebitCreditCardTable",values);
        return rowsInserted > 0;
    }
}
 // todo for tomorow:create model cards and use that here to fetch and update the details.