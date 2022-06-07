package com.testautomation.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.testautomation.enums.DriverType;
import com.testautomation.enums.EnvironmentType;



public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	//Browser is opened based on 
	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			//driver = new ChromeDriver(setChromeOption());
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		System.out.println("WebDriverManager");
		return driver;
	}

	/*
	 * public ChromeOptions setChromeOption() { ChromeOptions options = new
	 * ChromeOptions(); options.setAcceptInsecureCerts(true);
	 * options.addArguments("--disable-notifications");
	 * options.setExperimentalOption("useAutomationExtension", false);
	 * options.setExperimentalOption("excludeSwitches", new String[] {
	 * "enable-automation" }); // options.addArguments("headless");
	 * options.addArguments("disable-extensions");
	 * options.addArguments("disable-gpu");
	 * options.addArguments("disable-infobars");
	 * options.addArguments("disable-browser-side-navigation");
	 * options.addArguments("--ignore-ssl-errors=yes"); // handling ssl certificate
	 * error options.addArguments("--ignore-certificate-errors"); return options; }
	 */

	public void quitDriver() {
		driver.close();
		driver.quit();
	}

}
