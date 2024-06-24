package com.example.model;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;
public class wishlist implements Serializable {
	private int wishId;
	private int productCode;
	private int customerId;
	private  String wishlistDate;
	public wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public wishlist(int wishId, int productCode, int customerId, String wishlistDate) {
		super();
		this.wishId = wishId;
		this.productCode = productCode;
		this.customerId = customerId;
		this.wishlistDate = wishlistDate;
	}
	public int getWishId() {
		return wishId;
	}
	public void setWishId(int wishId) {
		this.wishId = wishId;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getWishlistDate() {
		return wishlistDate;
	}
	public void setWishlistDate(String wishlistDate) {
		this.wishlistDate = wishlistDate;
	}
	
	public int addWishList() {
		int n=0;
		try{
			DBConnection db=new DBConnection();
			Connection conn=db.getConnection();
			
			

			String qry = "insert into wishlist(productCode,customerId,wishlistDate) values(?,?,?)";

			PreparedStatement pst = conn.prepareStatement(qry);
			pst.setInt(1, this.productCode);
			
			pst.setInt(2, this.customerId);
			pst.setString(3, this.wishlistDate);
			
			n = pst.executeUpdate();

		
		}catch(Exception e) {
			System.out.println("error: "+e);
		}
		return n;
	}
	
	

	public List<Products> getAllWishListProductsByCustomerId(int customerId) {
		List<Products> ProductList = new ArrayList<Products>();
		int n = 0;

		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			String qry = "SELECT * from products where productcode in (select productCode from wishlist where customerId=?)";
			PreparedStatement st=conn.prepareStatement(qry);
			st.setInt(1, customerId);
			ResultSet rs = st.executeQuery();

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


	public boolean deleteWishlistItemByProducCode() {
		boolean flag=false;
		try {
			DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();
			
		    String qry="delete from wishlist where productCode=?";
		    PreparedStatement pst=conn.prepareStatement(qry);
		    pst.setInt(1,  this.productCode);
		    
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

