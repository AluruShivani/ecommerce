<%@page import="com.example.model.wishlist"%>
<%@page import="com.example.model.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Wish list</title>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"/>
</head>
<body>
<jsp:include page="customermenu.jsp" />
	
	<%
	wishlist WishList = new wishlist();
	List<Products> ListProducts = WishList.getAllWishListProductsByCustomerId((int)session.getAttribute("customerId"));
	
	%>
	

	<div class="container mt-4">
		<div class="row">
			<%
			int slno = 0;
			for (Products productOb : ListProducts) {
			%>
			<div class="col-sm-3 mt-2">
				<div class="card"
					style="width: 16rem; height: 100%; ">
					<img src="../uploads/<%=productOb.getProductImage1()%>"
						class="img-centered mx-auto d-block" alt="not found"
						style="width: 200px; height: 200px; object-fit: contain;">
					<div class="card-body style="height: 80px; overflow:hidden;">
						<h3 class="card-title"
							style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"><%=productOb.getProductName()%></h3>
						<p class='card-text'><%=productOb.getDescription()%></p>
						<p class="card-text float-start">
							<Strong>Cost:</Strong><%=productOb.getCost()%></p>
					</div>

					<div class="card-footer">
    <a href='/E-CommerceWebSite/DeleteWishlist?productCode=<%=productOb.getProductCode()%>' class="float-start" style="color: red;">
        <i class="fas fa-trash-alt fa-2x"></i> 
    </a>
    <a href='/E-CommerceWebSite/AddToCart?productCode=<%=productOb.getProductCode()%>' class="float-end" style="color: green;">
        <i class="fas fa-cart-plus fa-2x"></i> 
    </a>
</div>


				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>