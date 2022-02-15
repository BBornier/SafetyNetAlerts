package com.safetynetalert.urls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.dto.PersonDTO;

	
@Service
public class PersonEmailService {
	
	@Autowired
	private PersonRepository personRepository;

	
	public List<String> findEmailsByPersonsCity(String city) {
		List<Person> allPersons = personRepository.findAllByCity(city);
		List<String> byString = new ArrayList<>();
		for(Person perso : allPersons) {
			byString.add(perso.getEmail());
		}
		return byString;
		
	}

}
