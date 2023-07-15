package com.au.utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends BrowserDriver{

	WebDriver driver;
	
	@BeforeTest
	public void startBrowser() {
		driver.get(null);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
