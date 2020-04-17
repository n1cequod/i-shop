package connection;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionManager {

        public static Connection getConnection() {

            Connection connection = null;

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

            } catch (Exception e) {
                e.printStackTrace();
            }

            return connection;
        }
    }