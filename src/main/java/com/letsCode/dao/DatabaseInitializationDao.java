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
	    		createDatabaseIfNotExists();
	            createTables();
	            System.out.println("Database initialized successfully.");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    private static void createDatabaseIfNotExists() throws SQLException, ClassNotFoundException {
	        try (Connection connection = DatabaseConnection.initializeDatabaseConnection();
	             Statement statement = connection.createStatement()) {
	            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
	        }
	    }

	    private static void createTables() throws Exception {
	    	try (Connection connection = DatabaseConnection.initializeDatabaseConnection();
		             Statement statement = connection.createStatement()) {

		            InputStream inputStream = DatabaseInitializationDao.class.getResourceAsStream("schema.sql");
		            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		            String line;
		            StringBuilder sqlBuilder = new StringBuilder();
		            while ((line = reader.readLine()) != null) {
		                sqlBuilder.append(line).append("\n");
		            }
		            String[] sqlCommands = sqlBuilder.toString().split(";");
		            for (String sqlCommand : sqlCommands) {
		                if (!sqlCommand.trim().isEmpty()) {
		                    statement.execute(sqlCommand.trim());
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	    
	    }
	    
	}
