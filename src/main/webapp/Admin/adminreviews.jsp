<%@page import="java.util.List"%>
<%@page import="com.example.model.Ratings"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="title.jsp"></jsp:include>

</head>
<body>
<jsp:include page="./adminmenu.jsp" />

<div class="container-fluid mt-4">

	<%
		Ratings rating=new Ratings();
	
		List<Ratings> ratingList=rating.getAllRatings();
		System.out.println("ratingList=" +ratingList.size());
		
	%>
	
	<h2 class="text-center text-danger">
			<u>Reviews</u>
		</h2>
	<div class="table-responsive">
		<table
			class="table table-bordered table-secondary table-hover"
			id="table_id">

			<thead class="table-dark">
				<tr class="text-center">
				
				<tr>
					<th>SINo</th>
					<th>RatingId</th>
					<th>ProductCode</th>
					<th>Rating</th>
					<th>Comments</th>
					<th>CustomerId</th>
					
					
				</tr>
				</thead>
			<tbody class="table table-primary">
				<%
				int slno = 0;
				for (Ratings ratingObj : ratingList) {
					slno++;
				%>
				<tr>


					<td><%=slno%></td>
					<td><%=ratingObj.getRatingId()%></td>
					<td><%=ratingObj.getProductCode()%></td>
					<td><%=ratingObj.getRating()%></td>
					<td><%=ratingObj.getComments()%></td>
					<td><%=ratingObj.getCustomerId()%></td>
					
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
			$('#table_id').DataTable();
			
			$('#success_id').slideUp(3000);
		});
	</script>
</body>
</html>