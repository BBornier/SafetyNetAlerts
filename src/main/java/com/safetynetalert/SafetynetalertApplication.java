package com.safetynetalert;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynetalert.model.Person;
import com.safetynetalert.repository.JsonReaderTest;
import com.safetynetalert.repository.JsonReader;

@SpringBootApplication
public class SafetynetalertApplication implements CommandLineRunner {

	public static void main(String[] args) throws JSONException, IOException, ParseException {
		SpringApplication.run(SafetynetalertApplication.class, args);
		
		// méthode put pour définir une clé et une valeur à un objet Json.
		JSONObject myObject = new JSONObject();
		myObject.put("name", "Benoit");
		myObject.put("last_name", "Bornier");
		
		myObject.put("age", 40);
		myObject.put("bank_account_balance", 100000.1);
		myObject.put("is_developper", true);
		
		double[] myList = {1.9, 2.9, 3.4, 3.5};
		myObject.put("number_list", myList);
		
		JSONObject subData = new JSONObject();
		myObject.put("extra_data", subData);
		
		System.out.println(myObject);
		
		//Convertir String en objet Json. Get prend la clé et print affichera la valeur.
		JSONObject myJson = new JSONObject("{ \"number_list\": [ 1.9, 2.9, 3.4, 3.5 ], \"extra_data\": {}, \"name\": \"Benoit\", \"last_name\": \"Bornier\", \"bank_account_balance\": 100000.1, \"age\": 40, \"is_developer\": true }");
		System.out.println(myJson.get("name")); // Benoit
		System.out.println(myJson.get("age")); // 40
		
		
		//afficher objet Json à partir d'une URL
		JsonReaderTest js = new JsonReaderTest(); 
		System.out.println(js.getJSonObjectFromUrl("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"));
		
		// parser objet Json au level 1.
		JSONObject jsonObject = JsonReader.readJsonFromUrl("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"); // Fonctionne !
		
		System.out.println(jsonObject.get("persons"));
		System.out.println(jsonObject.get("firestations"));
		System.out.println(jsonObject.get("medicalrecords"));
		
		// parser objet Json avec une méthode sans JSONParser pour afficher noms et prénoms au level 2 du Json.
		JSONObject jsonObject2 = JsonReader.parseJsonNamesFromUrl(); // Fonctionne !
		//JSONObject jsonGet = (JSONObject) jsonObject2.get("persons"); // Ecrit avec Raph. à mettre dans la couche controller (?) StackTrace : org.json.JSONArray and org.json.JSONObject are in unnamed module of loader 'app'
		
		Person person = new Person();
		
		person.setId(1); // set les paramètres
		person.setFirstName(jsonObject2.getString("firstName")); // Ecriture avec Julien. Set un objet Json en paramètre pour un objet Java. StackTrace : JSONObject["firstName"] not found.
		//person.setFirstName((String) jsonObject2.get("firstName")); // Ecriture avec Raph. Correspondance entre objet java et JsonObject.
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Exemple de manipulation de JSON avec SpringBoot");
		
	}

}
