package servlets.regauth;

import dao.UserDAO;
import entity.User;
import enums.Message;
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


/**
 * Сервлет аутентификации
 * */
@Slf4j
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    /**
     * Метод для проверки данных введенных пользователем при аутентификации.
     * @param request запрос
     * @param response ответ
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("loginPassword");
        String email = request.getParameter("loginEmail");

        UserDAO userDao = new UserDAO();

        try {
            User user = userDao.checkLogin(email, password);
            String displayPage = Page.FORM_LOGIN_PAGE.getPage();

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                displayPage = Page.INDEX_PAGE.getPage();

            } else {
                String message = Message.AUTH_ERROR_MSG.getMessage();
                request.setAttribute("message", message);
            }
            ServletUtil.redirectDispatcher(request, response, displayPage);
        }
        catch (Exception err) {
            log.error("Ошибка при аутентификации пользователя", err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }
}
