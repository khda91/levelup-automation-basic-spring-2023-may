package ru.levelp.at.lesson0507.selenium.step.design.pattern.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.page.objects.steps.CompareProductsDnsPage;

public class CompareProductsDnsPageSteps {

    private CompareProductsDnsPage compareProductsPage;

    public CompareProductsDnsPageSteps(final WebDriver driver) {
        compareProductsPage = new CompareProductsDnsPage(driver);
    }

    public void assertThatSelectedProductShouldBeAddedToCompareList(List<String> expectedProductTitles) {
        var actualTitles = compareProductsPage.getTitles();
        assertThat(actualTitles)
            .as("Не все продукты отображены на странце")
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
