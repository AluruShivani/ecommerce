package com.example.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.Categories;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;  // Import added
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter pw = response.getWriter();

		    String categoryId = request.getParameter("categoryId");//getting the id
		    //use model to insert
		    Categories category = new Categories();//creating the object
		    category.setCategoryid(Integer.parseInt(categoryId));//setting the id
		    boolean flag = category.DeleteCategoryById();//this is retreving from the model program
		    if (flag) {
		        
		        response.sendRedirect("/E-CommerceWebSite/Admin/viewcategory.jsp?res=0");      // OR  response.sendRedirect("/Admin/addcategory.jsp?res="+n);
		    } else {
		        response.sendRedirect("/E-CommerceWebSite/Admin/viewcategory.jsp?res=1");//redirecting to the other page
		    }
		    pw.close();
		}
 
  
}
