package basic;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
	
	@Test
	public void statusCodeVerification() {
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
		.when()
			.get("/distancematrix/json")
		.then()
			.statusCode(200)
			.and()
			.body("rows[0].elements[0].distance.text", equalTo("225 mi"))
			.contentType(ContentType.JSON);
	}
}