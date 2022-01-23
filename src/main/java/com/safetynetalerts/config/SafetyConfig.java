package com.safetynetalerts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Configuration
public class SafetyConfig {

	/*@Autowired
	PersonRepository personRepository;
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			
			// parser objet Json au level 1.
			JSONObject jsonObject = JsonReader.readJsonFromUrl(
					"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"); // Fonctionne !

			System.out.println(jsonObject.get("persons"));
			System.out.println(jsonObject.get("firestations"));
			System.out.println(jsonObject.get("medicalrecords"));

			//parser objet Json avec une méthode sans JSONParser pour afficher noms et prénoms au level -1 du Json.
			JSONObject jsonObject3 = JsonReader.parseJsonFirestationsFromUrl(); // Fonctionne !
			JSONObject jsonObject4 = JsonReader.parseJsonMedicalRecordsFromUrl(); // ne fonctionne qu'au niveau 0 pas au niveau -1.
			
			Person person = new Person();
			person.setAddress("16, impasse Montrat");
			person.setCity("Villechenève");
			person.setZipCode(69770);
			personRepository.save(person);
			
			JsonReader js = new JsonReader();
			List<Person> personList = js.parseJsonPersonsFromUrl();
			
			personRepository.saveAll(personList);
			
		
		};
		
	}*/

}
