package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс для описания объекта "Пользователь"
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * Идентификатор
     * */
    private int id;

    /**
     * Имя
     * */
    private String firstName;

    /**
     * Электронная почта
     * */
    private String email;

    /**
     * Пароль
     * */
    private String password;
}
