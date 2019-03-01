package servlets;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class LoginServlet extends HttpServlet {
    UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User authUser = service.getUserByLogin(login);
        if (authUser != null && authUser.getPassword().equals(password)){
            switch (authUser.getRole()) {
                case "admin":
                    req.getSession().setAttribute("role", "admin");
                    break;
                case "user":
                    req.getSession().setAttribute("role", "user");
                    break;
            }
        }else {
            req.setAttribute("status", "Invalid username or password");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        resp.sendRedirect("/");
    }
}
