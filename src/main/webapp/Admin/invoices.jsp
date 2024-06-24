<%@page import="com.example.model.Invoices"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Invoices</title>
 <jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="title.jsp"></jsp:include>
</head>
<body>
<jsp:include page="./adminmenu.jsp" />

<div class="container-fluid mt-4">


		<h2 class="text-center text-danger">
			<u>Admin Invoices</u>
		</h2>
	<div class="table-responsive">
		<table class="table table-bordered table-warning table-hover"
			id="table_id">

			<thead class="table-dark">
				<tr class="text-center">
					<tr>
            <th>Invoice Number</th>
            <th>Order ID</th>
            <th>Invoice Amount</th>
            <th>Invoice Date</th>
            <th>Invoice Type</th>
            <th>Card Number</th>
            <th>Card Type</th>
            <th>Payment Status</th>
        </tr>
    </thead>
    <tbody>
    <%
    	List<Invoices> invoices = new Invoices().getAllInvoices();
    		if(invoices !=null){
    			for(Invoices invoiceOb : invoices){
    		
    %>
    <tr>
    	<td><%= invoiceOb.getInvoiceNumber() %></td>
            <td><%= invoiceOb.getOrderId() %></td>
            <td><%= invoiceOb.getInvoiceAmount() %></td>
            <td><%= invoiceOb.getInvoiceDate() %></td>
            <td><%= invoiceOb.getInvoiceType() %></td>
            <td><%= invoiceOb.getCardNumber() %></td>
            <td><%= invoiceOb.getCardType() %></td>
            <td><%= invoiceOb.getPaymentStatus() %></td>
        </tr>
			<% 
                }
            } 
        %>
    </tbody>
</table>
</div>

</div>

	<script>
    $(document).ready(function() {
        $('#table_id').DataTable();
    });
</script>
</body>
</html>