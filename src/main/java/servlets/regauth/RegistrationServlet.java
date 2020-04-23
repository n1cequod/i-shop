package servlets.regauth;


import dao.UserDAO;
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

/**
 * Сервлет регистрации
 * */
@Slf4j
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    /**
     * Метод регистрации пользователя.
     * @param request запрос
     * @param response ответ
     * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isUser;
        String displayPage = Page.INDEX_PAGE.getPage();
        UserDAO userDAO = new UserDAO();

        try {
            request.setCharacterEncoding("UTF-8");
            String firstName = request.getParameter("firstName");
            String pw = request.getParameter("pswd");
            String email = request.getParameter("email").toLowerCase();
            isUser = userDAO.userRegistration(firstName, pw, email);
            if (!isUser) {
                displayPage = Page.FORM_REG_PAGE.getPage();
                String message = Message.REG_ERROR_MSG.getMessage();
                request.setAttribute("message", message);
            }
            ServletUtil.redirectDispatcher(request, response, displayPage);
        }
        catch (Exception err) {
            log.error("Ошибка при регистрации", err);
            ServletUtil.redirectErrorPage(request, response);
        }
    }
}
