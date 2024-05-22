//$Id$
package com.letsCode.service;

import java.sql.*;
import java.util.*;

import com.letsCode.dao.DatabaseConnection;

public class LoginService {
//    private DatabaseConnection connection;

	public LoginService() {
//        this.connection = new DatabaseConnection();
    }
	
	

    public boolean authenticateUser(String userName, String password) throws Exception {
    	Connection connection = DatabaseConnection.initializeDatabaseConnection();
    	String sql = "SELECT * FROM AccountDetailsTable WHERE NetBankingUserId=?";
    	String NetBankingUserName="";
    	String NetBankingPassword="";
        List<Map<String, Object>> result = DatabaseConnection.select(connection, sql,userName);
        for (Map<String, Object> row : result) {
            NetBankingUserName=(String)row.get("NetBankingUserId");
            NetBankingPassword=(String)row.get("NetBankingPassword");
        }
        if(NetBankingUserName.equals(userName) && NetBankingPassword.equals(EncryptionService.encrypt_password(password))) {
        	return true;
        }
        else {
        	
        	return false;
        }
//        return databaseConnection.validateCredentials(username, password);
    }
}
