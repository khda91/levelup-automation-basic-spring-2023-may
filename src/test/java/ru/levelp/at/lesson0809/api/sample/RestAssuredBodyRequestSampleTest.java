package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestAssuredBodyRequestSampleTest {

    private static final String BASE_URL = "http://localhost:8082";
    private static final Integer PORT = 8082;
    private static final String BASE_PATH = "/srv-person-profile";
    private static final String PEOPLE_ENDPOINT = "/people";

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
    public void bodyStringTest() {
        final var faker = new Faker();
        final var firstName = faker.name().firstName();
        final var lastName = faker.name().lastName();
        final var email = faker.internet().emailAddress();

        given()
            .body("{\n"
                + "  \"role\": \"LECTOR\",\n"
                + "  \"email\": \"" + email + "\",\n"
                + "  \"phoneNumber\": \"+79211234567\",\n"
                + "  \"placeOfWork\": \"Engineer\",\n"
                + "  \"identity\": {\n"
                + "    \"firstName\": \"" + firstName + "\",\n"
                + "    \"lastName\": \"" + lastName + "\",\n"
                + "    \"middleName\": \"Ivanovich\",\n"
                + "    \"gender\": \"MALE\",\n"
                + "    \"dateOfBirth\": \"1980-02-07\",\n"
                + "    \"placeOfBirth\": \"Moscow\",\n"
                + "    \"passport\": {\n"
                + "      \"series\": \"1234\",\n"
                + "      \"number\": \"123456\",\n"
                + "      \"placeOfIssue\": \"\",\n"
                + "      \"dateOfIssue\": \"1980-02-07\",\n"
                + "      \"departmentCode\": \"123-456\"\n"
                + "    }\n"
                + "  },\n"
                + "  \"address\": {\n"
                + "    \"street\": \"Beethovenstrasse\",\n"
                + "    \"houseNumber\": 12,\n"
                + "    \"houseBuilding\": 1,\n"
                + "    \"houseLetter\": \"A\",\n"
                + "    \"flat\": 123,\n"
                + "    \"city\": \"Moscow\",\n"
                + "    \"postalCode\": \"123456\"\n"
                + "  }\n"
                + "}")
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(empty()))
            .body("data.email", equalTo(email))
            .body("data.identity.firstName", equalTo(firstName))
            .body("data.identity.lastName", equalTo(lastName));
    }

    @Test
    public void bodyFileTest() {
        final var faker = new Faker();
        final var firstName = faker.name().firstName();
        final var lastName = faker.name().lastName();
        final var email = faker.internet().emailAddress();
        final var dateOfBirth = faker.date().birthday()
                                     .toInstant()
                                     .atZone(ZoneId.systemDefault())
                                     .toLocalDate();

        var bodyRequest = "";
        try {
            bodyRequest = FileUtils
                .readFileToString(new File(this
                    .getClass().getResource("/ru/levelp/at/lesson0809/api/sample/file/create_person_request.json")
                    .getPath()), StandardCharsets.UTF_8)
                .replace("<email>", email)
                .replace("<firstName>", firstName)
                .replace("<lastName>", lastName)
                .replace("<dateOfBirth>", dateOfBirth.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(empty()))
            .body("data.email", equalTo(email))
            .body("data.identity.firstName", equalTo(firstName))
            .body("data.identity.lastName", equalTo(lastName))
            .body("data.identity.dateOfBirth", equalTo(dateOfBirth.toString()));
    }

    @Test
    public void bodyJsonPathTest() {
        final var faker = new Faker();
        final var firstName = faker.name().firstName();
        final var lastName = faker.name().lastName();
        final var email = faker.internet().emailAddress();
        final var dateOfBirth = faker.date().birthday()
                                     .toInstant()
                                     .atZone(ZoneId.systemDefault())
                                     .toLocalDate();

        var bodyRequest = "";
        try {
            bodyRequest = JsonPath
                .parse(new File(this
                    .getClass().getResource("/ru/levelp/at/lesson0809/api/sample/jsonpath/create_person_request.json")
                    .getPath()))
                .set("email", email)
                .set("identity.firstName", firstName)
                .set("identity.lastName", lastName)
                .set("identity.dateOfBirth", dateOfBirth.toString())
                .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(empty()))
            .body("data.email", equalTo(email))
            .body("data.identity.firstName", equalTo(firstName))
            .body("data.identity.lastName", equalTo(lastName))
            .body("data.identity.dateOfBirth", equalTo(dateOfBirth.toString()));
    }

    @Test
    public void bodyJsonPathDeleteTest() {
        final var faker = new Faker();
        final var firstName = faker.name().firstName();
        final var lastName = faker.name().lastName();
        final var email = faker.internet().emailAddress();
        final var dateOfBirth = faker.date().birthday()
                                     .toInstant()
                                     .atZone(ZoneId.systemDefault())
                                     .toLocalDate();

        var bodyRequest = "";
        try {
            bodyRequest = JsonPath
                .parse(new File(this
                    .getClass().getResource("/ru/levelp/at/lesson0809/api/sample/jsonpath/create_person_request.json")
                    .getPath()))
                .set("email", email)
                .set("identity.firstName", firstName)
                .set("identity.lastName", lastName)
                .set("identity.dateOfBirth", dateOfBirth.toString())
                .put("identity", "someFiled", "value")
                .delete("identity.passport")
                .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(empty()))
            .body("data.email", equalTo(email))
            .body("data.identity.firstName", equalTo(firstName))
            .body("data.identity.lastName", equalTo(lastName))
            .body("data.identity.dateOfBirth", equalTo(dateOfBirth.toString()));
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {"email"},
            {"role"},
            {"phoneNumber"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void bodyJsonPathDeleteDataProviderTest(String fieldPath) {
        var bodyRequest = "";
        try {
            bodyRequest = JsonPath
                .parse(new File(this
                    .getClass().getResource("/ru/levelp/at/lesson0809/api/sample/jsonpath/create_person_request.json")
                    .getPath()))
                .delete(fieldPath)
                .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider
    public Object[][] nullEmptyDataProvider() {
        return new Object[][] {
            {"email", null},
            {"role", null},
            {"phoneNumber", null},
            {"email", StringUtils.EMPTY},
            {"role", StringUtils.EMPTY},
            {"phoneNumber", StringUtils.EMPTY}
        };
    }

    @Test(dataProvider = "nullEmptyDataProvider")
    public void bodyJsonPathDeleteNullEmptyDataProviderTest(String fieldPath, String fieldValue) {
        var bodyRequest = "";
        try {
            bodyRequest = JsonPath
                .parse(new File(this
                    .getClass().getResource("/ru/levelp/at/lesson0809/api/sample/jsonpath/create_person_request.json")
                    .getPath()))
                .set(fieldPath, fieldValue)
                .jsonString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
            .body(bodyRequest)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
