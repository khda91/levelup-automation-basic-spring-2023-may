package ru.levelp.at.lesson0507.selenide.page.objects;

import static com.codeborne.selenide.Condition.text;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleWithPageObjectTest {

    private static final String BASE_URL = "http://users.bugred.ru";
    private static final Faker FAKER = new Faker();

    @DataProvider
    public Object[][] positiveDataProvider() {
        return new Object[][] {
            {FAKER.funnyName().name(), FAKER.internet().emailAddress(), FAKER.internet().password()}
        };
    }

    @DataProvider
    public Object[][] negativeDataProvider() {
        return new Object[][] {
            {FAKER.funnyName().name(), FAKER.internet().domainSuffix(), FAKER.internet().password()}
        };
    }

    @BeforeClass
    public void beforeClass() {
        Configuration.baseUrl = BASE_URL;
    }

    @Test(dataProvider = "positiveDataProvider")
    public void registerUserTest(final String name, final String email, final String password) {
        var registrationPage = new UserBugRedLoginRegistrationPage();

        registrationPage.open();
        registrationPage.nameTextField.sendKeys(name);
        registrationPage.emailTextField.sendKeys(email);
        registrationPage.passwordTextField.sendKeys(password);
        registrationPage.registerButton.click();

        var mainPage = new UserBugRedMainPage();
        mainPage.userDropdown.shouldHave(text(name));
    }

    @Test(dataProvider = "negativeDataProvider")
    public void negativeRegistrationTest(final String name, final String email, final String password) {
        var registrationPage = new UserBugRedLoginRegistrationPage();

        registrationPage.open();
        registrationPage.nameTextField.sendKeys(name);
        registrationPage.emailTextField.sendKeys(email);
        registrationPage.passwordTextField.sendKeys(password);
        registrationPage.registerButton.click();

        registrationPage.errorMessageLabel.shouldHave(text("register_not_correct_field (email)"));
    }
}
