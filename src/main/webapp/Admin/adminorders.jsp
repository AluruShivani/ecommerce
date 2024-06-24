<%@page import="java.util.List"%>
<%@page import="com.example.model.CustomerOderes"%>
<%@page import="com.example.model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp" />
 <script>
        function confirm_update(orderId,orderStatus) {
            let ans = confirm("Do You Want To Dispatch This Order?");
            if (ans) {
                window.location = "/E-CommerceWebSite/UpdateCustomerOrderStatus?n=2&orderId=" + orderId+"&orderStatus=Dispacted";
            }
        }
        
    </script>

</head>
<body>
<jsp:include page="adminmenu.jsp" />
	<%
	CustomerOderes corders = new CustomerOderes();
	
	//int customerId = (int) session.getAttribute("customerId");
	List<CustomerOderes> cordersList = corders.getAllCustomerOderes();
	System.out.println("cordersList=" + cordersList.size());
	%>

    
    <%
		String res = request.getParameter("res");
		if(res!=null){
			if(res.equals("1")){
	%>
		<div class="alert alert-success alert-dismissible" id='success_id'>
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Success!</strong>Product Dispacted.
		</div>
		<%
			}else if(res.equals("0")){
				%>
				<div class="alert alert-danger alert-dismissible" id='success_id'>
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
			<strong>Failed!</strong>Product not dispacted.
		</div>
		<%
			}
		}
		%>

    <div class="container mt-3">
        <h2 class="text-center text-danger">
            <u>Orders</u>
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
                    <th>Operation</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                int slno = 0;
                Products product = new Products();
                for (CustomerOderes cordersOb : cordersList) {
                
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
                    
                   	 <input type="submit" class="btn btn-sm btn-warning" name="update" value="update" onclick="confirm_update(<%=cordersOb.getOrderId()%>)" />
                   	 
                     <%
                    }
                    %>
                    </td>
                 	
    				<%
    				}
    				%>
                </tr>
               
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

