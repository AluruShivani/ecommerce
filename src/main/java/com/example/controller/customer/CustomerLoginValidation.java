package com.example.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.model.Customer;

import dbutil.DBConnection;

@WebServlet("/CustomerLoginValidation")
public class CustomerLoginValidation extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");

        System.out.print("emailid1: "+emailId);
        System.out.print("password1: "+password);
        
        Customer customers =new Customer();
        customers.setEmailId(emailId);
        customers.setPassword(password);

            boolean flag=customers.validateCustomerLogin();
            if (flag == true) { //customer user exist 
            	HttpSession session=request.getSession();
            	session.setAttribute("customerId", customers.getCustomerid());
            	session.setAttribute("customerName", customers.getFirstName() +" " +customers.getLastName());
            	session.setAttribute("customerMailId", customers.getEmailId());
                response.sendRedirect("/E-CommerceWebSite/customer/customerhome.jsp");
                
            } else {
                //System.out.println("Login failed. Redirecting to CustomerLogin.jsp");
            	//response.sendRedirect("customerlogin.jsp?res="+ flag);
            	out.println("<script language='javascript'>alert('Invalid user');window.location='customerlogin.jsp?res=0';</script>");
                out.close();
                    }
    }
}