package dao;

import connection.ConnectionManager;
import entity.User;

import java.sql.*;

public class UserDAO {

    Connection connection = null;

    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {

        Connection connection = ConnectionManager.getConnaction();

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
