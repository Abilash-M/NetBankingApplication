//$Id$
package com.letsCode.dao;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;
import static java.util.Collections.nCopies;

public class DatabaseConnection {
	 public static Connection initializeDatabaseConnection() throws ClassNotFoundException, SQLException{
	        String Database_Driver = "com.mysql.cj.jdbc.Driver";
	        String Database_UserName="root";
	        String Database_password="Ass@102002";
	        String Database_Url="jdbc:mysql://127.0.0.1/NetBankingApplication";
	        Class.forName(Database_Driver);
	        Connection con= DriverManager.getConnection(Database_Url ,Database_UserName ,Database_password);
	        return con;
	    }
	    public static int insert(Connection conn, String table, Map<String, Object> values) throws Exception {
	    List<String> columns = new ArrayList<>();
	    List<Object> columnValues = new ArrayList<>();
	    for(Map.Entry<String, Object> entry : values.entrySet()) {
	        columns.add("`" + entry.getKey() + "`"); 
	        columnValues.add(entry.getValue()); 
	    }
	    String query = "INSERT INTO `" + table + "` (" + String.join(",", columns) + ") VALUES ("
	                 + String.join(",", nCopies(columns.size(), "?")) + ")";
	    
//	        System.out.println(query);
	    PreparedStatement ps = conn.prepareStatement(query);
	    for(int i = 0; i < columnValues.size(); i++) {
	        ps.setObject(i + 1, columnValues.get(i));
	    }
	    int rowsAffected = ps.executeUpdate();
	    return rowsAffected;
	}
	    

	    public static List<Map<String, Object>> select(Connection conn, String sql, Object... params) throws Exception {
	        List<Map<String, Object>> rows = new ArrayList<>();
	        try(PreparedStatement ps = conn.prepareStatement(sql)) {
	            for(int i = 0; i < params.length; i++) {
	                ps.setObject(i+1, params[i]);
	            }
	            try(ResultSet rs = ps.executeQuery()) {
	                int columnCount = rs.getMetaData().getColumnCount();
	                while(rs.next()) {
	                    Map<String, Object> row = new HashMap<>();
	                    for(int i = 1; i <= columnCount; i++) {
	                        String columnName = rs.getMetaData().getColumnName(i);
	                        Object columnValue = rs.getObject(i);
	                        row.put(columnName, columnValue);
	                    }
	                    rows.add(row);
	                }
	            }
	        }

	        return rows;
	    }
	    

	        
	        
	    public static int update(Connection conn, String table, Map<String, Object> values, String condition) throws Exception {
	    StringBuilder queryBuilder = new StringBuilder("UPDATE `").append(table).append("` SET ");
	    for(String column : values.keySet()) {
	        queryBuilder.append("`").append(column).append("`").append("=?, ");
	    }
	    queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()); 
	    queryBuilder.append(" WHERE ").append(condition).append(" =?");
//	        System.out.println(queryBuilder);
	    PreparedStatement ps = conn.prepareStatement(queryBuilder.toString());
	    int index = 1;
	    for(Object value : values.values()) {
	        ps.setObject(index++, value);
	    }
	    ps.setObject(index++,values.get(condition));
	    int rowsAffected = ps.executeUpdate();
	    ps.close();
	    return rowsAffected;
	}
	    
	    public static int update(Connection conn, String table, Map<String, Object> values, String condition,String condition2) throws Exception {
	    StringBuilder queryBuilder = new StringBuilder("UPDATE `").append(table).append("` SET ");
	    for(String column : values.keySet()) {
	        queryBuilder.append("`").append(column).append("`").append("=?, ");
	    }
	    queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()); 
	    queryBuilder.append(" WHERE ").append(condition).append(" =? AND ").append(condition2).append(" =?");
//	        System.out.println(queryBuilder);
	    PreparedStatement ps = conn.prepareStatement(queryBuilder.toString());
	    int index = 1;
	    for(Object value : values.values()) {
	        ps.setObject(index++, value);
	    }
	    ps.setObject(index++,values.get(condition));
	    ps.setObject(index++,values.get(condition2));

	    int rowsAffected = ps.executeUpdate();
	    ps.close();
	    
	    return rowsAffected;
	}

}
