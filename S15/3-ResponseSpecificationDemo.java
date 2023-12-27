package specs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpecificationDemo {
	String consumerKey = "ubhe5nnmztzlJMzdLihtKEgsT";
	String consumerSecret = "KjDJDSJw2o882K71cK33PqUdRbIlp5DNxCxYknDrSvQwNsb2S1";
	String accessToken = "886092793365409792-mBtgcXzcn9IOC1WmWp5c1fXMn3HDZHr";
	String accessSecret = "jUIEOAnEiZLlICLBlpR6UhVKZ98CMpQ7banbfcP5gW3eS";
	
	ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
		responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectBody("user.name", hasItem("RestAPI Automation"));
		responseSpec = responseBuilder.build();
	}

	@Test
	public void readTweets() {
		given()
			.auth()
			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
			.queryParam("user_id", "apiautomation")
		.when()
			.get("/user_timeline.json")
		.then()
//		.statusCode(200)
//		.body("user.name", hasItem("RestAPI Automation"))
//		.body("user.screen_name", hasItem("apiautomation"));
			.spec(responseSpec)
			.body("user.screen_name", hasItem("apiautomation"));
	}
}