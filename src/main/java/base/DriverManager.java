package base;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private DriverManager() {
	}

	public static WebDriver getDriver() {
		return ThreadLocalDriver.getDriver();
	}

	public static void quitDriver() {
		ThreadLocalDriver.quitDriver();
	}
}
