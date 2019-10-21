package tests;

import objects.create.User;
import org.testng.annotations.Test;

public class DeleteUser extends BaseTest {

    @Test(description = "Проверяем удаление объекта")
    public void deleteUser() {

        User user = new User("Bob");

        methods.api.User.createUser(user).then().statusCode(200);

        methods.api.User.getUser("Bob").then().statusCode(200);

        methods.api.User.deleteUser("Bob").then().statusCode(200);

        methods.api.User.getUser("Bob").then().statusCode(404);

    }
}
