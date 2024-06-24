package com.example.controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.FeedBack;


@WebServlet("/UpdateFeedbackServlet")
public class UpdateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int feedbackId=Integer.parseInt(request.getParameter("feedbackId"));
        String customerQuery=(request.getParameter("customerQuery"));
        String feedback=request.getParameter("feedback");
        
        //
        System.out.println("feedbackid="+feedbackId);
       System.out.println("customerQueries="+customerQuery);
        System.out.println("feedback="+feedback);
        
        FeedBack feedbacks= new FeedBack();
        feedbacks.setFeedbackId(feedbackId);
        feedbacks.setCustomerQuery(customerQuery);
        feedbacks.setFeedback(feedback);
        
        int n = feedbacks.updateFeedback(); 
        
        if(n>0) {//successfully updated
        	response.sendRedirect("/E-CommerceWebSite/customer/viewfeedback.jsp?res="+n);
        }
        
	}


	
}
