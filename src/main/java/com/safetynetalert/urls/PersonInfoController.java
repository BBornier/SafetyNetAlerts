package com.safetynetalert.urls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.MedicalRecordsService;
import com.safetynetalert.service.PersonService;
import com.safetynetalerts.dto.MedicalRecordsDTO;


/*http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
Cette url doit retourner le nom, l'adresse, l'âge, l'adresse mail et les antécédents médicaux (médicaments,
posologie, allergies) de chaque habitant. Si plusieurs personnes portent le même nom, elles doivent
toutes apparaître.
*/

@RestController
public class PersonInfoController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MedicalRecordsService medicalRecordsService;
	
	@GetMapping("/personInfo")
	public PersonInfoDTO getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
		PersonInfoDTO personInfoDTO = new PersonInfoDTO();
		
		Person person = personService.findPersonByHisName(firstName, lastName);
		
		MedicalRecordsDTO medicalRecords = medicalRecordsService.getMedicalRecordsByUserId(person.getPersonId());
		
		personInfoDTO.setName(person.getLastName());
		personInfoDTO.setAddress(person.getAddress());
		personInfoDTO.setMail(person.getEmail());
		personInfoDTO.setAllergies(medicalRecords.getAllergies());
		personInfoDTO.setMedications(medicalRecords.getMedications());
		
		return personInfoDTO;
		
	}

}
