
package com.letsCode.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.letsCode.dao.TransactionsDao;
import com.letsCode.service.EncryptionService;
import com.letsCode.service.SessionService;
import com.letsCode.Model.Transactions;
import com.letsCode.config.StartupListener;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
//import jakarta.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;



public class AccountStatementDownloadAction extends ActionSupport implements SessionAware{
    private static final int BUFFER_SIZE = 4096;
	private InputStream inputStream;
	private Map<String, Object> session;
	 private String FromDate;
	    public String getFromDate() {
			return FromDate;
		}

		public void setFromDate(String fromDate) {
			FromDate = fromDate;
		}

		private String ToDate;


	    public String getToDate() {
			return ToDate;
		} 

		public void setToDate(String toDate) {
			ToDate = toDate;
		}

	 @Override
	    public String execute() throws Exception {
		
			

//	        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
	        int AccountNumber=Integer.parseInt((EncryptionService.decrypt(String.valueOf(SessionService.getSessionAttribute("accountNumber")))));
	        HttpServletResponse response = ServletActionContext.getResponse();
//	        response.setContentType("application/pdf");
//	        response.setHeader("Content-Disposition", "attachment; filename=\"StatementTable.pdf\"");
	        response.setContentType("text/csv");
	        response.setHeader("Content-Disposition", "attachment; filename=\"StatementTable.csv\"");
	        OutputStream out = response.getOutputStream();
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
	        List<Map<String,Object>> transactions = TransactionsDao.getTransactions(getFromDate(),getToDate(),AccountNumber); 
//	        for (Map<String, Object> transaction : transactions) {
	        writer.write("From Account,To Account,Transaction Value,Transaction Date,Transaction Type");
	        writer.newLine();
	        for (Map<String, Object> transaction : transactions) {
	        	writer.write(transaction.get("FromAccountNumber")+"," + transaction.get("ToAccountNumber") + "," + transaction.get("TransactionValue")+ "," + transaction.get("TransactionDate") + ","  + transaction.get("TransactionType"));
	        	writer.newLine();
	        }
	        writer.flush();
	        writer.close();
	        
	        
//	        OutputStream out = response.getOutputStream();
//	        PdfWriter writer = new PdfWriter(out);
//	        PdfDocument pdf = new PdfDocument(writer);
//	        Document document = new Document(pdf);
////	        Table table = new Table(5);
//	        pdf.addNewPage();
//
//	        float colWidth[]= {80,300,100,80};
//	        Table table = new Table(colWidth);
//	        
//	     //   String para = "Its working"; 
//	     // Creating an Area Break    
//	  //   Paragraph parag = new Paragraph (para); 
//	        
//	        Cell cell1 = new Cell();   
//          cell1.add(new Paragraph("Name"));
	        
//	        cell1.add("Name");         
//	        table.addCell(cell1);          
//
//	        // Adding cell 2 to the table Cell 
//	        Cell cell2 = new Cell();      
//	        cell2.add("Raju");        
//	        table.addCell(cell2);     
//	        table.addCell(new Cell().add(new Paragraph("To")));
//	        table.addCell(new Cell().add("To"));

//	        table.addHeaderCell(new Cell().add(new Paragraph("Transaction ID")));
//            table.addHeaderCell(new Cell().add(new Paragraph("To")));
//            table.addHeaderCell(new Cell().add(new Paragraph("Amount")));
//            table.addHeaderCell(new Cell().add(new Paragraph("Date")));
//            table.addHeaderCell(new Cell().add(new Paragraph("Type")));
//	        List<Map<String,Object>> transactions = TransactionsDao.getTransactions(getFromDate(),getToDate(),AccountNumber); 
//	        for (Map<String, Object> transaction : transactions) {
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(transaction.get("TransactionId")))));
//                table.addCell(new Cell().add(new Paragraph( transaction.get("ToAccountNumber").toString())));
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(transaction.get("TransactionValue")))));
//                table.addCell(new Cell().add(new Paragraph(transaction.get("TransactionDate").toString())));
//                table.addCell(new Cell().add(new Paragraph((String) transaction.get("TransactionType"))));
//            }
	        
//	        String[] headers = {"Transaction ID", "To", "Amount", "Date", "Type"};

//	      Loop through the headers array to add header cells to the table
//	     for (String header : headers) {
//	         table.addHeaderCell(new Cell().add(new Paragraph(header)));
//	     }
//	        document.add(table);
//	        document.close();

	        
	        

	        return NONE;
	        
	        
	    }
	 
	 public void createFile(int AccountNumber) {
//     	String filepath=StartupListener.class.getResource("../../../../DbInit.xml").getPath();
		 	String filePath=StartupListener.class.getResource("./").getPath();
//		    String filePath="/home/abilash-tt0378/Documents/e-commerce-program/" + ""+ "customer_details.txt";//for customers
		     File accountStatement= new File(filePath);
		    try (BufferedWriter writer=getFileWriter(accountStatement,true)){
		    	
		    	 List<Map<String,Object>> transactions = TransactionsDao.getTransactions(getFromDate(),getToDate(),AccountNumber); 
//			        for (Map<String, Object> transaction : transactions) {
		    	writer.write("From Account"+ " "+"To Account"+ " " + "Transaction Value" + " "+ "Transaction Date"+" " +"Transaction Type");
		    	writer.newLine();
		        for (Map<String, Object> transaction : transactions) {
		        	writer.write(transaction.get("FromAccountNumber")+" " + transaction.get("ToAccountNumber") + " " + transaction.get("TransactionValue")+ " " + transaction.get("TransactionDate") + " "  + transaction.get("TransactionType"));
		        }
		        // writer.close();
		    } catch (Exception e) {
		        // TODO: handle exception
		    }
	 }
	 
	 
	 public static void downloadFile() throws IOException {
		 String filePath = "path/to/your/textfile.txt"; 
	        File downloadFile = new File(filePath);

	        HttpServletResponse response = ServletActionContext.getResponse();

	        response.setContentType("application/octet-stream");
	        response.setContentLength((int) downloadFile.length());
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setHeader(headerKey, headerValue);

	        try (InputStream inStream = new FileInputStream(downloadFile);
	             OutputStream outStream = response.getOutputStream()) {

	            byte[] buffer = new byte[BUFFER_SIZE];
	            int bytesRead;

	            while ((bytesRead = inStream.read(buffer)) != -1) {
	                outStream.write(buffer, 0, bytesRead);
	            }

	            outStream.flush();
	        }

	 }

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
    public BufferedWriter getFileWriter(File file) throws IOException {
        return new BufferedWriter(new FileWriter(file, true));
    }

    public static BufferedWriter getFileWriter(File file, boolean append) throws IOException {
        return new BufferedWriter(new FileWriter(file, append));
    }
	
}

   
