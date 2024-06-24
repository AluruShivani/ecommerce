package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dbutil.DBConnection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Customer implements Serializable {
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private String password;
	private String profilePic;
	private String registerDate;
	private int Customerid;

	// Getters and setters for name, email, mobile, and customerid

	

	public Customer() {
		super();
	}

	
	public int getCustomerid() {
		return Customerid;
	}


	public void setCustomerid(int customerid) {
		Customerid = customerid;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	

	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getProfilePic() {
		return profilePic;
	}


	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}


	public String getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	
	
	public Customer(String firstName, String lastName, String emailId, String mobileNumber, String password,
			String profilePic, String registerDate, int customerid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.profilePic = profilePic;
		this.registerDate = registerDate;
		Customerid = customerid;
	}


	//methods to validate customer login credentials
	public boolean validateCustomerLogin() {
	    boolean flag = false;
	    DBConnection db = new DBConnection();
	    Connection conn = db.getConnection();

	    if (conn == null) {
	        flag = false;
	    } else {
	        try {
	            String qry = "select * from customers where emailId=? and password=?";
	            PreparedStatement pst = conn.prepareStatement(qry);
	            pst.setString(1, this.emailId);
	            pst.setString(2, this.password);
	            
	            System.out.print("emailid"+emailId);
	            System.out.print("password"+password);

	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	            	this.Customerid=rs.getInt("Customerid");
	            	this.setEmailId(rs.getString("emailId"));
					this.setFirstName(rs.getString("firstName"));
					this.setLastName(rs.getString("lastName"));

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

	// Add record to category table
			public int AddCustomer() {
				int n = 0;
				DBConnection db = new DBConnection();
				Connection conn = db.getConnection();

				if (conn == null) {
					n = 0;
				} else {
					try {
						String qry = "insert into customers(firstName,lastName,mobileNumber,emailId,password,profilePic,registerDate)values(?,?,?,?,?,?,?)";
						PreparedStatement pst = conn.prepareStatement(qry);

						pst.setString(1, this.firstName);
						pst.setString(2, this.lastName);
						pst.setString(3, this.mobileNumber);
						pst.setString(4, this.emailId);
						pst.setString(5, this.password);
						pst.setString(6, this.profilePic);
						
						Calendar c=Calendar.getInstance();
						// Assuming 'c' is a Calendar instance
						String registerDate= c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH);
						pst.setString(7, registerDate);


						n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE

					} catch (Exception e) {
						n = 0;
					}

				}
				return n;

			}


			public Customer getCustomerById(int customerId) {
			    Customer customer = new Customer();
			    try {
			        // Establish database connection
			        DBConnection db = new DBConnection();
			        Connection conn = db.getConnection();

			        // Prepare SQL query
			        String qry = "SELECT customerId, firstName, lastName, mobileNumber, emailId, password, profilePic, registerDate FROM customers WHERE customerId=?";
			        PreparedStatement pst = conn.prepareStatement(qry);
			        pst.setInt(1, customerId);

			        // Execute query
			        ResultSet rs = pst.executeQuery();

			        // Process result set
			        if (rs.next()) {
			            customer.setCustomerid(rs.getInt("customerId"));
			            customer.setFirstName(rs.getString("firstName"));
			            customer.setLastName(rs.getString("lastName"));
			            customer.setMobileNumber(rs.getString("mobileNumber"));
			            customer.setEmailId(rs.getString("emailId"));
			            customer.setPassword(rs.getString("password"));
			            customer.setProfilePic(rs.getString("profilePic"));
			            customer.setRegisterDate(rs.getString("registerDate"));
			        } else {
			            customer = null; // Customer not found
			        }

			    } catch (Exception e) {
			        System.out.println("Error: " + e);
			    }
			    return customer;
			}

			
			public List<String> getAllCustomerById() {
				List<String> customerList = new ArrayList<String>();
				int n = 0;

				try {
					DBConnection db = new DBConnection();
					Connection conn = db.getConnection();

					String qry = "SELECT  customerId FROM customers ORDER BY customerId";
					Statement st = conn.createStatement();

					ResultSet rs = st.executeQuery(qry);

					// You might want to process the ResultSet here
					while (rs.next()) {
						
						customerList.add(rs.getString("customerId"));
						
					}

				} catch (Exception e) {
					e.printStackTrace(); // Handle the exception properly, e.g., log it
				}

				return customerList;
			}
			
			public List<Customer> getAllCustomers() {
			    List<Customer> customerList = new ArrayList<Customer>();

			    try {
			        DBConnection db = new DBConnection();
			        Connection conn = db.getConnection();

			        String qry = "SELECT customerId, firstName, lastName, mobileNumber, emailId FROM customers";
			        Statement st = conn.createStatement();

			        ResultSet rs = st.executeQuery(qry);

			        // Process the ResultSet
			        while (rs.next()) {
			            Customer customer = new Customer();
			            customer.setCustomerid(rs.getInt("customerId"));
			            customer.setFirstName(rs.getString("firstName"));
			            customer.setLastName(rs.getString("lastName"));
			            customer.setMobileNumber(rs.getString("mobileNumber"));
			            customer.setEmailId(rs.getString("emailId"));

			            customerList.add(customer);
			        }

			    } catch (Exception e) {
			        e.printStackTrace(); // Handle the exception properly, e.g., log it
			    }

			    return customerList;
			}

	}
