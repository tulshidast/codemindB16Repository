package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;
import utils.Log;

public class FlightFinder extends BasePage {
	private final Logger logger = Log.getLogger(this.getClass());

	public FlightFinder() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	WebElement roundTripRadioButton;

	@FindBy(xpath = "//input[@value='oneway']")
	WebElement oneWayRadioButton;

	@FindBy(xpath = "//select[@name='passCount']")
	WebElement passengerCountDropdown;

	public WebElement getPassengerCountDropdown() {
		return passengerCountDropdown;
	}

	public boolean isRoundTripRadioButtonChecked() {
		logger.info("checking round trip radio button is checked or not checked");
		return roundTripRadioButton.isSelected();
	}

	public boolean isoneWayRadioButtonChecked() {
		return oneWayRadioButton.isSelected();
	}

}
