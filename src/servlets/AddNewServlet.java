package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moduls.New;
import moduls.User;

import java.io.IOException;

@WebServlet(value = "/addNew")
public class AddNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null && user.getRole_id() == 1) {
            request.getRequestDispatcher("addNew.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/403").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        int category_id = Integer.parseInt(request.getParameter("category"));
        String content = request.getParameter("content");
        New oneNew = new New(title, content, category_id);
        DBConnection.addNew(oneNew);
        response.sendRedirect("/addNew");

    }

}
