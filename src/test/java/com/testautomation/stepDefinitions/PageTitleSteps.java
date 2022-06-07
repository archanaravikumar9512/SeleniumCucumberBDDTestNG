package com.testautomation.stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.testautomation.cucumber.TestContext;
import com.testautomation.dataProviders.ConfigFileReader;
import com.testautomation.managers.FileReaderManager;
import com.testautomation.pageObjects.BasePage;
import com.testautomation.pageObjects.PageTitlePage;
import com.testautomation.utilities.ExcelHandler;
import com.testautomation.utilities.TestDataHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageTitleSteps {

	TestContext testContext;
	WebDriver driver;
	TestDataHandler testdata = new TestDataHandler();
	ConfigFileReader config = new ConfigFileReader();
	PageTitlePage pageTitle;
	BasePage basePage;

	public PageTitleSteps(TestContext context) {
		testContext = context;
		pageTitle = testContext.getPageObjectManager().getPageTitlePage();
		basePage = testContext.getPageObjectManager().getPageURL();
		System.out.println(pageTitle);
	}

	@Given("^read data from excel (\\w+)$")
	public void read_data_from_excel(String arg1) {
		Map<String, String> testDataInMap;
		try {
			testDataInMap = ExcelHandler.getTestDataInMap(
					FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath(),
					FileReaderManager.getInstance().getConfigReader().getSheetName(), arg1);

			String data = testDataInMap.get("Scenarios");
			testdata.setTestDataInMap(testDataInMap);
			Reporter.log("Reading data is extecuted Successfully");
		} catch (Exception e) {

		}
	}

	@When("user is already on home page")
	public void user_is_already_on_home_page() throws Throwable {
		Map<String, String> testdataINMap = testdata.getTestDataInMap();
		String URL = testdataINMap.get("URL");
		basePage.navigateTo_URLPage(URL);

	}

	@When("user gets the page title")
	public void user_gets_the_page_title() {
		String actualTitle = pageTitle.validateLoginPageTitle();
	}

	@Then("user validates the page title")
	public void user_validates_the_page_title() {
		boolean result = verifyPageTitle();
		if (result == true) {
			System.out.println("passed");
		} else
			System.out.println("failed");
	}

	public boolean verifyPageTitle() {
		Map<String, String> testdataINMap = testdata.getTestDataInMap();
		String expectedTitle = testdataINMap.get("Expected PageTitle");
		String actualTitle = pageTitle.validateLoginPageTitle();
		System.out.println(expectedTitle +"===="+actualTitle);
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			return true;
		} else {
			return false;
		}

	}

	@Then("^update the result into the excelfile for (\\w+)$")
	public void update_the_result_into_the_excelfile_for(String arg1) {
		boolean result = verifyPageTitle();
		String tcStatus = null;
		if (result == true) {
			tcStatus = "PASS";
		} else {
			tcStatus = "FAIL";
		}

		ExcelHandler.UpdateTestResultsToExcel(
				FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath(),
				FileReaderManager.getInstance().getConfigReader().getSheetName(), tcStatus, arg1);

		// Assert.assertEquals(expectedTitle, actualTitle);

	}

}
