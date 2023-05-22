package ru.levelp.at.lesson03.unit.testing.tools.hooks.suite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " before suite");
    }

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

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " after suite");
    }
}
