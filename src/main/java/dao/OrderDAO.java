package dao;

import connection.ConnectionManager;
import entity.Order;
import entity.Product;
import entity.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class OrderDAO {

    ConnectionManager connectionManager = new ConnectionManager();
    Connection connection = null;
    PreparedStatement statement = null;

    /**
     * Метод добавлять данные о заказе и пользователе в БД order_data.
     * Метод вызывается из BuyServlet
     * */
    public void insert(int orderId, Timestamp orderTime, int userId, int productId, int quantity) {

        try {
            connection = connectionManager.getConnection();
            String sql = "INSERT INTO orders_data (order_id, client_id, product_id, product_quantity, order_time) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            statement.setInt(2, userId);
            statement.setInt(3, productId);
            statement.setInt(4, quantity);
            statement.setTimestamp(5, orderTime);
            statement.executeUpdate();
        }
        catch (Exception err) {
            log.error("Ошибка при добавлении данных в БД (метод OrderDAO.insert) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
    }

    /**
     * Метод для генерации номера заказа.
     * Происходит поиск максимального order_id в БД orders_data и увеличивается на один.
     * Если null, то присваивается значение 1
     * Метод вызывается из BuyServlet
     * */
    public int generateOrderId () {

        try {
            connection = connectionManager.getConnection();
            String sql = "SELECT MAX(order_id) FROM orders_data";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("MAX(order_id)") + 1;
            }
        }
        catch (Exception err){
            log.error("Ошибка при генерации номера заказа (метод OrderDAO.generateOrderId) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return 1;
    }

    /**
     * Метод для получения id и времени всех заказов пользователя.
     * Запрос просиходит из PersonalOrdersServlet
     * Для отображения в personal-orders.jsp
     * */
    public List <Order> getUserOrdersId(int id) {

        List<Order> orderIdList = new LinkedList<>();
        int userOrderId;
        Timestamp timestamp;
        Order order;

        try {
            connection = connectionManager.getConnection();
            String sql = "SELECT DISTINCT order_id, order_time FROM orders_data WHERE client_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                userOrderId = result.getInt("order_id");
                timestamp = result.getTimestamp("order_time");
                order = new Order(userOrderId, timestamp);
                orderIdList.add(order);
            }
        }
        catch (Exception err){
            log.error("Ошибка при получении id заказаов (метод OrderDAO.getUserOrdersId) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return orderIdList;
    }

    /**
     * Метод для получения детализированной информации о заказае.
     * Происходит получение всех товаров по определенному id заказа
     * */
    public List<Order> getUserOrderDetails(int orderId){

        List<Order> orderDetailList = new LinkedList <>();

        Product product;
        ProductDAO productDAO = new ProductDAO();
        User user;
        Order order;
        int quantity;
        Timestamp timestamp;

        try {
            connection = connectionManager.getConnection();
            String sql = "SELECT * FROM orders_data WHERE order_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                user = new User();
                user.setId(result.getInt("client_id"));
                timestamp = result.getTimestamp("order_time");
                product = productDAO.getProductById(result.getInt("product_id"));
                quantity = result.getInt("product_quantity");
                order = new Order(orderId, timestamp, user, product, quantity);
                orderDetailList.add(order);
            }
        }
        catch (Exception err){
            log.error("Ошибка при получении всех товаров из заказа (метод OrderDAO.getUserOrderDetails) " + err);
        }
        finally {
            connectionManager.closeConnection();
        }
        return orderDetailList;
    }
}
