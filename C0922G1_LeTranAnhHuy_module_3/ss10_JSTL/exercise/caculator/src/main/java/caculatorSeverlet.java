import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class caculatorSeverlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("first-operand"));
        double secondOperand = Double.parseDouble(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
        double result = Caculator.calculate(firstOperand, secondOperand, operator);
        request.setAttribute("result", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

