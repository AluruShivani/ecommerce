<%@page import="com.example.model.Products"%>
<%@page import="com.example.model.CustomerOderes"%>
<%@page import="com.example.model.Customer"%>
<%@page import="com.example.controller.customer.UpdateCustomerOrderStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../header.jsp" />
    <jsp:include page="title.jsp"/>
   
<body>
<jsp:include page="customermenu.jsp" />
<%
    String productCode=request.getParameter("productCode");
	Products product=new Products();
	product.setProductCode(Integer.parseInt(productCode));
	product=product.getProductByCode();
%>
<div class="table-responsive">
<div class="container " style="background-color:; height: 600px; width: 1200px;">

<div class="col-md-12 mt-3">
    <div class="card p-4 border-danger border-2" style="background-color:yellow;width: 100%">
        <h2 class="card-header text-center border-danger border-2" style="background-color: #d1ecf1;">RATINGS</h2>
        <div class="card-body">
            <form action="/E-CommerceWebSite/RatingsServlet" method="post">
                <div class="row">
                    <div class='col-sm-6'>
                        <div class='row mt-2'>
                            <div class='col-sm-12'>
                                <label for='productCode' class="fw-bold">Product Code</label>
                                <span><%=product.getProductCode() %></span>
                                <input type="hidden" class='form-control' name='productCode' value='<%=product.getProductCode()%>' >
                            </div>
                        </div>
                    </div>
                    
                    <div class='col-sm-6'>
                        <div class='row mt-2'>
                            <div class='col-sm-12'>
                                <label for='productimage' class="fw-bold">Product Image</label>
                                <span><img src ='../uploads/<%=product.getProductImage1()%>' style='width:100px;height:100px'/></span>
                                
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="col-md-6">
                    <div class="form-group mb-2" style="display: inline-block; margin-left: 20px;">
                        <label for="productname" class="fw-bold">Product Name</label>
                        <input type="text" class="form-control" id="customerId" name="productName" value='<%=product.getProductName() %>' readonly>
                    </div>
                </div>

                    <div class="col-md-6">
                        <div class="form-group mb-2">
                            <label for="ratings" class="fw-bold">Ratings</label>
                            <select class="form-control" id="ratings" name="rating">
                                <option value="1">1 Stars</option>
                                <option value="2">2 Stars</option>
                                <option value="3">3 Stars</option>
                                <option value="4">4 Stars</option>
                                <option value="5">5 Stars</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class='row'>
                    <div class='col-sm-12'>
                        <label for='comments' class="fw-bold">Comments</label>
                        <textarea class="form-control" rows="3" cols="10" name="comments"></textarea>
                    </div>
                </div><br/>
                <center>
	                <button type="submit" class="btn btn-primary ">ADD RATING</button>
	            </center>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
