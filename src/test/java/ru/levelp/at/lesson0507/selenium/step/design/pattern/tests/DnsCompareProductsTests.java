package ru.levelp.at.lesson0507.selenium.step.design.pattern.tests;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.BaseSeleniumTest;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.steps.CommonDnsSteps;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.steps.CompareProductsDnsPageSteps;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.steps.SearchResultDnsPageSteps;

public class DnsCompareProductsTests extends BaseSeleniumTest {

    private CommonDnsSteps commonDnsSteps;
    private SearchResultDnsPageSteps searchResultDnsPageSteps;
    private CompareProductsDnsPageSteps compareProductsDnsPageSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        // driver = new EdgeDriver();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        commonDnsSteps = new CommonDnsSteps(driver);
        searchResultDnsPageSteps = new SearchResultDnsPageSteps(driver);
        compareProductsDnsPageSteps = new CompareProductsDnsPageSteps(driver);
    }

    @Test
    public void addToCompareTest() {
        // Октрываем страницу DNS магазина
        commonDnsSteps.openWebSite();

        // Ищем товар
        commonDnsSteps.searchProduct("Keychron");

        // Добавляем товары к сравнению
        var addedProducts = searchResultDnsPageSteps.addToCompareProducts(1, 2, 3);

        // проверка добавлдения товаров
        compareProductsDnsPageSteps.assertThatSelectedProductShouldBeAddedToCompareList(addedProducts);
    }
}
