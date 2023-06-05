package ru.levelp.at.lesson0507.selenium.page.objects.steps;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompareProductsDnsPage extends DnsBasePage {

    public CompareProductsDnsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Метод не имплементирован");
    }

    public List<String> getTitles() {
        return wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By
                .xpath("//*[@class='products-slider__product-name']"), 2))
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
