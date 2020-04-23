package servlets.orders;

import dao.ProductDAO;
import entity.Item;
import lombok.extern.slf4j.Slf4j;
import utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Сервлет для работы с корзиной
 * */
@Slf4j
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    private static final String REFERER = "referer";

    /**
     * Диспетчер запросов. В зависимости от параметра запроса отправляет на исполнение в соответствующий метод.
     * @param request запрос
     * @param response ответ
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("add")) {
            try {
                doGetBuy(request, response);
            }
            catch (ServletException | IOException err) {
                log.error("Ошибка при добавлении товара в корзину (метод doGetBuy) " + err );
            }
        }

        else if (action.equals("removeOne")){
            try {
                doGetRemoveOne(request, response);
            }
            catch (ServletException | IOException err) {
                log.error("Ошибка при удалении одного товара из корзины (метод doGetRemoveOne) " + err);
            }
        }

        else if (action.equals("removeAll")){
            try {
                doGetRemoveAll(request, response);
            }
            catch (ServletException | IOException err) {
                log.error("Ошибка при удалении всех товаров (метод doGetRemoveAll) " + err);
            }
        }
    }

    /**
     * Метод добавляет товар в корзину.
     * Если корзина пуста добавляет товар в корзину.
     * Если корзина не пуста увеличивает кол-во товара на 1
     * @param request запрос
     * @param response ответ
     * */
    @SuppressWarnings("unchecked")
    protected void doGetBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO();

        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));

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
            ServletUtil.responseRedirect(response, request.getHeader(REFERER));
        }
        catch (Exception err) {
            log.error("Ошибка при покупке товара (метод doGetBuy) " + err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }

    /**
     * Метод удаляет один товар в корзине.
     * Если метод используется когда кол-во товара 1, то вызывается метод removeAll
     * Запросы приходят из cart.jsp
     * @param request запрос
     * @param response ответ
     * */
    @SuppressWarnings("unchecked")
    protected void doGetRemoveOne (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));

            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int checkId = existenceCheck(cart, id);
            int quantity = cart.get(checkId).getQuantity();

            if (quantity == 1) {
                doGetRemoveAll(request, response);
            }
            else {
                quantity = cart.get(checkId).getQuantity() - 1;
                cart.get(checkId).setQuantity(quantity);
                ServletUtil.responseRedirect(response, request.getHeader(REFERER));
            }
            session.setAttribute("cart", cart);
        }
        catch (Exception err){
            log.error("Ошибка при удалении одного товара из корзины (метод doGetRemoveOne) " + err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }

    /**
     * Метод полностью удаляет товар из корзины
     * @param request запрос
     * @param response ответ
     * */
    @SuppressWarnings("unchecked")
    protected void doGetRemoveAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int checkId = existenceCheck(cart, id);
            cart.remove(checkId);
            session.setAttribute("cart", cart);
            ServletUtil.responseRedirect(response, request.getHeader(REFERER));
        }
        catch (NumberFormatException err) {
            log.error("Ошибка при получении id, метод doGetRemoveAll", err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }

    /**
     * Метод предназначен для проверки находится ли товар в корзине.
     * Происходит перебор id всех продукта, и сверка с id поступившим из request.
     * Иначе возвращает индекс товара в списке товаров.
     * Если совпадений не найдено, то возвращает -1.
     * @param cart Список товаров в корзине
     * @param id идентификатор продукта
     * @return индекс продукта в корзине, либо -1
     * */
    protected int existenceCheck(List<Item> cart, int id) {

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }return -1;
    }
}
