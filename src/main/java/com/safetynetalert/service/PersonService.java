package com.safetynetalert.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.dto.PersonDTO;

@Service
public class PersonService {

	private PersonRepository personRepository; 
	
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<PersonDTO> returnAllPersonsInDataBase() {
		List<Person> allPersons = personRepository.findAll();
		List<PersonDTO> allOfThem = new ArrayList<>();
		
		for(Person perso : allPersons) {
			PersonDTO personDto = new PersonDTO(perso.getFirstName(), perso.getLastName(), perso.getPhoneNumber(), perso.getEmail(), perso.getAddress());
			allOfThem.add(personDto);
		}
			return allOfThem;
	}
	
	public List<PersonDTO> returnPersonByHisId(Long id) {
		List<Person> allPersonsId = personRepository.findItById(id);
		List<PersonDTO> allById = new ArrayList<>();
		
		for(Person persoId : allPersonsId) {
			PersonDTO personIdDto = new PersonDTO(persoId.getPersonId());
					allById.add(personIdDto);
		}
		return allById;
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
