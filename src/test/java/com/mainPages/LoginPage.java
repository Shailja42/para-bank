package com.mainPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.utils.CommonUtils;



public class LoginPage extends CommonUtils   {
	public static Map<String, String> xpaths;
	//WebDriver driver;
	public void loadData() throws IOException {
		xpaths = new HashMap<>();
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("C:\\work-stuff\\workspace\\para-bank\\src\\test\\java\\com\\objectrepository\\parabank\\application.properties");
		obj.load(objfile);
		for (String key : obj.stringPropertyNames()) {
			String value = obj.getProperty(key);
			xpaths.put(key, (value));
		}
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

	}
	public void launch() throws IOException {
		 //SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
		 loadData();		
		 System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		 driver.get(xpaths.get("AppUrl"));
		 driver.manage().window().maximize();
	}

	public void login() throws IOException, InterruptedException {
		readData();
		driver.findElement(By.xpath(xpaths.get("login_xpath"))).click();
	}
	

}
