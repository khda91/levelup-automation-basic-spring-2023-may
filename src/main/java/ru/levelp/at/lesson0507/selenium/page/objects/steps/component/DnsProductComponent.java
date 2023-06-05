package ru.levelp.at.lesson0507.selenium.page.objects.steps.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DnsProductComponent extends BaseComponent {

    private static final By PRODUCT_TITLE_XPATH
        = By.xpath(".//a[contains(@class, 'catalog-product__name')]/span");
    private static final By COMPARE_BUTTON_XPATH = By.xpath(".//span[@class='compare-checkbox']");

    private WebElement root;

    public DnsProductComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public void clickCompareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(COMPARE_BUTTON_XPATH)).click();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE_XPATH)).getText();
    }

}
