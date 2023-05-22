package ru.levelp.at.lesson03.unit.testing.tools.hooks.classes.inheritance;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " before class");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up");
        // arrange || given
        calculator = new CalculatorImpl();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " after class");
    }
}
