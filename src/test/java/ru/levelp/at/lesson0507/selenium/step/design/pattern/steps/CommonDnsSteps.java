package ru.levelp.at.lesson0507.selenium.step.design.pattern.steps;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.page.objects.steps.DnsMainPage;

public class CommonDnsSteps {

    private final DnsMainPage mainPage;

    public CommonDnsSteps(final WebDriver driver) {
        mainPage = new DnsMainPage(driver);
    }

    // @Step("Открываем веб сайт")
    public void openWebSite() {
        mainPage.open();
    }

    /**
     * Ищем товар через поисковую строку на сайте.
     *
     * @param searchText - полное или частичное название товара.
     */
    public void searchProduct(final String searchText) {
        mainPage.searchProduct(searchText);
    }
}
