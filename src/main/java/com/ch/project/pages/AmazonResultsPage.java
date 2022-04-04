package com.ch.project.pages;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.project.helpers.UIHelper;

public class AmazonResultsPage {
	
	public WebDriver driver;
	
	Wait<WebDriver> wait;
	
	@FindBy(xpath = "//span[@class='a-dropdown-container']//span[contains(@class,'a-button-dropdown')]")
	private WebElement sortResultsDropdown;
	
	@FindBy(xpath = "//div[@class='a-popover-wrapper']//a[contains(text(),'High to Low')]")
	private WebElement highToLowDropdownValue;
		
	@FindBy(xpath = "//div[@data-component-type = 's-search-result' and @data-index='2']")
	private WebElement secondHighestPriceItem;
		
	@FindBy(xpath = "//div[@id='feature-bullets']//h1[contains(@class,'a-text-bold')]")
	private WebElement descriptionHeaderText;
		
	@FindBy(xpath = "//div[@id='feature-bullets']//li//span")
	private List<WebElement> descriptionBulletPoints;
	
	//Constructor
	public AmazonResultsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSortResultsByPriceDropdown() {
		wait.until(ExpectedConditions.visibilityOf(sortResultsDropdown));
		UIHelper.clickOnElement(sortResultsDropdown);
	}
	
	public void clickOnHighToLowOptionInDropdown() {
		wait.until(ExpectedConditions.visibilityOf(highToLowDropdownValue));
		UIHelper.clickOnElement(highToLowDropdownValue);
	}
	
	public void clickOnSecondHighestPriceItem() {
		wait.until(ExpectedConditions.visibilityOf(secondHighestPriceItem));
		UIHelper.clickOnElement(secondHighestPriceItem);
	}
	
	public void sortResultsFromHighToLow() {
		clickOnSortResultsByPriceDropdown();
		clickOnHighToLowOptionInDropdown();
	}
	
	public void printItemDescription() {
		
		System.out.println(UIHelper.getElementText(descriptionHeaderText));
		
		for(WebElement element : descriptionBulletPoints) {
			System.out.println(UIHelper.getElementText(element));	
		}
	}
	

}
