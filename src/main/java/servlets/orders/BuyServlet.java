package servlets.orders;

import dao.OrderDAO;
import entity.Item;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Сервлет для переноса товаров находящихся в корзине в БД order_data
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String displayPage = "buy-result.jsp";
        User user = (User) session.getAttribute("user");

        if (user == null) {
            String message = "Покупка может быть совершена только авторизованным пользователем";
            request.setAttribute("message", message);
        }
        else {
            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.generateOrderId();

            List<Item> cart = (List<Item>) session.getAttribute("cart");

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            int userId = user.getId();

            for (Item item: cart){
                orderDAO.insert(orderId, timestamp, userId, item.getProduct().getId(), item.getQuantity());
            }

            String message = "Спасибо за покупку. Приходите к нам еще!";
            request.setAttribute("message", message);

            cart.removeAll(cart);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }
}
