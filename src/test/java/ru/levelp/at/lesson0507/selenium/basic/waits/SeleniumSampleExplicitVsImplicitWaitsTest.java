package ru.levelp.at.lesson0507.selenium.basic.waits;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSampleExplicitVsImplicitWaitsTest {

    private static final String GOOGLE_URL = "https://google.com";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchExplicitMoreThenImplicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        var startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q2']")));
            searchTextBox.sendKeys("Александр Блок");
            searchTextBox.sendKeys(Keys.ENTER);

            var searchResults = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//div/a/h3"), 2));

            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(3);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения -> " + (endTime - startTime) + " ms");
        }
    }

    @Test
    public void searchExplicitLessThenImplicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        var startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q2']")));
            searchTextBox.sendKeys("Александр Блок");
            searchTextBox.sendKeys(Keys.ENTER);

            var searchResults = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//div/a/h3"), 2));

            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(3);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения -> " + (endTime - startTime) + " ms");
        }
    }

    @Test
    public void searchExplicitTogetherImplicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        var startTime = System.currentTimeMillis();
        try {

            var implicitWait = driver.manage().timeouts().getImplicitWaitTimeout();
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);

            WebElement searchTextBox;
            try {
                searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q2']")));
            } finally {
                driver.manage().timeouts().implicitlyWait(implicitWait);
            }
            searchTextBox.sendKeys("Александр Блок");
            searchTextBox.sendKeys(Keys.ENTER);

            var searchResults = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//div/a/h3"), 2));

            assertThat(searchResults)
                .as("Не найдено результатов")
                .hasSizeGreaterThan(3);
        } finally {
            var endTime = System.currentTimeMillis();
            System.out.println("Время выполнения -> " + (endTime - startTime) + " ms");
        }
    }
}
