package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ConfigReader {

	public static String getProperty(String key) {
		Properties properties = null;
		try {
			File file = new File("src/main/resources/master.properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			Reporter.log("File in not found");
		}
		return properties.getProperty(key);
	}

}
