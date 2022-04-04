package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ch.project.APIEndpoints.EndPoints;
import com.ch.project.helpers.APIHelper;
import com.ch.project.pojos.User;
import com.ch.project.utils.DataProviderClassFile;
import com.ch.project.utils.TestNGListenerUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

@Listeners(TestNGListenerUtil.class)
public class APIAutomationTest{
	
	SoftAssert softAssert = new SoftAssert(); 
	
	
	@Test(dataProvider = "userData", dataProviderClass = DataProviderClassFile.class)
	public void API_Test(String user, String job) {
		
		User userData = new User(user,job);
		
		ValidatableResponse validatableResponse = RestAssured.given().baseUri(EndPoints.BASE_URL).when().body(userData).post("/users").then(); 
		
		Response response = validatableResponse.log().all().assertThat().extract().response();
		
		softAssert.assertTrue(APIHelper.verifyStatusCode(response),"Response Status Code validation failed");
		softAssert.assertTrue(APIHelper.verifyResponseHeaders(response), "Response Headers validation failed");
		softAssert.assertTrue(APIHelper.verifyResponseTime(response),"Response Time validation failed");
		
		APIHelper.verifyResponseSchema(validatableResponse);
		
		softAssert.assertTrue(APIHelper.verifyDeserializeToPOJO(response),"Response deserializing to POJO validation failed");
		softAssert.assertAll();
	}
	

}
