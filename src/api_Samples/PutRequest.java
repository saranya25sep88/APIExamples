package api_Samples;

public class PutRequest{
	

	public static String putPlaceid(String Place_id) {		
	
		return "{\r\n" + 
				"\"place_id\":\""+Place_id+"\",\r\n" + 
				"\"address\":\"24, Georgecourt\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}

}
