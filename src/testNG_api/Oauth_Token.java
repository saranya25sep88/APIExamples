package testNG_api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Oauth_Token {

	public static void main(String[] args) {
		String response = given().queryParam("access_token","accesstoken")
				.when().get("https://rahulshettyacademy.com/getcourde.pho").asString();
		System.out.println(response);

	}

}
