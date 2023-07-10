package ru.levelp.at.taf.trello.steps;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter.Mode;
import ru.levelp.at.taf.trello.pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Логинимся на сайт как пользователь {username}")
    public void login(String username, @Param(mode = Mode.HIDDEN) String password) {
        loginPage.loginInButton.click();
        loginPage.emailTextField.sendKeys(username);
        loginPage.continueButton.click();
        loginPage.passwordTextField.sendKeys(password);
        loginPage.logInButton.click();
    }
}
