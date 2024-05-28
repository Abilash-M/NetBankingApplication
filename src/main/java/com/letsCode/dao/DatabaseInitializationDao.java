//$Id$
package com.letsCode.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseInitializationDao {
    private static final String DB_NAME = "NetBankingApplication";

	    public static void initializeDatabase() throws Exception {
	    	try {
	    		CreateDatabaseIfNotExists();
	            CreateTables();
//	            System.out.println("Database initialized");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    private static void CreateDatabaseIfNotExists() throws SQLException, ClassNotFoundException {
	        try (Connection connection = DatabaseConnection.initializeDatabaseConnection();
	             Statement statement = connection.createStatement()) {
	            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+DB_NAME);
	        }
	    }

	    private static void CreateTables() throws Exception {
	    	try (Connection connection = DatabaseConnection.initializeDatabaseConnection();
		             Statement statement = connection.createStatement()) {
		            InputStream inputStream = DatabaseInitializationDao.class.getResourceAsStream("schema.sql");
		            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		            String line;
		            StringBuilder stringBuilder = new StringBuilder();
		            while ((line = reader.readLine())!= null) {
		                stringBuilder.append(line).append("\n");
		            }
		            String[] sqlCommands = stringBuilder.toString().split(";");
		            for (String sqlCommand : sqlCommands){
		                if (!sqlCommand.trim().isEmpty()){
		                    statement.execute(sqlCommand.trim());
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	    
	    }
	    
	}
