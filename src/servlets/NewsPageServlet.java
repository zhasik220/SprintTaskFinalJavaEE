package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.Comment;
import moduls.New;
import moduls.NewCategory;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/news_page")
public class NewsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (request.getSession().getAttribute("currentUser")!=null) {
           int id = Integer.parseInt(request.getParameter("id"));
           New oneNew = DBConnection.getNew(id);
           request.setAttribute("oneNew", oneNew);
           ArrayList<NewCategory> categoryArrayList = DBConnection.GetCategories();
           request.setAttribute("categoryList", categoryArrayList);
           ArrayList<Comment> comments=DBConnection.getCommentList(oneNew.getId());
           request.setAttribute("news_comments",comments);
           request.getRequestDispatcher("/news_page.jsp").forward(request, response);
       }
       else {
           response.sendRedirect("/login");
       }
    }
}
