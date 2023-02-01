package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "search":
                searchUser(request, response);
                break;
            default:
                break;
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        request.setAttribute("listUser", userService.searchUser(country));
        try {
            request.getRequestDispatcher("view/user/search.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        boolean check = userService.updateUser(user);
        String mess = "Chỉnh sửa thành công";
        if (!check) {
            mess = "Chỉnh sửa không thành công";
        }
        request.setAttribute("mess", mess);
        showFormEdit(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = userService.deleteUser(id);
        String mess = "Xoá thành công";
        if (!check) {
            mess = "Xoá không thành công";
        }
        request.setAttribute("mess", mess);
        showList(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        boolean check = userService.insertUser(new User(name, email, country));
        String mess = "Thêm mới thành công";
        if (!check) {
            mess = "Thêm mới không thành công";
        }
        request.setAttribute("mess", mess);
        showFormCreate(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userService.selectUser(id));
        try {
            request.getRequestDispatcher("view/user/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("userList", userService.findAllUser());
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}