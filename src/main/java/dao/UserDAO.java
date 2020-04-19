package dao;

import connection.ConnectionManager;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import java.sql.*;

@Slf4j
public class UserDAO {

    Connection connection;
    PreparedStatement statement;
    private ConnectionManager connectionManager = new ConnectionManager();

    /**
     * Метод для логирования пользователя
     * */
    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {

        User user = null;

        try {
            connection = connectionManager.getConnection();
            String sql = "SELECT * FROM user_data WHERE email = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user = new User();
                user.setFirstName(result.getString("first_name"));
                user.setEmail(email);
                user.setId(result.getInt("id"));
            }
        }
        catch (SQLException err) {
            log.error("Ошибка подключения к БД (метод UserDAO.checkLogin()) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return user;
    }

    /**
     * Метод для регистрации пользователя.
     * Вызывается из RegistrationServlet.
     * Если пользователя с email уже существует, возвращает false, в ином случае возвращает true
     * */
    public boolean userRegistration (String firstName, String password, String email) throws SQLException {

        boolean isUser = false;

        try {
            connection = connectionManager.getConnection();
            String sql = "INSERT INTO user_data (first_name, password, email) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
            isUser = true;
        }
        catch (SQLException err) {
            log.error("Пользователь с таким имнем уже существует " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return isUser;
    }
}
