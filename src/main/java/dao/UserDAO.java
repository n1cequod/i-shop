package dao;

import connection.ConnectionManager;
import entity.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * Класс для получения пользователя
 * */
@Slf4j
public class UserDAO {

    ResultSet resultSet;
    private ConnectionManager connectionManager = new ConnectionManager();

    /**
     * Метод для логирования пользователя
     * @param email электронная почта указанная при аутентификации
     * @param password пароль указанный при аутентификации
     * @return пользователя
     * */
    public User checkLogin(String email, String password) {

        User user = null;

        try (PreparedStatement statement = connectionManager.getPreparedStatement(UserQueries.SELECT_USER)){
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setFirstName(resultSet.getString("first_name"));
                user.setEmail(email);
                user.setId(resultSet.getInt("id"));
            }
        }
        catch (SQLException err) {
            log.error("Ошибка при обращении к БД(метод UserDAO.checkLogin()) " + err);
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
     * @param firstName имя, указанное при регистрации
     * @param password пароль, указанный при регистрации
     * @param email эл. почта, указанная при регистрации
     * @return false если пользователь регистрировался ранее, если пользователь новый - true
     * */
    public boolean userRegistration (String firstName, String password, String email) {

        boolean isUser = false;

        try (PreparedStatement statement = connectionManager.getPreparedStatement(UserQueries.INSERT_USER)){
            statement.setString(1, firstName);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
            isUser = true;
        }
        catch (SQLException err) {
            log.error("Ошибка при обращении к БД (метод userRegistration)", err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return isUser;
    }
}
