package com.example.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.controller.admin.*;
import com.example.model.Admin;
import com.example.model.Categories;

@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    // getting the parameters 
	    String categoryname = request.getParameter("categoryname");
	   
	    //use model to insert
	    Categories category = new Categories();//creating the object
	    category.setCategoryname(categoryname);//setting the parameters
	

	    int result = category.AddCategory();

	    if (result==0) {
	        out.println("category not added");
	        response.sendRedirect("/E-CommerceWebSite/Admin/addcategory.jsp?res=0");      // OR  response.sendRedirect("/Admin/addcategory.jsp?res="+n);
	    } else {
	        response.sendRedirect("/E-CommerceWebSite/Admin/addcategory.jsp?res=1");
	    }
	    out.close();
	}
	
}

   






