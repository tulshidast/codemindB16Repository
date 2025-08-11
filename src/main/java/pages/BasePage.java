package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;
import utils.Log;

abstract class BasePage {

	protected WebDriver driver;
	protected Logger logger;

	public BasePage() {
		logger = Log.getLogger(this.getClass());
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

}
