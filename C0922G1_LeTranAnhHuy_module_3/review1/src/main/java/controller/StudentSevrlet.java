package controller;

import model.bean.ClassTeacher;
import model.bean.Student;
import model.service.IClassService;
import model.service.IStudentService;
import model.service.Impl.ClassService;
import model.service.Impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/student")
public class StudentSevrlet extends HttpServlet {
IStudentService studentService =new StudentService();
IClassService classService = new ClassService();
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
        String address = request.getParameter("address");
        request.setAttribute("listStudent", studentService.searchStudent(address));
        try {
            request.getRequestDispatcher("view/student/search.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
       Student student = new Student(id, name, birthday, address);
        boolean check =studentService.updateStudent(student);
        String mess = "Chỉnh sửa thành công";
        if (!check) {
            mess = "Chỉnh sửa không thành công";
        }
        request.setAttribute("mess", mess);
        showFormEdit(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = studentService.deleteStudent(id);
        String mess = "Xoá thành công";
        if (!check) {
            mess = "Xoá không thành công";
        }
        request.setAttribute("mess", mess);
        showList(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("classId"));
        ClassTeacher classTeacher = new ClassTeacher(id);

        boolean check = studentService.insertStudent(new Student(name, birthday, address,classTeacher));
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
        request.setAttribute("student", studentService.selectStudent(id));
        try {
            request.getRequestDispatcher("view/student/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("classList", classService.findAll());
        try {
            request.getRequestDispatcher("view/student/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("studentList", studentService.findAllUser());
        request.setAttribute("classList", classService.findAll());
        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
