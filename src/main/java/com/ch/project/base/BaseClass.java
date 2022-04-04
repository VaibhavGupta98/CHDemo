package com.ch.project.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.ch.project.utils.ConfigFileReader;
import com.ch.project.utils.TakeScreenshotUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver baseDriver;
	
	protected ConfigFileReader config ;
		
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
				
		config = new ConfigFileReader();
		
		String browser = System.getProperty("browser", config.getDefaultBrowser());
		
		System.out.println("Browser -> "+browser);
		
		if(browser.equals("remoteChrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			
			baseDriver = (new RemoteWebDriver(new URL(config.getRemoteChromeUrl()), options));
			
		}
		
		else if (browser.equals("localChrome")) {
			WebDriverManager.chromedriver().setup();
			baseDriver = new ChromeDriver();
		}
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TakeScreenshotUtil.captureScreenshot(baseDriver, result.getName());
		}
				
		if(baseDriver != null) {
			baseDriver.quit();
		}
	}

}
