package controller;

import model.bean.*;
import model.service.IContractService;
import model.service.ICustomerService;
import model.service.IEmployeeService;
import model.service.IServiceService;
import model.service.impl.ContractServiceImpl;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeServiceImpl();
    ICustomerService customerService = new CustomerServiceImpl();
    IServiceService serviceService = new ServiceServiceImpl();

    IContractService contractService = new ContractServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            default:
                findAllContract(request, response);
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
                insertNewService(request, response);
                break;
        }
    }

    //    ++++++++++++++
    private void findAllContract(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAllCustomer();
        List<Service> serviceList = serviceService.findAllService();

        List<Contract> contractList = contractService.findAll();

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAllCustomer();
        List<Service> serviceList = serviceService.findAllService();

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewService(HttpServletRequest request, HttpServletResponse response) {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Double deposit = Double.valueOf(request.getParameter("deposit"));
        Double totalMoney = Double.valueOf(request.getParameter("totalMoney"));
        Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
        Integer customerId = Integer.valueOf(request.getParameter("customerId"));
        Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));

        Contract contract = new Contract(startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
        Map<String, String> errors = contractService.insert(contract);
        if (errors.isEmpty()) {
            request.setAttribute("mess", "thêm mới thành công");
        } else {
            request.setAttribute("mess", "thêm mới thất bại");
            request.setAttribute("errors", errors);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
