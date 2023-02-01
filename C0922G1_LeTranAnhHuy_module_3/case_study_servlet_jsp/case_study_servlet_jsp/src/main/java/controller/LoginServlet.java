package controller;

import model.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "thang", "123", "ADMIN"));
        userList.add(new User(2, "guest1", "123", "GUEST"));
        userList.add(new User(3, "guest2", "123", "GUEST"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean rememberMe = Boolean.parseBoolean(request.getParameter("rememberMe"));
        // xác thực
        User userLogin = null;
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                userLogin = user;
                break;
            }
        }
        String messLogin = "";
        HttpSession session = request.getSession();

        if (userLogin != null) {
            session.setAttribute("sessionUser", userLogin);
            if (rememberMe) {
                Cookie cookieUsername = new Cookie("cookieUsername", username);
                Cookie cookiePassword = new Cookie("cookiePassword", password);
                cookieUsername.setMaxAge(1000);
                cookiePassword.setMaxAge(1000);
                response.addCookie(cookieUsername);
                response.addCookie(cookiePassword);
            }
            // đăng nhập thành công
            response.sendRedirect("/home");
        } else {
            // đăng nhập thấ bại
            messLogin = "Đăng nhập thất bại";
            request.setAttribute("messLogin", messLogin);
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }
    }
}
