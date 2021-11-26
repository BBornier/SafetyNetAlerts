package Brouillons;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EssaisSurJson implements CommandLineRunner {

	public static void main(String[] args) throws JSONException, IOException, ParseException {
		SpringApplication.run(EssaisSurJson.class, args);

		// méthode put pour définir une clé et une valeur à un objet Json.
		JSONObject myObject = new JSONObject();
		myObject.put("name", "Benoit");
		myObject.put("last_name", "Bornier");

		myObject.put("age", 40);
		myObject.put("bank_account_balance", 100000.1);
		myObject.put("is_developper", true);

		double[] myList = { 1.9, 2.9, 3.4, 3.5 };
		myObject.put("number_list", myList);

		JSONObject subData = new JSONObject();
		myObject.put("extra_data", subData);

		System.out.println(myObject);

		// Convertir String en objet Json. Get prend la clé et print affichera la
		// valeur.
		JSONObject myJson = new JSONObject(
				"{ \"number_list\": [ 1.9, 2.9, 3.4, 3.5 ], \"extra_data\": {}, \"name\": \"Benoit\", \"last_name\": \"Bornier\", \"bank_account_balance\": 100000.1, \"age\": 40, \"is_developer\": true }");
		System.out.println(myJson.get("name")); // Benoit
		System.out.println(myJson.get("age")); // 40

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}