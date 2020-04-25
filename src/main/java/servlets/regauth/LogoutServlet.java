package servlets.regauth;

import enums.Message;
import enums.Page;
import lombok.extern.slf4j.Slf4j;
import utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Сервлет для выхода из системы
 * */
@Slf4j
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    /**
     * Метод для выхода
     * @param request запрос
     * @param response ответ
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.removeAttribute("user");
            String logOutMessage = Message.LOGOUT_MSG.getMessage();
            request.setAttribute("logOutMessage", logOutMessage);
            ServletUtil.redirectDispatcher(request, response, Page.FORM_LOGIN_PAGE.getPage());
        }
    }
}
