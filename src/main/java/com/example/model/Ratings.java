package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class Ratings implements Serializable {
	
		private int ratingId;
		private int productCode;
		private  int rating;
		private String comments;
		private int customerId;
		private Date date;
		public Ratings() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Ratings(int ratingId, int productCode, int rating, String comments, int customerId, Date date) {
			super();
			this.ratingId = ratingId;
			this.productCode = productCode;
			this.rating = rating;
			this.comments = comments;
			this.customerId = customerId;
			this.date=date;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getRatingId() {
			return ratingId;
		}
		public void setRatingId(int ratingId) {
			this.ratingId = ratingId;
		}
		public int getProductCode() {
			return productCode;
		}
		public void setProductCode(int productCode) {
			this.productCode = productCode;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		public int addRatings() {
			int n=0;
			try{
				DBConnection db=new DBConnection();
				Connection conn=db.getConnection();
				
				

				String qry = "insert into rating (productCode,rating,comments,customerId,date) values(?,?,?,?,?)";

				PreparedStatement pst = conn.prepareStatement(qry);
				
				pst.setInt(1, this.productCode);
				pst.setInt(2, this.rating);
				pst.setString(3, this.comments);
				pst.setInt(4, this.customerId);
				pst.setDate(5, Date.valueOf(LocalDate.now()));

				n = pst.executeUpdate();

			
			}catch(Exception e) {
				System.out.println("error: "+e);
			}
			return n;
		}
		
		

		public boolean isRatingGiven(int customerId,int productCode) {
			boolean flag=false;
			
			try{
				DBConnection db=new DBConnection();
				Connection conn=db.getConnection();
			
			String qry="select ratingId from rating where customerId=? and productCode=?";
			PreparedStatement pst = conn.prepareStatement(qry);
			pst.setInt(1, customerId);
			pst.setInt(2, productCode);
			System.out.println("rating qry="+pst.toString());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			
			}catch(Exception e){
				System.out.println("error:"+e);
			}
			return flag;
			
		}
		
		public List<Ratings> getAllRatings() {
	        List<Ratings> ratingList = new ArrayList<>();
	        try {
	            DBConnection db = new DBConnection();
	            Connection conn = db.getConnection();

	            String query = "SELECT * FROM rating";
	            PreparedStatement pst = conn.prepareStatement(query);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	                Ratings rating = new Ratings();
	                rating.setRatingId(rs.getInt("ratingId"));
	                rating.setProductCode(rs.getInt("productCode"));
	                rating.setRating(rs.getInt("rating"));
	                rating.setComments(rs.getString("comments"));
	                rating.setCustomerId(rs.getInt("customerId"));
	                ratingList.add(rating);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ratingList;
		}
		
		 public int updateRating(int ratingId, int rating, String comments) {
		        int rowsAffected = 0;
		        try {
		            DBConnection db = new DBConnection();
		            Connection conn = db.getConnection();

		            String query = "UPDATE rating SET rating=?, comments=? WHERE ratingId=?";
		            PreparedStatement pst = conn.prepareStatement(query);
		            pst.setInt(1, rating);
		            pst.setString(2, comments);
		            pst.setInt(3, ratingId);

		            rowsAffected = pst.executeUpdate();
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            // Handle the exception appropriately
		        }
		        return rowsAffected;
		    }
		

		 
		 public static boolean deleteRating(int ratingId) {
		        boolean deleted = false;
		        try {
		            DBConnection db = new DBConnection();
		            Connection conn = db.getConnection();

		            String query = "DELETE FROM rating WHERE ratingId=?";
		            PreparedStatement pst = conn.prepareStatement(query);
		            
		            System.out.println("qry="+pst.toString());
		            pst.setInt(1, ratingId);

		            int rowsAffected = pst.executeUpdate();
		            if (rowsAffected > 0) {
		                deleted = true;
		            }
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return deleted;
		    }
		 
		 
		 public List<Ratings> getRatingsByProductCode(int productCode){
				List<Ratings> ratingList=new ArrayList<Ratings>();

				try {
					DBConnection db = new DBConnection();
				    Connection conn = db.getConnection();
				    
				    String qry="select * from rating where productCode=?";
					
					PreparedStatement pst = conn.prepareStatement(qry);
					 pst.setInt(1, productCode);
				    
					ResultSet rs = pst.executeQuery();
				    
				    while(rs.next()) {
				    	Ratings rating= new Ratings();
				    	rating.setRatingId(rs.getInt("ratingId"));
				    	rating.setCustomerId(rs.getInt("customerId"));
				    	rating.setRating(rs.getInt("rating"));
				    	rating.setComments(rs.getString("comments"));
				    	rating.setProductCode(rs.getInt("productCode")); // Set the description parameter
				    	

					
				    	ratingList.add(rating);
				    }
				}catch(Exception e) {
					System.out.println("Error:getAllCustomerOrders..:" +e);
					
				}
				return ratingList;
				}

		 public static Ratings getRatingById(int ratingId) {
		        Ratings rating = null;
		        try {
		            DBConnection db = new DBConnection();
		            Connection conn = db.getConnection();

		            String query = "SELECT * FROM rating WHERE ratingId=?";
		            PreparedStatement pst = conn.prepareStatement(query);
		            pst.setInt(1, ratingId);
		            ResultSet rs = pst.executeQuery();
		            System.out.println("rating:"+pst.toString());

		            if (rs.next()) {
		                rating = new Ratings();
		                rating.setRatingId(rs.getInt("ratingId"));
		                rating.setProductCode(rs.getInt("productCode"));
		                rating.setRating(rs.getInt("rating"));
		                rating.setComments(rs.getString("comments"));
		                rating.setCustomerId(rs.getInt("customerId"));
		            }
		            conn.close();
		        } catch (Exception e) {
		            System.out.println("Error: "+e);
		        }
		        return rating;
		    }

		}
