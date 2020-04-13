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
        PreparedStatement myStmt = null;
        String displayPage = "index.jsp";

        try {

            request.setCharacterEncoding("UTF-8");
            String firstName = request.getParameter("firstName");
            String pw = request.getParameter("password");
            String mail = request.getParameter("email").toLowerCase();

            connection = ConnectionManager.getConnaction();

            String sql = "INSERT INTO user_data (first_name, password, email) VALUES (?, ?, ?)";

            myStmt = connection.prepareStatement(sql);

            myStmt.setString(1, firstName);
            myStmt.setString(2, pw);
            myStmt.setString(3, mail);

            myStmt.executeUpdate();


        }

        catch (Exception e) {
            String message = "Пользователь с таким электронным адресом уже зарегистрирован";
            request.setAttribute("message", message);
            displayPage = "form-registration.jsp";
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
