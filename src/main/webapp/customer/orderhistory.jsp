<%@page import="com.example.model.Ratings"%>
<%@page import="com.example.model.Products"%>
<%@page import="com.example.model.CustomerOderes"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"/>
    <title>Orders History</title>
    <script>
        function confirm_delete(orderId) {
            let ans = confirm("Want to this delete product?");
            if (ans) {
                window.location = "/E-CommerceWebSite/UpdateCustomerOrderStatus?n=1&orderId=" +orderId +"&orderStatus=cancelled";
            }
        }
        
    </script>
</head>
<body>
<jsp:include page="customermenu.jsp" />


    <%
    CustomerOderes corders = new CustomerOderes(); 
    int customerId = (int) session.getAttribute("customerId");
    List<CustomerOderes> orderlist = corders.getAllCustomerOderes(); // Change method name

    System.out.println("orderlist=" + orderlist.size());
    %>
    
    <%
		String res = request.getParameter("res");
		if(res!=null){
			if(res.equals("1")){
	%>
		<div class="alert alert-success alert-dismissible" id='success_id'>
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Success!</strong>Order Status Updated.
		</div>
		<%
			}else if(res.equals("0")){
				%>
				<div class="alert alert-danger alert-dismissible" id='success_id'>
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Failed!</strong>Order Status not Updated.
		</div>
		<%
			}
		}
		%>

    <div class="container mt-3">
        <h2 class="text-center text-danger">
            <u>Orders History</u>
        </h2>

        <table
            class="table table-bordered  table-hover table-responsive"
            id="table_id">

            <thead>
                <tr class="text-center">
                    <th>Slno</th>
                    <th>Order Id</th>
                    <th>Customer Id</th>
                    <th>Invoice Number</th>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>Product Image</th>
                    <th>Order Date</th>
                    <th>Cost</th>
                    <th>Discount Amount</th>
                    <th>Qty</th>
                    <th>Gst Amount</th>
                    <th>Bill Amount</th>
                    <th>Status</th>
                    <th colspan="2">Operation</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                int slno = 0;
                Products product = new Products();
                for (CustomerOderes cordersOb : orderlist) {
                
                    slno++;
                %>
                <tr>
                    
                    <td><%=slno%></td>
                    <td><%=cordersOb.getOrderId()%></td>
                    <td class="text-center"><%=cordersOb.getCustomerId()%></td>
                    <td><%=cordersOb.getInvoiceNumber()%></td>
                    <td class="text-center"><%=cordersOb.getProductCode()%></td>
                    <% 
					
					product.setProductCode(cordersOb.getProductCode());
					product = product.getProductByCode();
					
					 %>
                    <td class="text-center"><%=product.getProductName()%></td>
                    <td><img src ='../uploads/<%=product.getProductImage1()%>' style='width:100px;height:100px'/></td>
                    <td class="text-center"><%=cordersOb.getOrderDateTime()%></td>
                    <td class="text-end"><%=cordersOb.getCost()%></td>
                    <td class="text-end"><%=cordersOb.getDiscountAmount()%></td>
                    <td class="text-end"><%=cordersOb.getQuantity()%></td>
                    <td class="text-end"><%=cordersOb.getGstAmount()%></td>
                    <td class="text-end"><%=cordersOb.getBillAmount()%></td>
                    <td><%=cordersOb.getOrderStatus()%></td>
                    
                    <td>
                    <%if(cordersOb.getOrderStatus().toString().equalsIgnoreCase("pending")){
                    %>
                    
                   	 <input type="button" class="btn btn-sm btn-warning" name="cancel" value="Cancel" onclick="confirm_delete(<%=cordersOb.getOrderId()%>)" />
                   	 
                     <%
                    }
                    %>
                    </td>
                    
    				<td>
    				
    				<%
    				Ratings rating=new Ratings();
    				boolean flag=rating.isRatingGiven(Integer.parseInt(session.getAttribute("customerId").toString()), cordersOb.getProductCode());
    				if(flag==false){
    				%>
    				
    				<a href='rating.jsp?productCode=<%=cordersOb.getProductCode()%>'>Rating</a></td>
    				
    				<%
    				}
    				%>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <script>
		$(document).ready(function() {
			$('#table_id').DataTable();
			$('#sucess_id').slideUp(3000);
		});
	</script>
    </div>
</body>
</html>
