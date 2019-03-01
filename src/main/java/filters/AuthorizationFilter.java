package filters;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserService service = UserServiceImpl.getInstance();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User authUser = service.getUserByLogin(login);
        if (request.getMethod().equalsIgnoreCase("post")){
            if (authUser != null && authUser.getPassword().equals(password)){
                if (authUser.getRole().equals("admin")){
                    request.getSession().setAttribute("role","admin");
                    response.sendRedirect("/list");
                }else if (authUser.getRole().equals("user")){
                    request.getSession().setAttribute("role","user");
                    response.sendRedirect("/user");
                }else {
                    response.sendRedirect("/");
                }
            }else {
                response.sendRedirect("/");
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
