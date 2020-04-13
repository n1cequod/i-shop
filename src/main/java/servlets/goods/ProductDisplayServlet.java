package servlets.goods;

import dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ProductDisplayServlet")
public class ProductDisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");
        ProductDAO productDAO = new ProductDAO();

        if (category.equals("footwear")){

            try {
                List productList = productDAO.getProduct(category);
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
            catch (SQLException e) {
                throw new ServletException(e);
            }
        }

        else if (category.equals("outerwear")){

            try {
                List productList = productDAO.getProduct(category);
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
            catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }
}
