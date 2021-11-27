package com.safetynetalert.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Person;

@Service
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
			
			Person person = new Person();
			person.setFirstName(firstNamesData);
			
			
			
		}
		List<Person> persons = new ArrayList<>(); 
		persons.add(null);
		
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

/*"medicalrecords": [
                   { "firstName":"John", "lastName":"Boyd", "birthdate":"03/06/1984", "medications":["aznol:350mg", "hydrapermazol:100mg"], "allergies":["nillacilan"] },
                   { "firstName":"Jacob", "lastName":"Boyd", "birthdate":"03/06/1989", "medications":["pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"], "allergies":[] },
                   { "firstName":"Tenley", "lastName":"Boyd", "birthdate":"02/18/2012", "medications":[], "allergies":["peanut"] },
                   { "firstName":"Roger", "lastName":"Boyd", "birthdate":"09/06/2017", "medications":[], "allergies":[] },
                   { "firstName":"Felicia", "lastName":"Boyd","birthdate":"01/08/1986", "medications":["tetracyclaz:650mg"], "allergies":["xilliathal"] },
                   { "firstName":"Jonanathan", "lastName":"Marrack", "birthdate":"01/03/1989", "medications":[], "allergies":[] },
                   { "firstName":"Tessa", "lastName":"Carman", "birthdate":"02/18/2012", "medications":[], "allergies":[] },
                   { "firstName":"Peter", "lastName":"Duncan", "birthdate":"09/06/2000", "medications":[], "allergies":["shellfish"] },
                   { "firstName":"Foster", "lastName":"Shepard", "birthdate":"01/08/1980", "medications":[], "allergies":[] },
                   { "firstName":"Tony", "lastName":"Cooper", "birthdate":"03/06/1994", "medications":["hydrapermazol:300mg", "dodoxadin:30mg"], "allergies":["shellfish"] },
                   { "firstName":"Lily", "lastName":"Cooper", "birthdate":"03/06/1994", "medications":[], "allergies":[] },
                   { "firstName":"Sophia", "lastName":"Zemicks", "birthdate":"03/06/1988", "medications":["aznol:60mg", "hydrapermazol:900mg", "pharmacol:5000mg", "terazine:500mg"], "allergies":["peanut", "shellfish", "aznol"] },
                   { "firstName":"Warren", "lastName":"Zemicks", "birthdate":"03/06/1985", "medications":[], "allergies":[] },
                   { "firstName":"Zach", "lastName":"Zemicks", "birthdate":"03/06/2017", "medications":[], "allergies":[] },
                   { "firstName":"Reginold", "lastName":"Walker", "birthdate":"08/30/1979", "medications":["thradox:700mg"], "allergies":["illisoxian"] },
                   { "firstName":"Jamie", "lastName":"Peters", "birthdate":"03/06/1982", "medications":[], "allergies":[] },
                   { "firstName":"Ron", "lastName":"Peters", "birthdate":"04/06/1965", "medications":[], "allergies":[] },
                   { "firstName":"Allison", "lastName":"Boyd", "birthdate":"03/15/1965", "medications":["aznol:200mg"], "allergies":["nillacilan"] },
                   { "firstName":"Brian", "lastName":"Stelzer", "birthdate":"12/06/1975", "medications":["ibupurin:200mg", "hydrapermazol:400mg"], "allergies":["nillacilan"] },
                   { "firstName":"Shawna", "lastName":"Stelzer", "birthdate":"07/08/1980", "medications":[], "allergies":[] },
                   { "firstName":"Kendrik", "lastName":"Stelzer", "birthdate":"03/06/2014", "medications":["noxidian:100mg", "pharmacol:2500mg"], "allergies":[] },
                   { "firstName":"Clive", "lastName":"Ferguson", "birthdate":"03/06/1994", "medications":[], "allergies":[] },
                   { "firstName":"Eric", "lastName":"Cadigan", "birthdate":"08/06/1945", "medications":["tradoxidine:400mg"], "allergies":[] }
                   ] */
