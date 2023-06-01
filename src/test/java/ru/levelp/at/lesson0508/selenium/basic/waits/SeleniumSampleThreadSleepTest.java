package ru.levelp.at.lesson0508.selenium.basic.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumSampleThreadSleepTest {

    private static final String GOOGLE_URL = "https://google.com";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
        SleepUtils.sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTest() {
        var startTime = System.currentTimeMillis();
        try {
            var searchTextBox = driver.findElement(By.xpath("//*[@name='q']"));
            searchTextBox.sendKeys("Александр Блок");
            searchTextBox.sendKeys(Keys.ENTER);

            SleepUtils.sleep(3000);
            var searchResults = driver.findElements(By.xpath("//div/a/h3"));

            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(3);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения -> " + (endTime - startTime) + " ms");
        }
    }
}
