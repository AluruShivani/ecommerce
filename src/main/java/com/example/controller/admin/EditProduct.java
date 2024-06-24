package com.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.model.Categories;
import com.example.model.Products;

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
        // Retrieve parameters from the view
    	String productCode = request.getParameter("productCode");
        String categoryName = request.getParameter("categoryName");
        String productName = request.getParameter("productName");
        String description=request.getParameter("description");
        String discount=request.getParameter("discount");
        String cost=request.getParameter("cost");
        
        //use model to insert category
        Products product = new Products();
        product.setProductCode(Integer.parseInt(productCode));
        product.setCategoryName(categoryName);
        product.setProductName(productName);
        product.setDescription(description);
        product.setDiscount(Integer.parseInt(discount));
        product.setCost(Integer.parseInt(cost));
        
        int n=product.UpdateProductByCode();
        response.sendRedirect("/E-CommerceWebSite/Admin/viewproduct.jsp?res=" +n);
        out.close();
	}

}
