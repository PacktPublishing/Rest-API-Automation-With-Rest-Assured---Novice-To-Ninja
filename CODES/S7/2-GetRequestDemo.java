package basic;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestDemo {
	/***
	 * 	Given I have this information
		When I perform this action
		Then this should be the output
	 */
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
	
	@Test(enabled=false)
	public void statusCodeVerification() {
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
		.when()
			.get("/distancematrix/json")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void getResponseBody() {
		Response res =
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
		.when()
			.get("/distancematrix/json");
		
		System.out.println(res.body().prettyPrint());
	}
}