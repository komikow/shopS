package by.it.academy.shopS;

import by.it.academy.shopS.entities.Product;
import by.it.academy.shopS.entities.User;
import by.it.academy.shopS.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Тестовый класс")
public class CommonTest {
    @Test
    void availableUserTest() {
        Assertions.assertEquals("Dmitriy", "Dmitriy");
        Assertions.assertNotEquals("Dmitriy", "Sergey");
        Assertions.assertNotNull(null);
        Assertions.assertThrows(NumberFormatException.class, ()->Integer.parseInt("B"));
    }

    @Test
    public void testAtUserId() {
        User user = new User();
        Assertions.assertEquals(0,user.getId());
        Assertions.assertEquals("komikow", "komikow");
        Assertions.assertNotEquals(-1, user.getId());
    }
}
