package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User firstTestUser;
    User secondTestUser;
    private static final int ID = 99;
    private static final String FIRSTNAME = "Junit";
    private static final String EMAIL = "Junit@Junit.Junit";
    private static final String PSWD = "Junit";

    /**
     * Инициализация клиентов
     * */
    @Before
    public void init() {
        firstTestUser = new User(ID, FIRSTNAME, EMAIL, PSWD);
        secondTestUser = new User();
    }

    /**
     * Базовый тест объекта
     * */
    @Test
    public void testUserNotNull() {
        assertNotNull(firstTestUser);
    }

    /**
     * Тест геттера и сеттера
     * */
    @Test
    public void testUserFirstNameSetterGetter() {
        firstTestUser.setFirstName("Junit2");
        assertEquals("Junit2", firstTestUser.getFirstName());
    }

    /**
     * Тест конструктора без аргументов
     * */
    @Test
    public void testUserNoArgsConstructor() {
        assertNotNull(secondTestUser);
    }

    /**
     * Тест конструктора со всеми агрументами
     * */
    @Test
    public void testUserAllArgsConstructor() {
        assertEquals(ID, firstTestUser.getId());
        assertEquals(FIRSTNAME, firstTestUser.getFirstName());
        assertEquals(PSWD, firstTestUser.getPassword());
        assertEquals(EMAIL, firstTestUser.getEmail());
    }
}