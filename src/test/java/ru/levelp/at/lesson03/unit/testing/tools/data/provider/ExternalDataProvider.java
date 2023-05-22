package ru.levelp.at.lesson03.unit.testing.tools.data.provider;

import java.math.BigDecimal;
import org.testng.annotations.DataProvider;

public class ExternalDataProvider {

    @DataProvider
    public static Object[][] addDataProvider() {
        return new Object[][] {
            {new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("4.0")},
            {new BigDecimal("12.0"), new BigDecimal("2.0"), new BigDecimal("14.0")},
            {new BigDecimal("888.0"), new BigDecimal("12.0"), new BigDecimal("900.0")}
        };
    }

    @DataProvider(name = "Subtract Test Data")
    public static Object[][] subtractDataProvider() {
        return new Object[][] {
            {new BigDecimal("2.0"), new BigDecimal("2.0"), new BigDecimal("0.0")},
            {new BigDecimal("12.0"), new BigDecimal("2.0"), new BigDecimal("10.0")},
            {new BigDecimal("888.0"), new BigDecimal("12.0"), new BigDecimal("876.0")},
            {new BigDecimal("-5.0"), new BigDecimal("12.0"), new BigDecimal("-17.0")},
            {new BigDecimal("1.1"), new BigDecimal("0.05"), new BigDecimal("1.05")}
        };
    }
}
