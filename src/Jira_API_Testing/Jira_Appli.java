package Jira_API_Testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import api_Samples.PostRequest;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class Jira_Appli {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8050";	
		
		SessionFilter session = new SessionFilter();
		/********************jira login authentication**********************/
		given().header("Content-Type","application/json").body("{ \"username\": \"sbnsharanya\", \"password\": \"ishaan009\" }")
		.log().all().filter(session).when().post("/rest/auth/1/session").then().log().all();
		
		/********************************posting issue in jira***********/		 
		String response1 = given().header("Content-Type","application/json").body("{\r\n" + 
				"\"fields\": {\r\n" + 
				"   \"project\":\r\n" + 
				"   { \r\n" + 
				"      \"key\": \"API\"\r\n" + 
				"   },\r\n" + 
				"   \"summary\": \"REST EXAMPLE\",\r\n" + 
				"   \"description\": \"Creating an issue via REST API\",\r\n" + 
				"   \"issuetype\": {\r\n" + 
				"      \"name\": \"Bug\"\r\n" + 
				"   }\r\n" + 
				"  }\r\n" + 
				"}")
		.log().all().filter(session).when().post("/rest/api/2/issue").then().log().all().assertThat().statusCode(201).extract().response().asString(); 
		 System.out.println("res1:  "+response1);	           
	        JsonPath js = new JsonPath(response1);
	        String Place_id = js.getString("id");        
	        System.out.println(Place_id);     
		    String key = js.getString("key");
		    System.out.println("key: "+key);
	        
		//if we want to print particular field from get o/p then we need to pass fields and field name in queryparam//		
		/*******************************get posted issues*******************/
		
		given().header("Content-Type","application/json")
		.log().all().filter(session).queryParam("fields", "comment").when().get("/rest/api/2/issue/API-7").then().log().all().assertThat().statusCode(200);
		
		/**********************************update issues*************************/
		given().header("Content-Type","application/json").body("{\r\n" + 
				"  \r\n" + 
				"   \"update\": {\r\n" + 
				"      \"comment\": [\r\n" + 
				"         {\r\n" + 
				"            \"add\": {\r\n" + 
				"               \"body\": \"comment adding by saranya\"\r\n" + 
				"            }\r\n" + 
				"         }\r\n" + 
				"      ]\r\n" + 
				"   }\r\n" + 
				"}")
		.log().all().filter(session).when().put("/rest/api/2/issue/API-10").then().log().all().assertThat().statusCode(204);
	
		/*************************************delete issue********************************/
		given().header("Content-Type","application/json").pathParam("key", "API-6")
		.log().all().filter(session).when().delete("/rest/api/2/issue/{key}").then().log().all();
		}
}