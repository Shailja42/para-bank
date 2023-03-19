package com.mainPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonBrowserClass {

	// instance of singleton class
	private static SingletonBrowserClass instanceOfSingletonBrowserClass = null;

	static WebDriver driver;

	// Constructor
	private SingletonBrowserClass() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// TO create instance of class
	public static SingletonBrowserClass getInstanceOfSingletonBrowserClass() {
		if (instanceOfSingletonBrowserClass == null) {
			instanceOfSingletonBrowserClass = new SingletonBrowserClass();
		}
		return instanceOfSingletonBrowserClass;
	}

	// To get driver
	public static WebDriver getDriver() {
		try {
			return driver;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return driver;
	}

}
