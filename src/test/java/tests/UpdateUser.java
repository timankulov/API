package tests;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import objects.create.User;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UpdateUser extends BaseTest {

    @Test(description = "Проверяем изменение объекта")
    public void updateUser() {
        //Работает неверно. Сервер не перезаписывает пользователя, а создает нового.
        User user = new User("Bob");
        User user2 = new User("Bob2");
        methods.api.User.createUser(user);
        methods.api.User.updateUser("Bob", user2);

        ResponseSpecification spec = RestAssured.responseSpecification;
        RestAssured.responseSpecification = null;
        methods.api.User.getUser("Bob").then().statusCode(404);
        User responseJson = methods.api.User.getUser("Bob2").then().statusCode(200).extract().as(User.class);
        assertEquals(user2, responseJson, "Объекты не совпадают");

        RestAssured.responseSpecification = spec;
    }
}
