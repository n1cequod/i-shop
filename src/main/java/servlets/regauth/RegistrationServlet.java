package servlets.regauth;

import connection.ConnectionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String displayPage = "index.jsp";

        try {

            request.setCharacterEncoding("UTF-8");
            String firstName = request.getParameter("firstName");
            String pw = request.getParameter("password");
            String email = request.getParameter("email").toLowerCase();

            connection = ConnectionManager.getConnection();

            String sql = "INSERT INTO user_data (first_name, password, email) VALUES (?, ?, ?)";

            statement = connection.prepareStatement(sql);

            statement.setString(1, firstName);
            statement.setString(2, pw);
            statement.setString(3, email);

            statement.executeUpdate();

        }

        catch (Exception err) {
            String message = "Пользователь с таким электронным адресом уже зарегистрирован";
            request.setAttribute("message", message);
            displayPage = "form-registration.jsp";
            err.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
