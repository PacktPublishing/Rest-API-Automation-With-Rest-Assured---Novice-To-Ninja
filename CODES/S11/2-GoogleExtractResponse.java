package extractresponse;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GoogleExtractResponse {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
	
	@Test
	public void extractResponse() {
		Response response = given()
			.queryParam("units", "imperial")
			.queryParam("origins", "Washington,DC")
			.queryParam("destinations", "New+York+City,NY")
			.queryParam("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
		.when()
			.get("/distancematrix/xml")
		.then()
			.statusCode(200).extract().response();
		
		String responseString = response.asString();
		System.out.println(responseString);
		
		String value = response.path("distancematrixresponse.row.element.duration.value");
		System.out.println("The duration value is: " + value);
		
		XmlPath xmlPath = new XmlPath(responseString);
		String text = xmlPath.get("distancematrixresponse.row.element.duration.text");
		System.out.println("The duration text using XMLPath is: " + text);
	}
}