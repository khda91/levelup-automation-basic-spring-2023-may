package ru.levelp.at.lesson0508.selenium.basic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumDomLocatorsTest {

    private static final String URL_WIKI_RU = "https://ru.wikipedia.org/";

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
    public void idLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var textBox = driver.findElement(By.id("searchInput"));
        textBox.sendKeys("Ночь, улица, фонарь");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void classNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var textBox = driver.findElement(By.className("vector-search-box-input"));
        textBox.sendKeys("Александр Блок");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void nameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var textBox = driver.findElement(By.name("search"));
        textBox.sendKeys("Владимир Маяковский");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void linkTextLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var link = driver.findElement(By.linkText("Доверие Александра Македонского к врачу Филиппу"));
        System.out.println(link.getAttribute("href"));
        SleepUtils.sleep(3000);
    }

    @Test
    public void partialLinkTextLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var link = driver.findElement(By.partialLinkText("Доверие Александра Македонского"));
        link.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var links = driver.findElements(By.tagName("a"));
        SleepUtils.sleep(3000);
        System.out.println("links sise -> " + links.size());
    }
}
