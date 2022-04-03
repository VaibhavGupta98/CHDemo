package com.ch.project.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.project.helpers.UIHelper;

public class AmazonHomePage {
	
	WebDriver driver;
	
	Wait<WebDriver> wait;
	
	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	private WebElement hamsurburgMenuIcon;
		
	@FindBy(xpath = "//a[@class='hmenu-item']//div[text()='TV, Appliances, Electronics']")
	private WebElement tvAppliancesElectronicsFilter;
		
	@FindBy(xpath = "//a[@class='hmenu-item' and text()='Televisions']")
	private WebElement televisionsFilter;	
	
	@FindBy(xpath = "//div[@id='s-refinements']//span[text()='Samsung']//parent::a/div")
	private WebElement samsungCheckBox;
	
	//Constructor
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHamsurburgMenu() {
		UIHelper.clickOnElement(hamsurburgMenuIcon);
	}
	
	public void clickOnTVAppliancesElectronics() {
		UIHelper.clickOnElement(tvAppliancesElectronicsFilter);
	}
	
	public void clickOnTelevisions() {
		UIHelper.clickOnElement(televisionsFilter);
	}
	
	public void filterResultsByBrandSamsung() {
		wait.until(ExpectedConditions.visibilityOf(samsungCheckBox));
		UIHelper.clickOnElement(samsungCheckBox);
	}
	
	
	
	
	
}
