package entity;

import java.sql.Timestamp;

public class Order {

    private int orderId;
    private Timestamp orderTime;
    private User user;
    private Product product;
    private int quantity;

    public Order () {

    }

    public Order (int orderId, Timestamp orderTime){
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    public Order (int orderId, Timestamp orderTime, User user, Product product, int quantity) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
