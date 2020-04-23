package dao;

public class UserQueries {

    /**
     * SQL-запрос на получение пользователя. Используется в checkLogin.
     * */
    protected static final String SELECT_USER = "SELECT * FROM user_data WHERE email = ? and password = ?";

    /**
     * SQL-запрос на добавление данных пользователя в БД.
     * */
    protected static final String INSERT_USER = "INSERT INTO user_data (first_name, password, email) VALUES (?, ?, ?)";

    protected void queries (){
        /*Create cause SonarLint*/
    }
}
