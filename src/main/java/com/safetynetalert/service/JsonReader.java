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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;
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
			
			return json;
		} finally {
			is.close();
		}
	}

	public static List<Person> parseJsonPersonsFromUrl() throws JSONException, IOException {

		JSONObject jsonObject = JsonReader.readJsonFromUrl(
				"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");

		JSONArray jsonArray = jsonObject.getJSONArray("persons");

		List<Person> personList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String firstNamesData = jsonObj.getString("firstName");
			String lastNamesData = jsonObj.getString("lastName");
			String addressData = jsonObj.getString("address");
			String cityData = jsonObj.getString("city");
			Long zipCodeData = jsonObj.getLong("zip");
			String phoneData = jsonObj.getString("phone");
			String emailData = jsonObj.getString("email");

			// Stocker les informations de l'itération dans une variable person.
			Person person = new Person();
			person.setFirstName(firstNamesData);
			person.setLastName(lastNamesData);
			person.setAddress(addressData);
			person.setCity(cityData);
			person.setZipCode(zipCodeData);
			person.setPhone(phoneData);
			person.setEmail(emailData);
			personList.add(person);

			
		}
		return personList;

	}

	public static JSONObject parseJsonFirestationsFromUrl() throws JSONException, IOException {

		JSONObject jsonObject = JsonReader.readJsonFromUrl(
				"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");

		JSONArray jsonArray = jsonObject.getJSONArray("firestations");

		List<Firestation> firestationsList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			
			String adressData = jsonObj.getString("address");
			String stationData = jsonObj.getString("station");

			// Stocker les informations de l'itération dans une variable firestation.
			Firestation firestation = new Firestation();
			firestation.setAddress(adressData);
			firestation.setStation(stationData);
			firestationsList.add(firestation);

		}

		return jsonObject;

	}

	public static List<MedicalRecords> parseJsonMedicalRecordsFromUrl() throws JSONException, IOException {

		JSONObject jsonFromUrl = JsonReader.readJsonFromUrl(
				"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");

		JSONArray jsonArray = jsonFromUrl.getJSONArray("medicalrecords");

		List<MedicalRecords> medicalRecordsList = new ArrayList<>();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			MedicalRecords medicalRecords = new MedicalRecords(); 
			
			List<String> stringList = parseJsonMedicationsFromMedicalRecords(jsonArray);
			List<Medications> medsList = convertStringListToMedicationList(stringList);
			medicalRecords.setMedications(medsList);
			
			//medicalRecords.setAllergies(medsList);
			
			medicalRecordsList.add(medicalRecords);
			
		}

		return medicalRecordsList;

	}

	public static List<String> parseJsonMedicationsFromMedicalRecords(JSONArray jsonArray)
			throws JSONException, IOException {

		List<String> medicationsList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			medicationsList.add(jsonArray.getString(i));

		}
	
		return medicationsList;

	}

	public static List<String> parseJsonAllergiesFromMedicalRecords(JSONArray jsonArray) {

		List<String> allergiesList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			allergiesList.add(jsonArray.getString(i));

		}
		
		return allergiesList;

	}
	
	public static List<Medications> convertStringListToMedicationList(List<String> stringList) {
		
		List<Medications> medicationList = new ArrayList<>();
		
		for (String s : stringList) {
			Medications meds = new Medications();
			meds.setNameAndDosage(s);
			
			medicationList.add(meds);
		}
		
		return medicationList;
		
	}

}