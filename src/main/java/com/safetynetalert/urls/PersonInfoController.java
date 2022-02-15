package com.safetynetalert.urls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.MedicalRecordsService;
import com.safetynetalert.service.PersonService;
import com.safetynetalerts.dto.MedicalRecordsDTO;
import com.safetynetalerts.dto.PersonDTO;
import com.safetynetalerts.dto.PersonInfoDTO;


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
	public List<Person> findPersonByHisNames(@RequestParam String firstName, @RequestParam String lastName) {
		return personService.returnAnyPersonByHisInNames(firstName, lastName);
		
	}

}
