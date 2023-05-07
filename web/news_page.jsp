<%@ page import="java.util.List" %>
<%@ page import="moduls.New" %>
<%@ page import="moduls.NewCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="moduls.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    New oneNew= (New) request.getAttribute("oneNew");
    ArrayList<NewCategory> categories=(ArrayList) request.getAttribute("categoryList");
    ArrayList<Comment> comments= (ArrayList<Comment>) request.getAttribute("news_comments");
%>
<html>
<head>
    <title>News Post</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container my-5">
    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <span class="news-category badge bg-secondary"><%=categories.get(oneNew.getCategory_id()-1).getName()%></span>
            <span class="news-time text-muted"><%=oneNew.getPost_date()%></span>
        </div>
        <div class="card-body">
            <h2 class="card-title"><%=oneNew.getTitle()%></h2>
            <p class="card-text"><%=oneNew.getContent()%></p>
        </div>
    </div>
    <%
    if (currentUser.getRole_id()==1){
    %>
    <div class="mt-3 row">
        <div class="col-12 d-flex justify-content-end">
            <div>
                <%@include file="updateNewsModal.jsp"%>
            </div>
            <div>
                <%@include file="deleteNewsModal.jsp"%>
            </div>
        </div>
    </div>
    <%
        }
    %>
    <div class="my-5">
        <form action="/add_comment" method="POST">
            <input type="hidden" name="news_id" value="<%=oneNew.getId()%>">
            <div class="form-group">
                <label for="comment-content">Comment:</label>
                <textarea class="form-control" id="comment-content" name="commentText" placeholder="Write Comment"
                          rows="3" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Add Comment</button>
        </form>

        <h3>Comments</h3>

        <% if (comments.isEmpty()) { %>
        <p>No comments yet.</p>
        <%
        }
        else {
        %>

        <% for (Comment comment : comments) {%>
        <div class="card my-3">
            <div class="card-header d-flex justify-content-between align-items-center">
                <div class="d-flex align-items-center">
                    <div class="avatar me-3">
                        <img src="<%=comment.getUser().getRole_id()==1 ?
                        "https://bitlab.kz/images/team/ilyas_team_final.png"
                        :"https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-HD-Image.png"%>"
                             alt="" class="rounded-circle" width="50" height="50">
                    </div>
                    <h5 class="card-title mb-0 <%=comment.getUser().getRole_id()==1 ? "text-primary":""%>">
                        <%=comment.getUser().getFullName()%></h5>
                </div>
                <div class="d-flex flex-wrap align-items-center justify-content-end text-end">
                    <div class="w-100">
                    <small class="text-muted"><%=comment.getPost_date()%></small>
                    </div>
                <%if (currentUser.getId() == comment.getUser().getId() || currentUser.getRole_id() == 1) {
                    System.out.println(comment.getId());
                %>
                    <div class="btn-group">
                        <div>
                            <%@include file="updateCommentModal.jsp"%>
                            <%@include file="deleteCommentModal.jsp"%>

                        </div>
                    </div>
                <% } %>
                </div>
            </div>
            <div class="card-body">
                <p class="card-text"><%=comment.getCommentText()%></p>
            </div>
        </div>
        <% } %>




        <%
        }
        %>

    </div>
</div>
</body>
</html>
