package ru.levelp.at.lesson13.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
