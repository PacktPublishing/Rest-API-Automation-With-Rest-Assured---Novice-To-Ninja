package basic;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.PlacesAddModel;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class POSTRequestWithPOJO {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
	
	@Test
	public void statusCodeVerification() {
		Map<String, Double> locationMap = new HashMap<String, Double>();
		locationMap.put("lat", -33.8669710);
		locationMap.put("lng", 151.1958750);
		
		ArrayList<String> types = new ArrayList<String>();
		types.add("shoe_store");
		
		PlacesAddModel places = new PlacesAddModel();
		places.setLocation(locationMap);
		places.setAccuracy(50);
		places.setName("Google Shoes!");
		places.setPhone_number("(02) 9374 4000");
		places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		places.setTypes(types);
		places.setWebsite("http://www.google.com.au/");
		places.setLanguage("en-AU");
		
		// jackson or gson -> They serialize the object into JSON format
		//Response res = 
		given()
			.queryParam("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
			.body(places)
		.when()
			.post("/place/add/json")
		//System.out.println(res.body().asString());
		.then()
			.statusCode(200).and()
			.contentType(ContentType.JSON).and()
			.body("scope", equalTo("APP")).and()
			.body("status", equalTo("OK"));
	}
}