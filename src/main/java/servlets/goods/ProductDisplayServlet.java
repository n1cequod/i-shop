package servlets.goods;

import dao.ProductDAO;
import entity.Product;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@WebServlet("/ProductDisplayServlet")
public class ProductDisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Метод для получения всех товаров в зависимости от категории.
     * Вызывается вкладкой "Категория товаров" (header.jsp)
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");
        ProductDAO productDAO = new ProductDAO();

        if (category.equals("footwear")){
            try {
                List <Product> productList = productDAO.getAllProducts(category);
                String displayPage = "footwear.jsp";

                if (productList != null) {
                    request.setAttribute("productList", productList);
                    displayPage = "footwear.jsp";
                } else {
                    String message = "Обишка!";
                    request.setAttribute("message", message);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
                dispatcher.forward(request, response);
            }
            catch (Exception err) {
                log.error("Ошибка при получении данных о товарах (ProductDisplayServlet) " + err);
            }
        }
        else if (category.equals("outerwear")){

            try {
                List <Product> productList = productDAO.getAllProducts(category);
                String displayPage = "outerwear.jsp";

                if (productList != null) {
                    request.setAttribute("productList", productList);
                    displayPage = "outerwear.jsp";
                } else {
                    String message = "Обишка!";
                    request.setAttribute("message", message);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
                dispatcher.forward(request, response);
            }
            catch (Exception err) {
                log.error("Ошибка при получении данных о товарах (ProductDisplayServlet) " + err);
            }
        }
    }
}
