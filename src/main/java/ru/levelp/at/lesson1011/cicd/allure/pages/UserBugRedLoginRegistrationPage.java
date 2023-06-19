package ru.levelp.at.lesson1011.cicd.allure.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    private static final String PAGE_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'register')]/p")
    private WebElement errorMessageLabel;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Открываем страницу регистрации")
    public void open() {
        open(PAGE_URL);
    }

    @Step("Заполняем поле name - {name}")
    public void fillNameTextField(final String name) {
        wait.until(ExpectedConditions.visibilityOf(nameTextField)).sendKeys(name);
    }

    @Step("Заполняем поле email - {email}")
    public void fillEmailTextField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(email);
    }

    @Step("Заполняем поле password - {password}")
    public void fillPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    @Step("Нажимаем на кнопку регистрации")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    @Step("Получем тескт ошибки")
    public String getErrorMessageLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
