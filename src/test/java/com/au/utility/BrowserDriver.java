package com.au.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BrowserDriver {
	
	public static WebDriver driver;
	
	public void close() {
		try {
			driver.close();
		}catch(org.openqa.selenium.WebDriverException e) {
			try {
				driver.switchTo().alert().accept();
			}catch(Exception exception) {}
		}
	}
	
	public WebDriver getBrowserInstance(String browser) {
		ConfigReader configReader = new ConfigReader();
		String headless = configReader.getConfigDataValue("HeadLessBrowser");
		
		if(driver == null) {
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
				//webDriverManager.chromedriver().setup();
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--remote-debugging-port=9222");
				options.addArguments("--start-maximized");
				options.addArguments("--window-size=1920,1080");
				
				//chrome headless mode
				if(headless.equalsIgnoreCase("true")) {
					options.addArguments("--headless");
				}
				driver = new ChromeDriver(options);
			} else if(browser.equals("ie")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				//WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}else if(browser.equals("chrome-headless")) {
			   ChromeOptions options = new ChromeOptions();
			   options.addArguments("headless");
			   driver = new ChromeDriver(options);
			}else {
				throw new RuntimeException("Browser type unsupported");
			}
			driver =  WebDriverListener();
			
		}
		return driver;
		
		
	}
	
	
	public EventFiringWebDriver WebDriverListener()
	{
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		
		// now create object of EventListenerHandler to register it with EventFiringWebDriver
		WebDriverListener listeners = new WebDriverListener();
		e_driver.register(listeners);
		return e_driver;
	}

}
