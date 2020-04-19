package servlets.orders;

import dao.ProductDAO;
import entity.Item;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * Деспетчер запросов. В зависимости от параметра запроса отправляет на исполнение в соответствующий метод.
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("add")) {
            doGetBuy(request, response);
        }

        else if (action.equals("removeOne")){
            doGetRemoveOne(request, response);
        }

        else if (action.equals("removeAll")){
            doGetRemoveAll(request, response);
        }
    }

    /**
     * Метод добавляет товар в корзину.
     * Если корзина пуста добавляет товар в корзину.
     * Если корзина не пуста увеличивает кол-во товара на 1
     * */
    protected void doGetBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO();
        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            if (session.getAttribute("cart") == null) {
                List<Item> cart = new ArrayList<>();
                cart.add(new Item(productDAO.getProductById(id), 1));
                session.setAttribute("cart", cart);
            }
            else {
                List<Item> cart = (List<Item>) session.getAttribute("cart");
                int checkId = existenceCheck(cart, id);

                if (checkId == -1) {
                    cart.add(new Item(productDAO.getProductById(id), 1));
                }
                else {
                    int quantity = cart.get(checkId).getQuantity() + 1;
                    cart.get(checkId).setQuantity(quantity);
                }
                session.setAttribute("cart", cart);
            }
            response.sendRedirect(request.getHeader("referer"));

        }
        catch (Exception err) {
            log.error("Ошибка при покупке товара (метод doGetBuy) " + err);
        }
    }

    /**
     * Метод удаляет один товар в корзине.
     * Если метод используется когда кол-во товара 1, то вызывается метод removeAll
     * Запросы приходят из cart.jsp
     * */

    protected void doGetRemoveOne (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int checkId = existenceCheck(cart, id);
            int quantity = cart.get(checkId).getQuantity();

            if (quantity == 1) {
                doGetRemoveAll(request, response);
            }
            else {
                quantity = cart.get(checkId).getQuantity() - 1;
                cart.get(checkId).setQuantity(quantity);
                response.sendRedirect(request.getHeader("referer"));
            }
            session.setAttribute("cart", cart);
        }
        catch (Exception err){
            log.error("Ошибка при удалении одного товара из корзины (метод doGetRemoveOne) " + err);
        }
    }

    /**
     * Метод полностью удаляет товар из корзины
     * */
    protected void doGetRemoveAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int checkId = existenceCheck(cart, id);
        cart.remove(checkId);
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("referer"));
    }


    /**
     * Метод предназначен для проверки находится ли товар в корзине.
     * Происходит перебор id всех продукта, и сверка с id поступившим из request.
     * Иначе возвращает индекс товара в списке товаров.
     * Если совпадений не найдено, то возвращает -1.
     * */
    protected int existenceCheck(List<Item> cart, int id) {

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }

        }return -1;
    }
}
