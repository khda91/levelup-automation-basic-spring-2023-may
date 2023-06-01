package ru.levelp.at.lesson0507.selenium.page.objects.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedMainPage extends UserBugRedBasePage {

    @FindBy(xpath = "//li[@id='fat-menu']/a[@class='dropdown-toggle']")
    private WebElement userDropdown;

    public UserBugRedMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/");
    }

    public String getUsernameDropdownText() {
        return wait.until(ExpectedConditions.visibilityOf(userDropdown)).getText();
    }
}
