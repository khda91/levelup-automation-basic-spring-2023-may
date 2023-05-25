package ru.levelp.at.lesson03.unit.testing.tools.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

class CalculatorSampleTest {

    @Test
    void addCalculatorTest() {
        Calculator calculator = new CalculatorImpl();

        var actual = calculator.add(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("24.0");

        assertEquals(expected, actual, "Сложение работает не правильно!!!");
    }

    @Test
    void multiplyCalculatorTest() {
        Calculator calculator = new CalculatorImpl();

        var actual = calculator.multiply(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("144.00");

        assertEquals(expected, actual, "Умножение работает не правильно!!!");
    }
}
