package ru.levelp.at.lesson0507.selenium.page.objects.with;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.BaseSeleniumTest;

public class SampleWithPageObjectTest extends BaseSeleniumTest {

    @Test
    public void registerUserTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().emailAddress();
        var password = faker.internet().password();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.fillNameTextField(name);
        registrationPage.fillEmailTextField(email);
        registrationPage.fillPasswordTextField(password);
        registrationPage.clickRegisterButton();

        var mainPage = new UserBugRedMainPage(driver);
        String actualUserName = mainPage.getUsernameDropdownText();
        assertThat(actualUserName).isEqualToIgnoringCase(name);
    }

    @Test
    public void negativeRegistrationTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().domainSuffix();
        var password = faker.internet().password();

        var registrationPage = new UserBugRedLoginRegistrationPage(driver);

        registrationPage.open();
        registrationPage.fillNameTextField(name);
        registrationPage.fillEmailTextField(email);
        registrationPage.fillPasswordTextField(password);
        registrationPage.clickRegisterButton();

        String actualUserName = registrationPage.getErrorMessageLabelText();
        assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
