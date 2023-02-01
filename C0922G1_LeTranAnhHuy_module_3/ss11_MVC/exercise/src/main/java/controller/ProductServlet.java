package controller;

import model.bean.Product;
import model.service.Impl.IProductService;
import model.service.Impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private IProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            Tạo sản phẩm mới
            case "create":
                showProductForm(request, response);
                break;
//            Cập nhật thông tin sản phẩm
            case "edit":
                showEditForm(request, response);
                break;
//            Xoá một sản phẩm
            case "delete":
                showDeleteForm(request, response);
                break;

//            Xem chi tiết một sản phẩm
            case "view":
                viewProduct(request, response);
                break;
            //            Tìm kiếm sản phẩm theo tên
            case "search":
                findNameProduct(request, response);
                break;
//            Hiển thị danh sách sản phẩm
            default:
                showListProduct(request, response);
                break;
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            Tạo sản phẩm mới
            case "create":
                createProduct(request, response);
                break;
//            Cập nhật thông tin sản phẩm
            case "edit":
                updateProduct(request, response);
                break;
//            Xoá một sản phẩm
            case "delete":
                deleteProduct(request, response);
                break;
            //            Tìm kiếm sản phẩm theo tên
            case "findOfName":
                findNameProduct(request, response);
                break;
        }
    }


//    ----------------------------------------------------------------------------------------------------

    // hiển thị list product
    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        // lấy list product để hiển thị
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // show form để thêm sản phẩm
    private void showProductForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // tiến hành tạo mới product
    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double cost = Double.parseDouble(request.getParameter("cost"));
        String describe = request.getParameter("describe");
        String nameProducer = request.getParameter("nameProducer");
        int id = (int) (Math.random() * 10000);

        Product product = new Product(id, name, cost, describe, nameProducer);
        productService.save(product);

        request.setAttribute("message", "New product was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // hiển thị form để edit sản phẩm
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        // lấy id từ trong bảng
        int id = Integer.parseInt(request.getParameter("id"));
        //lấy customer theo id sẵn có
        Product product = productService.findById(id);
        // gửi id xuống form để tí tiến hành edit

        request.setAttribute("product", product);
        request.setAttribute("id", id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // tiến hành edit sản phẩm
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        // tìm customer cần edit trong list customer
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        String name = request.getParameter("name");
        double cost = Double.parseDouble(request.getParameter("cost"));
        String describe = request.getParameter("describe");
        String nameProducer = request.getParameter("nameProducer");
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            // update customer
            product.setName(name);
            product.setCost(cost);
            product.setDescribe(describe);
            product.setNameProducer(nameProducer);

            productService.update(id, product);

            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // show lại product chuẩn bị xoá và xác nhận có delete không
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;

        request.setAttribute("product", product);

        dispatcher = request.getRequestDispatcher("view/delete.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // tiến hành xoá product
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);

        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // hiển thị view một sản phẩm khi click vào tên của nó
    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("view/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    tìm sản phẩm theo tên
    private void findNameProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("inputName");
        Product product = productService.findByName(name);
        RequestDispatcher dispatcher;

        if (product == null) {
            request.setAttribute("productFind", "NOT FOUND PRODUCT");
            showListProduct(request,response);
            dispatcher = request.getRequestDispatcher("view/list.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("view/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
