package com.example.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;

public class Employee implements Serializable {
	private int employeeId;
	private String firstname;
	private String lastname;
	private String gender;
	private String mobile;
	private String email;
	private String designation;
	private String password;
	private String employeepic;
	
	
	public Employee() {
		super();
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeepic() {
		return employeepic;
	}

	public void setEmployeepic(String employeepic) {
		this.employeepic = employeepic;
	}

	
	public Employee(int employeeId, String firstname, String lastname, String gender, String mobile, String email,
			String designation, String password, String employeepic) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.designation = designation;
		this.password = password;
		this.employeepic = employeepic;
	}
	

	public int addEmployee() {
		int n = 0;
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();

		if (conn == null) {
			n = 0;
		} else {
			try {
				String qry = "insert into employees(firstname,lastname,gender,mobile,email,designation,password,employeepic)values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(qry);
				
				pst.setString(1, this.firstname);
				pst.setString(2, this.lastname);
				pst.setString(3, this.gender);
				pst.setString(4, this.mobile);
				pst.setString(5, this.email);
				pst.setString(6, this.designation);
				pst.setString(7, this.password);
				pst.setString(8, this.employeepic);
				System.out.println("emp qry:"+pst.toString());
				

				n = pst.executeUpdate(); // Use executeUpdate for INSERT, UPDATE, DELETE
				System.out.println("add emp qry:"+pst.toString());
			} catch (Exception e) {
				System.out.println("Error11111:" + e);
				n = 0;
			}

		}
		return n;
	}
	
	
	public Employee getEmployeeById() {
		Employee employee =new Employee();
		try {
			DBConnection db=new DBConnection();
			Connection conn=db.getConnection();
			String qry="select employeeId,firstName,lastName,gender,mobile,email,designation,password,employeepic from employees where employeeId=?";
			
			//System.out.println("Updating employeeId: " + this.employeeId);
			//System.out.println("New first name: " + this.firstName);
			//System.out.println("New last name: " + this.lastName);

			PreparedStatement pst=conn.prepareStatement(qry);
			System.out.println("qry="+qry);
			pst.setInt(1, this.employeeId);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setFirstname(rs.getString("firstName"));
				employee.setLastname(rs.getString("lastName"));
				employee.setGender(rs.getString("gender"));
				employee.setMobile(rs.getString("mobile"));
				employee.setEmail(rs.getString("email"));
				employee.setDesignation(rs.getString("designation"));
				employee.setPassword(rs.getString("password"));
			}else {
				employee=null;
			}
			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return employee;
	}

	public List<Employee> getAllEmployee(){
		List<Employee> employeeList=new ArrayList<Employee>();
	
		try {
			DBConnection db = new DBConnection();
		    Connection conn = db.getConnection();
		    
		    String qry="select employeeId,firstName,lastName,gender,mobile,email,designation,password,employeepic from employees order by employeeId";
		    Statement st=conn.createStatement();
		    
		    ResultSet rs=st.executeQuery(qry);
		   
		    while(rs.next()) {
		    	Employee employee= new Employee();
		    	
		    	employee.setEmployeeId(rs.getInt("employeeId"));
		    	employee.setFirstname(rs.getString("firstName"));
		    	employee.setLastname(rs.getString("lastName"));
				employee.setGender(rs.getString("gender")); 
				employee.setMobile(rs.getString("mobile"));
				employee.setEmail(rs.getString("email"));
				employee.setDesignation(rs.getString("designation"));
				employee.setPassword(rs.getString("password"));
				employee.setEmployeepic (rs.getString("employeepic"));

				
		    	employeeList.add(employee);
		    }
		}catch(Exception e) {
			System.out.println("Error:getAllEmployees..:" +e);
			
		}
		return employeeList;
	}
	
	
	


}
