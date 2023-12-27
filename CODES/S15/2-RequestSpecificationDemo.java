package specs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {
	String consumerKey = "ubhe5nnmztzlJMzdLihtKEgsT";
	String consumerSecret = "KjDJDSJw2o882K71cK33PqUdRbIlp5DNxCxYknDrSvQwNsb2S1";
	String accessToken = "886092793365409792-mBtgcXzcn9IOC1WmWp5c1fXMn3HDZHr";
	String accessSecret = "jUIEOAnEiZLlICLBlpR6UhVKZ98CMpQ7banbfcP5gW3eS";
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;

	@BeforeClass
	public void setup() {
//		RestAssured.baseURI = "https://api.twitter.com";
//		RestAssured.basePath = "/1.1/statuses";
		AuthenticationScheme authScheme = 
				RestAssured.oauth(consumerKey, consumerSecret, accessToken, accessSecret);
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://api.twitter.com");
		requestBuilder.setBasePath("/1.1/statuses");
		requestBuilder.addQueryParam("user_id", "apiautomation");
		requestBuilder.setAuth(authScheme);
		requestSpec = requestBuilder.build();
	}

	@Test
	public void readTweets() {
		given()
			.spec(requestSpec)
//			.auth()
//			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
//			.queryParam("user_id", "apiautomation")
		.when()
			.get("/user_timeline.json")
		.then()
			.statusCode(200);
	}
}