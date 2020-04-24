package connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionManagerTest {
    Connection connection = null;
    ConnectionManager connectionManager = new ConnectionManager();

    /**
     * Инициализация подключения
     * */
    @Before
    public void init() {
        connection = connectionManager.getConnection();
    }

    /**
     * Тестирование подключения
     * */
    @Test
    public void testGetConnection() {
        System.out.println(connection);
        assertNotNull(connection);
    }

    /**
     * Закрытие подключения
     * */
    @After
    public void end() {
        connectionManager.closeConnection();
    }
}