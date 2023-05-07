<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <form action="/login" method="post">
        <div class="justify-content-center d-flex">
            <img class="mb-4" src="https://i.ibb.co/sFWw2LJ/2.png" width="150" height="150">
        </div>

        <h1 class="h3 mb-3 fw-normal">Please Login</h1>

        <div class="form-floating mt-3">
            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
            <label for="email">Email address</label>
        </div>
        <div class="form-floating mt-3">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            <label for="password">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">Sign in</button>

        <h2 class="mt-2">Don't have account? <a href="/signup">Sign Up</a> </h2>
    </form>
</div>
</body>
</html>
