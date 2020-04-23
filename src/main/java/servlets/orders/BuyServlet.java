package servlets.orders;

import dao.OrderDAO;
import entity.Item;
import entity.Order;
import entity.User;
import enums.Message;
import enums.Page;
import lombok.extern.slf4j.Slf4j;
import utils.ServletUtil;

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

/**
 * Сервлет для совершения покупки
 * */
@Slf4j
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

    private static final String MESSAGE = "message";

    /**
     * Метод для переноса товаров находящихся в корзине в БД order_data
     * @param request запрос
     * @param response ответ
     * */
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String displayPage = Page.BUY_RESULT_PAGE.getPage();
        String message;
        User user = (User) session.getAttribute("user");
        try {
            if (user == null) {
                message = Message.BUY_ERROR_MSG.getMessage();
                request.setAttribute(MESSAGE, message);
            }
            else {
                OrderDAO orderDAO = new OrderDAO();
                int orderId = orderDAO.generateOrderId();

                List<Item> cart = (List<Item>) session.getAttribute("cart");

                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());

                for (Item item: cart){
                    Order order = new Order(orderId, timestamp, user, item.getProduct(),  item.getQuantity());
                    orderDAO.insert(order);
                }
                message = Message.BUY_THANKS_MSG.getMessage();
                request.setAttribute(MESSAGE, message);

                cart.clear();
            }
            ServletUtil.redirectDispatcher(request, response, displayPage);
        }

        catch (Exception err) {
            log.error("Ошибка при обращении в BuyServlet", err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }
}
