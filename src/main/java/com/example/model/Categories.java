package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class Categories implements Serializable {
	private int categoryid;
	private String categoryname;

	public Categories() {
		super();
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int AddCategory() {
		int n = 0;

		try {
			DBConnection db = new DBConnection();// can b write in the before try block
			Connection conn = db.getConnection();
			String qry = "INSERT INTO category ( categoryname) VALUES (?)";
			PreparedStatement pst = conn.prepareStatement(qry);
			pst.setString(1, this.categoryname);

			n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

		} catch (Exception e) {
			e.printStackTrace(); // Handle the exception properly, e.g., log it
		}

		return n;
	}

	public List<Categories> getAllCategories() {
		List<Categories> categoryList = new ArrayList<Categories>();
		int n = 0;

		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();

			String qry = "SELECT categoryid, categoryname FROM category ORDER BY categoryid";
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(qry);

			// You might want to process the ResultSet here
			while (rs.next()) {
				Categories category = new Categories();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				categoryList.add(category);

			}

		} catch (Exception e) {
			e.printStackTrace(); // Handle the exception properly, e.g., log it
		}

		return categoryList;
	}

	public boolean DeleteCategoryById() {
	    boolean flag = false;

	    try {
	        DBConnection db = new DBConnection();
	        Connection conn = db.getConnection();
	        String qry = "DELETE FROM category WHERE categoryid=?";
	        PreparedStatement pst = conn.prepareStatement(qry);
	        pst.setInt(1, this.categoryid);

	        int n = pst.executeUpdate(); // Use executeUpdate for DELETE
	        if (n > 0) {
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle the exception properly, e.g., log it
	    }

	    return flag;
	}

	//get category record by id
		public Categories getCategoryById() {
			Categories categoryRow =new Categories();
			try {
				DBConnection db=new DBConnection();
				Connection conn=db.getConnection();
				String qry="select categoryId, categoryName from category where categoryId=?";
				PreparedStatement pst=conn.prepareStatement(qry);
				pst.setInt(1, this.categoryid);
				
				
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()) {
					categoryRow.setCategoryid(rs.getInt("categoryId"));
					categoryRow.setCategoryname(rs.getString("categoryName"));
				}else {
					categoryRow=null;
				}
				
			}catch(Exception e) {
				System.out.println("Error: "+e);
			}
			return categoryRow;
		}
		
		
		
		
		//update category table  by id
		public int updateCategoryById() {
		    int n = 0;
		    try {
		    DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();

		       String qry = "update category set categoryName=? where categoryId=?";
		            PreparedStatement pst = conn.prepareStatement(qry);
		           
		            pst.setString(1, this.categoryname);
		            pst.setInt(2, this.categoryid);

		            n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

		        } catch (Exception e) {
		            n=0;
		        } 
		    return n;
		    
		}
		
		
		public List<String> getAllCategoriesByName() {
			List<String> categoryList = new ArrayList<String>();
			int n = 0;

			try {
				DBConnection db = new DBConnection();
				Connection conn = db.getConnection();

				String qry = "SELECT  categoryname FROM category ORDER BY categoryname";
				Statement st = conn.createStatement();

				ResultSet rs = st.executeQuery(qry);

				// You might want to process the ResultSet here
				while (rs.next()) {
					
					categoryList.add(rs.getString("categoryName"));
					
				}

			} catch (Exception e) {
				e.printStackTrace(); // Handle the exception properly, e.g., log it
			}

			return categoryList;
		}
}


