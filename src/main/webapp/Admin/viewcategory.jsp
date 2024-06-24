<%@ page
	import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, java.util.List, com.example.model.Categories"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="../header.jsp" />
<title>View Category</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="title.jsp" />
<script src="js/script.js"></script>
<script>
        function confirm_delete(categoryId) {
            let ans = confirm("Want to delete this record?");
            if (ans) {
                window.location = "/E-CommerceWebSite/DeleteCategory?categoryId=" + categoryId;
            }
        }
    </script>
</head>
<body>
	<jsp:include page="adminmenu.jsp" />

	<%
	Categories category = new Categories();
	List<Categories> categoryList = category.getAllCategories();
	System.out.println("categoryList=" + categoryList.size());
	%>

	<div class="container mt-3">

		<%
		String res= request.getParameter("res");
		if(res!=null){
				if(res.equals("1")){
			%>

		<div class="alert alert-success alert-dismissible">
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Success!</strong> Record not updated.
		</div>
		<%
				}else if(res.equals("0")){
					%>
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Yup!</strong> Records   updated.
		</div>
		<%
							
				}
		}
		%>
		<h2>Categories</h2>
		<div class="table-responsive">
			<table class="table table-striped table-light table-hover" id="table_id">
				<thead>
					<tr>
						<th>Operations</th>
						<th>Operations</th>
						<th>Slno</th>
						<th>CategoryId</th>
						<th>CategoryName</th>
					</tr>
				</thead>
				<tbody>
					<%
					int slno = 0;
					for (Categories categoryOb : categoryList) {
						slno++;
					%>
					<tr>
						<td>
							 

							<button class='btn btn-sm btn-danger'
								onclick="confirm_delete(<%=categoryOb.getCategoryid()%>)">Delete</button>
						</td>
						<td><a
							href="/E-CommerceWebSite/editcategory.jsp?categoryId=<%=categoryOb.getCategoryid()%>"
							class='btn btn-sm btn-info'>Edit</a></td>

						<td><%=slno%></td>
						<td><%=categoryOb.getCategoryid()%></td>
						<td><%=categoryOb.getCategoryname()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<script>
        $(document).ready(function() {
        	$('#success_id').slideUp(3000);
        	
            $('#table_id').DataTable();
        });
    </script>
</body>
</html>
