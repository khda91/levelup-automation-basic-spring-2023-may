package ru.levelp.at.lesson0507.selenium.page.objects.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.BaseSeleniumTest;

public class PageObjectsPageComponentTest extends BaseSeleniumTest {

    @Test
    public void registerUserTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().emailAddress();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.registration().fillNameTextField(name);
        registrationPage.registration().fillEmailTextField(email);

        var password = faker.internet().password();
        registrationPage.registration().fillPasswordTextField(password);
        registrationPage.registration().clickRegisterButton();

        var mainPage = new UserBugRedMainPage(driver);
        String actualUserName = mainPage.getUsernameDropdownText();
        assertThat(actualUserName).isEqualToIgnoringCase(name);
    }

    @Test
    public void negativeRegistrationTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().domainSuffix();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.registration().fillNameTextField(name);
        registrationPage.registration().fillEmailTextField(email);
        var password = faker.internet().password();

        registrationPage.registration().fillPasswordTextField(password);
        registrationPage.registration().clickRegisterButton();

        String actualUserName = registrationPage.registration().getErrorMessageLabelText();
        assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
