package controller;

import model.bean.*;
import service.IRentTypeService;
import service.IServiceService;
import service.IServiceTypeService;
import service.Impl.RentTypeServiceImpl;
import service.Impl.ServiceServiceImpl;
import service.Impl.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private IServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    private IServiceService serviceService = new ServiceServiceImpl();
    private IRentTypeService rentTypeService = new RentTypeServiceImpl();

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
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                findAll(request, response);
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
                insertNewService(request, response);
                break;
            case "edit":
                updateService(request, response);
                break;
        }
    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAllService();

        List<RentType> rentTypeList = rentTypeService.findAll();
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();

        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = serviceService.deleteService(id);
        if (flag) {
            request.setAttribute("mess", "xoá thành công");
        } else {
            request.setAttribute("mess", "xoá thất bại");
        }
        findAll(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();

        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceType> serviceTypes= serviceTypeService.findAll();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxpeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("renttypeid"));
        int serviceTypeId = Integer.parseInt(request.getParameter("servicetypeid"));
        String standardRoom = request.getParameter("standardroom");
        String descriptionOtherConvenience = request.getParameter("descriptionotherconvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolarea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberoffloor"));

        Service service = new Service(id,name,area,cost,maxPeople,rentTypeId,serviceTypeId,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloor);
        boolean flag = serviceService.updateService(service);
        if (flag) {
            request.setAttribute("mess", "edit thành công");
            request.setAttribute("service", service);
            request.setAttribute("serviceTypes", serviceTypes);
        } else {
            request.setAttribute("mess", "edit thất bại");
            request.setAttribute("service", service);
            request.setAttribute("serviceTypes", serviceTypes);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void insertNewService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Integer area = Integer.valueOf(request.getParameter("area"));
        Double cost = Double.valueOf(request.getParameter("cost"));
        Integer maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        Integer rentTypeId = Integer.parseInt(request.getParameter("rentType"));
        Integer serviceTypeId = Integer.parseInt(request.getParameter("serviceType"));
        String standardName = request.getParameter("standardName");
        String description = request.getParameter("description");
        Double poolArea = Double.valueOf(request.getParameter("poolArea"));
        Integer numberFloor = Integer.valueOf(request.getParameter("numberFloor"));

        Service service = new Service(name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardName, description, poolArea, numberFloor);
        Map<String, String> errors = serviceService.insertService(service);
        if (errors.isEmpty()) {
            request.setAttribute("mess", "thêm mới thành công");
        } else {
            request.setAttribute("mess", "thêm mới thất bại");
            request.setAttribute("errors", errors);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
