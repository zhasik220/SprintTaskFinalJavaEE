<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row text-bg-light border border-opacity-50 rounded-top py-1">
        <h2>Profile Page</h2>
    </div>
    <div class="row border border-opacity-50 rounded-bottom border-top-0">
        <div class="mt-3 row">
            <label class="col-sm-2 col-form-label">Full Name:</label>
            <div class="col-10">
                <input type="text" class="form-control" name="full_name"
                       value="<%=currentUser.getFullName()%>" readonly>
            </div>
        </div>
        <div class="my-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Email:</label>
            <div class="col-10">
                <input type="email" class="form-control" id="staticEmail" name="email"
                       value="<%=currentUser.getEmail()%>" readonly>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-10">
                <input type="text" class="form-control" name="password"
                       value="<%=currentUser.getPassword()%>" readonly>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col-12 d-flex justify-content-end">
                <div>
                    <%@include file="updateUserModal.jsp" %>
                </div>
                <div>
                    <%@include file="deleteUserModal.jsp" %>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>
