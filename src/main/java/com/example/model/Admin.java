package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbutil.DBConnection;

public class Admin implements Serializable {
	
	private String username;
	private String password;
	private String role;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean validateAdminLogin() {
	    boolean flag = false;
	    DBConnection db = new DBConnection();
	    Connection conn = db.getConnection();

	    if (conn == null) {
	        flag = false;
	    } else {
	        try {
	            String qry = "select * from admin where username=? and password=? and role=?";

	            PreparedStatement pst = conn.prepareStatement(qry);
	            pst.setString(1, this.username);
	            pst.setString(2, this.password);
	            pst.setString(3, this.role);
	            
	           

	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	            	
	                flag = true;
	                
	            } else {
	                flag = false;
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e);
	           
	        }
	    }

	    return flag;
	}
	
	
	

}