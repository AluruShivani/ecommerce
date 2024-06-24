package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class Cart implements Serializable {
	private int cartId;
	private int customerId;
	private int productCode;
	private String selectedDate;

	public Cart() {
		super();
	}

	
	public Cart(int cartId, int customerId, int productCode, String selectedDate) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.productCode = productCode;
		this.selectedDate = selectedDate;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getProductCode() {
		return productCode;
	}


	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}


	public String getSelectedDate() {
		return selectedDate;
	}


	public void setSelectedDate(String today) {
		this.selectedDate = today;
	}


	public int addToCart() {
		int n=0;
		try {
			DBConnection db=new DBConnection();
			Connection conn=db.getConnection();
			
			String qry="insert into cart(productCode, selectedDate,customerId)values(?,?,?)";
			
			PreparedStatement pst=conn.prepareStatement(qry);
			pst.setInt(1, this.productCode);
			 pst.setString(2,  this.selectedDate);
			 pst.setInt(3, this.customerId);
			 
			n=pst.executeUpdate();
		}catch(Exception e) {
			System.out.println("error: "+e);
		}
		return n;
	}

	public List<Products> getAllCartProductsByCustomerId(int customerId) {
		List<Products> ProductList = new ArrayList<Products>();
		int n = 0;

		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			String qry = "SELECT productcode,categoryname,productname,description,discount,cost,productimage1,productimage2,productimage3 from products where productcode in (select productCode from cart where customerId=?)";
			PreparedStatement pst=conn.prepareStatement(qry);
			pst.setInt(1, customerId);
			ResultSet rs = pst.executeQuery();

			// You might want to process the ResultSet here
			while (rs.next()) {
				Products product = new Products();
				product.setProductCode(rs.getInt("productCode"));
				product.setCategoryName(rs.getString("categoryName"));
				product.setProductName(rs.getString("productName"));
				product.setDescription(rs.getString("description"));
				product.setDiscount(rs.getInt("discount"));
				product.setCost(rs.getInt("cost"));
				product.setProductImage1(rs.getString("productImage1"));
				product.setProductImage2(rs.getString("productImage2"));
				product.setProductImage3(rs.getString("productImage3"));
				
				ProductList.add(product);

			}

		} catch (Exception e) {
			System.out.println(e); // Handle the exception properly, e.g., log it
		}

		return ProductList;
	}


	public boolean deleteCartByCustomerId(int customerId) {
		boolean flag=false;
		try {
			DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();
			
		    String qry="DELETE FROM cart WHERE customerId = ?";
		    PreparedStatement pst=conn.prepareStatement(qry);
		    pst.setInt(1, customerId);
		    System.out.println("dlt qry="+pst.toString());
		    int n=pst.executeUpdate();
		    
		    if(n==0) {
		    	flag=false;
		    }else {
		    	flag=true;
		    }
		}catch(Exception e){
			flag=false;
			
		}
		return flag;
	}
}