package f58kq8;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ObjectF58KQ8 {
	public static void main(String[] args) {
		JSONObject Jobj = new JSONObject(); 
		/*
		JSONParser parser = new JSONParser();		
		
		try (Reader reader = new FileReader("JSONF58KQ8.json")) {
	
	        JSONObject jsonObject = (JSONObject) parser.parse(reader);	        
	
	        Jobj.put("student", jsonObject.get("student"));
	       
	        String jsonText = Jobj.toString();
	        System.out.println(jsonText);
	
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    */
		Jobj.put("neptunkod", "kkklll");
		Jobj.put("hallgato", "hallgato neve");
		Jobj.put("szak", "PTI");
		System.out.println(Jobj);
	
	}	
}
