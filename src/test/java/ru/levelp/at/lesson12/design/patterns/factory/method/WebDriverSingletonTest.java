package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverSingletonTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {"edge"},
            {"chrome"},
            {"firefox"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void test(String browser) {
        // System.setProperty("browser.name", browser);
        WebDriverSingleton.getDriver();
        SleepUtils.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
