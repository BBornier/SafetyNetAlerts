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

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
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

			Person person = new Person();
			person.setFirstName(firstNamesData);
			person.setLastName(lastNamesData);
			person.setAddress(addressData); // Ecrire une méthode de conversion String adressData en un objet address.
			person.setCity(cityData);
			person.setZipCode(zipCodeData);
			person.setPhone(phoneData);
			person.setEmail(emailData);
			personList.add(person);

			
		}
		return personList;

	}

	public static List<Firestation> parseJsonFirestationsFromUrl() throws JSONException, IOException {

		// JSONObject à qui je passe la méthode readJsonFromUrl.
		JSONObject jsonObject = JsonReader.readJsonFromUrl(
				"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");

		// Je converti le JSONObject en JSONArray et je prends les informations dans firestations.
		JSONArray jsonArray = jsonObject.getJSONArray("firestations");
		
		// Je crée une instance de List de Firestation.
		List<Firestation> firestationsList = new ArrayList<>();

		// J'itère dans tout le JSONArray, et je prends chaque valeur de chaque index.  
		// Je converti le JSONArray en JSONObject et je prends chaque objet à chaque itération.
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
	 
		// A chaque itération je prends la valeur de chaque adresse et de chaque caserne.
		// Je converti mon JSONObject qui prend à chaque tour les valeurs des adresses et des casernes, en String. Je stocke dans mes objets String les valeurs.
			String addressData = jsonObj.getString("address");
			String stationNumberData = jsonObj.getString("station");
			
		// Je dois ensuite convertir mon String en objet Address !

		// Je crée un objet firestation, je lui paramètre les informations contenues dans les objets adressData et sattionNumberData.
		// J'ajoute enfin à ma firesationList toutes les informations contenues dans l'objet firestation. Et je retourne comme valeur de la méthode la firestationList.
			Firestation firestation = new Firestation();
			firestation.setAddress(addressData); // Ecrire une méthode de conversion String adressData en un objet address.
			firestation.setStationNumber(stationNumberData); // Ecrire une méthode de conversion String stationNumberData en un objet stationNumber.
			firestationsList.add(firestation);

		}

		return firestationsList;

	}

	public static List<MedicalRecords> parseJsonMedicalRecordsFromUrl() throws JSONException, IOException {

		JSONObject jsonFromUrl = JsonReader.readJsonFromUrl(
				"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json");

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
	
	public static String convertStringToObject() {
		
		
		
		return null;
		
	}

}