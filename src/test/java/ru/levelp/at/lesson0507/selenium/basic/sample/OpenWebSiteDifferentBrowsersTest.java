package ru.levelp.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class OpenWebSiteDifferentBrowsersTest {

    private static final String URL = "https://ya.ru/";

    @DataProvider
    static Object[][] browserDataProvider() {
        return new Object[][] {
            {new ChromeDriver()},
            {new EdgeDriver()}
        };
    }

    private WebDriver driver;


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "browserDataProvider")
    public void openWebSiteTest(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to(URL);
        SleepUtils.sleep(3000);

        assertThat(driver.getTitle())
            .as("Название сайта не совпадает с ожидаемым")
            .isEqualTo("Яндекс");
    }
}
