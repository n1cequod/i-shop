package regauth;

import entity.User;

import java.sql.*;

public class UserDAO {

    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {

        String dbUrl = "jdbc:mysql://localhost:3306/my_shop?serverTimezone=UTC";
        String dbUser = "root";
        String dbPassword = "123456";

        String dbDriver = "com.mysql.cj.jdbc.Driver";
        Class.forName(dbDriver);

        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        String sql = "SELECT * FROM user_data WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setFirstName(result.getString("first_name"));
            user.setEmail(email);
        }

        connection.close();

        return user;
    }
}
