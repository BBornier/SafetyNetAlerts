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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;
import com.safetynetalert.model.Person;

@Service
public class JsonHelper {
	private static final Logger LOGGER = LogManager.getLogger(JsonHelper.class);
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private FirestationService firestationService;
	
	public static final String URL = "https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json";

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

	public void parseJsonPersonsFromUrl() throws JSONException, IOException {

		JSONObject jsonObject = JsonHelper.readJsonFromUrl(JsonHelper.URL);

		JSONArray jsonArray = jsonObject.getJSONArray("persons");

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			
			Person person = new Person(jsonObj.getString("firstName"), jsonObj.getString("lastName"), jsonObj.getString("phone"), jsonObj.getString("email"));
			Address address = new Address(jsonObj.getString("address"), jsonObj.getString("zip"), jsonObj.getString("city"));
			
			person.getAddress().add(address);
			LOGGER.info("person before: " + person);
			
			person = personService.savePerson(person);
			
			LOGGER.info("person after: " + person);
			
		}

	}

	public void parseJsonFirestationsFromUrl() throws JSONException, IOException {

		JSONObject jsonObject = JsonHelper.readJsonFromUrl(JsonHelper.URL);
		JSONArray jsonArray = jsonObject.getJSONArray("firestations");

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			
			Firestation firestation = new Firestation(jsonObj.getString("station"));
			Address address = new Address(jsonObj.getString("address"),jsonObj.getString("zip"), jsonObj.getString("city"));
			
			firestation.getAddress().add(address);
			LOGGER.info("firestation before: " + firestation);
			
			firestationService.saveFirestation(firestation);
			LOGGER.info("firestation after: " + firestation);
		}

	}

	public static List<MedicalRecords> parseJsonMedicalRecordsFromUrl() throws JSONException, IOException {

		JSONObject jsonFromUrl = JsonHelper.readJsonFromUrl(JsonHelper.URL);
		JSONArray jsonArray = jsonFromUrl.getJSONArray("medicalrecords");

		List<MedicalRecords> medicalRecordsList = new ArrayList<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			MedicalRecords medicalRecords = new MedicalRecords();

			List<String> stringMedicationsList = parseJsonMedicationsFromMedicalRecords(jsonArray);
			List<Medications> medsList = convertStringListToMedicationJavaList(stringMedicationsList);
			medicalRecords.setMedications(medsList);
			medicalRecordsList.add(medicalRecords);

			List<String> stringAllergiesList = parseJsonAllergiesFromMedicalRecords(jsonArray);
			List<Allergies> allergList = convertStringListToAllergiesJavaList(stringAllergiesList);
			medicalRecords.setAllergies(allergList);
			medicalRecordsList.add(medicalRecords);

		}

		return medicalRecordsList;

	}

	public static List<String> parseJsonMedicationsFromMedicalRecords(JSONArray jsonArray)
			throws JSONException, IOException {

		List<String> medicationsListParsed = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			medicationsListParsed.add(jsonArray.getString(i));
		}

		return medicationsListParsed;
	}

	public static List<String> parseJsonAllergiesFromMedicalRecords(JSONArray jsonArray) {

		List<String> allergiesListParsed = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			allergiesListParsed.add(jsonArray.getString(i));
		}

		return allergiesListParsed;
	}

	public static List<Medications> convertStringListToMedicationJavaList(List<String> stringList) {

		List<Medications> medicationList = new ArrayList<>();

		for (String s : stringList) {
			Medications meds = new Medications();
			meds.setNameAndDosage(s);

			medicationList.add(meds);
		}

		return medicationList;
	}

	public static List<Allergies> convertStringListToAllergiesJavaList(List<String> stringList) {

		List<Allergies> allergiesList = new ArrayList<>();

		for (String s : stringList) {
			Allergies allergies = new Allergies();
			allergies.setName(s);

			allergiesList.add(allergies);

		}

		return allergiesList;
	}

}