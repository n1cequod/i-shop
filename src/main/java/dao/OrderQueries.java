package dao;

public final class OrderQueries {

    /**
     * SQL-запрос на добавление в БД информации о заказе пользователя.
     * */
    protected static final String INSERT_ORDER_DATA = "INSERT INTO orders_data (order_id, client_id, product_id, product_quantity, order_time) VALUES (?, ?, ?, ?, ?)";

    /**
     * SQL-запрос на получение последнего id заказа. Используется в generateOrderId.
     * */
    protected static final String SELECT_MAX_ORDER_ID = "SELECT MAX(order_id) FROM orders_data";

    /**
     * SQL-запрос для получения id и времени закзов пользователя. Используется в getUserOrdersId.
     * */
    protected static final String SELECT_ORDER_ID_AND_TIME = "SELECT DISTINCT order_id, order_time FROM orders_data WHERE client_id = ?";

    /**
     * SQL-запрос для получения всех заказов по id. Используется в getUserOrderDetails.
     * */
    protected static final String SELECT_ORDER_DETAILS = "SELECT * FROM orders_data WHERE order_id = ?";

    protected void queries (){
        /*Create cause SonarLint*/
    }
}
