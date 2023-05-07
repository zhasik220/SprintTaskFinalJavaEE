package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.Comment;
import moduls.User;

import java.io.IOException;

@WebServlet(value = "/updateComment")
public class UpdateCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("comment_id"));
        int news_id = Integer.parseInt(request.getParameter("news_id"));
        String commentText = request.getParameter("commentText");
        Comment comment = new Comment();
        comment.setId((long) id);
        comment.setCommentText(commentText);
        DBConnection.updateComment(comment);
        response.sendRedirect("/news_page?id=" + news_id);
    }
}
