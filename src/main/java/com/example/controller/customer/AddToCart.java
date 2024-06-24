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

import com.example.model.Cart;


@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String productCode=request.getParameter("productCode");
		
		System.out.println("productCode=" +productCode);
		
		Calendar calendar = Calendar.getInstance();
		String today = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.DAY_OF_MONTH);

		HttpSession session=request.getSession();
		int customerId=(int) session.getAttribute("customerId");
		
		System.out.println("customerId=" +customerId);
		
		Cart cart=new Cart();
		cart.setCustomerId(customerId);
		cart.setSelectedDate(today);
		cart.setProductCode(Integer.parseInt(productCode));
		
		int n=cart.addToCart();
		
		response.sendRedirect("/E-CommerceWebSite/customer/customerhome.jsp?res="+n);
		pw.close();
	}

	
	
}