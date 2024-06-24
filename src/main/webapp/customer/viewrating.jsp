<%@page import="com.example.model.Ratings"%>
<%@page import="java.util.List"%>
<%@page import="com.example.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"/>
<script>
function confirm_delete(ratingId) { 
let ans = confirm("Want to delete this?"); if (ans) { 
window.location ="/E-CommerceWebSite/DeleteRating?ratingId=" + ratingId; } }
</script>
</head>
<body>
	<jsp:include page="/customer/customermenu.jsp" />
	<%
	Ratings rating = new Ratings();
	List<Ratings> ratingList = rating.getAllRatings();
	%>

	<div class="container mt-2">
		<div class=" mx-auto border-success" style="max-width: 1000px;">

			<h2 class=" text-center mb-4">
				<u>View Ratings</u>
			</h2>

			<table
				class="table table-striped table-success table-hover table-responsive"
				id="table_id">
				<thead class="table-dark">
					<tr>
						<th>Slno</th>
						<th>RatingId</th>
						<th>CustomerId</th>
						<th>ProductCode</th>
						<!--  <th>Date</th> -->
						<th>Ratings</th>
						<th>Comments</th>
						<th>Opeation</th>
					</tr>
				</thead>
				<tbody>
					<%
					int slno = 0;
					for (Ratings ratingOb : ratingList) {
						slno++;
					%>
					<tr>
						<td><%=slno%></td>
						<td><%=ratingOb.getRatingId()%></td>
						<td><%=ratingOb.getCustomerId()%></td>
						<td><%=ratingOb.getProductCode()%></td>

						<td><%=ratingOb.getRating()%></td>
						<td><%=ratingOb.getComments()%></td>

						<td>
							<button class='btn btn-sm btn-outline-danger'
								onclick="confirm_delete(<%=ratingOb.getRatingId()%>)">Delete</button>
							<a href="/E-CommerceWebSite/customer/editrating.jsp?ratingId=<%=ratingOb.getRatingId()%>"
   								class="btn btn-sm btn-outline-success">Edit</a>

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

	<!-- <div class="footer mt-5 bg-dark text-white text-center fixed-bottom">
        <div class="container">
            <p>&lt;&lt; &lt;&copy; 2023 EMMADI Group of Companies. All rights reserved &gt;&gt;&gt;</p>
            <p>
                <a href="index.jsp">Back to Home</a>
            </p>
        </div>
    </div> -->

	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
			
			$('#success_id').slideUp(3000);
		});
	</script>
</body>
</html>