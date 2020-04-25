package dao;

import entity.User;
import org.junit.*;

/**
 * Класс для тестирования UserDAO
 * */
@Ignore("Тест требует наличия базы данных")
public class UserDAOTest {

    UserDAO userDAO;
    String firstName = "Junit";
    String email = "Junit@Junit.Junit";
    String pswd = "Junit";

    /**
     * Метод инициализирует необходимые классы
     * */
    @Before
    public void init () {
        userDAO = new UserDAO();
    }

    /**
     * Метод для провекри доступа к БД
     * */
    @Test
    public void testCheckLogin() {
        User user;
        user = userDAO.checkLogin(email, pswd);
        Assert.assertEquals(firstName, user.getFirstName());
    }

    /**
     * Метод для проверки что возвращаемое значение false
     * */
    @Test
    public void testUserRegistration() {
        boolean isUser = userDAO.userRegistration(firstName, pswd, email);
        Assert.assertFalse(isUser);
    }
}