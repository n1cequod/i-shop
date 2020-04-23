package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс для описания объекта "Товар"
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**Идентификатор*/
    private int id;

    /**
     * Категория
     * */
    private String category;

    /**
     * Наименование
     * */
    private String label;

    /**
     * Размер
     * */
    private int size;

    /**
     * Цена
     * */
    private int price;

    /**
     * Название фото (с расширением)
     * */
    private String photo;

    /**
     * Описание товара
     * */
    private String description;

}
