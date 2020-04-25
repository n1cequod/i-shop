package dao;

import connection.ConnectionManager;
import entity.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для получения товаров из БД
 * */
@Slf4j
public class ProductDAO {

    private ResultSet resultSet;
    ConnectionManager connectionManager = new ConnectionManager();
    Product product = new Product();

    /**
     * Метод для получения всех продуктов определенной категории
     * Вызов происходит из ProductDisplayServlet
     * @param category категория товара
     * @return список товаров
     * */
    public List<Product> getAllProductsByCategory (String category) {

        List <Product> productList = new LinkedList<>();

        try (PreparedStatement statement = connectionManager.getPreparedStatement(ProductQueries.SELECT_GOODS_BY_CATEGORY)){
            statement.setString(1, category);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                product = getProduct(resultSet);
                productList.add(product);
            }
            resultSet.close();
        }
        catch (SQLException err){
            log.error("Ошибка при получении товара по id (метод ProductDAO.getAllProductsByCategory) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return productList;
    }

    /**
     * Метод для получения одного Продукта по id.
     * Вызывается из OrderDAO, CartServlet
     * @param id идентификатор продукта
     * @return товар
     * */
    public Product getProductById(int id) {

        try (PreparedStatement statement = connectionManager.getPreparedStatement(ProductQueries.SELECT_GOODS_BY_ID)){
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = getProduct(resultSet);
            }
        }
        catch (Exception err) {
            log.error("Ошибка при получении товара по id (метод ProductDAO.getProductById) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return product;
    }

    /**
     * Метод получения товаров из ResultSet
     * @param resultSet данные из БД
     * @return объект продукт
     * */
    public Product getProduct (ResultSet resultSet) {

        try {
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setLabel(resultSet.getString("label"));
            product.setCategory(resultSet.getString("category"));
            product.setSize(resultSet.getInt("size"));
            product.setPrice(resultSet.getInt("price"));
            product.setDescription(resultSet.getString("description"));
            product.setPhoto(resultSet.getString("photo"));
        }
        catch (SQLException err) {
            log.error("Ошибка при обращении к БД (метод ProductDAO.getProduct)" + err);
        }
        return product;
    }
}
