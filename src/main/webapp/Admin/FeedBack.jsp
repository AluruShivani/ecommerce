<%@page import="java.util.List"%>
<%@page import="com.example.model.FeedBack"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedbacks</title>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp" />
<jsp:include page="adminmenu.jsp" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/datatables.net-bs5/js/dataTables.bootstrap5.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/datatables.net-bs5/css/dataTables.bootstrap5.min.css" rel="stylesheet">
</head>
<body>

<%
   	FeedBack feedback = new FeedBack();
    List<FeedBack> feedbackList = feedback.getAllFeedback();
%>

<div class="container mt-2">
    <div class="card mx-auto border-success" style="max-width: 1000px;">
        <div class="card-body">
            <h2 class="text-center mb-4"><u>View Feedback</u></h2>
            <div class="table-responsive">
                <table class="table table-striped table-success table-hover" id="table_id">
                    <thead class="table-dark">
                        <tr>
                            <th>Slno</th>
                            <th>FeedbackId</th>
                            <th>Date</th>
                            <th>CustomerId</th>
                            <th>CustomerQuery</th>
                            <th>Feedback</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        int slno = 0;
                        for (FeedBack feedbackOb : feedbackList) {
                            slno++;
                        %>
                        <tr>
                            <td><%= slno %></td>
                            <td><%= feedbackOb.getFeedbackId() %></td>
                            <td><%= feedbackOb.getDate() %></td>
                            <td><%= feedbackOb.getCustomerId() %></td>
                            <td><%= feedbackOb.getCustomerQuery() %></td>
                            <td><%= feedbackOb.getFeedback() %></td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>
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
