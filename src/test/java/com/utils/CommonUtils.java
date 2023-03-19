package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mainPages.LoginPage;

public class CommonUtils {
	public static WebDriver driver;

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void readData() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\akumar94\\Documents\\TestingData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		int k = 0;
		int column = 0;
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata2")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstCell = rows.next();
				Iterator<Cell> cells = firstCell.cellIterator();
				while (cells.hasNext()) {
					Cell value = cells.next();

					if (value.getStringCellValue().equals("Username")) {
						column = k;
					}
					k++;

					System.out.println(column);
					break;
				}
				while (rows.hasNext()) {
					Row r = rows.next();
					String value = r.getCell(column).getStringCellValue();
					System.out.println("Vaue is: " + value);
					String pwd_value = r.getCell(1).getStringCellValue();
					System.out.println(pwd_value);
					// Thread.sleep(1000);
					driver.findElement(By.xpath(LoginPage.xpaths.get("username_xpath"))).sendKeys(value);
					driver.findElement(By.xpath(LoginPage.xpaths.get("password_xpath"))).sendKeys(pwd_value);

				}

			}
		}
		workbook.close();
	}

}
