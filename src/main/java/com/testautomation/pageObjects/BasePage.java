package com.testautomation.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_URLPage(String url) {
		driver.get(url);
	}
	
	public void scrollToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToView(WebElement element, double scrollDownBy) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); "
				+ "window.scrollBy(0, -window.innerHeight * " + scrollDownBy + ");", element);
	}
}
