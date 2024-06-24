package com.example.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.model.Admin;
import com.example.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dbutil.DBConnection;

@WebServlet("/AdminLoginValidation")
public class AdminLoginValidate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
       
        Admin admin =new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setRole(role);

            boolean flag=admin.validateAdminLogin();
            if (flag == true) {
                HttpSession session=request.getSession();
                response.sendRedirect("/E-CommerceWebSite/Admin/adminhome.jsp");
                
            } else {
               
            	out.println("<script language='javascript'>alert('Invalid user');window.location='adminlogin.jsp?res=0';</script>");
                out.close();
                    }
    }
}