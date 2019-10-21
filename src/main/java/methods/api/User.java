package methods.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.api.ApiEndpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class User {

    public static Response getUser(String username){

        return given()
                .pathParam("username", username)
                .get(ApiEndpoints.user);
    }
    public static Response createUser(objects.create.User user) {
        String json = user.toString();
        return given()
                .body(json)
                .post(ApiEndpoints.createUser);
    }
    public static Response updateUser(String oldUserUsername, objects.create.User newUser) {

        return given()
                .pathParam("username", oldUserUsername)
                .body(newUser)
                .put(ApiEndpoints.user);
    }
    public static Response deleteUser(String username) {

        return given()
                .pathParam("username", username)
                .delete(ApiEndpoints.user);
    }
}
