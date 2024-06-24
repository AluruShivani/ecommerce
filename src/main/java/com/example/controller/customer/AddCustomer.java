package com.example.controller.customer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import com.example.model.Customer;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomer")
@MultipartConfig
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Calendar c = Calendar.getInstance();
		// Assuming 'c' is a Calendar instance
		String registerDate = c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/"
				+ c.get(Calendar.DAY_OF_MONTH);

		// getting the parameters
		//int customerId = request.("customerId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		//String profilePic = request.getParameter("profilePic");
		// String registerDate=request.getParameter("registerDate");
		
		Part profilePic = request.getPart("profilePic");


////////////////creation of uploads directory in webapp folder
///////////////////////

		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/");
		System.out.println("path = " + path);
		
		

		/*String str = path.substring(0, path.indexOf(".metadata") - 1);
		System.out.println("str = " + str);

// get application name
		String appName = path.substring(path.lastIndexOf("\\", path.length() - 2));
		System.out.println("appName = " + appName);

// Concatenate root directory with application name
		//String uploadDirectory = str + appName + "\\src\\main\\webapp\\uploads";*/
		
		
		
		
		String uploadDirectory = path +"/uploads";
		System.out.println("uploadDirectory :" + uploadDirectory);

		Path uploadPath = Path.of(uploadDirectory);
		
		// Create the directory if it doesnt't exist
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
			System.out.println("directory Created");
		} else {
			System.out.println("directory not Created");
		}

	/////// upload Image1////////////////////
					//////////////////////////////

					// Get the input stream of the uploaded file
					InputStream inputStream1 = profilePic.getInputStream();

					// Generate the unique filename or use the original file name
					String fileName1 = System.currentTimeMillis() + "_" + profilePic.getSubmittedFileName();

					// Save file to the server
					Path filePath1 = uploadPath.resolve(fileName1);
					Files.copy(inputStream1, filePath1, StandardCopyOption.REPLACE_EXISTING);
					

		// use model to insert
					 Customer customer = new Customer();
				        customer.setFirstName(firstName);
				        customer.setLastName(lastName);
				        customer.setMobileNumber(mobileNumber);
				        customer.setEmailId(emailId);
				        customer.setPassword(password); // Set password here
		//customer.setRegisterDate(today);
		customer.setProfilePic(fileName1);
		//customer


		int n = customer.AddCustomer();

		if (n == 1) {
			//response.sendRedirect("/EcommereceProject/admin/CustomerLogin.jsp?res=0"); // OR
			response.sendRedirect("customerlogin.jsp?res="+n);
			out.close();																			// response.sendRedirect("/Admin/addcategory.jsp?res="+n);
		} else {
			// response.sendRedirect("/EcommereceProject/admin/AddCategory.jsp?res=1");
			out.println("<h1>Fill all the required feilds</h1>");
			out.println(
					"<script language='javascript'>alert('Registration failed');window.location='customerregister.jsp?res=0';</script>");

		}
		out.close();
	}

}