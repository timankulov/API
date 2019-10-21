package tests;

import objects.create.User;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetUser extends BaseTest {

    @Test(description = "Проверяем получение объекта")
    public void getUser() {

        User user = new User("Bob");
        methods.api.User.createUser(user);

        User responseJson = methods.api.User.getUser("Bob").then().statusCode(200).extract().body().as(User.class);

        assertEquals(user, responseJson, "Объекты не совпадают");

    }
}
