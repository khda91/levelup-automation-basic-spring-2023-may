package ru.levelp.at.lesson0508.selenium.basic.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowHandleTest {

    private static final String URL_YA_RU = "https://ya.ru/";
    private static final String URL_CITILINK_RU = "https://www.citilink.ru/";
    private static final String URL_MAIL_RU = "https://www.mail.ru/";

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
    public void openWebSiteTest() {
        // открываем ya.ru
        System.out.println("открываем ya.ru");
        driver.navigate().to(URL_YA_RU);
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();

        // открываем citilink.ru
        System.out.println("открываем citilink.ru");
        driver = driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(URL_CITILINK_RU);
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();

        System.out.println("закрываем citilink.ru");
        driver.close();
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver = driver.switchTo().window(windowHandle);
            if ("Яндекс".equalsIgnoreCase(driver.getTitle())) {
                break;
            }
        }

        // открываем mail.ru
        System.out.println("открываем mail.ru");
        driver = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(URL_MAIL_RU);
        SleepUtils.sleep(2000);
        System.out.println(driver.getWindowHandles());
        System.out.println();
    }
}
