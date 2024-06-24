<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Page</title>
<jsp:include page="header.jsp" />
<jsp:include page="title.jsp" />
</head>
<body>
	
	<div class="container mt-5">
		<form action="/E-CommerceWebSite/AdminLoginValidation" method="post" class="p-4 shadow bg-white rounded"
			style="max-width: 1200px;">
			<h1 class="h3 mb-3 text-center text-decoration-underline">ADMIN LOGIN</h1>

			<div class="mb-3">
				<label for="Username" class="form-label fw-bold">Username:</label> <input
					type="text" class="form-control" id="Username" name="username"
					required>
			</div>

			<div class="mb-3">
				<label for="Password" class="form-label fw-bold">Password:</label> <input
					type="password" class="form-control" id="Password" name="password"
					required>
			</div>

			<div class="mb-3">
				<label for="Role" class="form-label fw-bold">Role:</label><input
					type="text" class="form-control" id="Role" name="role"
					required> 
			</div>
			<div class="mb-4 mt-4 d-flex justify-content-center">
				<button type="submit" class="btn btn-success w-70">LOGIN</button>
			</div>
		</form>
	</div>
</body>
</html>