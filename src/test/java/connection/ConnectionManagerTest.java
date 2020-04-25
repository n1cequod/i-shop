package connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;


@Ignore ("Тест требует наличия базы данных")
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