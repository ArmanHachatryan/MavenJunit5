package restAssuredStreamApiJava;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class AppTest {


    public List<User> check() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().body()
                .extract().jsonPath().getList("data", User.class);


    }
    @Test
    public void filter() {
        List<User> users = check()
                .stream().filter(x -> x.getFirst_name().endsWith("ael"))
                .collect(Collectors.toList());

        int a = 0;
    }
}
