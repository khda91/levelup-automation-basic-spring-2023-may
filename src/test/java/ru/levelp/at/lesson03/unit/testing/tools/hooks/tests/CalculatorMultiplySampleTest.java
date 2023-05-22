package ru.levelp.at.lesson03.unit.testing.tools.hooks.tests;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;

public class CalculatorMultiplySampleTest extends BaseCalculatorTest {

    @Test
    public void multiplyTest() {
        System.out.println(this.getClass().getName() + " multiplyTest");
        // act
        var actual = calculator.multiply(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.00");

        // assert
        assertEquals(actual, expected, "Calculator multiply function error");
    }
}
