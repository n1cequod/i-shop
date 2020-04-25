package dao;

import entity.Product;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Класс для тестирования ProductDAO
 * */
@Ignore("Тест требует наличия БД")
public class ProductDAOTest {
    Product product;
    ProductDAO productDAO;
    String category = "footwear";

    /**
     * Метод инициализирует необходимые классы
     * */
    @Before
    public void init(){
        product = new Product();
        productDAO = new ProductDAO();
    }

    /**
     * Метод для провекри категории
     * */
    @Test
    public void testGetAllProductsByCategory() {
        List<Product> productList = productDAO.getAllProductsByCategory(category);
        product = productList.get(0);
        assertEquals(category, product.getCategory());
    }

    /**
     * Метод для проверки что возвращаемое значение not null
     * */
    @Test
    public void testGetAllProductsByCategoryNotNull() {
        List<Product> productList = productDAO.getAllProductsByCategory(category);
        assertNotNull(productList);
    }

    /**
     * Метод для проверки категории
     * */
    @Test
    public void testGetProductById() {
        int id = 1;
        product = productDAO.getProductById(id);
        assertEquals(category, product.getCategory());
    }

    /**
     * Метод для проверки что возвращаемое значение not null
     * */
    @Test
    public void testGetProductByIdNotNull() {
        int id = 1;
        product = productDAO.getProductById(id);
        assertNotNull(product);
    }
}