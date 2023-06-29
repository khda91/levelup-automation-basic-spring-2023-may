package ru.levelp.at.lesson13.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.pages.UserBugRedMainPage;

public class UserBugRedMainPageStep {

    private UserBugRedMainPage mainPage;

    public UserBugRedMainPageStep() {
        var driver = (WebDriver) TestContext.getInstance().getParameter("driver");
        mainPage = new UserBugRedMainPage(driver);
    }

    @Тогда("происходит переход на главную страницу")
    public void shouldBeRedirectedToMainPage() {
        assertThat(mainPage.getUsernameDropdownText())
            .as("Проверка регистрации пользователя")
            .isNotBlank();
    }

    @Тогда("появляется дропдаун с введённым именем пользователя")
    public void usernameShouldBeEqualEnteredUserName() {
        final var expectedName = (String) TestContext.getInstance().getParameter("expected_name");
        assertThat(mainPage.getUsernameDropdownText())
            .as("Проверка имени зарегистрированного пользователя")
            .isEqualToIgnoringCase(expectedName);
    }
}
