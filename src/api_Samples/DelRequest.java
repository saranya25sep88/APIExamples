package api_Samples;

public class DelRequest {
	
	public static String deletePlaceid(String Place_id) {		
		
		return "{\r\n" + 
				"    \"place_id\":\""+Place_id+"\"\r\n" + 
				"}\r\n" + 
				"";
	}
}
