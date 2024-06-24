<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>CATEGORY</title>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp" />
</head>
<body>
<jsp:include page="adminmenu.jsp" />
	<div class="container mt-5">
		<form action="/E-CommerceWebSite/AddCategory" method="post" class="p-4 shadow bg-white rounded"
			style="max-width: 1200px;">
			<h1 class="h3 mb-3 text-center text-decoration-underline">ADD CATEGORY</h1>

			<div class="mb-3">
				<label for="name" class="form-label fw-bold">Category name:</label> <input
					type="text" class="form-control" id="name" name="categoryname"
					required>
			</div>

			</div>
			<div class="mb-4 mt-4 d-flex justify-content-center">
				<button type="submit" class="btn btn-success w-70">AddCategory</button>
			</div>
			
			<%
                String res=request.getParameter("res");
                if(res!=null){
                	if(res.equals("1")){
                		out.println("<h4 style='color:red'>category  added</h4>");
                	}else{
                		out.println("<h4 style='color:green'>category not added</h4>");
                	}
                }
                %>
		</form>
	</div>
</body>
</html>