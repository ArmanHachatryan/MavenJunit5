package infoService;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.aston.exercise.infoService.models.Response.SuccessCreatedBug;

public class BugReportTest {
    @Step("Установка базового URI")
    public void setBaseUri(String uri) {
        RestAssured.baseURI = uri;
    }

    @Step("Установка типа контента: {contentType}")
    public void setContentType(ContentType contentType) {
        RestAssured.given().contentType(contentType);
    }

    @Step("Добавление multipart данных: {name} = {value}")
    public void addMultiPartData(String name, String value) {
        RestAssured.given().multiPart(name, value);
    }

    @Step("Отправка POST запроса на {endpoint}")
    public Response sendPostRequest(String endpoint) {
        return RestAssured.given().when().post(endpoint);
    }

    @Step("Проверка статуса ответа: {statusCode}")
    public void verifyStatusCode(Response response, int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Step("Извлечение и возврат результата как {classType}")
    public <T> T extractResponseAs(Response response, Class<T> classType) {
        return response.then().extract().as(classType);
    }

    @Test
    public void reportBug() {
        setBaseUri("http://172.17.1.16:9005");
        setContentType(ContentType.MULTIPART);
        addMultiPartData("message", "i founded bug");
        addMultiPartData("userEmail", "test@mail.ru");

        Response response = sendPostRequest("/info-service/bug-report-unauthorized/");
        verifyStatusCode(response, 201);

        SuccessCreatedBug successCreatedBug = extractResponseAs(response, SuccessCreatedBug.class);
    }
}
