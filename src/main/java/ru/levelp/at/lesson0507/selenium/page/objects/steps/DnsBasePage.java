package ru.levelp.at.lesson0507.selenium.page.objects.steps;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DnsBasePage {

    protected static final String DNS_URL = "https://dns-shop.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(xpath = "//*[@class='compare-link-counter']")
    private WebElement compareButton;

    @FindBy(xpath = "//*[@class='presearch__input']")
    private WebElement searchTextBox;

    protected DnsBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeUrl) {
        driver.navigate().to(DNS_URL + relativeUrl);
    }

    public abstract void open();

    public void clickCompareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }

    public void searchProduct(final String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchTextBox)).sendKeys(searchText + Keys.ENTER);
    }
}
