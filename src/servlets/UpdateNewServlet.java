package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.User;

import java.io.IOException;

@WebServlet(value = "/updateUser")
public class UpdateNewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("user_id"));

        User user = new User();
        user.setId((long) id);
        user.setPassword(request.getParameter("password"));
        user.setFullName(request.getParameter("full_name"));
        user.setEmail(((User) (request.getSession().getAttribute("currentUser"))).getEmail());
        DBConnection.updateUser(user);
        request.getSession().setAttribute("currentUser", user);
        response.sendRedirect("/profile");
    }
}
