package servlets.orders;

import dao.OrderDAO;
import entity.Order;
import entity.User;
import lombok.extern.slf4j.Slf4j;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet("/PersonalOrdersServlet")
public class PersonalOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Метод распределяет запрос на исполнение в зависимсоти от переменной action
     * Данные о action передаются из personal-orders.jsp
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("getOrdersId")) {
            try {
                doGetOrdersId(request, response);
            }
            catch (ServletException | IOException err) {
                log.error("Ошибка получения ИД заказов метод PersonalOrdersServlet.doGetOrdersId" + err);
            }

        }
        else if (action.equals("getOrderDetail")) {
            try {
                doGetOrderDetail(request, response);
            }
            catch (ServletException | IOException err) {
                log.error("Ошибка получения ИД заказов метод PersonalOrdersServlet.doGetOrdersId" + err);
            }
        }
    }

    /**
     * Метод для получения уникальных ИД заказов.
     * Получение происходит по ИД пользователя.
     * */
    protected void doGetOrdersId (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List <Order> ordersIdList;
        OrderDAO orderDAO = new OrderDAO();

        User user = (User) session.getAttribute("user");

        ordersIdList = orderDAO.getUserOrdersId(user.getId());
        request.setAttribute("ordersIdList", ordersIdList);

        String displayPage = "/personal-page/index-personal.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }

    /**
     * Метод для получения всех товаров из конкретного заказа
     * */
    protected void doGetOrderDetail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> productList;
        OrderDAO orderDAO = new OrderDAO();

        int orderId = Integer.parseInt(request.getParameter("id"));

        productList = orderDAO.getUserOrderDetails(orderId);
        request.setAttribute("productList", productList);

        String displayPage = "/personal-page/order-details.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }
}
