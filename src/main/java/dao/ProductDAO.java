package dao;

import connection.ConnectionManager;
import entity.Product;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDAO {

    public List<Product> getProduct (String category) throws SQLException {

        Connection connection = null;
        List productList = new LinkedList();

        try {

            connection = ConnectionManager.getConnection();
            String sql = "SELECT * FROM goods WHERE category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category);
            ResultSet result = statement.executeQuery();

            Product product = null;

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

        } catch (SQLException err){
            err.printStackTrace();
        }

        connection.close();

        return productList;
    }

    /**
     * Метод для получения одного Продукта по id.
     * */

    public static Product find(int id) throws SQLException {

        Connection connection = null;
        Product product = null;

        try {
            connection = ConnectionManager.getConnection();
            String sql = "SELECT * FROM goods WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
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
            err.printStackTrace();
        }

        finally {
            connection.close();
        }

        return product;
    }

}
