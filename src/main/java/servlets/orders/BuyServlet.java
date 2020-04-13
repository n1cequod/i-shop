package servlets.orders;

import com.mysql.cj.Session;
import dao.UserDAO;
import entity.Item;
import entity.Product;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String displayPage = "buy-result.jsp";


        User user = (User) session.getAttribute("user");
        System.out.println(user.getId());
        System.out.println(user.getFirstName());
        System.out.println(user.getEmail());


//        List<Item> items = (List<Item>) session.getAttribute("cart");
//        for (Item item : items){
//            Product product = item.getProduct();
//            System.out.println(product.getId());
//        }


        if (session.getAttribute("user") == null){
            String message = "Покупка может быть совершена только авторизованным пользователем";
            request.setAttribute("message", message);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }
}
