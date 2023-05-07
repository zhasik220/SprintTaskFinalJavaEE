package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.User;

import java.io.IOException;

@WebServlet(value = "/signup")
public class SignUpServet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signUp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName=request.getParameter("full_name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        User user =DBConnection.getUser(email);
        System.out.println(user);
        if (DBConnection.getUser(email)==null){
            DBConnection.addUser(new User(email,password,fullName,2));
            response.sendRedirect("/login");
        }
        else {
            response.sendRedirect("/signup?error");
        }
    }
}
