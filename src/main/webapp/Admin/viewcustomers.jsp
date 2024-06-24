<%@page import="java.util.List"%>
<%@page import="com.example.model.Customer"%>
<%@page import="dbutil.DBConnection"%>
<%@ page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, com.example.controller.admin.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp" />
    <title>View Customers</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>
<jsp:include page="adminmenu.jsp" />
<%
	Customer customer = new Customer();
	List<Customer> customerList = customer.getAllCustomers();
	System.out.println("CustomerList=" + customerList.size());
	%>
	<div class="table-responsive">
    <div class="container">
        <h2 class="text-center mt-3">Customers</h2>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                	<th>slno</th>
                    <th>CustomerId</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>MoileNumber</th>
                    <th>EmailId</th>
                   
                </tr>
            </thead>
            <tbody>
                <%
				int slno = 0;
				for (Customer customerOb : customerList) {
					slno++;
				%>
                <tr>
					<td><%=slno%></td>
					<td><%=customerOb.getCustomerid()%></td>
					<td><%=customerOb.getFirstName()%></td>
					<td><%=customerOb.getLastName()%></td>
					<td><%=customerOb.getMobileNumber()%></td>
					<td><%=customerOb.getEmailId()%></td>
				</tr>
				<%
				}
				%>
            </tbody>
        </table>
    </div>
    </div>
</body>
</html>
