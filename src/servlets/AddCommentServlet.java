package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.Comment;
import moduls.New;
import moduls.User;

import java.io.IOException;

@WebServlet(value = "/add_comment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user!=null) {

           String commentText=request.getParameter("commentText");
           Comment comment=new Comment();
           int news_id= Integer.parseInt(request.getParameter("news_id"));
           New oneNew=DBConnection.getNew(news_id);
           if (oneNew!=null){
               comment.setUser(user);
               comment.setOneNew(oneNew);
               comment.setCommentText(commentText);
               DBConnection.addComment(comment);
               response.sendRedirect("/news_page?id="+news_id);
           }
           else {
               response.sendRedirect("/");
           }
        }
        else {
            response.sendRedirect("/");
        }
    }
}
