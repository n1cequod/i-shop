package entity;

import dao.ProductDAO;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore("Тест требует наличия базы данных")
public class ItemTest {
    Item item;
    Product product;
    ProductDAO productDAO;
    int QUANTITY = 1;

    /**
     * Инициализация объекта
     * */
    @Before
    public void init() {
        productDAO = new ProductDAO();
        product = productDAO.getProductById(1);
        item = new Item(product, QUANTITY);
    }

    /**
     * Базовый тест для объекта
     * */
    @Test
    public void testItemNotNull() {
        assertNotNull(item);
    }

    /**
     * Тест геттера и сеттера количества объекта
     * */
    @Test
    public void testQuantityGetterSetter() {
        item.setQuantity(QUANTITY + 1);
        assertEquals(2, item.getQuantity());
    }
}