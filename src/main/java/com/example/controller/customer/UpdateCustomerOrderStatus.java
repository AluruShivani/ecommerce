package com.example.controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.Categories;
import com.example.model.CustomerOderes;

@WebServlet("/UpdateCustomerOrderStatus")
public class UpdateCustomerOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateCustomerOrderStatus() {
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
		
		String orderId = request.getParameter("orderId");
		String orderStatus = request.getParameter("orderStatus");
		
		CustomerOderes corders = new CustomerOderes();
		corders.setOrderId(Long.parseLong(orderId));
		corders.setOrderStatus(orderStatus);
		int n = corders.customerOrderStatusUpdate(Long.parseLong(orderId), orderStatus);
	
		int m=Integer.parseInt(request.getParameter("n"));
		if(m==1) { //customer
			response.sendRedirect("/E-CommerceWebSite/customer/orderhistory.jsp?res="+ n);
		}else if(m==2) {
			response.sendRedirect("/E-CommerceWebSite/Admin/adminorders.jsp?res="+ n);
		}

	}


	

}
