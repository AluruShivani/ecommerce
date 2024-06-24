package com.example.controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.FeedBack;

@WebServlet("/DeleteFeedbackServlet")
public class DeleteFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        String feedbackId = request.getParameter("feedbackId");

        FeedBack feedback = new FeedBack();
        feedback.setFeedbackId(Integer.parseInt(feedbackId));

        boolean flag = feedback.deleteFeedback(Integer.parseInt(feedbackId));
        int n = 0;
        if (flag) {
            n = 1;
            response.sendRedirect("/E-CommerceWebSite/customer/viewfeedback.jsp");
        } else {
            n = 0;
        }


	}

	

}
