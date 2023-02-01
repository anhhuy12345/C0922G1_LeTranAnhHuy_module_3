package controller;


import model.Book;
import service.IBookService;
import service.impl.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookCardServlet", urlPatterns = "/book")
public class BookCardServlet extends HttpServlet {
    private IBookService bookService = new BookServiceImpl();
//    private IStudentService studentService = new StudentServiceImpl();
//    private IBookBorrowCardService bookBorrowCardService = new BookBorrowCardServiceImpl();

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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insert(request, response);
                break;
            case "edit":
                update(request, response);
                break;
        }
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.findAll();
        request.setAttribute("bookList", bookList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/sach/list.jsp");
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
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
//        String idBook = request.getParameter("idBook");
//        Book book = bookService.findById(idBook);
//        List<Book> bookList = bookService.findAll();
//        List<Student> studentList = studentService.findAll();
//        request.setAttribute("bookList", bookList);
//        request.setAttribute("studentList", studentList);
//        request.setAttribute("book", book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
