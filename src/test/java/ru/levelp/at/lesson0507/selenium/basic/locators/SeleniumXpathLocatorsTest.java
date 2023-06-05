package ru.levelp.at.lesson0507.selenium.basic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumXpathLocatorsTest {

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
        // var textBox = driver.findElement(By.cssSelector("#searchInput"));             // CSS
        var textBox = driver.findElement(By.xpath("//*[@id='searchInput']"));             // XPATH
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
        // var textBox = driver.findElement(By.cssSelector(".vector-search-box-input"));               // CSS
        var textBox = driver.findElement(By.xpath("//*[@class='vector-search-box-input']"));  // XPATH
        textBox.sendKeys("Александр Блок");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void classNameContainsLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        var button = driver.findElement(By.xpath("//*[contains(@class, 'mw-made-collapsible')]"));
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void nameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.name("search"));                 // DOM
        // var textBox = driver.findElement(By.cssSelector("[name='search']"));    // CSS
        var textBox = driver.findElement(By.xpath("//*[@name='search']"));    // XPATH
        textBox.sendKeys("Владимир Маяковский");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagNameLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var links = driver.findElements(By.tagName("a"));        // DOM
        // var links = driver.findElements(By.cssSelector("a"));       // CSS
        var links = driver.findElements(By.xpath("//a"));       // XPATH
        SleepUtils.sleep(3000);
        System.out.println("links sise -> " + links.size());
    }

    @Test
    public void otherAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("[placeholder='Искать в Википедии']")); // CSS
        var textBox = driver.findElement(By.xpath("//*[@placeholder='Искать в Википедии']")); // XPATH
        textBox.sendKeys("Александр Пушкин");
        textBox.sendKeys(Keys.ENTER);
        SleepUtils.sleep(3000);
    }

    @Test
    public void tagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var textBox = driver.findElement(By.cssSelector("div[class='main-footer-menu']")); // CSS
        // var button = driver.findElement(By.cssSelector("div.main-footer-menu")); // CSS
        var button = driver.findElement(By.xpath("//div[@class='main-footer-menu']")); // XPATH
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void parentTagPlusAttributeLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var button = driver.findElement(By
        //     .cssSelector("a[title='Доверие Александра Македонского к врачу Филиппу'] > span.mw-ui-button")); // CSS
        var button = driver.findElement(By
            .xpath("//a[@title='Доверие Александра Македонского к врачу Филиппу']"
                + "/span[@class='mw-ui-button']")); // XPATH
        button.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void linkTextLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var link = driver.findElement(By.linkText("Доверие Александра Македонского к врачу Филиппу")); /// DOM
        var link = driver.findElement(By
            .xpath("//*[text() = 'Доверие Александра Македонского к врачу Филиппу']")); // XPATH
        System.out.println(link.getAttribute("href"));
        SleepUtils.sleep(3000);
    }

    @Test
    public void partialLinkTextLocatorTest() {
        driver.navigate().to(URL_WIKI_RU);
        SleepUtils.sleep(500);

        // var link = driver.findElement(By.partialLinkText("Доверие Александра Македонского")); // DOM
        var link = driver.findElement(By
            .xpath("//*[contains(text(), 'Доверие Александра Македонского')]")); // XPATH
        link.click();
        SleepUtils.sleep(3000);
    }

    @Test
    public void parentSearchTest() {
        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%94%D0%BE%D0%B2%D0%B5%D1%80%D0%B8%D0%B5_"
            + "%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B0%D0%BD%D0%B4%D1%80%D0%B0_%D0%9C%D0%B0%D0%BA%D0%B5%D0%B4%D0%"
            + "BE%D0%BD%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_%D0%BA_%D0%B2%D1%80%D0%B0%D1%87%D1%83_%D0%A4%D0%B8%D0%BB%"
            + "D0%B8%D0%BF%D0%BF%D1%83");
        SleepUtils.sleep(1000);

        var link = driver.findElement(By
            .xpath("//span[@class='tocnumber' and contains(text(), '1.1')]/../../../../a"));
        System.out.println(link.getText());
        SleepUtils.sleep(3000);
    }
}
