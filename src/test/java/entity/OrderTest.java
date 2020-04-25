package entity;


import dao.ProductDAO;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@Ignore("Тест требует наличия базы данных")
public class OrderTest {
    Order firstOrder;
    Order secondOrder;
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());
    User user;
    Product product;
    ProductDAO productDAO;
    int expected = 100;
    int ID = 99;

    /**
     * Инициализация объекта
     * */
    @Before
    public void init() {
        user = new User(43, "Junit", "Junit@Junit.Junit", "Junit");
        product = new Product();
        productDAO = new ProductDAO();
        product = productDAO.getProductById(1);
        firstOrder = new Order(ID, timestamp, user, product, 99);
        secondOrder = new Order(ID, timestamp);
    }

    /**
     * Базовый тест объекта
     * */
    @Test
    public void testOrderNotNull() {
        assertNotNull(firstOrder);
    }

    /**
     * Тест конструктора с двумя агрументами
     * */
    @Test
    public void testTwoArgsConstructor() {
        assertNotNull(secondOrder);
    }

    /**
     * Тест геттера и сеттера ИД
     * */
    @Test
    public void testOrderIdGetterSetter() {
        firstOrder.setOrderId(expected);
        assertEquals(expected, firstOrder.getOrderId());
    }

    /**
     * Тест геттера и сеттера количества
     * */
    @Test
    public void testQuantityGetterSetter() {
        firstOrder.setQuantity(expected);
        assertEquals(expected, firstOrder.getQuantity());
    }

}