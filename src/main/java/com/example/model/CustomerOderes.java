package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class CustomerOderes implements Serializable {
	private Long orderId;
	private int customerId;
	private long invoiceNumber;
	private int productCode;
	private int cost;
	private int discountAmount;
	private int quantity;
	private int gstAmount;
	private int billAmount;
	private String orderStatus;
	private String OrderDateTime;
	
	public CustomerOderes() {
		super();
	}
	
	
	
	public CustomerOderes(Long orderId, int customerId, long invoiceNumber, int productCode, int cost,
			int discountAmount, int quantity, int gstAmount, int billAmount, String orderStatus, String orderDateTime) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.invoiceNumber = invoiceNumber;
		this.productCode = productCode;
		this.cost = cost;
		this.discountAmount = discountAmount;
		this.quantity = quantity;
		this.gstAmount = gstAmount;
		this.billAmount = billAmount;
		this.orderStatus = orderStatus;
		OrderDateTime = orderDateTime;
	}



	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId2) {
		this.orderId = orderId2;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuatity(int quatity) {
		this.quantity = quatity;
	}
	
	public int getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(int gstAmount) {
		this.gstAmount = gstAmount;
	}

	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}


	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDateTime() {
		return OrderDateTime;
	}
	public void setOrderDateTime(String orderDateTime) {
		OrderDateTime = orderDateTime;
	}
	
	public int addCustomerOrder() {
		int n = 0;
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		if (conn == null) {
			n = 0;
		} else {
			try {
				String qry = "insert into customerorders(orderId,customerId,invoiceNumber,productCode,orderDateTime,cost,discountAmount,quantity,gstAmount,billAmount,orderStatus)values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(qry);

				pst.setLong(1, this.orderId);
				pst.setInt(2, this.customerId);
				pst.setLong(3, this.invoiceNumber);
				pst.setInt(4, this.productCode);
				pst.setString(5, this.OrderDateTime);
				pst.setInt(6, this.cost);
				pst.setInt(7, this.discountAmount);
				pst.setInt(8, this.quantity);
				pst.setInt(9, this.gstAmount);
				pst.setInt(10, this.billAmount);
				pst.setString(11, this.orderStatus);

				System.out.println("qry="+pst.toString());//de-bugging method
				n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

			} catch (Exception e) {
				n = 0;
			}

		}
		return n;
	}
	
		public List<CustomerOderes> getAllCustomerOderes(){
			List<CustomerOderes> customerordersList=new ArrayList<>();
			
			try {
				DBConnection db = new DBConnection();
			    Connection conn = db.getConnection();
			    
			    String qry = "select orderId, customerId, invoiceNumber, productCode, orderDateTime, cost, discountAmount, quantity, gstAmount, billAmount, orderStatus from customerorders order by customerId";

			    Statement st=(Statement) conn.createStatement();
			    
			    ResultSet rs=st.executeQuery(qry);
			    
			    while(rs.next()) {
			    	CustomerOderes customerorders= new CustomerOderes();
			    	customerorders.setOrderId(rs.getLong("orderId"));
			    	customerorders.setCustomerId(rs.getInt("customerId"));
			    	customerorders.setInvoiceNumber(rs.getLong("invoiceNumber"));
			    	customerorders.setProductCode(rs.getInt("productCode")); // Set the description parameter
			    	customerorders.setOrderDateTime(rs.getString("orderDateTime"));
			    	customerorders.setCost(rs.getInt("cost"));
			    	customerorders.setDiscountAmount(rs.getInt("discountAmount"));
			    	customerorders.setQuantity(rs.getInt("quantity"));
			    	customerorders.setGstAmount(rs.getInt("gstAmount"));
			    	customerorders.setBillAmount (rs.getInt("billAmount"));
			    	customerorders.setOrderStatus (rs.getString("orderStatus"));

				
			    	customerordersList.add(customerorders);
			    }
			}catch(Exception e) {
				System.out.println("Error:getAllCustomerOrders..:" +e);
				
			}
			return customerordersList;
		}
		
		
		public int customerOrderStatusUpdate(long orderId,String orderStatus) {
			int n=0;
			try {
				DBConnection db = new DBConnection();
			    Connection conn = db.getConnection();
			    String qry="update customerorders set orderStatus=? where orderId=?";
			    PreparedStatement pst = conn.prepareStatement(qry);
			    
			    pst.setString(1, orderStatus);
			    pst.setLong(2, orderId);
			    
			   n= pst.executeUpdate();
			    
			}catch(Exception e) {
				System.out.println("Error:getAllCustomerOrders..:" +e);
				
		}
			return n;
		
		}
}


