package com.safetynetalert.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
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
			System.out.println("\nJSON data in string format from JsonReader class with persons, firestations and medical records parsing");
			System.out.print("\n");
			return json;
		} finally {
			is.close();
		}
	}
	
	public static JSONObject parseJsonPersonsFromUrl () throws JSONException, IOException {
		
		JSONObject jsonObject = JsonReader.readJsonFromUrl("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");
		
		JSONArray jsonArray = jsonObject.getJSONArray("persons");
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String firstNamesData = jsonObj.getString("firstName");
			System.out.print(firstNamesData);
			System.out.print(" ");
			String lastNamesData = jsonObj.getString("lastName");
			System.out.print(lastNamesData);
			System.out.print(" - ");
			String addressData = jsonObj.getString("address");
			System.out.print(addressData);
			System.out.print(" - ");
			String cityData = jsonObj.getString("city");
			System.out.print(cityData);
			System.out.print(" - ");
			String zipCodeData = jsonObj.getString("zip");
			System.out.print(zipCodeData);
			System.out.print(" - ");
			String phoneData = jsonObj.getString("phone");
			System.out.print(phoneData);
			System.out.print(" - ");
			String emailData = jsonObj.getString("email");
			System.out.print(emailData);
			System.out.print("\n");
		}
		
		return jsonObject;
		
	}
	
public static JSONObject parseJsonFirestationsFromUrl () throws JSONException, IOException {
		
		JSONObject jsonObject = JsonReader.readJsonFromUrl("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");
		
		JSONArray jsonArray = jsonObject.getJSONArray("firestations");
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String adressData = jsonObj.getString("address");
			System.out.print(adressData);
			System.out.print(" - ");
			String stationData = jsonObj.getString("station");
			System.out.print(stationData);
			System.out.print("\n");
		}
		
		return jsonObject;
		
	}

public static JSONObject parseJsonMedicalRecordsFromUrl () throws JSONException, IOException {
	
	JSONObject jsonFromUrl = JsonReader.readJsonFromUrl("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");
	
	JSONArray jsonArray1 = jsonFromUrl.getJSONArray("medicalrecords");
	for (int i = 0; i < jsonArray1.length(); i++) {
		JSONObject jsonObj1 = jsonArray1.getJSONObject(i);
		
		String firstNamesData = jsonObj1.getString("firstName");
		System.out.print(firstNamesData);
		System.out.print(" ");
		String lastNamesData = jsonObj1.getString("lastName");
		System.out.print(lastNamesData);
		System.out.print(" - ");
		String birthData = jsonObj1.getString("birthdate");
		System.out.println(birthData);
		System.out.println("Elements from medications array");
		System.out.println("Medications: " +jsonObj1.get("medications"));
		System.out.println("Elements from allergies array");
		System.out.println("Allergies: " +jsonObj1.get("allergies"));
		System.out.println("\n");
		
		
		 JSONArray jsonArray2 = jsonObj1.getJSONArray("medications");
		for (int j = 0; j < jsonArray2.length(); j++) {
			JSONObject jsonObj2 = jsonArray2.getJSONObject(j);
			
			String medsData = jsonObj2.getString("aznol");
			System.out.println(medsData);
		}
		
	}
	
	return jsonFromUrl;
	
	}

}
