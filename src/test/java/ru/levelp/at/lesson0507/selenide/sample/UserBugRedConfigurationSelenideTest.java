package ru.levelp.at.lesson0507.selenide.sample;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.xpath;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import java.time.Duration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserBugRedConfigurationSelenideTest {

    private static final String BASE_URL = "http://users.bugred.ru";
    private static final String LOGIN_REGISTRATION_URL = "/user/login/index.html";
    private static final Faker FAKER = new Faker();

    @BeforeClass
    public void beforeClass() {
        Configuration.baseUrl = BASE_URL;
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.timeout = 5000;
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {FAKER.funnyName().name(), FAKER.internet().emailAddress(), FAKER.internet().password()}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void registrationTest(final String name, final String email, final String password) {
        open(LOGIN_REGISTRATION_URL);

        $(xpath("//form[contains(@action, 'register')]//input[@name='name']")).sendKeys(name);
        $x("//form[contains(@action, 'register')]//input[@name='email']").sendKeys(email);
        element(xpath("//form[contains(@action, 'register')]//input[@name='password']"))
            .sendKeys(password);
        $x("//form[contains(@action, 'register')]//input[@name='act_register_now']").click();

        $x("//li[@id='fat-menu']/a[@class='dropdown-toggle']")
            .shouldHave(Condition.text(name), Duration.ofSeconds(10));
    }
}
