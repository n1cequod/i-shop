package servlets.orders;

import dao.OrderDAO;
import dao.ProductDAO;
import entity.Order;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PersonalOrdersServlet")
public class PersonalOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Метод предназначен для получения из orderDAO всех заказов
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");


        if (action.equals("getOrdersId")) {
            doGetOrdersId(request, response);
        }

        else if (action.equals("getOrderDetail")) {
            doGetOrderDetail(request, response);
        }

    }

    protected void doGetOrdersId (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List ordersIdList;
        User user = (User) session.getAttribute("user");

        OrderDAO orderDAO = new OrderDAO();

        //Для получения ИД заказов и времени заказов пользователя из orders_data
        ordersIdList = orderDAO.getUserOrdersId(user.getId());
        request.setAttribute("ordersIdList", ordersIdList);

        String displayPage = "/personal-page/index-personal.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }

    protected void doGetOrderDetail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List productList;

        int orderId = Integer.parseInt(request.getParameter("id"));

        OrderDAO orderDAO = new OrderDAO();

        //Для получения всех закзаов пользователя из orders_data
        productList = orderDAO.getUserOrderDetails(orderId);
        request.setAttribute("productList", productList);

        String displayPage = "/personal-page/order-details.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }

}
