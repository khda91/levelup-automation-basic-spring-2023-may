package ru.levelp.at.lesson03.unit.testing.tools.hooks.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(this.getClass().getName() + " before test");
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

    @AfterTest
    public void afterTest() {
        System.out.println(this.getClass().getName() + " after test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " after suite");
    }
}
