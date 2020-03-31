package goods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FootwearDisplayServlet")
public class FootwearDisplayServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dbUrl = "jdbc:mysql://localhost:3306/my_shop?serverTimezone=UTC";
        String dbUser = "root";
        String dbPassword = "123456";

        Connection myConn = null;
        Statement myStmt = null;

        List dataList = new ArrayList();

        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbDriver);

            myConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM footwear";
            ResultSet myRes = myStmt.executeQuery(sql);
            String destPage = "footwear.jsp";

            while (myRes.next()){
                List tempList = new ArrayList();
                tempList.add(myRes.getString("label"));
                tempList.add(myRes.getInt("size"));
                tempList.add(myRes.getString("description"));
                tempList.add(myRes.getString("photo"));
                tempList.add(myRes.getInt("id"));
                dataList.add(tempList);
                request.setAttribute("data", dataList);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
