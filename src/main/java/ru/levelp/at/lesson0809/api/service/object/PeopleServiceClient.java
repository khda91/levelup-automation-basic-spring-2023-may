package ru.levelp.at.lesson0809.api.service.object;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Collections;
import java.util.Map;
import ru.levelp.at.lesson0809.api.pojo.model.AddPersonMessengerRequest;
import ru.levelp.at.lesson0809.api.pojo.model.CreatePersonRequest;

public class PeopleServiceClient {

    private static final String PEOPLE_ENDPOINT = "/people";
    private static final String PERSON_ENDPOINT = PEOPLE_ENDPOINT + "/{personId}";
    private static final String PERSON_MESSENGERS = PERSON_ENDPOINT + "/messengers";

    public Response createPerson(final CreatePersonRequest requestBody) {
        return given()
            .body(requestBody)
            .when()
            .post(PEOPLE_ENDPOINT)
            .andReturn();
    }

    public Response addMessenger(final String personId, final AddPersonMessengerRequest requestBody) {
        return given()
            .pathParams("personId", personId)
            .body(requestBody)
            .when()
            .post(PERSON_MESSENGERS)
            .andReturn();
    }

    public Response getMessengers(final String personId) {
        return getMessengers(personId, Collections.emptyMap());
    }

    public Response getMessengers(final String personId, final Map<String, Object> queryParams) {
        return given()
            .pathParams("personId", personId)
            .queryParams(queryParams)
            .when()
            .get(PERSON_MESSENGERS)
            .andReturn();
    }
}
