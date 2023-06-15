package ru.levelp.at.lesson0809.api.pojo;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import java.time.ZoneId;
import java.util.Locale;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0809.api.pojo.model.AddressData;
import ru.levelp.at.lesson0809.api.pojo.model.CreatePersonRequest;
import ru.levelp.at.lesson0809.api.pojo.model.CreatePersonResponse;
import ru.levelp.at.lesson0809.api.pojo.model.IdentityData;

public class RestAssuredObjectTest {

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
    public void pojoTest() {
        var requestBody = createRequestBody();
        var expectedResponse = CreatePersonResponse.from(requestBody);

        var actualResponse = given()
            .body(requestBody)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreatePersonResponse.class);

        assertThat(actualResponse.getData().getId())
            .as("не удалось создать объект, поле id пустое")
            .isNotBlank();
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringFields("data.id")
            .isEqualTo(expectedResponse);
    }

    private CreatePersonRequest createRequestBody() {
        final var faker = new Faker();
        return CreatePersonRequest
            .builder()
            .role("LECTOR")
            .email(faker.internet().emailAddress())
            .phoneNumber(faker.phoneNumber().phoneNumber())
            .placeOfWork(faker.company().name())
            .identity(IdentityData
                .builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .gender("MALE")
                .placeOfBirth(faker.address().city())
                .dateOfBirth(faker.date().birthday()
                                  .toInstant()
                                  .atZone(ZoneId.systemDefault())
                                  .toLocalDate())
                .build())
            .addressData(AddressData
                .builder()
                .city(faker.address().city())
                .street(faker.address().streetAddress())
                .build())
            .build();
    }
}
