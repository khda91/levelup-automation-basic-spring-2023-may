package ru.levelp.at.lesson0507.selenium.incognoto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class IncognitoTest {

    private static final String URL = "https://ya.ru";

    @Test
    public void sampleTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--headless");

        WebDriver driver = new ChromeDriver(options);

        SleepUtils.sleep(3000);
        driver.navigate().to(URL);
        SleepUtils.sleep(3000);

        driver.quit();
    }
}
