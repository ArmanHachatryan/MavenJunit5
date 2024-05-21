package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class ReqresTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void checkAvatarAndIdTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecification(200));
        List<UserData> users = given()
                .when()
                .get("/api/users?page=2")  //http methods
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

                users.stream().forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));

                Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

                List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

                List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());

                for (int i = 0; i < avatars.size(); i++) {
                    Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));
                }
    }

    @Test
    public void successRegTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecification(200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReq successReq = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReq.class);

        Assertions.assertNotNull(successReq.getId());
        Assertions.assertNotNull(successReq.getToken());

        Assertions.assertEquals(id, successReq.getId());
        Assertions.assertEquals(token, successReq.getToken());
    }

    @Test
    public void badRequestTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecification(400));

        String error = "Missing password";

        Register user = new Register("sydney@fife");

        BadReq badReq = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all().extract().as(BadReq.class);

        Assertions.assertEquals(error, badReq.getError());
    }
}
