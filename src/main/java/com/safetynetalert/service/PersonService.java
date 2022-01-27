package com.safetynetalert.service;

import static org.hamcrest.CoreMatchers.anyOf;

import java.util.List;
import java.util.Optional;

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

	public Person updatePersonById(Person updateThePersonPlease, Long id) {
		Person anyPerson = personRepository.findById(id).get();
		anyPerson.setPhoneNumber(updateThePersonPlease.getPhoneNumber());
		anyPerson.setEmail(updateThePersonPlease.getEmail());
		anyPerson.setAddress(updateThePersonPlease.getAddress());
		
		return personRepository.save(anyPerson);
	}

	public void deleteThisPerson(Long id) {
		personRepository.deleteById(id);
	}
	
}
