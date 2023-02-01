package controller;

import model.bean.Customer;
import model.bean.CustomerType;
import model.service.ICustomerService;
import model.service.ICustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();
    private ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                findAllCustomer(request, response);
                break;
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
        }
    }


    //    +++++++++++++++++++++++++++++++++++++++++++++++
    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAllCustomer();
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        String emailSearch = request.getParameter("emailSearch");
        String typeSearch = request.getParameter("typeSearch");
        List<Customer> customerList = customerService.searchCustomer(nameSearch, emailSearch, typeSearch);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("nameSearch", nameSearch);
        request.setAttribute("emailSearch", emailSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = customerService.deleteCustomer(id);
        if (flag) {
            request.setAttribute("mess", "xoá thành công");
        } else {
            request.setAttribute("mess", "xoá thất bại");
        }
        List<Customer> customerList = customerService.findAllCustomer();
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        Integer typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");


        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");


        Customer customer = new Customer(typeId, name, birthday, gender, idCard, phone, email, address);
        Map<String, String> errors = customerService.insertCustomer(customer);
        if (errors.isEmpty()) {
            request.setAttribute("mess", "thêm mới thành công");
        } else {
            // lấy lại những gì đã nhập
            request.setAttribute("type", typeId);
            request.setAttribute("name", name);
            request.setAttribute("birthday", birthday);
            request.setAttribute("gender", gender);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);

            request.setAttribute("mess", "thêm mới thất bại");
            request.setAttribute("customerTypeList", customerTypeList);
            request.setAttribute("errors", errors);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    +++++++++++++++++++edit++++++
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);

        List<CustomerType> customerTypeList = customerTypeService.findAll();

        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customer", customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Integer typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        boolean flag = customerService.updateCustomer(customer);
        if (flag) {
            request.setAttribute("mess", "edit thành công");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypeList", customerTypeList);
        } else {
            request.setAttribute("mess", "edit thất bại");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypeList", customerTypeList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

