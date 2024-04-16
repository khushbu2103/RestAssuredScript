import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/*
 Different ways to create post request body
 1. post request body using hashmap
 2. post request body using hashmap creation using org.json
 3. post request body using hashmap creation using pojo class
 4. post request using external json file data
 */

public class DiffWaysToCreatePostReqBody {
   @Test
   void testPostUsingHashMap()
   {
      HashMap data = new HashMap();
      data.put("email", "george.bluth@reqres.in");
      data.put("first_name", "George");
      data.put("last_name", "Bluth");
      data.put("avatar", "https://reqres.in/img/faces/1-image.jpg");

      given()
              .contentType("application/json")
              .body(data)
      .when()
              .post("http://localhost:3000/jsonfile")
      .then()
              .statusCode(201)
              .body("email", equalTo("george.bluth@reqres.in"))
              .body("first_name", equalTo("George"))
              .body("last_name", equalTo("Bluth"))
              .body("avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"))
              .header("Content-Type", "application/json; charset=utf-8")
              .log().all();
   }
}
