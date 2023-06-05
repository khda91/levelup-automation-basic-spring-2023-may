package ru.levelp.at.lesson0507.selenide.sample;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.xpath;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserBugRedRegistrationTest {

    private static final String URL = "http://users.bugred.ru/user/login/index.html";
    private static final Faker FAKER = new Faker();

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {FAKER.funnyName().name(), FAKER.internet().emailAddress(), FAKER.internet().password()}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void registrationTest(final String name, final String email, final String password) {
        open(URL);

        $(xpath("//form[contains(@action, 'register')]//input[@name='name']")).sendKeys(name);
        $x("//form[contains(@action, 'register')]//input[@name='email']").sendKeys(email);
        element(By.xpath("//form[contains(@action, 'register')]//input[@name='password']"))
            .sendKeys(password);
        $x("//form[contains(@action, 'register')]//input[@name='act_register_now']").click();

        $x("//li[@id='fat-menu']/a[@class='dropdown-toggle']").shouldHave(Condition.text(name + "12"));
    }
}
