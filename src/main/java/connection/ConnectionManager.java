package connection;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class ConnectionManager {

    private Connection connection;

    public Connection getConnection() {

        try {
            InputStream appProp = Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties");
            Properties props = new Properties();
            props.load(appProp);

            String dbUrl = props.getProperty("dbUrl");
            String dbUser = props.getProperty("dbUser");
            String dbPassword = props.getProperty("dbPassword");

            String dbDriver = props.getProperty("dbDriver");
            Class.forName(dbDriver);

            connection = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }
        catch (Exception err) {
            log.error("Ошибка подключения к БД (метод ConnectionManager.getConnection) " + err);
        }
        return connection;
    }

    public void closeConnection () {

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException err) {
                log.error("Попытка закрытия подключения во время подключения к БД (метод ConnectionManager.closeConnection) " + err);
            }
        }
    }
}