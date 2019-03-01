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

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (service.getUserByID(id) != null){
            User user = service.getUserByID(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/editUser.jsp").forward(req,resp);
        }else {
            req.setAttribute("errStatus", "No user found");
            resp.sendRedirect("/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confPassword = req.getParameter("confPassword");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        if (service.getUserByID(id) != null){
            if (password.equals(confPassword)){
                //req.setAttribute("okStatus", "User " + login + " is edit");
                req.getSession().setAttribute("okStatus", "User " + login + " is edit");
                service.updateUser(new User(id,login,password,name,email,role));
                resp.sendRedirect("/list");
            }else {
                //req.setAttribute("errStatus", "Passwords do not match");
                req.getSession().setAttribute("errStatus", "Passwords do not match");
                req.getRequestDispatcher("/editUser.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("errStatus", "Login " + login + " is busy");
            req.getRequestDispatcher("/editUser.jsp").forward(req,resp);
        }
    }
}
