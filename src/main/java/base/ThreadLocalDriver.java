package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class ThreadLocalDriver {

	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

	private ThreadLocalDriver() {
	}

	public static WebDriver getDriver() {
		if (driverThreadLocal.get() == null) {
			if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driverThreadLocal.set(new ChromeDriver());
			}

			if (ConfigReader.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driverThreadLocal.set(new EdgeDriver());
			}

			if (ConfigReader.getProperty("browser").equalsIgnoreCase("safari")) {
				WebDriverManager.safaridriver().setup();
				driverThreadLocal.set(new SafariDriver());
			}
		}

		return driverThreadLocal.get();
	}

	public static void quitDriver() {
		if (driverThreadLocal.get() != null) {
			driverThreadLocal.get().quit();
			driverThreadLocal.remove();
		}
	}

}
