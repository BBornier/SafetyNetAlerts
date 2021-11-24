package com.safetynetalert.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			System.out.println("\nJSON data in string format from JsonReader2 class and persons data without parsing.");
			return json;
		} finally {
			is.close();
		}
	}
	
	public static JSONObject parseJsonNamesFromUrl () throws JSONException, IOException, ParseException {
		
		JSONObject jsonObject = JsonReader.readJsonFromUrl("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");
		
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("persons");
		
		for (int i = 0; i < jsonArray1.length(); i++) {
			JSONObject jsonObj1 = (JSONObject) jsonArray1.get(i);
			String firstNamesData = (String) jsonObj1.get("firstName");
			System.out.print(firstNamesData);
			System.out.print(" ");
			String lastNamesData = (String) jsonObj1.get("lastName");
			System.out.print(lastNamesData);
			System.out.println("\n");
		}
		
		return jsonObject;
		
	}

}
