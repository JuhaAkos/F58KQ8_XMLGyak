package f58kq8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ListF58KQ8 {

	public static void main(String[] args) {
		
		JSONObject Jobj = new JSONObject();
		
		Jobj.put("neptunkod", "kkklll");
		Jobj.put("hallgato", "hallgato neve");
		
		JSONArray list = new JSONArray();
        list.add("PTI");
        list.add("Mérnökinfó");
        list.add("Tesztérték");

        Jobj.put("szak", list);
		
		String jsonText = Jobj.toString();
        System.out.println(jsonText);


	}

}
