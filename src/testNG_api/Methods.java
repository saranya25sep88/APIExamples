package testNG_api;

public class Methods {

	
	public static String postbook(String aisle, String author) {
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"bcd\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\""+author+"\"\r\n" + 
				"}\r\n" + 
				" ";
	}
		
	public static String delinTestNG(String id) {
		return "{\r\n" + 
				"    \"place_id\":\""+id+"\r\n" + 
				"}\r\n" + 
				" ";
}
}
