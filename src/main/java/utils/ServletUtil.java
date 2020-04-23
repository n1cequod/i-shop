package utils;

import enums.Message;
import enums.Page;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Класс для перенаправления запросов
 * */
@Slf4j
public class ServletUtil {

    /**
     * Метод для перенаправления с информационным сообщением
     * @param request запрос, содержащий сообщение
     * @param response ответ
     * @param displayPage страница для перенаправления
     * */
    public static void redirectDispatcher (HttpServletRequest request, HttpServletResponse response, String displayPage) {

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
            dispatcher.forward(request, response);
        }
        catch (Exception err) {
            try {
                String errorPage = Page.ERROR_PAGE.getPage();
                RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
                dispatcher.forward(request, response);
            }
            catch (Exception err2) {
                log.error("Ошибка перенапарвления на страницу с ошибкой", err2);
            }
        }
    }

    /**
     * Метод для перенаправления
     * @param response ответ
     * @param displayPage страница для перенаправления
     * */
    public static void responseRedirect (HttpServletResponse response, String displayPage) {

        try {
            response.sendRedirect(displayPage);
        }
        catch (IOException err) {
            try {
                response.sendRedirect(Page.ERROR_PAGE.getPage());
            }
            catch (IOException err2) {
                log.error("Ошибка при попытке перенаправить на страницу с ошибкой", err2);
            }
        }
    }

    /**
     * Метод для перенаправления на страницу с ошибкой
     * @param request запрос
     * @param response ответ
     * */
    public static void redirectErrorPage (HttpServletRequest request, HttpServletResponse response) {

        String displayPage = Page.ERROR_PAGE.getPage();
        String massage = Message.ERROR_MSG.getMessage();
        request.setAttribute("message", massage);

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
            dispatcher.forward(request, response);
        }
        catch (Exception err) {
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
                dispatcher.forward(request, response);
            }
            catch (Exception err2) {
                log.error("Ошибка перенапарвления на страницу с ошибкой", err2);
            }
        }
    }
}
