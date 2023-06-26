package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createDriver(Browser browser) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case EDGE:
                driver = createEdgeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Не поддерживаемый браузер " + browser);
        }
        return driver;
    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }
}
