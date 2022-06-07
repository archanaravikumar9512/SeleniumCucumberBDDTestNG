package com.testautomation.runners;

import java.io.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.testautomation.stepDefinitions" },
		// tags = "@SmokeTest",
		dryRun = false, monochrome = true,
		// strict =true,
		plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
				"json:target/cucumber-reports/CucumberTestReport.json"
		})

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new
	 * File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())
	 * ); Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	 * Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	 * Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	 * Reporter.setSystemInfo("Selenium", "3.7.0"); Reporter.setSystemInfo("Maven",
	 * "3.5.2"); Reporter.setSystemInfo("Java Version", "1.8.0_151"); }
	 */

}
