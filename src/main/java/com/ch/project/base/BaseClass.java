package com.ch.project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver baseDriver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		baseDriver = new ChromeDriver();
	}
	
	
	@AfterTest
	public void tearDown() {
		if(baseDriver != null) {
			baseDriver.quit();
		}
	}

}
