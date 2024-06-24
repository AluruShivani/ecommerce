<%@page import="java.util.ArrayList"%>
<%@page import="com.example.model.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"/>
<jsp:include page="title.jsp"/>
</head>
<body>
	<jsp:include page="customermenu.jsp" />
	
	<%
		Products product = new Products();
		List<Products> Listproducts=new ArrayList<Products>();  //empty product list
		
		String search = request.getParameter("search");
		if(search==null){  //without search
			
			Listproducts = product.getAllProducts(null);
			System.out.print(Listproducts);
		}else{ //with search
			System.out.print("search: " + search);
			Listproducts = product.getAllProducts(search);
			
		}
		%>
	

	<div class="container mt-4 ">
		<div class="row">
			<%
			int slno = 0;
			for (Products productOb : Listproducts) {
			%>
			<div class="col-sm-3 mt-2 ">
				<div class="card "
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
    <div class="card-footer">
    <a href='/E-CommerceWebSite/AddwishList?productCode=<%=productOb.getProductCode()%>' class="float-start" >
        <i class="fas fa-heart" style="font-size: 28px; color: red;"></i> 
    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='/E-CommerceWebSite/AddToCart?productCode=<%=productOb.getProductCode()%>' class="float-end">
        <i class="fas fa-cart-plus" style="font-size: 28px; color: blue;"></i>
    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='/E-CommerceWebSite/customer/review.jsp?productCode=<%=productOb.getProductCode()%>' >
        <i class="fas fa-star" style="font-size: 28px; color: green;"></i>
    </a>
</div>

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




