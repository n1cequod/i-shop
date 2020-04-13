package servlets.orders;

import dao.ProductDAO;
import entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** Корзина выбраных товаров реализованная через сессию.
         * Если корзина НЕ пуста, то в уже существующую корзину добавляется Item.*/

        //TODO Дополнить функционалом по удалению товаров
        // TODO Дополнить функционалом по добавлению еще одного товара

        ProductDAO productDAO = new ProductDAO();
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));

        try {

            if (session.getAttribute("cart") == null) {
                List<Item> cart = new ArrayList<Item>();
                cart.add(new Item(productDAO.find(id), 1));
                session.setAttribute("cart", cart);
            }

            else {
                List<Item> cart = (List<Item>) session.getAttribute("cart");
                cart.add(new Item(productDAO.find(id), 1));
                session.setAttribute("cart", cart);

            }

        } catch (Exception err) {
            err.printStackTrace();

        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
//        dispatcher.forward(request, response);

        response.sendRedirect(request.getHeader("referer"));
        }
    }
