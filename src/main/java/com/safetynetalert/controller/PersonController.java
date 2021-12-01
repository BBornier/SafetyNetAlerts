package com.safetynetalert.controller;

import java.util.Date;
import java.util.Objects;
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

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * Create - Add a new person
	 * 
	 * @param person An object person
	 * @return The person object saved
	 */
	@PostMapping("/person")
	public Person create(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	/**
	 * Read - Get one person
	 * 
	 * @param id The id of the person
	 * @return A Person object full filled
	 */
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") final Long id) {
		Optional<Person> person = personService.getPerson(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}

	/**
	 * Read - Get all persons
	 * 
	 * @return - An Iterable object of Person full filled
	 */
	@GetMapping("/person")
	public Iterable<Person> getPersons() {
		return personService.getPersons();
	}

	/**
	 * Update - Update an existing person
	 * 
	 * @param id     - The id of the person to update
	 * @param person - The person object updated
	 * @return
	 */
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable("id") final Long id, @RequestBody Person person) {
		Optional<Person> p = personService.getPerson(id);
		if (p.isPresent()) {
			Person currentPerson = p.get();

			Date birthdate = person.getBirthdate();
			if (birthdate != null) {
				currentPerson.setBirthdate(birthdate);
			}
			String address = person.getAdress();
			if (address != null) {
				currentPerson.setAdress(address);
				;
			}
			String city = person.getCity();
			if (city != null) {
				currentPerson.setCity(city);
				;
			}
			long zipCode = person.getZipCode();
			if (Objects.isNull(zipCode)) { // vérifier un null sur un type primitif. Avec la classe Objects.
				currentPerson.setZipCode(zipCode);
			}

			String phone = person.getPhone();
			if (phone != null) {
				currentPerson.setPhone(phone);
			}

			String email = person.getEmail();
			if (email != null) {
				currentPerson.setEmail(email);
			}

			personService.savePerson(currentPerson);
			return currentPerson;
		} else {
			return null;
		}
	}

	/**
	 * Delete - Delete a person
	 * 
	 * @param id - The id of the person to delete
	 */
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") final Long id) {
		personService.deletePerson(id);
	}

}
