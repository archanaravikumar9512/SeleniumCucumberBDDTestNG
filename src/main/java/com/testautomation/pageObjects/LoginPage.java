package com.testautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	@FindBy(how = How.XPATH, using = "//*[@aria-label='Signup']")
	public WebElement loginIcon;

	// @FindBy(how = How.XPATH, using =
	// "//*[contains(@class,'ups-user-actions')]/button")
	@FindBy(how = How.XPATH, using = "//button[@id='dropdownMenuButton']")
	public WebElement userProfile;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	public WebElement emailOrUserId;

	@FindBy(how = How.XPATH, using = "//input[@id='pwd']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Remember my user ID.')]")
	public WebElement checkBox;

	@FindBy(how = How.XPATH, using = "//button[@id='submitBtn']")
	public WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//p[@id='errorMessages']")
	public WebElement errorMessage;

	@FindBy(how = How.XPATH, using = "//div[@id='error_list']")
	public List<WebElement> errorMsgList;

	/////////////////////////////////////////////////////////////////////////////

	WebDriver driver;
	String actualLabels;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public String getAllLabelsOnPage(String labels) { // Gets all the labels on
	 * the page for (WebElement label : loginLabels) {
	 * System.out.println(label.getText()); actualLabels = label.getText().trim();
	 * System.out.println("actualLabels.contains(labels)===" +
	 * labels.contains(actualLabels)); if (labels.contains(actualLabels)) {
	 * Assert.assertTrue(true); } else Assert.assertFalse(false); } return
	 * actualLabels; }
	 */

	/*
	 * public String getActualLables() { return getAllLabelsOnPage(); }
	 * 
	 */
	public boolean verifyLogin() {
		// Wait.untilPageLoadComplete(driver);
		if (getTitle().contains("Global Shipping and Logistics Services | UPS"))
			return true;
		else
			return false;

	}

	public String getTitle() {
		return driver.getTitle();
	}

	/*
	 * public boolean isForgotPwdLinkExist() { return forgotPwdLink.isDisplayed(); }
	 */
	public void enterUserName(String username) {
		emailOrUserId.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clearFields() {
		emailOrUserId.clear();
		password.clear();
	}

	public void clickOnLogin() {
		submitBtn.click();
	}

	public void verifyCheckboxPresent() {
		checkBox.isEnabled();
	}

	public void clickOnUserProfile() {
		userProfile.click();
	}

	/*
	 * public void clickOnSignOut() { logOut.click(); }
	 */

	public void clickOnCheckBox() {
		try {
			checkBox.click();
			// Log.info("Check box is clikable");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyCheckboxClikable() {
		try {
			clickOnCheckBox();
			if (checkBox.isSelected())
				Assert.assertTrue(true);
			else
				Assert.assertFalse(false);
		} catch (Exception e) {

		}
	}

}
