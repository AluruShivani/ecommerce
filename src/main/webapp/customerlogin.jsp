<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Page</title>
<jsp:include page="header.jsp" />
</head>
<body>
<jsp:include page="title.jsp" />

	<div class="container mt-5">
		<form action="/E-CommerceWebSite/CustomerLoginValidation" method="post" class="p-4 shadow bg-white rounded"
			style="max-width: 1200px;">
			<h1 class="h3 mb-3 text-center text-decoration-underline">CUSTOMER LOGIN</h1>

			<div class="mb-3">
				<label for="email" class="form-label fw-bold">Email:</label> <input
					type="email" class="form-control" id="email" name="emailId"
					required>
			</div>

			<div class="mb-3">
				<label for="Password" class="form-label fw-bold">Password:</label> <input
					type="Password" class="form-control" id="Password" name="password"
					required>
			</div>
			
			<div class="mb-4 mt-4 d-flex justify-content-center">
				<button type="submit" class="btn btn-dark w-70">SIGNIN</a>
				</button>
			</div>
			<a href="customerregister.jsp" class="text-primary">New Customer!!<u class="text-success">REGISTER HERE</u></a>
		</form>
	</div>
</body>
</html>