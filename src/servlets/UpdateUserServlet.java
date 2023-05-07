package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.New;
import moduls.User;

import java.io.IOException;

@WebServlet(value = "/updateNew")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("news_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int category = Integer.parseInt(request.getParameter("category"));
        New oneNew = new New();
        oneNew.setId((long) id);
        oneNew.setTitle(title);
        oneNew.setContent(content);
        oneNew.setCategory_id(category);
        DBConnection.updateNew(oneNew);
        response.sendRedirect("/news_page?id=" + id);
    }
}
