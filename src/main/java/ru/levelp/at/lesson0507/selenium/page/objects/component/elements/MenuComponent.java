package ru.levelp.at.lesson0507.selenium.page.objects.component.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuComponent extends BaseComponent {

    public MenuComponent(WebDriver driver) {
        super(driver);
    }

    public void menuClick(final String menuItem) {
        var menuItems = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.xpath("//*[@id='main-menu']//*[@class='newlink']/a"), 1));

        for (WebElement item : menuItems) {
            var name = wait.until(ExpectedConditions.elementToBeClickable(item)).getText();
            if (menuItem.equalsIgnoreCase(name)) {
                item.click();
                break;
            }
        }
    }
}
