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
   
</head>
<body class="bg-light">
    <jsp:include page="customermenu.jsp" />
    
    
    
    <form class="card-body" action="/E-CommerceWebSite/UploadProfile"
        method="post" enctype="multipart/form-data">

        <div class="container card mt-4">
            <h1 class=" mt-4 mb-3 text-center">
        <span class=" text-danger font-italic" style><i>Edit Image</i></span>
    </h1>
    
    <input type='hidden' name='tableName' value='<%=request.getParameter("tableName")%>'>
	<input type='hidden' name='setColName' value='<%=request.getParameter("setColName")%>'>
	<input type='hidden' name='whereColName' value='<%=request.getParameter("whereColName")%>'>
	<input type='hidden' name='conditionValue' value='<%=request.getParameter("conditionValue")%>'>


            <div class="row">
                <div class="col-md-6">
                    <label><strong>Profile Image</strong></label>
                    <input type="file" class="form-control" name="profilePic">
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
