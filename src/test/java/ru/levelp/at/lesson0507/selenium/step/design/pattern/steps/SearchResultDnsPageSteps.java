package ru.levelp.at.lesson0507.selenium.step.design.pattern.steps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.page.objects.steps.SearchResultDnsPage;

public class SearchResultDnsPageSteps {

    private SearchResultDnsPage searchResultPage;

    public SearchResultDnsPageSteps(final WebDriver driver) {
        searchResultPage = new SearchResultDnsPage(driver);
    }

    public List<String> addToCompareProducts(int... productNumbers) {
        var productTitles = Arrays.stream(productNumbers)
            .mapToObj(number -> searchResultPage.getProductCard(number))
            .map(product -> {
                product.clickCompareButton();
                return product.getTitle();
            })
            .collect(Collectors.toList());

        searchResultPage.clickCompareButton();

        return productTitles;
    }
}
