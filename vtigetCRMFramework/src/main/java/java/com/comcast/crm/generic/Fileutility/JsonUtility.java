package java.com.comcast.crm.generic.Fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.parser.JSONParser;

import com.google.gson.JsonObject;

public class JsonUtility {
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws Throwable
	 */
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fileR = new FileReader("./configAppData/CommondataJSON.json");
		JSONParser pars= new JSONParser();
		Object obj = pars.parse(fileR);
		JsonObject map = (JsonObject) obj;
		String data = map.get(key).toString();
		return data;
	}
}
