
package com.letsCode.controllers;

import java.io.InputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.letsCode.dao.TransactionsDao;
import com.letsCode.service.EncryptionService;
import com.letsCode.Model.Transactions;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
//import jakarta.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;



public class AccountStatementDownloadAction extends ActionSupport implements SessionAware{
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
		
			

	        int AccountNumber=Integer.parseInt((EncryptionService.decrypt((String)session.get("accountNumber"))));
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=\"StatementTable.pdf\"");
	        OutputStream out = response.getOutputStream();
	        PdfWriter writer = new PdfWriter(out);
	        PdfDocument pdf = new PdfDocument(writer);
	        Document document = new Document(pdf);
//	        Table table = new Table(5);
	        pdf.addNewPage();

	        float colWidth[]= {80,300,100,80};
	        Table table = new Table(colWidth);
	        
	     //   String para = "Its working"; 
	     // Creating an Area Break    
	  //   Paragraph parag = new Paragraph (para); 
	        
	        Cell cell1 = new Cell();   
          cell1.add(new Paragraph("Name"));
//
//	        cell1.add("Name");         
	        table.addCell(cell1);          
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

	     // Loop through the headers array to add header cells to the table
//	     for (String header : headers) {
//	         table.addHeaderCell(new Cell().add(new Paragraph(header)));
//	     }
	        document.add(table);
	        document.close();

	        
	        

	        return NONE;
	        
	        
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
	
}

   
