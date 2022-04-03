package com.ch.project.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	Properties properties;
	String filePath = ".\\src\\test\\resources\\Configuration.properties";
	
	public ConfigFileReader() {
		
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

}
