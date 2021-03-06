package enums;


public enum Message {
    /**
     * Сообщение при выходе из системы
     * */
    LOGOUT_MSG("Всего хорошего. Будем рады видеть Вас снова!"),

    /**
     * Сообщение об ошибке при аутентификации
     * */
    AUTH_ERROR_MSG("Неверно указана электронная почта или пароль. Пожалуйста, попробуйте снова."),

    /**
     * Сообщение об ошибке при регистрации
     * */
    REG_ERROR_MSG("Пользователь уже зарегистрирован в система"),

    /**
     * Сообщение об ошибке при покупке
     * */
    BUY_ERROR_MSG("Покупка может быть совершена только авторизованным пользователем"),

    /**
     * Сообщение при успешной покупке
     * */
    BUY_THANKS_MSG("Спасибо за покупку. Приходите к нам еще!"),

    /**
     * Общее сообщение об ошибке
     * */
    ERROR_MSG("Упс, что-то пошло не так, повторите попытку позже!");

    /***/
    private String msg;

    /***/
    Message(String msg){
        this.msg = msg;
    }

    /***/
    public String getMessage() {
        return msg;
    }
}
