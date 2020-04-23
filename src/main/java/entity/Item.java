package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс для описания объекта "Предмет"
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    /**
     * Товар
     * */
    private Product product;

    /**
     * Количество
     * */
    private int quantity;

}
