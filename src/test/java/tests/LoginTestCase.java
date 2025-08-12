package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LoginSucessPage;

public class LoginTestCase extends BaseTest {

	@Test
	public void verifyLogin() {
		logger.info("This before getting login page instance");
		LoginPage loginPage = new LoginPage();
		LoginSucessPage loginSucessPage = new LoginSucessPage();
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		logger.info("User logged in successfully");
		assertEquals(loginSucessPage.getLoginSuccessMsg(), "Login Successfully", "User login failed");
	}

}
