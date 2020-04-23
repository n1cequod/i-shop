package dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDAOTest {

    @Test
    public void insert() {
    }

    @Test
    public void generateOrderId() {
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.generateOrderId();
        // Тут надо както вернуть наш сгенеренный OrderId в actual и сверить с expected
        assertEquals(true, true);
    }

    @Test
    public void getUserOrdersId() {
    }

    @Test
    public void getUserOrderDetails() {
    }
}

