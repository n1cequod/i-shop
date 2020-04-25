package dao;

import entity.Order;
import entity.Product;
import entity.User;
import org.junit.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Класс для тестирования OrderDAO
 * */
@Ignore("Тест требует наличия базы данных")
public class OrderDAOTest {
    Order order;
    OrderDAO orderDAO;
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());
    User user = new User(43, "Junit", "Junit@Junit.Junit", "Junit");
    Product product;
    ProductDAO productDAO;

    /**
     * Метод инициализирует необходимые классы
     * */
    @Before
    public void init () {
        product = new Product();
        productDAO = new ProductDAO();
        product = productDAO.getProductById(1);
        order = new Order(99, timestamp, user, product, 99);
        orderDAO = new OrderDAO();
    }

    /**
     * Тест для проверки максимального order id
     * */
    @Test
    public void testGenerateOrderId() {
        int actual = orderDAO.generateOrderId();
        List<Order> orders = orderDAO.getUserOrderDetails(actual - 1);
        Order order1 =  orders.get(0);
        int expected =  order1.getOrderId();
        assertEquals(expected, actual - 1);
    }

    /**
     * Тест для проверки что список not null
     * */
    @Test
    public void testGetUserOrdersId() {
        List<Order> orders = orderDAO.getUserOrderDetails(1);
        assertNotNull(orders);
    }

    /**
     * Тест для проверки что список not null
     * */
    @Test
    public void testGetUserOrderDetails() {
        List<Order> orders = orderDAO.getUserOrderDetails(1);
        assertNotNull(orders);
    }
}

