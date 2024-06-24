<%@page import="java.util.List"%>
<%@page import="com.example.model.FeedBack"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>feedbacks</title>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"/>
<script>
    function confirm_delete(feedbackId) {
        let ans = confirm("Want to delete this?");
        if (ans) {
            window.location = "/E-CommerceWebSite/DeleteFeedbackServlet?feedbackId=" + feedbackId;
        }
    }
</script>
</head>
<body>
<jsp:include page="customermenu.jsp" />
<%
    FeedBack feedback = new FeedBack();
    List<FeedBack> feedbackList = feedback.getAllFeedback();
%>

<div class="container mt-2">
    <div class=" mx-auto border-success" style="max-width: 1000px;">
        <h2 class=" text-center mb-4"><u>View FeedBack</u></h2>

        <table class="table table-striped table-success table-hover table-responsive" id="table_id">
            <thead class="table-dark">
                <tr>
                    <th>Slno</th>
                    <th>FeedbackId</th>
                    <th>Date</th>
                    <th>CustomerId</th>
                    <th>CustomerQuery</th>
                    <th>Feedback</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
                <%
                int slno = 0;
                for (FeedBack feedbackOb : feedbackList) {
                    slno++;
                %>
                <tr>
                    <td><%=slno%></td>
                    <td><%=feedbackOb.getFeedbackId()%></td>
                    <td><%=feedbackOb.getDate()%></td>
                    <td><%=feedbackOb.getCustomerId()%></td>
                    <td><%=feedbackOb.getCustomerQuery()%></td>
                    <td><%=feedbackOb.getFeedback()%></td>
                    <td>
                        <button class='btn btn-sm btn-outline-danger' onclick="confirm_delete(<%=feedbackOb.getFeedbackId()%>)">Delete</button>
                        <a href="/E-CommerceWebSite/customer/editfeedback.jsp?feedbackId=<%=feedbackOb.getFeedbackId()%>" class='btn btn-sm btn-outline-success'>Edit</a> 
                    </td>
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
