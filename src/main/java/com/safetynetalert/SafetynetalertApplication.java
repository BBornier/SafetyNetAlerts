package com.safetynetalert;

import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.AddressRepository;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordsRepository;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalert.service.JsonReader;

@SpringBootApplication
public class SafetynetalertApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LogManager.getLogger(SafetynetalertApplication.class);
	
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository;
	
	@Autowired
	private FirestationRepository firestationRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertApplication.class, args);
		
		LOGGER.info("Initializing Safety Net Alerts System.");
		
		LOGGER.log(Level.INFO, "Logs with Log4j2, don't be afraid of hackers.");
		
        LOGGER.debug("Exemple of Debug level log message.");
        
        LOGGER.error("Exemple of Error level log message.");
        
    	LOGGER.trace("Exiting application.");
	
	}

	@Override
	public void run(String... args) throws Exception {

			//Créer une liste d'adresse ICI !
			List<Address> addressList = JsonReader.parseJsonPersonsFromUrl();
			add
		
			List<Person> personList = JsonReader.parseJsonPersonsFromUrl();
			personRepository.saveAll(personList);
			
			/*List<Firestation> fireStList = JsonReader.parseJsonFirestationsFromUrl();
			firestationRepository.saveAll(fireStList);*/
			
			List<MedicalRecords> medsRec = JsonReader.parseJsonMedicalRecordsFromUrl();
			medicalRecordsRepository.saveAll(medsRec);

	}

}
