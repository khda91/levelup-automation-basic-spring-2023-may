package ru.levelp.at.lesson03.unit.testing.tools.data.provider;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorExternalDataProviderTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("set up");
        // arrange || given
        calculator = new CalculatorImpl();
    }

    @Test(dataProvider = "addDataProvider", dataProviderClass = ExternalDataProvider.class)
    public void addTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println("addTest");
        // act
        var actual = calculator.add(a, b);

        // assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test(dataProvider = "Subtract Test Data", dataProviderClass = ExternalDataProvider.class)
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
