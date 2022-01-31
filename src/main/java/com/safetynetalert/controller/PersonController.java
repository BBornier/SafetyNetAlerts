package com.safetynetalert.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonService;
import com.safetynetalerts.dto.PersonDTO;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/persons")
	public List<PersonDTO> findAllPersonsInDataBase() {
		return personService.returnAllPersonsInDataBase();
	}
	
	@GetMapping("/person/{id}")
	public PersonDTO findOnePersonById(@PathVariable Long id) {
		return personService.returnOnePersonWithHisId(id);
	}
	
	
	
	@GetMapping("/person/{firstName}/{lastName}")
	public Person name(@PathVariable String firstName, @PathVariable String lastName) {
		return personService.findPersonByHisName(firstName, lastName);
	}
	
	@PostMapping("/person")
	public Person create(@RequestBody Person newPerson) {
		return personService.createNewPerson(newPerson);
	}
	
	@PutMapping("/updatePerson/{id}")
	public Person updatePerson(@RequestBody Person update, @PathVariable Long id) {
		return personService.updatePersonById(update, id);
	}
	
	@DeleteMapping("/person/{id}")
	public String deleteById(@PathVariable Long id) {
		personService.deleteThisPerson(id);
		return "Sorry for your loss.";
	}
	
}
