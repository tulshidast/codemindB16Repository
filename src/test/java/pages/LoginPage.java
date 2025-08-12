package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;
import utils.Log;

public class LoginPage extends BasePage {

	private final Logger logger = Log.getLogger(this.getClass());

	public LoginPage() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//input[@name='userName']")
	WebElement userNameTextField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextField;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//a[text()='Flights']")
	WebElement flightsLink;

	// methods
	public void login(String userName, String password) {
		logger.info("Before entering user name");
		userNameTextField.sendKeys(userName);
		logger.info("After entering user name");
		passwordTextField.sendKeys(password);
		logger.info("After entering password");
		submitButton.click();
	}

	public void clickOnFlightsLink() {
		flightsLink.click();
	}

}
