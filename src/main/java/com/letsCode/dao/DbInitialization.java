//$Id$
package com.letsCode.dao;
import java.io.File;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.letsCode.config.StartupListener;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;

public class DbInitialization {
	String primaryKeyColumnName = null;
	public static void initializeTables() {
        try {
//        	String fullPath = context.getRealPath("/WEB-INF/test/foo.txt");
//        	System.out.println(StartupListener.class.getResource("../../../..").getPath());
        	String filepath=StartupListener.class.getResource("../../../../DbInit.xml").getPath();
            File xmlFile=new File(filepath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc=dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList tableList = doc.getElementsByTagName("table");
            for (int i = 0;i<tableList.getLength();i++) {
                Node tableNode = tableList.item(i);
                if(tableNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element tableElement =(Element) tableNode;
                    String tableName = tableElement.getAttribute("name");
                    NodeList columnList = tableElement.getElementsByTagName("column");
                    StringBuilder foreignKeyConstraints= new StringBuilder();
                    StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (");
                    for(int j = 0; j < columnList.getLength(); j++){
                        Node columnNode = columnList.item(j);
                        if(columnNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element columnElement = (Element) columnNode;
                            String columnName = columnElement.getAttribute("name");
                            String dataType = columnElement.getElementsByTagName("data-type").item(0).getTextContent();
                            boolean nullable = getBooleanFromElement(columnElement,"nullable",true);
                            boolean primaryKey=getBooleanFromElement(columnElement,"primary-key",false);
                            boolean unique = getBooleanFromElement(columnElement,"unique",false);
                            boolean autoIncrement =getBooleanFromElement(columnElement,"auto-increment",false);
                            boolean foreignKey =getBooleanFromElement(columnElement,"foreign-key",false);
                            String referenceTable = foreignKey ? columnElement.getElementsByTagName("reference-table").item(0).getTextContent() : "";
                            String referenceColumn = foreignKey ?  columnElement.getElementsByTagName("reference-column").item(0).getTextContent() : "";

                            
                            
                            String defaultValue = "";
                            if(columnElement.getElementsByTagName("default-value").getLength() > 0) {
                                defaultValue = " DEFAULT " + columnElement.getElementsByTagName("default-value").item(0).getTextContent();
                            }
                            createTableQuery.append(columnName).append(" ").append(dataType);
                            if(!nullable) {
                                createTableQuery.append(" NOT NULL");
                            }
                            if(unique) {
                            	createTableQuery.append(" UNIQUE");
                            }
                            if(primaryKey) {
                                createTableQuery.append(" PRIMARY KEY");
                            }
                            if(autoIncrement) {
                            	createTableQuery.append(" AUTO_INCREMENT");
                            }
                            if(foreignKey) {
                                foreignKeyConstraints.append(", FOREIGN KEY (").append(columnName).append(") REFERENCES ");
                                foreignKeyConstraints.append(referenceTable).append("(").append(referenceColumn).append( ")");
                            }

                            createTableQuery.append(defaultValue).append(",");
                        }
                    }
                    createTableQuery.deleteCharAt(createTableQuery.length() - 1);
                    createTableQuery.append(foreignKeyConstraints);
                    createTableQuery.append(")");
//                    System.out.println(createTableQuery.toString());
                    executeQuery(createTableQuery.toString());
                }
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
	private static boolean getBooleanFromElement(Element element, String tagName, boolean defaultValue) {
		if(element.getElementsByTagName(tagName).getLength() > 0) {
			return Boolean.parseBoolean(element.getElementsByTagName(tagName).item(0).getTextContent());
		}
		return defaultValue;
		
	}
    
    
    private static void executeQuery(String query) {
        try {
            Connection conn =  DatabaseConnection.initializeDatabaseConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
