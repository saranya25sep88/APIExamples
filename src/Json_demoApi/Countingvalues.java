package Json_demoApi;

import api_Samples.PostRequest;
import io.restassured.path.json.JsonPath;

public class Countingvalues {

	public static void main(String[] args) {
		JsonPath js = new JsonPath(PostRequest.jsonValuescount());
		int count = js.getInt("courses.size()");		
		System.out.println(count);
	}
}