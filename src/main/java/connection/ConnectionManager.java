package connection;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Класс для управления подключением  к БД
 * */
@Slf4j
public class ConnectionManager {

    private Connection connection;

    /**
     * Метод для создания подключения к БД
     * @return соединение
     * */
    public Connection getConnection() {

        try {
            InputStream appProp = Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties");
            Properties properties = new Properties();
            properties.load(appProp);

            String dbUrl = properties.getProperty("dbUrl");
            String dbUser = properties.getProperty("dbUser");
            String dbPassword = properties.getProperty("dbPassword");

            String dbDriver = properties.getProperty("dbDriver");
            Class.forName(dbDriver);

            connection = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }
        catch (Exception err) {
            log.error("Ошибка подключения к БД (метод ConnectionManager.getConnection) " + err);
        }
        return connection;
    }

    /**
     * Метод для закрытия подключения
     * */
    public void closeConnection () {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException err) {
                log.error("Попытка закрытия подключения во время подключения к БД (метод ConnectionManager.closeConnection) " + err);
            }
        }
    }

    /**
     * Метод для создания подготовленного выражения
     * @param query запрос к БД
     * @return подготовленное выражение
     * */
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        try {
            connection = getConnection();
            if (connection != null) {
                return connection.prepareStatement(query);
            }
            else {
                String statementErrorMsg = "Проблемы с подключением к БД при создании подготовленного выражения, метод (getPreparedStatement)";
                log.error(statementErrorMsg);
                throw new SQLException(statementErrorMsg);
            }
        }
        catch (SQLException err) {
            String errorMsg = "Ошибка при попытке получить подготовленное выражение";
            log.error(errorMsg, err);
            throw new SQLException(err);
        }
    }
}