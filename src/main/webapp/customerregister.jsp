<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<jsp:include page="title.jsp" />
<style>
#password-strength {
	margin-top: 10px;
	font-weight: bold;
}
</style>

</head>
<body>


	<div class="container mt-2">
		<form action="/E-CommerceWebSite/AddCustomer" method="post"
			enctype="multipart/form-data" class="p-4 shadow bg-white rounded">
			<div class="card mx-auto border-danger"
				style="max-width: 1200px; max-height: 500;">
				<div class="card-body">
					<h2 class="card-title text-center mb-4">New Customer
						Registration</h2>

					<div class="mb-3">
						<label for="firstName" class="form-label fw-bold">First
							Name:</label> <input type="text" class="form-control" id="firstName"
							name="firstName" placeholder="Enter your first name">
					</div>

					<div class="mb-3">
						<label for="lastName" class="form-label fw-bold">Last
							Name:</label> <input type="text" class="form-control" id="lastName"
							name="lastName" placeholder="Enter your last name">
					</div>

					<div class="mb-3">
						<label for="mobileNumber" class="form-label fw-bold">Mobile
							Number:</label> <input type="text" class="form-control" id="mobileNumber"
							name="mobileNumber" placeholder="Enter your mobile number">
					</div>

					<div class="mb-3">
						<label for="emailId" class="form-label fw-bold">Email:</label> <input
							type="text" class="form-control" id="emailId" name="emailId"
							placeholder="Enter your E-mail">
					</div>

					<div class="mb-3">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" oninput="checkPasswordStrength(this.value)">
					<div id="password-strength"></div>
					</div>
					
					<div class="mb-3">
					<label for="password">Confirm-Password:</label> <input type="password"
						id="cpassword" name="cpassword" oninput="validatePasswords(this.value)">
					<div id="cpwdLabel"></div>
					</div>

					<div class="mb-3">
						<label for="profilePic" class="form-label fw-bold">Profile
							Picture:</label> <input type="file" class="form-control" id="profilePic"
							name="profilePic" placeholder="Enter your Profilepic">
					</div>
					
					<script>
    function checkPasswordStrength(password) {
      // Define your password strength criteria and calculations here
      // This is a simple example, you can modify it based on your requirements

      var strength = 0;

      // Check the length of the password
      if (password.length >= 8) {
        strength += 1;
      }

      // Check if the password contains both uppercase and lowercase characters
      if (/[a-z]/.test(password) && /[A-Z]/.test(password)) {
        strength += 1;
      }

      // Check if the password contains at least one number
      if (/\d/.test(password)) {
        strength += 1;
      }

      // Check if the password contains at least one special character
      if (/[$&+,:;=?@#|'<>.^*()%!-]/.test(password)) {
        strength += 1;
      }

     
      var strengthText = "";
      switch (strength) {
        case 0:
        case 1:
          strengthText = "Weak";
          break;
        case 2:
          strengthText = "Moderate";
          break;
        case 3:
        case 4:
          strengthText = "Strong";
          break;
      }

      document.getElementById("password-strength").innerHTML = "Password Strength: " + strengthText;
	  if(strengthText=="Weak"){
		document.getElementById("password-strength").style.color = 'red';
    }else if(strengthText=="Moderate"){
		document.getElementById("password-strength").style.color = 'blue';
    }else if(strengthText=="Strong"){
		document.getElementById("password-strength").style.color = 'green';
    }
	}
    function validatePasswords(cpassword){
		var cpwd = document.getElementById("password").value;
		if(cpassword == cpwd){
		document.getElementById("cpwdLabel").innerHTML = "Passwords match";
		document.getElementById("cpwdLabel").style.color = "green";
		}else{
		document.getElementById("cpwdLabel").innerHTML = "Passwords not match";
		document.getElementById("cpwdLabel").style.color = "red";
		}
	
	}
    </script>

					<div class="text-center">
						<button type="submit" class="btn btn-sucess">Register</button>
					</div>

				</div>
			</div>
		</form>
	</div>
	
</body>
</html>
