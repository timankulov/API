package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;
import utils.BaseUrl;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BaseUrl.getUrl())
                .setContentType(ContentType.JSON)
                .build();
    }
}
