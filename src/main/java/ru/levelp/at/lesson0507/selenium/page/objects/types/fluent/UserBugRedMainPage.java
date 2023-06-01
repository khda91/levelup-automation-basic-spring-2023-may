package ru.levelp.at.lesson0507.selenium.page.objects.types.fluent;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserBugRedMainPage {

    @FindBy(xpath = "//li[@id='fat-menu']/a[@class='dropdown-toggle']")
    private WebElement userDropdown;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserBugRedMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    public String getUsernameDropdownText() {
        return wait.until(ExpectedConditions.visibilityOf(userDropdown)).getText();
    }
}
