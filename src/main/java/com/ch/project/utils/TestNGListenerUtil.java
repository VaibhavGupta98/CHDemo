package com.ch.project.utils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenerUtil implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Succeeded");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed But Within Success Percentage");
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Starting Test Case");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test Case Completed");
		
	}


}
