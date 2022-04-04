package com.ch.project.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotUtil {
	
	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			ConfigFileReader configs = new ConfigFileReader();
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			String browser = System.getProperty("browser", configs.getDefaultBrowser());
			
			if(browser.equals("remoteChrome")) {
				FileHandler.copy(source, new File(configs.getRemoteScreenshotFolderPath()+screenshotName+".png"));
			}
			
			else if(browser.equals("localChrome")) {	 
				FileHandler.copy(source, new File(configs.getScreenshotFolderPath()+screenshotName+".png"));
			}
			 
			System.out.println("Screenshot taken");
		} 
		catch (Exception e){
			
			System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	}

}
