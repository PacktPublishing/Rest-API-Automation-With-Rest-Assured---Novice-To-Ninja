package loggingexample;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class RequestLoggingExample {
	
	String consumerKey = "ubhe5nnmztzlJMzdLihtKEgsT";
	String consumerSecret = "KjDJDSJw2o882K71cK33PqUdRbIlp5DNxCxYknDrSvQwNsb2S1";
	String accessToken = "886092793365409792-mBtgcXzcn9IOC1WmWp5c1fXMn3HDZHr";
	String accessSecret = "jUIEOAnEiZLlICLBlpR6UhVKZ98CMpQ7banbfcP5gW3eS";
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
	}
	
	@Test
	public void testMethod() {
		given()
			.log()
			//.headers()
			//.body()
			//.parameters()
			//.all()
			.ifValidationFails()
			.auth()
			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
			.queryParam("status", "My First Tweet 3")
		.when()
			.post("/update.json")
		.then()
			.statusCode(200);
	}
}