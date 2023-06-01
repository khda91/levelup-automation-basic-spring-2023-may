package ru.levelp.at.lesson0507.selenium.page.objects.component;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.page.objects.component.elements.LoginComponent;
import ru.levelp.at.lesson0507.selenium.page.objects.component.elements.RegistrationComponent;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    private static final String PAGE_URL = "/user/login/index.html";

    private final LoginComponent login;
    private final RegistrationComponent registration;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
        login = new LoginComponent(driver);
        registration = new RegistrationComponent(driver);
    }

    public LoginComponent login() {
        return login;
    }

    public RegistrationComponent registration() {
        return registration;
    }

    @Override
    public void open() {
        open(PAGE_URL);
    }
}
