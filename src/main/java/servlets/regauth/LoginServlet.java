package servlets.regauth;

import dao.UserDAO;
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
import java.sql.SQLException;

@Slf4j
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("loginPassword");
        String email = request.getParameter("loginEmail");

        UserDAO userDao = new UserDAO();

        try {
            User user = userDao.checkLogin(email, password);
            String displayPage = "form-login.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                displayPage = "index.jsp";

            } else {
                String message = "Неверно указана электронная почта или пароль. Пожалуйста, попробуйте снова.";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
            dispatcher.forward(request, response);
        }
        catch (SQLException | ClassNotFoundException err) {
            log.error("Ошибка при логировании пользователя " + err);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
