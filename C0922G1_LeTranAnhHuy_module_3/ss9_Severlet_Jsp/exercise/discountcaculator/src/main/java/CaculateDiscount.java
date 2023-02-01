import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CaculateDiscount", value = "/display-discount")
public class CaculateDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String product = request.getParameter("product");
        float listprice = Float.parseFloat(request.getParameter("listprice"));
        float discountpercent = Float.parseFloat(request.getParameter("discountpercent"));

        float discountamount = (float) (listprice * discountpercent * 0.01);
        float discountprice = listprice-discountamount;

        request.setAttribute("name",name);
        request.setAttribute("product",product);
        request.setAttribute("listprice",listprice);
        request.setAttribute("discountpercent",discountpercent);
        request.setAttribute("discountamount",discountamount);
        request.setAttribute("discountprice",discountprice);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);

    }

}
