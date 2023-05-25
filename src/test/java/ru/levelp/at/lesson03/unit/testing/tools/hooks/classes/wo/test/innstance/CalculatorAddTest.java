package ru.levelp.at.lesson03.unit.testing.tools.hooks.classes.wo.test.innstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CalculatorAddTest extends CalculatorBaseTest {

    @Test
    void addCalculatorTest() {
        System.out.println(this.getClass().getName() + " addCalculatorTest");
        var actual = calculator.add(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("24.0");

        assertEquals(expected, actual, "Сложение работает не правильно!!!");
    }

    @Test
    void addCalculatorAdditionalTest() {
        System.out.println(this.getClass().getName() + " addCalculatorAdditionalTest");
        var actual = calculator.add(new BigDecimal("113.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("125.0");

        assertEquals(expected, actual, "Сложение работает не правильно!!!");
    }
}
