package ru.levelp.at.taf.trello.service.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardsRestClient {

    private final RequestSpecification requestSpecification;

    private static final String BOARDS_ENDPOINT = "/boards";

    public Response createBoard(final String name) {
        return given()
            .spec(requestSpecification)
            .queryParams("name", name)
            .when()
            .post(BOARDS_ENDPOINT)
            .andReturn();
    }
}
