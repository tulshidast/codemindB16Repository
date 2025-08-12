package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class CommonUtils {

	public static void getScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,
					new File("src/test/resources/screenshots/" + fileName + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void waitforElementToBeVisible(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.ignoring(TimeoutException.class).pollingEvery(Duration.ofMillis(200));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static List<Object> readExcelData(String filePath) {

		List<Object> userDetails = new ArrayList<Object>();

		File file = new File(filePath);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet("userdetails");
			int numOfRows = xssfSheet.getLastRowNum();

			for (int i = 1; i < numOfRows; i++) {
				XSSFRow xssfRow = xssfSheet.getRow(i);

				short lastNumCell = xssfRow.getLastCellNum();

				for (int j = 0; j < lastNumCell; j++) {
					XSSFCell cell = xssfRow.getCell(j);

					if (cell.getCellType() == CellType.STRING) {
						userDetails.add(cell.getStringCellValue());
					}
					if (cell.getCellType() == CellType.NUMERIC) {
						userDetails.add(cell.getNumericCellValue());
					}

					if (cell.getCellType() == CellType._NONE) {
						userDetails.add(cell.getRawValue());
					}

				}

			}
			xssfWorkbook.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userDetails;
	}

	public static List<Object> readExcelSpecificSheetData(String sheetName, String filePath) {

		List<Object> userDetails = new ArrayList<Object>();

		File file = new File(filePath);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
			int numOfRows = xssfSheet.getLastRowNum();

			for (int i = 1; i < numOfRows; i++) {
				XSSFRow xssfRow = xssfSheet.getRow(i);

				short lastNumCell = xssfRow.getLastCellNum();

				for (int j = 0; j < lastNumCell; j++) {
					XSSFCell cell = xssfRow.getCell(j);

					if (cell.getCellType() == CellType.STRING) {
						userDetails.add(cell.getStringCellValue());
					}
					if (cell.getCellType() == CellType.NUMERIC) {
						userDetails.add(cell.getNumericCellValue());
					}

					if (cell.getCellType() == CellType._NONE) {
						userDetails.add(cell.getRawValue());
					}

				}

			}
			xssfWorkbook.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userDetails;
	}

	public static List<Object> readExcelSpecificSheetData(String filePath, String sheetName, int rowNumber) {

		List<Object> userDetails = new ArrayList<Object>();

		File file = new File(filePath);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

			XSSFRow xssfRow = xssfSheet.getRow(rowNumber);

			short lastNumCell = xssfRow.getLastCellNum();

			for (int j = 0; j < lastNumCell; j++) {
				XSSFCell cell = xssfRow.getCell(j);

				if (cell.getCellType() == CellType.STRING) {
					userDetails.add(cell.getStringCellValue());
				}
				if (cell.getCellType() == CellType.NUMERIC) {
					userDetails.add(cell.getNumericCellValue());
				}

				if (cell.getCellType() == CellType._NONE) {
					userDetails.add(cell.getRawValue());
				}

			}

			xssfWorkbook.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userDetails;
	}

	public static void selectValueFromDropdown(WebElement dropdown, String option) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	public static String getSelectedValueFromDropdown(WebElement dropdown) {
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}

}
