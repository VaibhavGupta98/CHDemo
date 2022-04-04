package com.ch.project.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UIHelper {
	
	
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static String getElementText(WebElement element) {
		return element.getText();
	}
	
	public static String getElementText(WebDriver driver, By element) {
		return driver.findElement(element).getText();
	}
	

}
