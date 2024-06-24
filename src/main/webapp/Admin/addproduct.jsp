<%@page import="java.util.List"%>
<%@page import="com.example.model.Categories"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%-- Include header.jsp --%>
    <jsp:include page="../header.jsp" />
    <jsp:include page="title.jsp"/>
    <meta charset="ISO-8859-1">
    <title>Addproduct</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">
    <%-- Include menu.jsp --%>
    <jsp:include page="adminmenu.jsp" />
    <%
    Categories category=new Categories();
    List<String> categoryList=category.getAllCategoriesByName();
    %>

    <form class="card-body" action="/E-CommerceWebSite/AddProduct"
        method="post" enctype="multipart/form-data">

        <div class="container card mt-4">
            <h1 class=" mt-4 mb-3 text-center">
        <span class=" text-danger font-italic" style><i>ADD PRODUCT</i></span>
    </h1>

            <div class="row">
                <div class="col-md-6">
                    <label for="productCode"><strong>Product Code:</strong></label>
                    <input type="number" class="form-control" id="productCode" name="productCode" required>
                </div>
                
                <div class="col-md-6">
                    <label for="productName"><strong>Product Name:</strong></label>
                    <input type="text" class="form-control" id="productName" name="productName" required>
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label for="categoryName"><strong>Category Name:</strong></label>
                    <select name="categoryName" class="form-control">
                    <%
                    for(String categoryname:categoryList){
                    	String option="<option value='"+categoryname+"'>"+categoryname+"</option>";
                    	out.println(option);
                    }
                    %>
                        
                    </select>
                </div>
                <div class="col-md-6">
                    <label><strong>Cost</strong></label>
                    <input type="number" class="form-control" name="cost">
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label><strong>Description</strong></label>
                    <textarea rows="2" cols="50" class="form-control" name="description"></textarea>
                </div>
                <div class="col-md-6">
                    <label><strong>Discount</strong></label>
                    <input type="number" class="form-control" name="discount">
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label><strong>Product Image1</strong></label>
                    <input type="file" class="form-control" name="productImage1">
                </div>
                <div class="col-md-6">
                    <label><strong>Product Image2</strong></label>
                    <input type="file" class="form-control" name="productImage2">
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label><strong>Product Image3</strong></label>
                    <input type="file" class="form-control" name="productImage3">
                </div>
            </div><br/>

            <div class="text-center mt-2">
                <button type="submit" class="btn btn-success">Add Product</button>
            </div>

            <%-- Display result message --%>
            <%
            String res = request.getParameter("res");
            if (res != null) {
                if (res.equals("0")) {
                    out.println("<h4 style='color:red'>product not added</h4>");
                } else {
                    out.println("<h4 style='color:green'>product added</h4>");
                }
            }
            %>
        </div>
    </form>
</body>
</html>
