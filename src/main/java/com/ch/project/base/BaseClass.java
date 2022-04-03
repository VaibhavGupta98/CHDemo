package com.ch.project.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ch.project.utils.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver baseDriver;
	
	public static String remote_url_chrome = "http://localhost:4444/wd/hub";
	
	protected ConfigFileReader config;
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		config = new ConfigFileReader();
		
		String browser = System.getProperty("browser", config.getDefaultBrowser());
		
		if(browser.equals("remoteChrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			
			baseDriver = (new RemoteWebDriver(new URL(remote_url_chrome), options));
			
		}
		
		else if (browser.equals("localChrome")) {
			WebDriverManager.chromedriver().setup();
			baseDriver = new ChromeDriver();
		}
		
	}
	
	
	@AfterTest
	public void tearDown() {
		if(baseDriver != null) {
			baseDriver.quit();
		}
	}

}
