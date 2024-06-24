<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <%-- Include header.jsp --%>
    <jsp:include page="../header.jsp" />
      <jsp:include page="title.jsp" />
    <meta charset="ISO-8859-1">
    <title>Add Employee</title>
   
</head>
<body>
<body class="bg-light">
    <%-- Include menu.jsp --%>
    <jsp:include page="adminmenu.jsp" />
    

    <form class="card-body" action="/E-CommerceWebSite/AddEmployee"
        method="post" enctype="multipart/form-data">

        <div class="container card mt-4">
            <h1 class=" mt-4 mb-3 text-center">
        <span class=" text-danger font-italic" style><i>ADD EPMLOYEE</i></span>
    </h1>

            <div class="row">
                <div class="col-md-6">
                    <label for="productCode"><strong>firstName:</strong></label>
                    <input type="text" class="form-control" id="fistName" name="firstname" required>
                </div>
                
                <div class="col-md-6">
                    <label for="productName"><strong>lastName:</strong></label>
                   <input type="text" class="form-control" id="lastName" name="lastname" required>
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label for="categoryName"><strong>Gender:</strong></label>
                    <select class="form-control" id="gender" name="gender">
						 <option value=""></option>
                   		 <option value="male">Male</option>
                  		 <option value="female">Female</option>
                     </select>
                </div>
                <div class="col-md-6">
                    <label><strong>Mobile</strong></label>
                    <input type="number" class="form-control" name="mobile">
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label><strong>Email</strong></label>
                    <input type="email" class="form-control" name="email"></textarea>
                </div>
                <div class="col-md-6">
                    <label><strong>Designation</strong></label>
                    <input type="text" class="form-control" name="designation">
                </div>
            </div><br/>

            <div class="row">
                <div class="col-md-6">
                    <label><strong>Password</strong></label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="col-md-6">
                    <label><strong>EmployeePic</strong></label>
                   <input type="file" class="form-control" name="employeepic">
                </div>
            </div><br/>

            

            <div class="text-center mt-2">
                <button type="submit" class="btn btn-success">Add Employee</button>
            </div>

            <%-- Display result message --%>
            <%
            String res = request.getParameter("res");
            if (res != null) {
                if (res.equals("1")) {
                    out.println("<h4 style='color:green'>Employee  added</h4>");
                } else {
                    out.println("<h4 style='color:red'>Employee not added</h4>");
                }
            }
            %>
        </div>
    </form>
</body>

</html>