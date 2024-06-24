package com.example.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.model.Products;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.getWriter().append("Served at: ").append(request.getContextPath());

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String productCode = request.getParameter("productCode");

        Products product = new Products();
        product.setProductCode(Integer.parseInt(productCode));
        
        boolean flag = product.deleteProductByCode(); // Corrected method name

        int n = 0;
        if (flag) {
            n = 1;
            response.sendRedirect("/E-CommerceWebSite/Admin/viewproduct.jsp");

        } else {
            n = 0;
        }
    }
}
