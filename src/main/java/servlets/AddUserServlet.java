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

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confPassword = req.getParameter("confPassword");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        if (service.getUserByLogin(login) == null){
            if (!password.equals(confPassword)){
                req.setAttribute("errStatus", "Passwords do not match");
                req.getRequestDispatcher("/addUser.jsp").forward(req,resp);
            }
            service.addNewUser(new User(login,password,name,email,role));
            req.setAttribute("okStatus","User added");
            resp.sendRedirect("/list");
        }else {
            req.setAttribute("errStatus", "Login " + login + " is busy");
            req.getRequestDispatcher("/addUser.jsp").forward(req,resp);
        }
    }
}
