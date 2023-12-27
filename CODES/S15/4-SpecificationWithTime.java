package specs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class SpecificationWithTime {
	String consumerKey = "ubhe5nnmztzlJMzdLihtKEgsT";
	String consumerSecret = "KjDJDSJw2o882K71cK33PqUdRbIlp5DNxCxYknDrSvQwNsb2S1";
	String accessToken = "886092793365409792-mBtgcXzcn9IOC1WmWp5c1fXMn3HDZHr";
	String accessSecret = "jUIEOAnEiZLlICLBlpR6UhVKZ98CMpQ7banbfcP5gW3eS";
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;
	ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;

	@BeforeClass
	public void setup() {
		AuthenticationScheme authScheme = 
				RestAssured.oauth(consumerKey, consumerSecret, accessToken, accessSecret);
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://api.twitter.com");
		requestBuilder.setBasePath("/1.1/statuses");
		requestBuilder.addQueryParam("user_id", "apiautomation");
		requestBuilder.setAuth(authScheme);
		requestSpec = requestBuilder.build();
		
		responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectResponseTime(lessThan(1L), TimeUnit.SECONDS);
		responseBuilder.expectBody("user.name", hasItem("RestAPI Automation"));
		responseSpec = responseBuilder.build();
	}

	@Test
	public void readTweets() {
		given()
			.spec(requestSpec)
		.when()
			.get("/user_timeline.json")
		.then()
			.spec(responseSpec)
			.body("user.screen_name", hasItem("apiautomation"));
	}
}