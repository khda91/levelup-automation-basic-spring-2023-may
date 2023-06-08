package ru.levelp.at.lesson0809.api.configuration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredConfigurationSampleTest {
    private static final String BASE_URL = "http://localhost";
    private static final Integer PORT = 8082;
    private static final String BASE_PATH = "/srv-person-profile";
    private static final String MESSENGERS_ENDPOINT = "/messengers";

    // /messengers/{messengerId}
    private static final String MESSENGER_ENDPOINT = MESSENGERS_ENDPOINT + "/{messengerId}";

    private static RequestSpecification paginationRequestSpecification(final int limit, final int offset) {
        return new RequestSpecBuilder()
            .addQueryParams(Map.of(
                "limit", limit,
                "offset", offset
            ))
            .build();
    }

    private static ResponseSpecification paginationResponseSpecification(final int limit, final int offset) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpStatus.SC_OK)
            .expectBody("meta.pagination.limit", equalTo(limit))
            .expectBody("meta.pagination.offset", equalTo(offset))
            .build();
    }

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        RestAssured.port = PORT;
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void getMessengersTest() {
        given()
            .when()
            .get(MESSENGERS_ENDPOINT)
            .then()
            .statusCode(200);
    }

    @Test
    public void getMessengersBodyAssertionTest() {
        given()
            .when()
            .get(MESSENGERS_ENDPOINT)
            .then()
            .statusCode(200)
            .body("data.id", hasItems("VIBER", "WHATS_UP", "TELEGRAM"));
    }

    @Test
    public void getMessengersQueryParamsTest() {
        final var limit = 1;
        final var offset = 1;

        given()
            .spec(paginationRequestSpecification(limit, offset))
            .when()
            .get(MESSENGERS_ENDPOINT)
            .then()
            .spec(paginationResponseSpecification(limit, offset))
            .body("data.id", hasSize(limit))
            .body("data.id", containsInAnyOrder("MILLARD"))
            .body("data.id", not(containsInAnyOrder("WHATS_UP", "TELEGRAM")));
    }

    @Test
    public void getMessengersPathParamsTest() {
        final var messengerName = new Faker().name().firstName().toUpperCase();

        given()
            .headers(Map.of(
                "header1", "value1",
                "header2", "value2"
            ))
            .pathParams("messengerId", messengerName)
            .when()
            .put(MESSENGER_ENDPOINT)
            .then()
            .statusCode(204);

        given()
            .when()
            .get(MESSENGERS_ENDPOINT)
            .then()
            .statusCode(200)
            .body("data.id", hasItem(messengerName));
    }
}
