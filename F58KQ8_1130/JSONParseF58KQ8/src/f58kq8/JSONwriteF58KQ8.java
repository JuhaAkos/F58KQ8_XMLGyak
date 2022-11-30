package f58kq8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;


public class JSONwriteF58KQ8 {
	public static void main(String[] args) {
		JSONObject Jobj = new JSONObject();
		Jobj.put("nev", "Hallgato neve");
		Jobj.put("neptunkod", "kkklll");
		Jobj.put("szak", "PTI");
		
		String jsonText = Jobj.toString();
        System.out.println(jsonText);
	
		try {
	        
	        FileWriter file = new FileWriter("JSONF58KQ8_out.json");
	        file.write(jsonText);
	        file.close();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}