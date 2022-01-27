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
import com.safetynetalert.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	//Post-Put-Delete + Get

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/persons")
	public List<Person> all(){	
		return personService.findAllPersonsInDataBase();
	}
	
	@GetMapping("/person/{id}")
	public Person solo(@PathVariable Long id) {
		return personService.findPersonByHisId(id);
	}
	
	@GetMapping("/person/{fisrstName}, {lastName}")
	public Person name(@PathVariable String firstName, String lastName)	{
		return personService.findPersonByHisName(firstName, lastName);
	}
	
	@PostMapping("/person")
	public Person save(@RequestBody Person newPerson) {
		return personService.createNewPerson(newPerson);
	}
	
	@PutMapping("/updatePerson/{id}")
	public Person updatePerson(@RequestBody Person update, @PathVariable Long id) {
		return personService.updatePersonById(update, id);
	}
	
	@DeleteMapping("/person")
	public String deleteById() {
		personService.deleteThisPerson();
		return "Sorry for your loss.";
	}
	
	/*
	 * @PostMapping("/person") public Person create(@RequestBody Person person) {
	 * return personService.savePerson(person); }
	 * 
	 * 
	 * @GetMapping("/person/{id}") public Person getPerson(@PathVariable("id") final
	 * Long id) { Optional<Person> person = personService.getPerson(id); if
	 * (person.isPresent()) { return person.get(); } else { return null; } }
	 * 
	 * 
	 * @GetMapping("/person") public Iterable<Person> getPersons() { return
	 * personService.getPersons(); }
	 * 
	 * 
	 * @PutMapping("/person/{id}") public Person updatePerson(@PathVariable("id")
	 * final Long id, @RequestBody Person person) { Optional<Person> p =
	 * personService.getPerson(id); if (p.isPresent()) { Person currentPerson =
	 * p.get();
	 * 
	 * Set<Address> address = person.getAddress(); if (address != null) {
	 * currentPerson.setAddress(address); }
	 * 
	 * String phone = person.getPhoneNumber(); if (phone != null) {
	 * currentPerson.setPhoneNumber(phone); }
	 * 
	 * String email = person.getEmail(); if (email != null) {
	 * currentPerson.setEmail(email); }
	 * 
	 * personService.savePerson(currentPerson); return currentPerson; } else {
	 * return null; } }
	 * 
	 * 
	 * @DeleteMapping("/person/{id}") public void deletePerson(@PathVariable("id")
	 * final Long id) { personService.deletePerson(id); }
	 */
}
