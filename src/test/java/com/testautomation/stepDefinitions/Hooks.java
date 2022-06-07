package com.testautomation.stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;
import com.testautomation.cucumber.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	/*
	 * @Before public void beforeScenario(Scenario scenario) {
	 * Reporter.assignAuthor("Cucumber_Automation - Extent Reporter"); }
	 */

	/*
	 * @BeforeClass public static void setup() { ExtentProperties extentProperties =
	 * ExtentProperties.INSTANCE;
	 * extentProperties.setReportPath("output/myreport.html"); }
	 */

	/*
	 * @After(order = 1) public void afterScenario(Scenario scenario) { if
	 * (scenario.isFailed()) { String screenshotName =
	 * scenario.getName().replaceAll(" ", "_"); try { File sourcePath =
	 * ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
	 * .getScreenshotAs(OutputType.FILE); File destinationPath = new
	 * File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
	 * + screenshotName + ".png"); Files.copy(sourcePath, destinationPath);
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } catch
	 * (IOException e) { } } }
	 */

	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().quitDriver();
	}

}