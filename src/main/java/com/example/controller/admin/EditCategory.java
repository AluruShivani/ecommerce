package com.example.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.model.Categories;

/**
 * Servlet implementation class UpdateCategoryServlet
 */
@WebServlet("/EditCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
        // Retrieve parameters from the view
        String categoryName = request.getParameter("categoryName");
        String categoryId = request.getParameter("categoryId");
        
        //use model to insert category
        Categories category = new Categories();
        category.setCategoryname(categoryName);
        category.setCategoryid(Integer.parseInt(categoryId));
        
        int n=category.updateCategoryById();
        /*if(n==0) {
        	out.println("category not updated");
        	response.sendRedirect("/EcommerceProject/admin/EditCategory.jsp?res=0");
        }else {
        	out.println("category Updated");
        	response.sendRedirect("/EcommerceProject/admin/EditCategory.jsp?res=1");
        }*/
        response.sendRedirect("Admin/viewcategory.jsp?res=" +n);
        out.close();

	}

}