package enums;

public enum Page {
    /**
     * Главная страница
     * */
    INDEX_PAGE("index.jsp"),

    /**
     * Страница аутентификации
     * */
    FORM_LOGIN_PAGE("form-login.jsp"),

    /**
     * Страница регистрации
     * */
    FORM_REG_PAGE("form-registration.jsp"),

    /**
     * Страница совершенной покупки
     * */
    BUY_RESULT_PAGE("buy-result.jsp"),

    /**
     * Главная страница личного кабинета пользователя
     * */
    INDEX_PERSONAL_PAGE("/personal-page/index-personal.jsp"),

    /**
     * Страница детализации заказа
     * */
    ORDER_DETAIL_PAGE("/personal-page/order-details.jsp"),

    /**
     * Страница с ошибкой
     * */
    ERROR_PAGE("error.jsp");


    /**
     * Страница
     * */
    private String page;

    /**
     * Конструктор с полем названия страницы
     *
     * @param page название страницы
     */
    Page(String page) {
        this.page = page;
    }

    /**
     * Геттер названия страницы
     *
     * @return адрес страницы
     */
    public String getPage() {
        return page;
    }
}
