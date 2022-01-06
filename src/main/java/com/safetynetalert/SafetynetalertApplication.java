package com.safetynetalert;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordsRepository;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalert.service.JsonReader;

@SpringBootApplication
public class SafetynetalertApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository;

	
	@Autowired
	private FirestationRepository firestationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Exemple de manipulation de JSON avec SpringBoot");

			//parser objet Json au level 1.
			JSONObject jsonObject = JsonReader.readJsonFromUrl(
					"https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"); // Fonctionne !

			System.out.println(jsonObject.get("persons"));
			System.out.println(jsonObject.get("firestations"));
			System.out.println(jsonObject.get("medicalrecords"));

			/*parser objet Json avec une méthode sans JSONParser pour afficher noms et prénoms au level -1 du Json.
			JSONObject jsonObject3 = JsonReader.parseJsonFirestationsFromUrl(); // Fonctionne !
			JSONObject jsonObject4 = JsonReader.parseJsonMedicalRecordsFromUrl(); // ne fonctionne qu'au niveau 0 pas au niveau -1.*/
			
			/*Person person = new Person();
			person.setAddress("16, impasse Montrat");
			person.setCity("Villechenève");
			person.setZipCode(69770);
			personRepository.save(person);*/

			
			List<Person> personList = JsonReader.parseJsonPersonsFromUrl();
			personRepository.saveAll(personList);
			
			/*List<Firestation> fireStList = JsonReader.parseJsonFirestationsFromUrl();
			firestationRepository.saveAll(fireStList);*/
			
			/*List<MedicalRecords> medsRec = JsonReader.parseJsonMedicalRecordsFromUrl();
			medicalRecordsRepository.saveAll(medsRec);*/

	}

}
