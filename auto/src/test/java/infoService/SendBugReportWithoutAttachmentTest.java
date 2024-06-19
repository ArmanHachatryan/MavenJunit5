package infoService;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aston.exercise.infoService.models.Patterns;
import org.aston.exercise.infoService.models.Request.CreateBugReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.aston.exercise.infoService.models.Response.SuccessCreatedBug;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@DisplayName("IS-3.1. Создание отчета об ошибке для неавторизованных пользователей")
public class SendBugReportWithoutAttachmentTest {
    //    @Test
//    @Epic("1")
//    @Story("US-1.5.4.1")
//    @Tag("new")
//    @DisplayName("Отправка баг репорта от незарегистрированного пользователя")
//    @Step
//    public void test() {
//        SuccessCreatedBug sc = Allure.step("Sending post request", () ->
//                RestAssured.given()
//                        .baseUri("http://172.17.1.16:9005")
//                        .contentType(ContentType.MULTIPART)
//                        .multiPart("message", "i founded bug")
//                        .multiPart("userEmail", "newtest5@mail.ru")
//                        .when()
//                        .post("/info-service/bug-report-unauthorized/")
//                        .then().log().all()
//                        .statusCode(SC_CREATED)
//                        .extract().as(SuccessCreatedBug.class)
//        );
//
//        var bugReportsFromBd = DbInfoService.getBugReports();
//        bugReportsFromBd.stream()
////                .filter(x -> x.getUser_email() == "newtest5@mail.ru")
//
//                .filter(x -> x.getUser_email().equals("newtest5@mail.ru"))
//                        .forEach(x -> System.out.println(x));
//
//
//
//        Allure.step("Verify response body", () -> {
//            Assertions.assertNotNull(sc.getBugId());
//            Assertions.assertNotNull(sc.getMailingDate());
//        });
    @Test
    public void testMono() {
        SuccessCreatedBug sc = Allure.step("Sending", () ->
                RestAssured.given()
                        .contentType(ContentType.MULTIPART)
                        .spec(buildMultiParts("message", "i founded bug", "userEmail", "test@mail.ru"))
                        .log().all()  // Логирование запроса
                        .when()
                        .post("http://172.17.1.16:9005/info-service/bug-report-unauthorized/")
                        .then()
                        .log().all()  // Логирование ответа
                        .statusCode(201)
                        .extract().as(SuccessCreatedBug.class)
        );

        Allure.step("Verify", () -> {
            Assertions.assertNotNull(sc.getBugId());
            Assertions.assertNotNull(sc.getMailingDate());
        });
    }

//    public static RequestSpecification requestSpecification() {
//        return new RequestSpecBuilder()
//                .addRequestSpecification(buildMultiParts(ContentType.MULTIPART, "message", "i founded bug", "userEmail", "test@mail.ru"))
//                .build();
//    }

    private static RequestSpecification buildMultiParts(String... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        int numPairs = keyValues.length / 2;
        RequestSpecification specification = RestAssured.given();
//                .contentType(contentType);
        for (int i = 0; i < numPairs; i++) {
            int index = i * 2;
            String key = keyValues[index];
            String value = keyValues[index + 1];
            specification.multiPart(key, value);
        }

        return specification;
    }


    private static RequestSpecification buildMultiParts2(Map<String, Objects> map) {
        RequestSpecification specification = RestAssured.given();

        for (var set : map.entrySet()) {
            specification.multiPart(set.getKey(), set.getValue());
        }
        return specification;
    }
}
