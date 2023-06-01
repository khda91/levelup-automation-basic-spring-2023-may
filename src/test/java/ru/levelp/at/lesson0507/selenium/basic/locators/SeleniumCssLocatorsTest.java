package ru.levelp.at.lesson0507.selenium.basic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumCssLocatorsTest {

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

        // var textBox = driver.findElement(By.id("searchInput"));                    // DOM
        // var textBox = driver.findElement(By.cssSelector("[id='searchInput']"));    // CSS
        var textBox = driver.findElement(By.cssSelector("#searchInput"));             // CSS
        textBox.sendKeys("Ночь, улица, фонарь");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void classNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.className("vector-search-box-input"));               // DOM
        // var textBox = driver.findElement(By.className("[class='vector-search-box-input']"));     // CSS
        var textBox = driver.findElement(By.cssSelector(".vector-search-box-input"));               // CSS
        textBox.sendKeys("Александр Блок");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void nameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.name("search"));                 // DOM
        var textBox = driver.findElement(By.cssSelector("[name='search']"));    // CSS
        textBox.sendKeys("Владимир Маяковский");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var links = driver.findElements(By.tagName("a"));        // DOM
        var links = driver.findElements(By.cssSelector("a"));       // CSS
        SleepUtils.sleep(3000);
        System.out.println("links sise -> " + links.size());
    }

    @Test
    public void otherAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var textBox = driver.findElement(By.cssSelector("[placeholder='Искать в Википедии']"));
        textBox.sendKeys("Александр Пушкин");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("div[class='main-footer-menu']"));
        var button = driver.findElement(By.cssSelector("div.main-footer-menu"));
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void parentTagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var button = driver.findElement(By
            .cssSelector("a[title='Доверие Александра Македонского к врачу Филиппу'] > span.mw-ui-button"));
        button.click();
        SleepUtils.sleep(3000);
    }
}
