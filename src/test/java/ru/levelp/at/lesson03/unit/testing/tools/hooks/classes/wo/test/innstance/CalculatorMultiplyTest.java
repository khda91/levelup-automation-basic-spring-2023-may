package ru.levelp.at.lesson03.unit.testing.tools.hooks.classes.wo.test.innstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CalculatorMultiplyTest extends CalculatorBaseTest {

    @Test
    void multiplyCalculatorTest() {
        System.out.println(this.getClass().getName() + " multiplyCalculatorTest");
        var actual = calculator.multiply(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("144.00");

        assertEquals(expected, actual, "Умножение работает не правильно!!!");
    }
}
