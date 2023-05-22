package ru.levelp.at.lesson03.unit.testing.tools.sample;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public class CalculatorSampleTest {

    @Test
    public void addTest() {
        // arrange
        var calculator = new CalculatorImpl();

        // act
        var actual = calculator.add(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("4.0");

        // assert
        assertEquals(actual, expected, "Calculator add function error");
    }

    @Test
    public void subtractTest() {
        // given
        var calculator = new CalculatorImpl();

        // when
        var actual = calculator.subtract(new BigDecimal("2.0"), new BigDecimal("2.0"));
        var expected = new BigDecimal("0.0");

        // then
        assertEquals(actual, expected, "Calculator subtract function error");
    }
}
