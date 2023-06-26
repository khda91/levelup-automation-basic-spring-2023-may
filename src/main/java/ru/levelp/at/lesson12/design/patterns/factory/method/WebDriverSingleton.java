package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.openqa.selenium.WebDriver;

public final class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            var browser = Browser.getBrowser(System.getProperty("browser.name"));
            driver = WebDriverFactory.createDriver(browser);
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
