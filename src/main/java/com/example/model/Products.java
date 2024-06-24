package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class Products implements Serializable{
	private int productCode;
	private String categoryName;
	private String productName;
	private String description;
	private int discount;
	private int cost;
	private String productImage1;
	private String productImage2;
	private String productImage3;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int productCode, String categoryName, String productName, String description, int discount,
			int cost, String productImage1, String productImage2, String productImage3) {
		super();
		this.productCode = productCode;
		this.categoryName = categoryName;
		this.productName = productName;
		this.description = description;
		this.discount = discount;
		this.cost = cost;
		this.productImage1 = productImage1;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getProductImage1() {
		return productImage1;
	}
	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}
	public String getProductImage2() {
		return productImage2;
	}
	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}
	public String getProductImage3() {
		return productImage3;
	}
	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	

	// Add record to category table
	public int AddProduct() {
		int n = 0;
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		if (conn == null) {
			n = 0;
		} else {
			try {
				String qry = "insert into products(productCode,categoryName,productName,description,discount,cost,productImage1,productImage2,productImage3)values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(qry);

				pst.setInt(1, this.productCode);
				pst.setString(2, this.categoryName);
				pst.setString(3, this.productName);
				pst.setString(4, this.description);
				pst.setInt(5, this.discount);
				pst.setInt(6, this.cost);
				pst.setString(7, this.productImage1);
				pst.setString(8, this.productImage2);
				pst.setString(9, this.productImage3);

				n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

			} catch (Exception e) {
				
				n = 0;
				System.out.println("add Product error="+e);
			}

		}
		return n;
	}
	
	
	public List<Products> getAllProducts(String search){
		
		List<Products> productList=new ArrayList<Products>();
	
		try {
			DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();
		    
		    String qry="";
		    if(search==null) {
		     qry="select productCode,categoryName,productName,description,discount,cost,productImage1,productImage2,productImage3 from products order by productName";
		    }else {  //for search products
		    	search = search.toLowerCase();
		    	String words[] = search.split(" ");
		    	String columnNames[] = {"categoryName", "productName", "description"};
		    	qry="select productCode,categoryName,productName,description,discount,cost,productImage1,productImage2,productImage3 from products where ";
		    	
		    	for(String word: words) {
		    		for (String colName: columnNames) {
		    			qry+= "lower("+colName +") like '%" + word + "%' or ";
		    		}
		    	}
		    	
		    	qry = qry.substring(0, qry.length()-3);
		    	
		    	qry +=" order by categoryName, productName";
		    	System.out.println("qry=" + qry);	
		    	
		    }
		    
		    
		    Statement st=(Statement) conn.createStatement();
		    ResultSet rs=st.executeQuery(qry);
		    
		    while(rs.next()) {
		    	Products product= new Products();
		    	product.setProductCode(rs.getInt("productCode"));
		    	product.setCategoryName(rs.getString("categoryName"));
				product.setProductName(rs.getString("productName"));
				product.setDescription(rs.getString("description")); // Set the description parameter
				product.setDiscount(rs.getInt("discount"));
				product.setCost(rs.getInt("cost"));
				product.setProductImage1(rs.getString("productImage1"));
				product.setProductImage2(rs.getString("productImage2"));
				product.setProductImage3 (rs.getString("productImage3"));

			
		    	productList.add(product);
		    }
		}catch(Exception e) {
			System.out.println("Error:getAllProducts..:" +e);
			
		}
		return productList;
	}
	

		    		
		    		
		public Products getProductByCode() {
			Products productRow =new Products();
			try {
				DBConnection db=new DBConnection();
				Connection conn=db.getConnection();
				String qry="select productCode,categoryName,productName,description,discount,cost,productImage1,productImage2,productImage3 from products where productCode=?";
				PreparedStatement pst=conn.prepareStatement(qry);
				
				pst.setInt(1, this.productCode);
				//System.out.println("qry111="+pst.toString());
				ResultSet rs=pst.executeQuery();
				
				if(rs.next()) {
					productRow.setProductCode(rs.getInt("productCode"));
					productRow.setCategoryName(rs.getString("categoryName"));
					productRow.setProductName(rs.getString("productName"));
					productRow.setDescription(rs.getString("description"));
					productRow.setDiscount(rs.getInt("discount"));
					productRow.setCost(rs.getInt("cost"));
					productRow.setProductImage1(rs.getString("productImage1"));
					productRow.setProductImage2(rs.getString("productImage2"));
					productRow.setProductImage3(rs.getString("productImage3"));
				}else {
					productRow=null;
				}
				
			}catch(Exception e) {
				System.out.println("Error11: "+e);
			}
			return productRow;
		}
		
		
		
		public boolean deleteProductByCode() {
			boolean flag=false;
			try {
				DBConnection db = new DBConnection();
			    Connection conn = db.getConnection();
				
			    String qry="delete from products where productCode=?";
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


		
		public int UpdateProductByCode() {
		    int n = 0;
		    try {
		    DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();

		       String qry = "update products set categoryName=?, productName=?, description=?, discount=?,cost=? where productCode=?";
		            PreparedStatement pst = conn.prepareStatement(qry);
		           
		            pst.setString(1, this.categoryName);
		            pst.setString(2, this.productName);
		            pst.setString(3, this.description);
		            pst.setInt(4, this.discount);
		            pst.setInt(5, this.cost);
		            pst.setInt(6, this.productCode);

		            n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

		        } catch (Exception e) {
		            n=0;
		        } 
		    return n; 
		}


	}

