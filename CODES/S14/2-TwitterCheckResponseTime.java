package usefultricks;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class TwitterCheckResponseTime {
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
	public void readTweets() {
//		long responseTime =
//		given()
//			.auth()
//			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
//			.queryParam("user_id", "apiautomation")
//		.when()
//			.get("/user_timeline.json")
//			//.time();
//			.timeIn(TimeUnit.SECONDS);
//		System.out.println("Response Time: " + responseTime);
		
		given()
			.auth()
			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
			.queryParam("user_id", "apiautomation")
		.when()
			.get("/user_timeline.json")
		.then()
			.statusCode(200)
			.time(lessThan(1L), TimeUnit.SECONDS)
			.log().body()
			.body("user.name", hasItem("RestAPI Automation"))
			.body("user.screen_name", hasItem("apiautomation"))
			.body("entities.hashtags[0].text", hasItem("multiple"))
			.body("entities.hashtags[0].size()", equalTo(2));
	}
}