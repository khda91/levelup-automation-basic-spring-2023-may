package ru.levelp.at.lesson03.unit.testing.tools.hooks.method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

class CalculatorBeforeAfterEachTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " before each");
        calculator = new CalculatorImpl();
    }

    @Test
    void addCalculatorTest() {
        System.out.println(this.getClass().getName() + " addCalculatorTest");
        var actual = calculator.add(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("24.0");

        assertEquals(expected, actual, "Сложение работает не правильно!!!");
    }

    @Test
    void multiplyCalculatorTest() {
        System.out.println(this.getClass().getName() + " multiplyCalculatorTest");
        var actual = calculator.multiply(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("144.00");

        assertEquals(expected, actual, "Умножение работает не правильно!!!");
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " after each");
        calculator = null;
    }
}
