import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerSeverlet extends HttpServlet {
    List<Customer> customerList = new ArrayList<>();


    @Override
    public void init() throws ServletException {

        customerList.add(new Customer("Nguyễn Ngọc Duy", "06/06/2001", "Đà Nẵng", "https://scontent.fsgn2-1.fna.fbcdn.net/v/t39.30808-6/315978769_1517322385409550_3985473778380024369_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=YMByUcropAoAX_lKlac&_nc_ht=scontent.fsgn2-1.fna&oh=00_AfCSqn8N6BLyuTSMmvW3VrqRGGudZN7O_s6lVBAtsDuv2A&oe=63B3B822"));
        customerList.add(new Customer("Lê Đức Nghĩa", "14/10/2003", "Đà Nẵng", "https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.15752-9/321908079_544432914255595_8682076616412490109_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=ae9488&_nc_ohc=vTC8vW_AFKkAX-ciZX6&_nc_ht=scontent.fsgn2-1.fna&oh=03_AdSQTnl4Ph1oKurwOHcGXsy-l8Zem7PHIwdkbxrxc1rc3Q&oe=63D5E4D8"));
        customerList.add(new Customer("Nguyễn Thị Thuý Nga", "19/06/2004", "Hà Tĩnh", "https://scontent.fsgn2-5.fna.fbcdn.net/v/t1.6435-9/150403029_1008019993063024_8154978546946014954_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=174925&_nc_ohc=7EyzNvde48cAX9peQys&tn=A5dNulvfqAYSyM8u&_nc_ht=scontent.fsgn2-5.fna&oh=00_AfDuRd0sWTvzqeZegXDWDvZKZ_wHBh2L5pmvPzCmGowkMg&oe=63D5E6F4"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerListData", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
