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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">
    <jsp:include page="customermenu.jsp" />
    
    
    
    <form class="card-body" action="/E-CommerceWebSite/UpdateImage"
        method="post" enctype="multipart/form-data">

        <div class="container card mt-4">
            <h1 class=" mt-4 mb-3 text-center">
        <span class="  font-italic" style><i>Edit Image</i></span>
    </h1>
    
    <input type='hidden' name='tablename' value='<%=request.getParameter("tablename")%>'>
	<input type='hidden' name='setcolname' value='<%=request.getParameter("setcolname")%>'>
	<input type='hidden' name='wherecolname' value='<%=request.getParameter("wherecolname")%>'>
	<input type='hidden' name='conditionvalue' value='<%=request.getParameter("conditionvalue")%>'>


            <div class="row">
                <div class="col-md-6">
                    <label><strong>ProfilePic</strong></label>
                    <input type="file" class="form-control" name="image1">
                </div>
             </div>
             
             
                
            <div class="text-center mt-2">
                <button type="submit" class="btn btn-success">Update Image</button>
            </div>

            <%-- Display result message --%>
            <%
            String res = request.getParameter("res");
            if (res != null) {
                if (res.equals("0")) {
                    out.println("<h4 style='color:red'>Image not updated</h4>");
                } else {
                    out.println("<h4 style='color:green'>Image updated</h4>");
                }
            }
            %>
        </div>
    </form>
</body>
</html>
