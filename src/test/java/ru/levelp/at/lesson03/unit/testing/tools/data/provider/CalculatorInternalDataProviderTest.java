package ru.levelp.at.lesson03.unit.testing.tools.data.provider;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorInternalDataProviderTest {

    private Calculator calculator;

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

    @BeforeMethod
    public void setUp() {
        System.out.println("set up");
        // arrange || given
        calculator = new CalculatorImpl();
    }

    @Test(dataProvider = "addDataProvider")
    public void addTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println("addTest");
        // act
        var actual = calculator.add(a, b);

        // assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test(dataProvider = "Subtract Test Data")
    public void subtractTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println("subtractTest");
        // when
        var actual = calculator.subtract(a, b);

        // then
        assertEquals(actual, expected, "Calculator subtract function error");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("tear down");
        calculator = null;
    }
}
