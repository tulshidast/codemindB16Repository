package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.DriverManager;

public class VerifyPageTitle extends BaseTest {

	@Test
	public void verifyPageTitle() {
		assertEquals(DriverManager.getDriver().getTitle(), "Welcome: Mercury Tours");
	}

}
