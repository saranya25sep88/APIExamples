package testNG_api;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class NewTest {
	
	
	//first test case for add book

  @Test(dataProvider="bookdata")
  public static void addbook(String aisle, String author) {
	  
	  RestAssured.baseURI="http://216.10.245.166";		
      String response1 = given().log().all().header("Content-Type","application/json")
      .body(Methods.postbook(aisle, author)).when().post("/Library/Addbook.php").then().assertThat().statusCode(200)
                 .extract().response().asString();        
      System.out.println("res1:  "+response1);
      JsonPath js = new JsonPath(response1);
      String id = js.getString("ID");        
      System.out.println(id);     	  	  
  }
  
  @DataProvider(name="bookdata")
  public static Object[][] getdata() {	  
   return new Object[][] {{"selenium","123"},{"python","234"},{"ruby","567"}};
  }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

 /* @Test
 public static void getbook() {
 	  
	  RestAssured.baseURI="http://216.10.245.166";
	  String response2 = given().log().all().queryParam("AuthorName", "somename").header("Content-Type","application/json")
		     .when().log().all().get("/Library/GetBook.php").then().assertThat().statusCode(200)
		                 .extract().response().asString();        
		      System.out.println("res2:  "+response2);
  }
  @Test
  public static void delbook() {
 	  
 	 RestAssured.baseURI="http://216.10.245.166";
 	
	String response3 = given().log().all().header("Content-Type","application/json")
		     .body(Methods.delinTestNG(id)).when().delete("/Library/DeleteBook.php").then().assertThat().statusCode(200)
		     .body("status", equalTo("OK")).extract().response().asString(); 
	 System.out.println("res3:  "+response3);   
	
  }*/
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
