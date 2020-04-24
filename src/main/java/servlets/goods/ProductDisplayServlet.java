package servlets.goods;

import dao.ProductDAO;
import entity.Product;
import enums.Message;
import enums.Page;
import lombok.extern.slf4j.Slf4j;
import utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Сервлет для получения товаров
 * */
@Slf4j
@WebServlet("/ProductDisplayServlet")
public class ProductDisplayServlet extends HttpServlet {

    /**
     * Метод для получения всех товаров в зависимости от категории.
     * Вызывается вкладкой "Категория товаров" (header.jsp)
     * @param request запрос пользователя
     * @param response ответ пользователю
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");
        ProductDAO productDAO = new ProductDAO();

        try {
            List <Product> productList = productDAO.getAllProductsByCategory(category);
            String displayPage = category + ".jsp";

            if (productList != null) {
                request.setAttribute("productList", productList);
            }
            else {
                String message = Message.ERROR_MSG.getMessage();
                displayPage = Page.ERROR_PAGE.getPage();
                request.setAttribute("message", message);
            }
            ServletUtil.redirectDispatcher(request, response, displayPage);
        }
        catch (Exception err) {
            log.error("Ошибка при получении данных о товарах (ProductDisplayServlet)", err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }
}
