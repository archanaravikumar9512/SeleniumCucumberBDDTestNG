package com.testautomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageTitlePage {

	WebDriver driver;

	public PageTitlePage(WebDriver driver) { 
		// TODO Auto-generated constructor stub 
	  this.driver = driver; 
	  PageFactory.initElements(driver, this); 
	 }

	public void navigateTo_URLPage(String url) {
		driver.get(url);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle().trim();
	}
}

