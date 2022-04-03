package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ch.project.base.BaseClass;
import com.ch.project.pages.AmazonHomePage;
import com.ch.project.pages.AmazonResultsPage;
import com.ch.project.utils.ConfigFileReader;


public class WebAutomationTest extends BaseClass {
	
	WebDriver driver;
	
	@Test
	public void UI_Test() throws InterruptedException {
		
		System.out.println("------------------ UI Test Started -----------------");
		
		this.driver = baseDriver;
		
		driver.get(config.getUrl());
		
		AmazonHomePage homePage = new AmazonHomePage(driver);
		
		AmazonResultsPage resultsPage = new AmazonResultsPage(driver);
		
		homePage.clickOnHamsurburgMenu();
		
		homePage.clickOnTVAppliancesElectronics();
		
		homePage.clickOnTelevisions();
		
		homePage.filterResultsByBrandSamsung();
		
		resultsPage.sortResultsFromHighToLow();
		
		resultsPage.clickOnSecondHighestPriceItem();
		
		String currentWindow = driver.getWindowHandle();		
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window: allWindows) {
			if(!window.equals(currentWindow)) {
				driver.switchTo().window(window);
			}
		}
		
		resultsPage.printItemDescription();
	
		System.out.println("------------------ UI Test Completed -----------------");
	}
	
}
