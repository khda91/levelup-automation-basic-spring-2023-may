package ru.levelp.at.lesson0809.api.sample;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import java.util.Map;
import org.testng.annotations.Test;

public class RestAssuredSampleTest {
    private static final String BASE_URL = "http://localhost:8082/srv-person-profile";
    private static final String MESSENGERS_ENDPOINT = "/messengers";

    // /messengers/{messengerId}
    private static final String MESSENGER_ENDPOINT = MESSENGERS_ENDPOINT + "/{messengerId}";

    @Test
    public void getMessengersTest() {
        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URL)
                   .when()
                   .get(MESSENGERS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200);
    }

    @Test
    public void getMessengersBodyAssertionTest() {
        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URL)
                   .when()
                   .get(MESSENGERS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200)
                   .body("data.id", hasSize(3))
                   .body("data.id", containsInAnyOrder("VIBER", "WHATS_UP", "TELEGRAM"));
    }

    @Test
    public void getMessengersQueryParamsTest() {
        final var limit = 1;
        final var offset = 1;
        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URL)
                   .queryParams(Map.of(
                       "limit", limit,
                       "offset", offset
                   ))
                   .when()
                   .get(MESSENGERS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200)
                   .body("data.id", hasSize(limit))
                   .body("data.id", containsInAnyOrder("VIBER"))
                   .body("data.id", not(containsInAnyOrder("WHATS_UP", "TELEGRAM")))
                   .body("meta.pagination.limit", equalTo(limit))
                   .body("meta.pagination.offset", equalTo(offset));
    }

    @Test
    public void getMessengersPathParamsTest() {
        final var messengerName = new Faker().name().firstName().toUpperCase();

        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URL)
                   .headers(Map.of(
                       "header1", "value1",
                       "header2", "value2"
                   ))
                   .pathParams("messengerId", messengerName)
                   .when()
                   .put(MESSENGER_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(204);

        RestAssured.given()
                   .log().all()
                   .baseUri(BASE_URL)
                   .when()
                   .get(MESSENGERS_ENDPOINT)
                   .then()
                   .log().everything()
                   .statusCode(200)
                   .body("data.id", hasItem(messengerName));
    }
}
