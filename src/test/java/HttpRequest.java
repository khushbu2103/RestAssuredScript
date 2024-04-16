import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

//given()
//        contact type, set cookies, add param, set header info etc;
//when()
//      get, post, put, delete
//Then()
//        validate status code, Extract response, Extract header cookies & response etc
//
public class HttpRequest {
    @Test
    void getUsers()
    {
        given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }
}
