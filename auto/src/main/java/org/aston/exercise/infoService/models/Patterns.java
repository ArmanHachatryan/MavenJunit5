package org.aston.exercise.infoService.models;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.aston.exercise.infoService.models.Response.SuccessCreatedBug;

public class Patterns {

    public static Object postRequest(String baseUri, ContentType contentType, int statusCode, String body) {
        return RestAssured.given()
                .baseUri("http://172.17.1.16:9005")
                .contentType(ContentType.MULTIPART)
                .multiPart("message", "i founded bug")
                .multiPart("userEmail", "test@mail.ru")
                .body(body)
                .when()
                .post("/info-service/bug-report-unauthorized/")
                .then().log().all()
                .statusCode(201)
                .extract().as(SuccessCreatedBug.class);
    }
}
