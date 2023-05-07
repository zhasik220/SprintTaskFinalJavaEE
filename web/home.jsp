<%@ page import="java.util.ArrayList" %>
<%@ page import="moduls.New" %>
<%@ page import="moduls.NewCategory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
ArrayList<New> news= (ArrayList) request.getAttribute("newsList");
ArrayList<NewCategory>  categories=(ArrayList) request.getAttribute("categoryList");
%>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp"%>
    <style>
        .card-text {
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            overflow: hidden;
            text-overflow: ellipsis;
        }


    </style>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <h2>Hello <%=currentUser.getFullName()%></h2>
    <%
        for (New oneNew : news) {
    %>
    <div class="card mb-3">
        <div class="card-header d-flex justify-content-between align-items-center">
            <span class="news-category badge bg-secondary"><%=categories.get(oneNew.getCategory_id()-1).getName()%></span>
            <span class="news-time text-muted"><%=oneNew.getPost_date()%></span>
        </div>
<%--        <img src="example-image.jpg" class="card-img-top" alt="...">--%>
        <div class="card-body">
            <h2 class="card-title"><%=oneNew.getTitle()%></h2>
            <p class="card-text"><%=oneNew.getContent()%></p>
            <a href="/news_page?id=<%=oneNew.getId()%>" class="btn btn-primary">Read More</a>
        </div>
    </div>
    <%
        }
    %>

</div>
</body>
</html>
