package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.DriverManager;
import pages.FlightFinder;
import pages.LoginPage;
import utils.CommonUtils;

public class VerifyFlightFinderPageDetails extends BaseTest {

	@Test
	public void verifyFinderDetails() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		FlightFinder filFinder = new FlightFinder();
		loginPage.clickOnFlightsLink();
		logger.info("Veryfying round trip radio button");
		assertTrue(filFinder.isRoundTripRadioButtonChecked(), "Round trip radio button not selected by default");

		assertFalse(filFinder.isoneWayRadioButtonChecked(), "One way radio button is selected by default");

		assertEquals(CommonUtils.getSelectedValueFromDropdown(filFinder.getPassengerCountDropdown()), "1");
		CommonUtils.getScreenshot(DriverManager.getDriver(), "FlightFinder_");
	}

}
