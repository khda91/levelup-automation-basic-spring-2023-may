package ru.levelp.at.lesson03.unit.testing.tools.hooks.classes.wo.test.innstance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

abstract class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println(CalculatorBaseTest.class.getName() + " before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(CalculatorBaseTest.class.getName() + " after all");
    }

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
