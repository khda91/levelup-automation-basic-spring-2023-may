package ru.levelp.at.lesson0507.selenide.page.objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage {

    protected static final String USER_BUG_RED_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    public SelenideElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    public SelenideElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    public SelenideElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    public SelenideElement registerButton;

    public final SelenideElement errorMessageLabel = $x("//form[contains(@action, 'register')]/p");

    public UserBugRedLoginRegistrationPage() {
        page(this);
    }

    public void open() {
        Selenide.open(USER_BUG_RED_URL);
    }
}
