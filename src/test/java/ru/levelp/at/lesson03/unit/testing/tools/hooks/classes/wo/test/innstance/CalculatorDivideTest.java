package ru.levelp.at.lesson03.unit.testing.tools.hooks.classes.wo.test.innstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorDivideTest extends CalculatorBaseTest {

    // так переопределять нельзя!!!
    //    @BeforeAll
    //    static void beforeAll() {
    //        CalculatorBaseTest.beforeAll();
    //        System.out.println(CalculatorDivideTest.class.getName() + " before all!!!");
    //    }

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        System.out.println("ОЙ! Переопределили!!!");
    }

    @Test
    void divideCalculatorTest() {
        System.out.println(this.getClass().getName() + " multiplyCalculatorTest");
        var actual = calculator.divide(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("1.00");

        assertEquals(expected, actual, "Деление работает не правильно!!!");
    }
}
