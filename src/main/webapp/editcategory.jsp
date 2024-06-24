<%@ page import="com.example.model.Categories"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="ISO-8859-1">
<title>Edit Category</title>
<jsp:include page="menu.jsp" />
</head>
<body>
<%
String categoryId = request.getParameter("categoryId");
Categories category = new Categories();
category.setCategoryid(Integer.parseInt(categoryId));

category = category.getCategoryById();
%>

<body class="bg-light">


	<div class="container mt-4">
		<div class="card">
			<form class="card-body"
				action="/E-CommerceWebSite/EditCategory" method="post">

				<h2 class="mb-4 text-center">Edit Category</h2>

				<div class="form-group">
					<label for="categoryName">Category Name:</label> <input type="text"
						class="form-control" id="categoryName" name="categoryName"
						value="<%=category.getCategoryname()%>" required>
				</div>

				<div class="form-group">
					<label for="categoryId">Category Id:</label> <input type="text"
						class="form-control" id="categoryId" name="categoryId"
						value="<%=category.getCategoryid()%>" readonly required>
				</div>


				<div class="text-center">
					<button type="submit" class="btn btn-success">Update
						Category</button>
				</div>





			</form>
		</div>
	</div>
	<%
	String res = request.getParameter("res");
	if (res != null) {
		if (res.equals("0")) {
			out.println("<h4 style='color:red'>Category not updated</h4>");
		} else {
			out.println("<h4 style='color:green'>Category  updated</h4>");
		}
	}
	%>

</body>
</html>