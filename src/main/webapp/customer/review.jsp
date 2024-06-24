<%@page import="java.util.List"%>
<%@page import="com.example.model.Ratings"%>
<%@page import="com.example.model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"/>
</head>
<body>
<jsp:include page="customermenu.jsp" />


    <form action="/E-CommerceWebSite/RatingsServlet" method="post">

        <div class="container mt-5 ">

            <% 
                String productCode = request.getParameter("productCode");
                Products product = new Products();
                product.setProductCode(Integer.parseInt(productCode));
                product = product.getProductByCode();
            %>

            <div class="card mx-auto border-danger border-2 " style="width: 50%;">
                <div class="card-body">
    				<h1 class="card-title text-bold text-center" style="color: #2C3E50; font-family: 'Protest Guerilla', cursive;">Product</h1>
                    <div class="row mt-2">
                        <div class="col-sm-4">
                            <img src='../uploads/<%= product.getProductImage1() %>' class='card-img-top' alt='Product Image' />
                        </div>
                        <div class="col-sm-8">
                            <p class="card-text ">ProductName: <%=product.getProductName()%></p>
                            <p class="card-text ">Cost: <%=product.getCost()%></p>
                            <p class="card-text ">Discount: <%=product.getDiscount()%></p>
                            <p class="card-text ">Description: <%=product.getDescription()%></p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mt-5 mx-auto" style="width: 50%;">
                <div class="card-body">
                    <h1 class="card-title text-bold text-center" style="color:#7A035D;font-weight: bold;font-family: 'Protest Guerilla', cursive;">Ratings</h1>
                    <div class="col-sm-12">
                        <%
                            Ratings rating = new Ratings();
                            List<Ratings> ratingList = rating.getRatingsByProductCode(Integer.parseInt(productCode));
                        %>

                        <%
                            for(Ratings ratingsOb :ratingList){
                        %>
                               
                                <p class="card-text text-danger text-bold">Rating: <%=ratingsOb.getRating()%></p>
                                <p class="card-text text-danger text-bold">Comments: <%=ratingsOb.getComments()%></p>
                                <hr>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>

        </div>
    </form>


</body>
</html>