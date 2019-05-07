package twitterapiexample;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TwitterExtractResponse {
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
	public void extractResponse() {
		Response response =
			given()
				.auth()
				.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
				.queryParam("status", "My First Tweet")
			.when()
				.post("/update.json")
			.then()
				.statusCode(200)
				.extract()
				.response();
		
		String id = response.path("id_str");
		System.out.println("The response.path: " + id);

		String responseString = response.asString();
		System.out.println(responseString);

		JsonPath jsPath = new JsonPath(responseString);
		String name = jsPath.get("user.name");
		System.out.println("The username is: " + name);
	}
}