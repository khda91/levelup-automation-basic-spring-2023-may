package ru.levelp.at.lesson03.unit.testing.tools.hooks.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

public abstract class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeGroups(groups = {GroupNames.POSITIVE_TEST_GROUP, GroupNames.NEGATIVE_TEST_GROUP,
        GroupNames.INCREMENT_TEST_GROUP, GroupNames.DECREMENT_TEST_GROUP})
    public void beforeGroups() {
        System.out.println(this.getClass().getName() + " before groups");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up");
        // arrange || given
        calculator = new CalculatorImpl();
    }

    @AfterMethod(groups = {GroupNames.POSITIVE_TEST_GROUP})
    public void positiveGroupTearDown() {
        System.out.println(this.getClass().getName() + " positive group tear down");
        calculator = null;
    }

    @AfterMethod(groups = {GroupNames.NEGATIVE_TEST_GROUP})
    public void negativeGroupTearDown() {
        System.out.println(this.getClass().getName() + " negative group tear down");
        calculator = null;
    }

    @AfterGroups(groups = {GroupNames.POSITIVE_TEST_GROUP, GroupNames.NEGATIVE_TEST_GROUP,
        GroupNames.INCREMENT_TEST_GROUP, GroupNames.DECREMENT_TEST_GROUP})
    public void afterGroups() {
        System.out.println(this.getClass().getName() + " after groups");
    }
}
