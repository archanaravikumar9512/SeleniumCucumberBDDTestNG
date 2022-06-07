package com.testautomation.managers;

import org.openqa.selenium.WebDriver;

import com.testautomation.pageObjects.BasePage;
import com.testautomation.pageObjects.LoginPage;
import com.testautomation.pageObjects.PageTitlePage;

public class PageObjectManager {
	private WebDriver driver;

	private PageTitlePage pageTitlePage;
	private BasePage basePage;
	private LoginPage loginPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public PageTitlePage getPageTitlePage() {
		return (pageTitlePage == null) ? pageTitlePage = new PageTitlePage(driver) : pageTitlePage;
	}

	public BasePage getPageURL() {
		return (basePage == null) ? basePage = new BasePage(driver) : basePage;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

}
