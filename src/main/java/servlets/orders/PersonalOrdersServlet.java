package servlets.orders;

import dao.OrderDAO;
import entity.Order;
import entity.User;
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
import java.util.List;

/**
 * Сервлет для отображения заказов пользователя
 * */
@Slf4j
@WebServlet("/PersonalOrdersServlet")
public class PersonalOrdersServlet extends HttpServlet {

    /**
     * Метод распределяет запрос на исполнение в зависимости от переменной action
     * Данные о action передаются из personal-orders.jsp
     * @param request запрос
     * @param response ответ
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("getOrdersId")) {
            try {
                doGetOrdersId(request, response);
            }
            catch (Exception err) {
                log.error("Ошибка получения ИД заказов метод PersonalOrdersServlet.doGetOrdersId", err);
            }
        }
        else if (action.equals("getOrderDetail")) {
            try {
                doGetOrderDetail(request, response);
            }
            catch (ServletException | IOException err) {
                log.error("Ошибка получения ИД заказов метод PersonalOrdersServlet.doGetOrdersId", err);
            }
        }
    }

    /**
     * Метод для получения уникальных ИД заказов.
     * Получение происходит по ИД пользователя.
     * @param request запрос
     * @param response ответ
     * */
    protected void doGetOrdersId (HttpServletRequest request, HttpServletResponse response) {

        List <Order> ordersIdList;
        OrderDAO orderDAO = new OrderDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        ordersIdList = orderDAO.getUserOrdersId(user.getId());
        request.setAttribute("ordersIdList", ordersIdList);

        String displayPage = Page.INDEX_PERSONAL_PAGE.getPage();
        ServletUtil.redirectDispatcher(request, response, displayPage);
    }

    /**
     * Метод для получения всех товаров из конкретного заказа
     * @param request запрос
     * @param response ответ
     * */
    protected void doGetOrderDetail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> productList;
        OrderDAO orderDAO = new OrderDAO();

        try {
            int orderId = Integer.parseInt(request.getParameter("id"));
            productList = orderDAO.getUserOrderDetails(orderId);
            request.setAttribute("productList", productList);
            String displayPage = Page.ORDER_DETAIL_PAGE.getPage();
            ServletUtil.redirectDispatcher(request, response, displayPage);
        }
        catch (NumberFormatException | IllegalStateException err) {
            log.error("Ошибка при получении товаров заказа (метод doGetOrderDetail)", err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }
}
