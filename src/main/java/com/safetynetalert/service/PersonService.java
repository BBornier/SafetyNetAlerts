package com.safetynetalert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository; 
	
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAllPersonsInDataBase() {
		return personRepository.findAll();
	}
	
	public Person findPersonByHisId(final Long id) {
		return personRepository.findById(id).get();
	}
	
	public Person findPersonByHisName(String firstName, String lastName) {
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public Person createNewPerson(Person newPerson) {
		return personRepository.save(newPerson);
	}

	public Person updatePersonById(Person updateThePersonPlease, Long idFix) {
		Person anyPerson = personRepository.findById(idFix).get();
		anyPerson.setPhoneNumber(updateThePersonPlease.getPhoneNumber());
		anyPerson.setEmail(updateThePersonPlease.getEmail());
		anyPerson.setAddress(updateThePersonPlease.getAddress());
		
		return personRepository.save(anyPerson);
	}

	public void deleteThisPerson() {
		personRepository.deleteAll();
		
	}
	
	/*
	 * public Optional<Person> getPerson(final Long id) { return
	 * personRepository.findById(id); }
	 * 
	 * public Iterable<Person> getPersons() { return personRepository.findAll(); }
	 * 
	 * public void deletePerson(final Long id) { personRepository.deleteById(id); }
	 * 
	 * public Person savePerson(Person person) { Person savedPerson =
	 * personRepository.save(person); return savedPerson; }
	 * 
	 * public Person findByName(String firstName, String lastName) { return
	 * personRepository.findByFirstNameAndLastName(firstName, lastName);
	 * 
	 * }
	 */
	
}
