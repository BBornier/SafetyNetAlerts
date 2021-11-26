package com.safetynetalert;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.JsonReader;


@SpringBootApplication
public class SafetynetalertApplication implements CommandLineRunner {

	public static void main(String[] args) throws JSONException, IOException, ParseException {
		SpringApplication.run(SafetynetalertApplication.class, args);

		// parser objet Json au level 1.
		JSONObject jsonObject = JsonReader.readJsonFromUrl(
				"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"); // Fonctionne !

		System.out.println(jsonObject.get("persons"));
		System.out.println(jsonObject.get("firestations"));
		System.out.println(jsonObject.get("medicalrecords"));

		// parser objet Json avec une méthode sans JSONParser pour afficher noms et prénoms au level 2 du Json.
		JSONObject jsonObject2 = JsonReader.parseJsonPersonsFromUrl(); // Fonctionne !
		JSONObject jsonObject3 = JsonReader.parseJsonFirestationsFromUrl(); // Fonctionne !
		JSONObject jsonObject4 = JsonReader.parseJsonMedicalRecordsFromUrl();
		// JSONObject jsonGet = (JSONObject) jsonObject2.get("persons"); // Ecrit avec Raph. à mettre dans la couche controller (?) StackTrace : org.json.JSONArray and org.json.JSONObject are in unnamed module of loader 'app'

		Person person = new Person();
		person.setId(1); // set les paramètres
		person.setFirstName(jsonObject2.getString("firstName")); // Ecriture avec Julien. Set un objet Json en paramètre pour un objet Java. StackTrace : JSONObject["firstName"] not found.
		// person.setFirstName((String) jsonObject2.get("firstName")); // Ecriture avec Raph. Correspondance entre objet java et JsonObject.

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Exemple de manipulation de JSON avec SpringBoot");

	}

}
