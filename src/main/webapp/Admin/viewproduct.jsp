<%@page import="com.example.model.Products"%>
<%@ page
	import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, java.util.List, com.example.model.Categories"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp" />
<title>View Products</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="js/script.js"></script>
<script>
    function confirm_delete(productCode) {
        let ans = confirm("Want to delete this record?");
        if (ans) {
            window.location = "/E-CommerceWebSite/DeleteProduct?productCode=" + productCode;
        }
    }
</script>

</head>
<body>
	<jsp:include page="adminmenu.jsp" />

	<%
	Products product = new Products();
	List<Products> ProductList = product.getAllProducts(null);
	
	%>

	<div class="container mt-3">

		<%
		String res= request.getParameter("res");
		if(res!=null){
				if(res.equals("1")){
			%>

		<div class="alert alert-success alert-dismissible">
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Success!</strong> Record updated.
		</div>
		<%
				}else if(res.equals("0")){
					%>
		<div class="alert alert-success alert-dismissible">
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Yup!</strong> Records  not updated.
		</div>
		<%
							
				}
		}
		%>
			<h2>Products</h2>
		<div class="table-responsive">
			<table class="table table-striped table-light table-hover"
			id="table_id">
				<thead>
					<tr>
						<th>Operations</th>
						<th>Operations</th>
						<th>Slno</th>
						<th>ProductCode</th>
						<th>ProductName</th>
						<th>CategoryName</th>
						<th>Cost</tt>
						<th>Description</th>
						<th>Discount</th>
						<th>ProductImage1</th>
						<th>ProductImage2</th>
						<th>ProductImage3</th>
					</tr>
				</thead>
				<tbody>
					<%
					int slno = 0;
					for (Products productOb : ProductList) {
						slno++;
					%>
					<tr>
						<td>
							<button class='btn btn-sm btn-danger'
								onclick="confirm_delete(<%=productOb.getProductCode()%>)">Delete</button>
						</td>
						<td><a
						href="/E-CommerceWebSite/Admin/editproduct.jsp?productCode=<%=productOb.getProductCode()%>"
						class='btn btn-sm btn-info'>Edit</a></td>

						<td><%=slno%></td>
						<td><%=productOb.getProductCode()%></td>
						<td><%=productOb.getProductName()%></td>
						<td><%=productOb.getCategoryName()%></td>
						<td><%=productOb.getCost()%></td>
						<td><%=productOb.getDescription()%></td>
						<td><%=productOb.getDiscount()%></td>
						<td><a href='editimage.jsp?tableName=products&setColName=productImage1&whereColName=productCode&conditionValue=<%=productOb.getProductCode() %>'> <img src='../uploads/<%=productOb.getProductImage1()%>' style='width:100px;height:100px'/></a></td>
						<td><a href='editimage.jsp?tableName=products&setColName=productImage2&whereColName=productCode&conditionValue=<%=productOb.getProductCode() %>'> <img src='../uploads/<%=productOb.getProductImage2()%>' style='width:100px;height:100px'/></a></td>
						<td><a href='editimage.jsp?tableName=products&setColName=productImage3&whereColName=productCode&conditionValue=<%=productOb.getProductCode() %>'> <img src='../uploads/<%=productOb.getProductImage3()%>' style='width:100px;height:100px'/></a></td>
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
