package com.example.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.Ratings;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/RatingsServlet")
public class RatingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String productCode = request.getParameter("productCode");
		String rating=request.getParameter("rating");
		String comments=request.getParameter("comments");
		
		System.out.println("productCode="+productCode);
		System.out.println("rating="+rating);
		System.out.println("comments="+comments);
		
		HttpSession session=request.getSession();
		
		int customerId= Integer.parseInt(session.getAttribute("customerId").toString());
		System.out.println("customerId="+customerId);
		
		Ratings ratings=new Ratings();
		ratings.setProductCode(Integer.parseInt(productCode));
		ratings.setRating(Integer.parseInt(rating));
		ratings.setComments(comments);
		ratings.setCustomerId(customerId);
		
		int n= ratings.addRatings();
		
		response.sendRedirect("/E-CommerceWebSite/customer/orderhistory.jsp?res="+n);
		pw.close();
	}
}
