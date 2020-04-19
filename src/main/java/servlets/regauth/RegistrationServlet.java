package servlets.regauth;


import dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isUser;
        String displayPage = "index.jsp";

        UserDAO userDAO = new UserDAO();

        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String pw = request.getParameter("password");
        String email = request.getParameter("email").toLowerCase();

        try {
            isUser = userDAO.userRegistration(firstName, pw, email);
            if (!isUser) {
                String message = "Пользователь уже зарегистрирован в система";
                request.setAttribute("message", message);
                displayPage = "form-registration.jsp";
            }
        }
        catch (Exception err) {
            log.error("Ошибка при регистрации " + err);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
