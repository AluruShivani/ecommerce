<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Home</title>
<jsp:include page="../header.jsp" />
<jsp:include page="title.jsp" />
<style>
    body {
        background: url('<%= request.getContextPath() %>/ec14.jpg') no-repeat center center fixed;
        background-size: cover;
        margin: 0;
        padding: 0;
        height: 100vh;
        width: 100vw;
    }
</style>
</head>
<body>
<jsp:include page="adminmenu.jsp" />
</body>
</html>
