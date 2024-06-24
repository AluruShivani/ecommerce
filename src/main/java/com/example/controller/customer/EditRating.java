package com.example.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.model.Ratings;

@WebServlet("/EditRating")
public class EditRating extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditRating() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int ratingId = Integer.parseInt(request.getParameter("ratingId"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comments = request.getParameter("comments");

        Ratings ratings = new Ratings();
        int n = ratings.updateRating(ratingId, rating, comments);

        if (n > 0) {
            response.sendRedirect("/E-CommerceWebSite/customer/viewrating.jsp?res=" + n);
        }
    }
}
