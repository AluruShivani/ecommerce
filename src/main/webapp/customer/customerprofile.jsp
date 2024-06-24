<%@ page import="com.example.model.Customer" %>
<%@ page import="dbutil.DBConnection" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, com.example.controller.admin.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .profile-pic {
            width: 200px;
            height: 200px;
            object-fit: cover;
        }
        .card {
            max-width: 800px;
            margin: 0 auto;
            box-shadow: 30px 30px 10px rgba(0, 0, 0, 0.1);
        }
        .card-body p {
            margin-bottom: 0.75rem;
            font-size: 1.1rem;
        }
        .card-body strong {
            font-size: 1.1rem;
        }
        .profile-title {
            font-weight: 600;
        }
        .text-highlight {
            color: #8492bd;
        }
    </style>
</head>
<body>
    <jsp:include page="title.jsp" />
    <jsp:include page="customermenu.jsp" />
    
    <%
        Customer customer = new Customer();
        customer = customer.getCustomerById((int) session.getAttribute("customerId"));
    %>

    <div class="container mt-4">
        <h2 class="card-title text-center fs-1">PROFILE</h2>
        <div class="card mt-4">
            <div class="row g-0">
                <div class="col-md-4 d-flex justify-content-center align-items-center p-3">
                    <a href="editprofile.jsp?tableName=customers&setColName=profilePic&whereColName=customerId&conditionValue=<%= customer.getCustomerid() %>">
                        <img src="../uploads/<%= customer.getProfilePic() %>" class="img-fluid rounded-circle profile-pic" alt="Profile Picture">
                    </a>
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <p class="profile-title">
                            <strong class="text-highlight">Customer ID: </strong><%= customer.getCustomerid() %>
                        </p>
                        <p class="profile-title">
                            <strong class="text-highlight">First Name: </strong><%= customer.getFirstName() %>
                        </p>
                        <p class="profile-title">
                            <strong class="text-highlight">Last Name: </strong><%= customer.getLastName() %>
                        </p>
                        <p class="profile-title">
                            <strong class="text-highlight">Mobile Number: </strong><%= customer.getMobileNumber() %>
                        </p>
                        <p class="profile-title">
                            <strong class="text-highlight">Email ID: </strong><%= customer.getEmailId() %>
                        </p>
                        <p class="profile-title">
                            <strong class="text-highlight">Password: </strong><%= customer.getPassword() %>
                        </p>
                        <p class="profile-title">
                            <strong class="text-highlight">Register Date: </strong><%= customer.getRegisterDate() %>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

   
</body>
</html>
