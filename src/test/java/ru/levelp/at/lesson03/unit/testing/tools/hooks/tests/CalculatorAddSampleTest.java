package ru.levelp.at.lesson03.unit.testing.tools.hooks.tests;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;

public class CalculatorAddSampleTest extends BaseCalculatorTest {

    @Test
    public void addTest() {
        System.out.println(this.getClass().getName() + " addTest");
        // act
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");

        // assert
        assertEquals(actual, expected, "Calculator add function error");
    }
}
