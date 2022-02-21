package com.safetynetalert.urls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
		List<PersonDTO> allPersons = personRepository.findByCity(city);
		List<String> cities = new ArrayList<>();
		for(PersonDTO perso : allPersons) {
			cities.add(city);
		}
		return cities;
		
	}

}
