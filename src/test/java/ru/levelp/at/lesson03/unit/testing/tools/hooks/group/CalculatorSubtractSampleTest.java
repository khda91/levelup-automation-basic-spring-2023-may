package ru.levelp.at.lesson03.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;

public class CalculatorSubtractSampleTest extends BaseCalculatorTest {

    @Test(groups = {GroupNames.POSITIVE_TEST_GROUP, GroupNames.DECREMENT_TEST_GROUP})
    public void subtractTest() {
        System.out.println(this.getClass().getName() + " subtractTest");
        // when
        var actual = calculator.subtract(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("0.0");

        // then
        assertEquals(actual, expected, "Calculator subtract function error");
    }
}
