package ru.levelp.at.lesson13.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.pages.UserBugRedLoginRegistrationPage;

public class UserBugRedRegistrationPageStep {

    private UserBugRedLoginRegistrationPage loginRegistrationPage;

    public UserBugRedRegistrationPageStep() {
        var driver = (WebDriver) TestContext.getInstance().getParameter("driver");
        loginRegistrationPage = new UserBugRedLoginRegistrationPage(driver);
    }

    @Дано("Пользователь открывает страницу регистарции на ресурсе userbugred")
    public void userOpenRegistrationPageOnUserBugRedWebSite() {
        loginRegistrationPage.open();
    }

    @Когда("Пользователь вводит корректные данные в форму регистрации")
    public void enterCorrectDataToRegistrationForm() {
        final var faker = new Faker();
        final var name = faker.name().firstName();
        TestContext.getInstance().addParameter("expected_name", name);
        loginRegistrationPage.fillNameTextField(name);
        loginRegistrationPage.fillEmailTextField(faker.internet().emailAddress());
        loginRegistrationPage.fillPasswordTextField(faker.internet().password());
    }

    @Когда("Пользователь вводит корректные данные в форму регистрации с  email {string}")
    public void enterCorrectDataToRegistrationFormAndIncorrectEmail(String email) {
        final var faker = new Faker();
        loginRegistrationPage.fillNameTextField(faker.name().firstName());
        loginRegistrationPage.fillEmailTextField(email);
        loginRegistrationPage.fillPasswordTextField(faker.internet().password());
    }

    @Когда("нажимает на кнопку  \"Зарегистрироваться\"")
    public void registerUser() {
        loginRegistrationPage.clickRegisterButton();
    }


    @Тогда("пользователь остаётся на странице регистрации")
    public void registrationPageShouldBeOpened() {
        assertThat(loginRegistrationPage.isRegisterButtonDisplayed())
            .as("Проверка, что страница регистации открыта")
            .isTrue();
    }

    @Тогда("на странице отображается ошибка с текстом {string}")
    public void errorTextShouldBeEqualTo(String expectedErrorText) {
        assertThat(loginRegistrationPage.getErrorMessageLabelText())
            .as("Проверка, текста ошибки")
            .isEqualTo(expectedErrorText);
    }

}
