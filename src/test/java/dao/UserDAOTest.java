package dao;

import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;
import entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Класс для тестирования UserDAO
 * */
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