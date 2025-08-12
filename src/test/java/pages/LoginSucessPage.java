package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverManager;

public class LoginSucessPage extends BasePage {

	public LoginSucessPage() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Login Successfully']")
	WebElement loginSuccessMsg;

	public String getLoginSuccessMsg() {
		return loginSuccessMsg.getText();
	}

}
