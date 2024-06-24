package com.example.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.model.FeedBack;



@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		//reading parameters from html page
		////String date = request.getParameter("date");
		//int customerId = Integer.parseInt("customerId");
		String customerQuery = request.getParameter("customerQuery");
		String feedback = request.getParameter("feedback");
		
		
		//System.out.println("date="+date);
		//System.out.println("customerId="+customerId);
				
		System.out.println("customerQuery="+customerQuery);
		System.out.println("feedback="+feedback);
		
			HttpSession session = request.getSession();
		
		Integer customerId = (Integer)session.getAttribute("customerId");
		//System.out.println("customerId="+customerId);
		
		
		//Calendar calendar = Calendar.getInstance();
        //String today = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
          //      + calendar.get(Calendar.DAY_OF_MONTH);
		
		 FeedBack feedbacks = new FeedBack();
		 //feedbacks.setDate(today);
		 feedbacks.setCustomerId(customerId);
		 feedbacks.setCustomerQuery(customerQuery);
		 feedbacks.setFeedback(feedback);
		   
		   int n = feedbacks.addFeedback();
		   
		   response.sendRedirect("/E-CommerceWebSite/customer/feedback.jsp?res="+n);
		   pw.close();
		   

	}
	}