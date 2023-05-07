package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moduls.New;
import moduls.NewCategory;
import moduls.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        if (session.getAttribute("currentUser")!=null){
            ArrayList<New> news= DBConnection.getNewsList();
            request.setAttribute("newsList",news);
            ArrayList<NewCategory> categoryArrayList= DBConnection.GetCategories();
            request.setAttribute("categoryList",categoryArrayList);
            request.getRequestDispatcher("home.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/login");
        }

    }
}
