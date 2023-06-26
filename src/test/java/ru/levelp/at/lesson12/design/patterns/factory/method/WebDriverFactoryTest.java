package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverFactoryTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {Browser.EDGE},
            {Browser.CHROME},
            {Browser.FIREFOX}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void test(Browser browser) {
        var driver = WebDriverFactory.createDriver(browser);
        SleepUtils.sleep(3000);
        driver.quit();
    }
}
