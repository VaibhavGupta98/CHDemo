package com.ch.project.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	Properties properties;
	
	String defaultBrowser = "localChrome";
	
	String filePath;	
	
	
	public ConfigFileReader() {
		
		String browser = System.getProperty("browser", defaultBrowser);
		
		if(browser.equals("localChrome")) {
			filePath = "src/test/resources/Configuration.properties";
		}
		
		else if(browser.equals("remoteChrome")) {
			filePath = "/home/CHTest/src/test/resources/Configuration.properties";
		}
		
		
		System.out.println("FilePath -> "+filePath);
		
		
		BufferedReader reader;
		try {
			reader= new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public String getDefaultBrowser() {
		String browser = properties.getProperty("defaultBrowser");
		return browser;
	}
	
	public String getScreenshotFolderPath() {
		String screenshotsFolderPath = properties.getProperty("screenshotsFolder");
		return screenshotsFolderPath;
	}
	
	public String getRemoteScreenshotFolderPath() {
		String screenshotsFolderPath = properties.getProperty("remote_screenshotsFolder");
		return screenshotsFolderPath;
	}
	
	public String getRemoteChromeUrl() {
		String remoteUrl = properties.getProperty("remote_url_chrome");
		return remoteUrl;
	}
	
	public String getAPIResponseSchemaPath() {
		String remoteUrl = properties.getProperty("apiResponseSchemaPath");
		return remoteUrl;
	}
	
	public String getRemoteAPIResponseSchemaPath() {
		String remoteUrl = properties.getProperty("remote_apiResponseSchemaPath");
		return remoteUrl;
	}

}
