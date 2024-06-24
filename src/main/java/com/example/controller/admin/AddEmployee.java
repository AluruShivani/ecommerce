package com.example.controller.admin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.example.model.Employee;
import com.example.model.Products;

@WebServlet("/AddEmployee")
@MultipartConfig
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String fistname = request.getParameter("firstname");
		String Lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");

		String Mobile = request.getParameter("mobile");
		String Email = request.getParameter("email");
		String Designation = request.getParameter("designation");
		String PassWord = request.getParameter("password");
		Part employeepic = request.getPart("employeepic");
		
		
		System.out.println("fname: " + fistname);
		System.out.println("lname: " + Lastname);
		System.out.println("gender: " + gender);
		System.out.println("mobile: " + Mobile);
		System.out.println("email: " + Email);
		System.out.println("designation: " + Designation);
		System.out.println("password: " + PassWord);
		System.out.println("employeepic: " + employeepic);// Debugging statement

		
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/");
		System.out.println("path = " + path);

		/*String str = path.substring(0, path.indexOf(".metadata") - 1);
		System.out.println("str = " + str);
		// get application name
		String appName = path.substring(path.lastIndexOf("\\", path.length() - 2));
		System.out.println("appName = " + appName);

		// Concatenate root directory with application name
		String uploadDirectory = str + appName + "\\src\\main\\webapp\\uploads";*/
		
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

		/////// upload productImage1////////////////////
		//////////////////////////////

		// Get the input stream of the uploaded file
		InputStream inputStream1 = employeepic.getInputStream();

		// Generate the unique filename or use the original file name
		String fileName1 = System.currentTimeMillis() + "_" + employeepic.getSubmittedFileName();

		// Save file to the server
		Path filePath1 = uploadPath.resolve(fileName1);
		Files.copy(inputStream1, filePath1, StandardCopyOption.REPLACE_EXISTING);

		Employee employee = new Employee();
		employee.setFirstname(fistname);
		employee.setLastname(Lastname);
		employee.setGender(gender);
		employee.setMobile(Mobile); // Set the description parameter
		employee.setEmail(Email);
		employee.setDesignation(Designation);
		employee.setPassword(PassWord);
		employee.setEmployeepic(fileName1);
		
		
		
		int n=employee.addEmployee();
		response.sendRedirect("Admin/addemployee.jsp?res="+n);
		pw.close();
		
	}

}
