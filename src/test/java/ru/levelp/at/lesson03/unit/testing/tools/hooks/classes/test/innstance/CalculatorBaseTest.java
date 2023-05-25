package ru.levelp.at.lesson03.unit.testing.tools.hooks.classes.test.innstance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

@TestInstance(Lifecycle.PER_CLASS)
abstract class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeAll
    void beforeAll() {
        System.out.println(this.getClass().getName() + " before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println(this.getClass().getName() + " after all");
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
