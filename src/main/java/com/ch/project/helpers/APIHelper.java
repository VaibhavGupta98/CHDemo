package com.ch.project.helpers;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.ch.project.pojos.JSONSuccessResponse;

import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

public class APIHelper {
	
	public static boolean verifyResponseTime(Response response) {
		
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		long maxTime = 2000;
		
		return (responseTime < maxTime);
	}
	
	
	public static boolean verifyStatusCode(Response response) {  
		
		int status = response.statusCode();
		int expectedStatus = 201;
		
		return (status==expectedStatus);	
	}
	
	
	public static boolean verifyResponseHeaders(Response response) {
		
		Headers headers = response.headers(); 
		
		String contentType = headers.getValue("Content-Type");
		
		return contentType.contains("application/json");
	}
	
	
	public static boolean verifyDeserializeToPOJO(Response response) {
		
		JSONSuccessResponse json =  response.body().as(JSONSuccessResponse.class);
		return !(json.id.isEmpty() || json.createdAt.isEmpty());
		
	}
	
	
	public static void verifyResponseSchema(ValidatableResponse validatableResponse) {
		
		validatableResponse.assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(".\\src\\test\\resources\\APIResponseSchema.json")));	
	
	}

}
