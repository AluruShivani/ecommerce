<%@page import="com.example.model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"/>
<title>Edit Product</title>
</head>
<body>
<%
String productCode = request.getParameter("productCode");
Products product = new Products();
product.setProductCode(Integer.parseInt(productCode));

product = product.getProductByCode();
%>

<body class="bg-light">


	<div class="container mt-4">
		<div class="card">
			<form class="card-body"
				action="/E-CommerceWebSite/EditProduct" method="post">

				<h2 class="mb-4 text-center">Edit Product</h2>

				<div class="form-group">
					<label for="productName">Product Name:</label> <input type="text"
						class="form-control" id="productName" name="productName"
						value="<%=product.getProductName()%>" required>
				</div>

				<div class="form-group">
					<label for="productCode">Product Code:</label> <input type="text"
						class="form-control" id="productCode" name="productCode"
						value="<%=product.getProductCode()%>" readonly required>
				</div>
				
				<div class="form-group">
					<label for="categoryName">Category Name:</label> <input type="text"
						class="form-control" id="categoryName" name="categoryName"
						value="<%=product.getCategoryName()%>" required>
				</div>
				
				<div class="form-group">
					<label for="cost">Cost:</label> <input type="number"
						class="form-control" id="cost" name="cost"
						value="<%=product.getCost()%>" required>
				</div>
				
				<div class="form-group">
					<label for="description">Description:</label> <input type="text"
						class="form-control" id="description" name="description"
						value="<%=product.getDescription()%>" required>
				</div>
				
				<div class="form-group">
					<label for="discount">Discount:</label> <input type="number"
						class="form-control" id="discount" name="discount"
						value="<%=product.getDiscount()%>" required>
				</div>


				<div class="text-center">
					<button type="submit" class="btn btn-success">Update
						Product</button>
				</div>





			</form>
		</div>
	</div>
	<%
	String res = request.getParameter("res");
	if (res != null) {
		if (res.equals("0")) {
			out.println("<h4 style='color:red'>Product not updated</h4>");
		} else {
			out.println("<h4 style='color:green'>Product  updated</h4>");
		}
	}
	%>
</body>
</html>