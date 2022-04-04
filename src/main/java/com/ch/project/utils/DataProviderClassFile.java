package com.ch.project.utils;

import org.testng.annotations.DataProvider;

public class DataProviderClassFile {
	
	@DataProvider(name = "userData")
	public static Object[][] getLoginData(){
		return new Object[][] {
			{"admin","admin"},{"ronaldo","player"}
		};
	}

}
