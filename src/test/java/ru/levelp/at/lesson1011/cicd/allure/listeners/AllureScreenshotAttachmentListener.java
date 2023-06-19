package ru.levelp.at.lesson1011.cicd.allure.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureScreenshotAttachmentListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        var driver = (WebDriver) result.getTestContext().getAttribute("driver");
        attachScreenshot(driver);
        attachPageSource(driver);
        attachScreenshotV2(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenshot(final WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void attachPageSource(final WebDriver driver) {
        Allure.addAttachment("page_source", "text/html", driver.getPageSource(), ".html");
    }

    private void attachScreenshotV2(final WebDriver driver) {
        var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
}
