package ru.levelp.at.lesson0507.selenium.page.objects.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson0507.selenium.page.objects.component.elements.MenuComponent;

public abstract class UserBugRedBasePage {

    protected static final String USER_BUG_RED_URL = "http://users.bugred.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private final MenuComponent menu;

    protected UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);

        this.menu = new MenuComponent(driver);
    }

    protected void open(final String relativeUrl) {
        driver.navigate().to(USER_BUG_RED_URL + relativeUrl);
    }

    public abstract void open();

    public MenuComponent menu() {
        return menu;
    }
}
