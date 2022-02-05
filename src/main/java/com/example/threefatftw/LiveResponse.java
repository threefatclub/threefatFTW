package com.example.threefatftw;

//necessary components are imported

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LiveResponse{

	static Logger log = LoggerFactory.getLogger(LiveResponse.class);
	
    // essential URL structure is built using constants 
	public static final String
				ACCESS_KEY = "1dc286032ed037a75e241c33b078f2d0",
				BASE_URL = "http://apilayer.net/api/",
				ENDPOINT = "live";

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
      Files.writeString(Paths.get("src/main/resources/lastUpdatedValues.json"), payload);
			log.info("Currency rates successfully fetched . . . \nstored in lastUpdatedValues.json");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// sendLiveRequest() function is created to request and retrieve the data
	public static Content storeLiveRequest(){

		try {
			var payload = Request.get(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY)
					.execute().returnContent();
			System.out.println("fetched successfully");
			return payload;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("error in API request");
		return null;
	}


	// sendLiveRequest() function is executed
	public static void main(String...args) {
		sendLiveRequest();
	}

}
