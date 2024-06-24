package com.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.wishlist;

/**
 * Servlet implementation class DeleteWishlist
 */
public class DeleteWishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWishlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        
	        String productCode = request.getParameter("productCode");

	       
	        
		    wishlist wishlist = new wishlist();
		    wishlist.setProductCode(Integer.parseInt(productCode));
		    
		    boolean flag = wishlist.deleteWishlistItemByProducCode();
		    int n=0;
		    if (flag) {
		    	n=1;
		        
		        response.sendRedirect("/E-CommerecWebSite/customer/wishlist.jsp");      // OR  response.sendRedirect("/Admin/addcategory.jsp?res="+n);
		    } else {
		       n=0;
		    }
		    //response.sendRedirect("/EcommerceProject/admin/ViewCategories.jsp?res=" +flag);
	}
	       

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
