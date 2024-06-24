<%@page import="com.example.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.example.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>View Employee</title>
 <jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="title.jsp"></jsp:include>
<script>
        function confirm_delete(employeeId) {
            let ans = confirm("Want to delete this Employee?");
            if (ans) {
                window.location = "/EcommerceProject/DeleteEmployeeServlet?employeeId=" + employeeId;
            }
        }
    </script>
</head>
<body>
	<jsp:include page="adminmenu.jsp" />

	<%
	 //System.out.println("EmployeeId: " + request.getParameter("EmployeeId"));
    Employee employees= new Employee();
    List<Employee> employeesList = employees.getAllEmployee();
    System.out.println("employeesList=" + employeesList.size());
    %>

	<div class="container mt-2">
	<%
		String res= request.getParameter("res");
		if(res!=null){
				if(res.equals("1")){
			%>

		<div class="alert alert-success alert-dismissible fade show">
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Success!</strong> Employee updated.
		</div>
		<%
				}else if(res.equals("0")){
					%>
		<div class="alert alert-success alert-dismissible fade show">
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Yup!</strong> Employee not updated.
		</div>
		<%
			
			
							
				}
		}
		%>

	
		<div class=" mx-auto border-success" style="max-width: 1300px;">

			<h2 class=" text-center mb-4"><u>View Employees</u></h2>
			
			<div class="table-responsive">
			<table class="table table-striped table-dark table-hover" id="table_id">
				<thead class="table-success">
					<tr>
						
						<th>Slno</th>
						<th>Employee ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Gender</th>
						<th>Mobile No</th>
						<th>Email</th>
						<th>Designation</th>
						<th>Password</th>
						<th class="text-center">Employee Pic</th>
						
					</tr>
				</thead>
				<tbody>
					<%
                        int slno = 0;
                        for (Employee employeeOb : employeesList) {
                            slno++;
                        %>
                        
                        <tr>
                        
                       
							
							
						<td><%=slno%></td>
						<td><%=employeeOb.getEmployeeId()%></td>
						<td><%=employeeOb.getFirstname()%></td>
						<td><%=employeeOb.getLastname()%></td>
						<td><%=employeeOb.getGender()%></td>
						<td><%=employeeOb.getMobile()%></td>
						<td><%=employeeOb.getEmail()%></td>
						<td><%=employeeOb.getDesignation()%></td>
						<td><%=employeeOb.getPassword()%></td>
						
						
							<td><a href='EditEmployeeProfile.jsp?tableName=employees&setColName=employeepic&whereColName=employeeId&conditionValue=<%=employeeOb.getEmployeeId() %>&colName=employeepic'><img src='<%=request.getContextPath()%>/uploads/<%=employeeOb.getEmployeepic()%>' style='width: 100px; height: 100px' /> </a>
								</td>
							
						
						
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	</div>

	

	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
			
			$('#success_id').slideUp(3000);
		});
	</script>
</body>
</html>