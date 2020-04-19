package dao;

import connection.ConnectionManager;
import entity.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ProductDAO {

    private Connection connection;
    private PreparedStatement statement;
    ConnectionManager connectionManager = new ConnectionManager();
    Product product = new Product();

    /**
     * Метод для получения всех продуктов определенной категории
     * Вызов происходит из ProductDisplayServlet
     * Возвращает список товаров
     * */
    public List<Product> getAllProducts (String category) {

        List <Product> productList = new LinkedList<>();

        try {
            connection = connectionManager.getConnection();
            String sql = "SELECT * FROM goods WHERE category = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, category);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                product = new Product();
                product.setId(result.getInt("id"));
                product.setLabel(result.getString("label"));
                product.setSize(result.getInt("size"));
                product.setPrice(result.getInt("price"));
                product.setDescription(result.getString("description"));
                product.setPhoto(result.getString("photo"));
                productList.add(product);
            }
        }
        catch (SQLException err){
            log.error("Ошибка при получении товара по id (метод ProductDAO.getProduct) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return productList;
    }

    /**
     * Метод для получения одного Продукта по id.
     * Вызывается из OrderDAO, CartServlet
     * */
    public Product getProductById(int id) {

        try {
            connection = connectionManager.getConnection();
            String sql = "SELECT * FROM goods WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                product = new Product();
                product.setId(result.getInt("id"));
                product.setLabel(result.getString("label"));
                product.setCategory(result.getString("category"));
                product.setSize(result.getInt("size"));
                product.setPrice(result.getInt("price"));
                product.setDescription(result.getString("description"));
                product.setPhoto(result.getString("photo"));
            }
        }
        catch (Exception err) {
            log.error("Ошибка при получении товара по id (метод ProductDAO.find) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return product;
    }
}
