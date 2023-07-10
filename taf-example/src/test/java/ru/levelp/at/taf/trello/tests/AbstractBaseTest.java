package ru.levelp.at.taf.trello.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.taf.trello.configuration.ApiConfiguration;
import ru.levelp.at.taf.trello.configuration.ConfigProvider;
import ru.levelp.at.taf.trello.configuration.UiConfiguration;
import ru.levelp.at.taf.trello.service.api.BoardsRestClient;
import ru.levelp.at.taf.trello.steps.BoardsSteps;
import ru.levelp.at.taf.trello.steps.LoginSteps;

public abstract class AbstractBaseTest {

    protected static final Faker FAKER = new Faker();
    protected static final UiConfiguration UI_CONFIG = ConfigProvider.uiConfiguration();
    protected static final ApiConfiguration API_CONFIG = ConfigProvider.apiConfiguration();

    protected LoginSteps loginSteps;
    protected BoardsSteps boardsSteps;

    protected BoardsRestClient boardsRestClient;

    @BeforeClass
    public void beforeClass() {
        // System.getProperties();
        Configuration.baseUrl = UI_CONFIG.url();
    }

    @BeforeMethod
    public void setUp() {
        loginSteps = new LoginSteps();
        boardsSteps = new BoardsSteps();
        var reqSpec = new RequestSpecBuilder()
            .setBaseUri(API_CONFIG.url())
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .addQueryParams(
                Map.of("key", API_CONFIG.apiKey(),
                    "token", API_CONFIG.apiToken())
            )
            .build();
        boardsRestClient = new BoardsRestClient(reqSpec);
    }
}
