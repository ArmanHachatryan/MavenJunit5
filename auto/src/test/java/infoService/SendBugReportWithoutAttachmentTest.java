package infoService;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aston.exercise.infoService.models.Request.CreateBugReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.aston.exercise.infoService.models.Response.SuccessCreatedBug;

@DisplayName("IS-3.1. Создание отчета об ошибке для неавторизованных пользователей")
public class SendBugReportWithoutAttachmentTest {
    @Test
    @Epic("1")
    @Story("US-1.5.4.1")
    @Tag("Smoke")
    @Link("https://testrailt/bug1")
    @DisplayName("Отправка баг репорта от незарегистрированного пользователя")
    @Step("Отправка")
    public void test() {
        installSpecification(requestSpecification("http://172.17.1.16:9005", ContentType.MULTIPART),
                responseSpecification(201));

        SuccessCreatedBug sc = RestAssured.given()
                .multiPart("message", "i founded bug")
                .multiPart("userEmail", "test@mail.ru")
                .when()
                .post("/info-service/bug-report-unauthorized/")
                .then()
                .extract().as(SuccessCreatedBug.class);

        Assertions.assertNotNull(sc.getBugId());
        Assertions.assertNotNull(sc.getMailingDate());
    }

    public static RequestSpecification requestSpecification(String url, ContentType contentType) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(contentType)
                .build();
    }

    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    @Test
    public void testMono(){
        SuccessCreatedBug sc = Allure.step("Sending", () ->
            RestAssured.given()
                .baseUri("http://172.17.1.16:9005")
                .contentType(ContentType.MULTIPART)
                .multiPart("message", "i founded bug")
                .multiPart("userEmail", "test@mail.ru")
                .when()
                .post("/info-service/bug-report-unauthorized/")
                .then().log().all()
                .statusCode(201)
                .extract().as(SuccessCreatedBug.class)
        );

        Allure.step("Verify", () -> {
            Assertions.assertNotNull(sc.getBugId());
            Assertions.assertNotNull(sc.getMailingDate());
        });
    }
}
