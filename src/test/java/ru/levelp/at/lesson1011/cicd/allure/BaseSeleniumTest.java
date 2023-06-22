package ru.levelp.at.lesson1011.cicd.allure;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeMethod(alwaysRun = true)
    @Step("Инициализация браузера")
    public void setUp(ITestContext context) {
        var options = new ChromeOptions();
        System.out.println("-----------" + System.getenv("HEADLESS"));
        var headless = Boolean.parseBoolean(System.getenv("HEADLESS"));
        if (headless) {
            System.out.println("here");
            options.addArguments("--headless");
        }

        faker = new Faker();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Закрытие браузера")
    public void tearDown() {
        driver.quit();
    }
}
