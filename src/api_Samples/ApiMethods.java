package api_Samples;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class ApiMethods {
	
	
   	public static void main(String[] args) {
			
		RestAssured.baseURI="https://rahulshettyacademy.com";	
		
		//post the place***************************************************************
       String response1 = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
        .body(PostRequest.postadd()).when().log().all().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
                   .body("scope",equalTo("APP")).extract().response().asString();        
        System.out.println("res1:  "+response1);
        
        //extract the elements from response****************************************
        JsonPath js = new JsonPath(response1);
        String Place_id = js.getString("place_id");        
        System.out.println(Place_id);        
       
        //update or put the place************************************************          
        String response2 = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
        .body(PutRequest.putPlaceid(Place_id)).when().put("maps/api/place/update/json").then().assertThat().statusCode(200)
        .body("msg", equalTo("Address successfully updated")).extract().response().asString(); 
        System.out.println("resp:   "+response2);    
   	
   	 	    
        //delete the place id***************************************
       String response3 = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(DelRequest.deletePlaceid(Place_id)).when().delete("maps/api/place/delete/json").then().assertThat().statusCode(200)
                .body("status", equalTo("OK")).extract().response().asString(); 
                System.out.println("resp:   "+response3);
}}
   		/* {
   			JsonPath js = new JsonPath(PostRequest.jsonValuescount());
   			int count = js.getInt("courses.size()");	
   			int puramt = js.getInt("dashboard.purchaseAmount");
   			String title = js.get("courses[1].title");   			
   			System.out.println("courses count:  "+count);
   			System.out.println("purchase amt:  " +puramt);
   			System.out.println("course title: "+title);   		
   			for(int i=0;i<count;i++)
   			{
   				String titleall = js.get("courses["+i+"].title");
   				if(titleall.equalsIgnoreCase("RPA"))
   				{
   					int copiesall = js.getInt("courses["+i+"].copies");
   					System.out.println("Total copies of RPA: "+copiesall);
   					break;
   				}
   			}
   			int result = 0;   	
   			for(int i=0;i<count;i++) {
   				String titleall = js.get("courses["+i+"].title");
   				int priceall = js.getInt("courses["+i+"].price");
   				int copiesall = js.getInt("courses["+i+"].copies");
   				int result1 = priceall*copiesall; 
   				result=result+result1;  				
   				System.out.println("course title:  "+titleall);
   	   			System.out.println("price:  "+priceall);
   	   		    System.out.println("copies:  "+copiesall); 
   			   }System.out.println("result: "+result);
   	   		    if(result==puramt)
   	   		    {
   	   		    System.out.println("Both are equal");	
   	   		    }   	   		    	
   		}                
             
      }	     
}*/
