package com.safetynetalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.Person;
import com.safetynetalert.service.PersonServiceImpl;
import com.safetynetalerts.dto.PersonDTO;

@RestController
public class PersonController {

	@Autowired
	private PersonServiceImpl personService;

	public PersonController(PersonServiceImpl personService) {
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
	public PersonDTO names(@PathVariable String firstName, @PathVariable String lastName) {
		 return personService.findPersonByHisNamesAndShowHisProfile(firstName, lastName);
	}
	
	@PostMapping("/newPerson")
	public String create(@RequestBody Person newPerson) {
		personService.addNewPersonToTheList(newPerson);
		return "A new kid in Town, congrats ! or a new stranger... be carefull.";
	}
	
	@PutMapping("/updatePerson/{id}")
	public String updatePerson(@RequestBody Person update, @PathVariable Long id) {
		personService.updatePersonById(update, id);
		return "This fellow leveled up !";
	}
	
	
	@DeleteMapping("/person/{firstName}/{lastName}")
    public String deleteByNames(@PathVariable String firstName, @PathVariable String lastName) {
		personService.deleteOnePerson(firstName, lastName);
        return "Sorry for your loss.";
	}
	
}
