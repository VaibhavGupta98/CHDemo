package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ch.project.base.BaseClass;
import com.ch.project.pages.AmazonHomePage;
import com.ch.project.pages.AmazonResultsPage;


public class WebAutomationTest extends BaseClass {
	
	WebDriver driver;
	
	@Test
	public void Test1() throws InterruptedException {
		this.driver = baseDriver;
		
		driver.get("https://amazon.in");
		
		AmazonHomePage homePage = new AmazonHomePage(driver);
		
		AmazonResultsPage resultsPage = new AmazonResultsPage(driver);
		
		homePage.clickOnHamsurburgMenu();
		
		homePage.clickOnTVAppliancesElectronics();
		
		homePage.clickOnTelevisions();
		
		homePage.filterResultsByBrandSamsung();
		
		resultsPage.sortResultsFromHighToLow();
		
		resultsPage.clickOnSecondHighestPriceItem();
		
		String currentWindow = driver.getWindowHandle();		
		
		Set<String> set = driver.getWindowHandles();
		
		for(String window: set) {
			if(!window.equals(currentWindow)) {
				driver.switchTo().window(window);
			}
		}
		
		resultsPage.printItemDescription();
	
	
	}
	
}
