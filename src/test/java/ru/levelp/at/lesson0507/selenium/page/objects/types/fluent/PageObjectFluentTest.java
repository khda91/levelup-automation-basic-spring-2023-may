package ru.levelp.at.lesson0507.selenium.page.objects.types.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.BaseSeleniumTest;

public class PageObjectFluentTest extends BaseSeleniumTest {

    @Test
    public void registerUserTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().emailAddress();
        var password = faker.internet().password();

        var mainPage = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .fillNameTextField(name)
            .fillEmailTextField(email)
            .fillPasswordTextField(password)
            .clickRegisterButton();

        String actualUserName = mainPage.getUsernameDropdownText();
        assertThat(actualUserName).isEqualToIgnoringCase(name);
    }

    @Test
    public void negativeRegistrationTest() {
        var name = faker.funnyName().name();
        var email = faker.internet().domainSuffix();
        var password = faker.internet().password();

        String actualUserName = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .fillNameTextField(name)
            .fillEmailTextField(email)
            .fillPasswordTextField(password)
            .failClickRegisterButton()
            .getErrorMessageLabelText();

        assertThat(actualUserName).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
