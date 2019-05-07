package com.letskodeit.common;

import static org.hamcrest.Matchers.lessThan;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.letskodeit.constants.Auth;
import com.letskodeit.constants.Path;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestUtilities {
	
	public static String ENDPOINT;
	public static RequestSpecBuilder REQUEST_BUILDER;
	public static RequestSpecification REQUEST_SPEC;
	public static ResponseSpecBuilder RESPONSE_BUILDER;
	public static ResponseSpecification RESPONSE_SPEC;
	
	public static void setEndPoint(String epoint) {
		ENDPOINT = epoint;
	}

	public static RequestSpecification getRequestSpecification() {
		AuthenticationScheme authScheme = 
				RestAssured.oauth(Auth.CONSUMER_KEY, Auth.CONSUMER_SECRET, Auth.ACCESS_TOKEN,
						Auth.ACCESS_SECRET);
		REQUEST_BUILDER = new RequestSpecBuilder();
		REQUEST_BUILDER.setBaseUri(Path.BASE_URI);
		REQUEST_BUILDER.setAuth(authScheme);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}

	public static ResponseSpecification getResponseSpecification() {
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		RESPONSE_BUILDER.expectStatusCode(200);
		RESPONSE_BUILDER.expectResponseTime(lessThan(3L), TimeUnit.SECONDS);
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}

	public static RequestSpecification createQueryParam(RequestSpecification rspec,
			String param, String value) {
		return rspec.queryParam(param, value);
	}

	public static RequestSpecification createQueryParam(RequestSpecification rspec,
			Map<String, String> queryMap) {
		return rspec.queryParams(queryMap);
	}

}
