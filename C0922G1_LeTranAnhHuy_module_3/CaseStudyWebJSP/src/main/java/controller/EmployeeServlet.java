package controller;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.Impl.DivisionServiceImpl;
import service.Impl.EducationDegreeServiceImpl;
import service.Impl.EmployeeServiceImpl;
import service.Impl.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private IPositionService positionService = new PositionServiceImpl();
    private IDivisionService divisionService = new DivisionServiceImpl();
    private IEducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                findAllEmployee(request, response);
                break;
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
        }
    }



//    +++++++++++++++++++++++++++++++++

    private void findAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        String emailSearch = request.getParameter("emailSearch");
        String divisionSearch = request.getParameter("divisionSearch");

        List<Employee> employeeList = employeeService.search(nameSearch, emailSearch, divisionSearch);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

        request.setAttribute("employeeList", employeeList);

        request.setAttribute("positionList", positionList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("educationDegreeList", educationDegreeList);

        request.setAttribute("nameSearch", nameSearch);
        request.setAttribute("emailSearch", emailSearch);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employeelist.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = employeeService.delete(id);
        if (flag) {
            request.setAttribute("mess", "xoá thành công");
        } else {
            request.setAttribute("mess", "xoá thất bại");
        }
      findAllEmployee(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.selectEmployee(id);
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();



        request.setAttribute("positionList", positionList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("employee", employee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

        request.setAttribute("positionList", positionList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.valueOf(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.valueOf(request.getParameter("educationDegreeId"));
        Integer divisionId = Integer.valueOf(request.getParameter("divisionId"));
        String username = request.getParameter("username");

        Employee employee =new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);

        boolean flag = employeeService.update(employee);
        if (flag) {
            request.setAttribute("mess", "edit thành công");
        } else {
            request.setAttribute("mess", "edit thất bại");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.valueOf(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.valueOf(request.getParameter("educationDegreeId"));
        Integer divisionId = Integer.valueOf(request.getParameter("divisionId"));
        String username = request.getParameter("username");

        Employee employee =new Employee(name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);


        Map<String, String> errors = employeeService.insert(employee);
        if (errors.isEmpty()) {
            request.setAttribute("mess", "thêm mới thành công");
        } else {
            // lấy lại những gì đã nhập
            request.setAttribute("name", name);
            request.setAttribute("birthday", birthday);
            request.setAttribute("idCard", idCard);
            request.setAttribute("salary", salary);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("positionId", positionId);
            request.setAttribute("educationDegreeId", educationDegreeId);
            request.setAttribute("divisionId", divisionId);
            request.setAttribute("username", username);
            request.setAttribute("address", address);

            request.setAttribute("mess", "thêm mới thất bại");
            request.setAttribute("positionList", positionList);
            request.setAttribute("divisionList", divisionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("errors", errors);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
