package com.example.controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import com.example.model.Ratings;

@WebServlet("/DeleteRating")
public class DeleteRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String ratingId=request.getParameter("ratingId");
        
        Ratings rating=new Ratings();
        rating.setRatingId(Integer.parseInt(ratingId));
        
        boolean flag=Ratings.deleteRating(Integer.parseInt(ratingId));
        int n=0;
        if(flag) {
        	n=1;
        	response.sendRedirect("/E-CommerceWebSite/customer/viewrating.jsp");
        }else {
        	n=0;
        }
		
	}

	

}
