package ru.levelp.at.lesson03.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;

public class CalculatorDivideSampleTest extends BaseCalculatorTest {

    @Test(groups = {GroupNames.POSITIVE_TEST_GROUP, GroupNames.DECREMENT_TEST_GROUP})
    public void divideTest() {
        System.out.println(this.getClass().getName() + " divideTest");
        // act
        var actual = calculator.divide(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("1");

        // assert
        assertEquals(actual, expected, "Calculator divide function error");
    }

    @Test(groups = {GroupNames.NEGATIVE_TEST_GROUP, GroupNames.DECREMENT_TEST_GROUP},
          expectedExceptions = {IllegalArgumentException.class})
    public void divideToZeroTest() {
        System.out.println(this.getClass().getName() + " divideToZeroTest");

        // when
        calculator.divide(new BigDecimal("2.0"), new BigDecimal("0.0"));
    }
}
