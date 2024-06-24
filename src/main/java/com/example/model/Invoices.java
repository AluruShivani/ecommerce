package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class Invoices implements Serializable{
	
	private Long orderId;
	private Long invoiceNumber;
	private int invoiceAmount;
	private String invoiceDate;
	private String invoiceType;
	private String cardNumber;
	private String cardType;
	private String paymentStatus;
	public Invoices() {
		super();
	}
	public Invoices( Long orderId, Long invoiceNumber, int invoiceAmount, String invoiceDate,
			String invoiceType, String cardNumber, String cardType, String paymentStatus) {
		super();
		
		this.orderId = orderId;
		this.invoiceNumber = invoiceNumber;
		this.invoiceAmount = invoiceAmount;
		this.invoiceDate = invoiceDate;
		this.invoiceType = invoiceType;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.paymentStatus = paymentStatus;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public int getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(int invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	public int addInvoices() {
		int n = 0;
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		if (conn == null) {
			n = 0;
		} else {
			try {
				String qry = "insert into invoices(orderId,invoiceNumber,invoiceAmount,invoiceDate,invoiceType,cardNumber,cardType,paymentStatus)values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(qry);
				
				pst.setLong(1, this.orderId);
				pst.setLong(2, this.invoiceNumber);
				pst.setInt(3, this.invoiceAmount);
				pst.setString(4, this.invoiceDate);
				pst.setString(5, this.invoiceType);
				pst.setString(6, this.cardNumber);
				pst.setString(7, this.cardType);
				pst.setString(8, this.paymentStatus);
				
				System.out.println("invoice qry="+pst.toString());
				n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

			} catch (Exception e) {
				n = 0;
			}

		}
		return n;
	}
	
	public List<Invoices> getAllInvoices(){
		List<Invoices> invoicesList=new ArrayList<Invoices>();
		
		try {
			DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();
		    
		    String qry="select invoiceNumber,orderId,invoiceAmount,invoiceDate,invoiceType,cardNumber,cardType,paymentStatus from invoices order by orderId";
		    Statement st=(Statement) conn.createStatement();
		    ResultSet rs=st.executeQuery(qry);
		    
		    while(rs.next()) {
		    	Invoices invoices= new Invoices();
		    	invoices.setInvoiceNumber(rs.getLong("invoiceNumber"));
		    	invoices.setOrderId(rs.getLong("orderId"));
		    	invoices.setInvoiceAmount(rs.getInt("invoiceAmount"));
		    	invoices.setInvoiceDate(rs.getString("invoiceDate"));
		    	invoices.setInvoiceType(rs.getString("invoiceType")); // Set the description parameter
		    	invoices.setCardNumber(rs.getString("cardNumber"));
		    	invoices.setCardType(rs.getString("cardType"));
		    	invoices.setPaymentStatus(rs.getString("paymentStatus"));
		    	
		    	
			
		    	invoicesList.add(invoices);
		    }
		}catch(Exception e) {
			System.out.println("Error:getAllInvoices..:" +e);
			
		}
		return invoicesList;
	}
	

	
}