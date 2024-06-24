<%@page import="com.example.model.Customer"%>
<%@page import="com.example.model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp"></jsp:include>
<title>feedback</title>
</head>
<body>
<jsp:include page="customermenu.jsp" />
<div class="table-responsive">
<div class="container " style="background-color:; height: 600px; width: 1200px;">

<div class="col-md-12 mt-3">
    <div class="card p-4 border-danger border-2" style="background-color:yellow;width: 100%">
        <h2 class="card-header text-center border-danger border-2" style="background-color: #d1ecf1;">FEEDBACK</h2>
        <div class="card-body">
            <form action="/E-CommerceWebSite/FeedbackServlet" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group mb-2">
                            <label for="customerQuery" class="fw-bold">Customer Query</label>
                            <select class="form-control" id="customerQuery" name="customerQuery">
                                <option value="">Select Query</option>
                                <option value="How can I help?">How can I help?</option>
                                <option value="Could you give me some background about the issue?">Could you give me some background about the issue?</option>
                                <option value="Issue About the delivery date or Address?">Issue About the delivery date or Address?</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class='row'>
                    <div class='col-sm-12'>
                        <label for='feedback' class="fw-bold">FeedBack</label>
                        <textarea class="form-control" rows="3" cols="10" name="feedback"></textarea>
                    </div>
                </div><br/>
                <center>
	                <button type="submit" class="btn btn-primary ">SUBMIT</button>
	            </center>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>