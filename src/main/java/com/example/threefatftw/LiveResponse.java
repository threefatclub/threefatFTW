package com.example.threefatftw;

//necessary components are imported

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.hc.client5.http.fluent.Request;

class LiveResponse{
	
    // essential URL structure is built using constants 
	public static final String ACCESS_KEY = "1dc286032ed037a75e241c33b078f2d0";
	public static final String BASE_URL = "http://apilayer.net/api/";
	public static final String ENDPOINT = "live";

	/**
	 * 
	 * Notes:<br><br>
	 * 
	 * A JSON response of the form {"key":"value"} is considered a simple Java JSONObject.<br>
	 * To get a simple value from the JSONObject, use: <JSONObject identifier>.get<Type>("key");<br>
	 * 
	 * A JSON response of the form {"key":{"key":"value"}} is considered a complex Java JSONObject.<br>
	 * To get a complex value like another JSONObject, use: <JSONObject identifier>.getJSONObject("key")
	 * 
	 * Values can also be JSONArray Objects. JSONArray objects are simple, consisting of multiple JSONObject Objects.
	 * 
	 * 
	 */
	
	// sendLiveRequest() function is created to request and retrieve the data
	public static void sendLiveRequest(){

		try {
			var payload = Request.get(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY)
					.execute().returnContent().asString();
//       System.out.println(payload)
//			JsonNode exchangeRates = new ObjectMapper().readTree(payload);
      Files.writeString(Paths.get("src/main/resources/lastUpdatedValues.json"), payload);
			System.out.println("Currency rates successfully fetched . . . \nstored in lastUpdatedValues.json");
		} catch (IOException e) {
			e.printStackTrace();
		}

			// parsed JSON Objects are accessed according to the JSON resonse's hierarchy, output strings are built
			//Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000));
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			//String formattedDate = dateFormat.format(timeStampDate);
			//System.out.println("1 " + exchangeRates.getString("source") + " in GBP : " + exchangeRates.getJSONObject("quotes").getDouble("USDGBP") );
			//System.out.println("\n");

	}

    // sendLiveRequest() function is executed
	public static void main(String...args) throws IOException{
		sendLiveRequest();
	}

}
