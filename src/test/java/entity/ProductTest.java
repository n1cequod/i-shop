package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    Product product;
    private int ID = 999;
    private String CATEGORY = "footwear";
    private String LABEL = "TestLabel";
    private int SIZE = 99;
    private int PRICE = 999;
    private String PHOTO = "test.jpg";
    private String DESCRIPTION = "TestDescription";

    /**
     * Инициализация объекта
     * */
    @Before
    public void init() {
        product = new Product(ID, CATEGORY, LABEL, SIZE, PRICE, PHOTO, DESCRIPTION);
    }

    /**
     * Базовый тест для объекта
     * */
    @Test
    public void testProductNotNull() {
        assertNotNull(product);
    }

    /**
     * Тест геттера и сеттера цены объекта
     * */
    @Test
    public void testPriceGetterSetter() {
        product.setPrice(1111);
        assertNotEquals(PRICE, product.getPrice());
    }
}