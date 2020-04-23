package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Класс для описания объекта "Заказ"
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * Идентификатор
     * */
    private int orderId;

    /**
     * Вермя заказа
     * */
    private Timestamp orderTime;

    /**
     * Заказавший пользователь
     * */
    private User user;

    /**
     * Заказанный товар
     * */
    private Product product;

    /**
     * Количество товара
     * */
    private int quantity;

    /**
     * Конструктор Заказа по его идентификатору и времени
     * @param orderId идентификатор заказа
     * @param orderTime время заказа
     * */
    public Order (int orderId, Timestamp orderTime){
        this.orderId = orderId;
        this.orderTime = orderTime;
    }
}
