package tests;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.DriverManager;
import utils.Log;

public class BaseTest {

	protected static Logger logger;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		logger = Log.getLogger(this.getClass());
		DriverManager.getDriver().get(ConfigReader.getProperty("url"));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
