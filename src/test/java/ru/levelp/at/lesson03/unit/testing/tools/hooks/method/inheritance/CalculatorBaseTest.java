package ru.levelp.at.lesson03.unit.testing.tools.hooks.method.inheritance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

abstract class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " before each");
        calculator = new CalculatorImpl();
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " after each");
        calculator = null;
    }
}
