package com.ae.shopping.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/ae/shopping/cucumber", glue = "com.ae.shopping.stepDefinitions", monochrome = true, plugin = {
		"html:target.cucumber.html" }, tags = "@NegativeScenario or @SmokeTestCucumber")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}

