package ru.levelp.at.lesson0508.selenium.basic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class AttributeTest {

    private static final String URL = "https://mail.ru";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void elementAttributesTest() {
        driver.navigate().to(URL);
        SleepUtils.sleep(1500);

        var button = driver.findElement(By.cssSelector("button.search-arrow__button"));
        SleepUtils.sleep(1000);

        System.out.println("Размерность кнопки -> " + button.getSize());
        System.out.println("Цвет кнопки -> " + button.getCssValue("color"));
        System.out.println("Цвет background кнопки -> " + button.getCssValue("background-color"));
    }
}
