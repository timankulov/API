package tests;

import objects.create.User;
import org.testng.annotations.Test;

public class CreateUser extends BaseTest {

    @Test(description = "Проверяем создание объекта")
    public void createUser() {

        User user = new User("Bob");

        methods.api.User.createUser(user).then().statusCode(200);
    }
}
