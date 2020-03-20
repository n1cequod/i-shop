package regauth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/my_shop?serverTimezone=UTC";
        String user = "root";
        String password = "123456";

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {

            String dbDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbDriver);

            String firstName = request.getParameter("firstName");
            String pw = request.getParameter("password");
            String mail = request.getParameter("email");

            myConn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO user_data (first_name, password, email) VALUES (?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, firstName);
            myStmt.setString(2, pw);
            myStmt.setString(3, mail);

            myStmt.executeUpdate();

        }

        catch (Exception exc) {
            exc.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
