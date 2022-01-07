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
		
			
			List<Person> personList = JsonReader.parseJsonPersonsFromUrl();
			personRepository.saveAll(personList);
			
			/*List<Firestation> fireStList = JsonReader.parseJsonFirestationsFromUrl();
			firestationRepository.saveAll(fireStList);*/
			
			List<MedicalRecords> medsRec = JsonReader.parseJsonMedicalRecordsFromUrl();
			medicalRecordsRepository.saveAll(medsRec);

	}

}
