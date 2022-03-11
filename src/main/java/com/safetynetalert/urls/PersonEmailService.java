package com.safetynetalert.urls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.dto.AddressDTO;
import com.safetynetalerts.dto.PersonDTO;

	
@Service
public class PersonEmailService {
	
	@Autowired
	private PersonRepository personRepository;

	
	public List<String> getEmail(String city) {
		return personRepository.findEmailByCity(city);
		
		
		
	}
	
	/*public List<String> returnEmailsByPersonsCity(String city) {
		List<PersonDTO> allPersons = personRepository.findAllByAddress(city);
		List<AddressDTO> cities = new ArrayList<>();
		
		for(PersonDTO perso : allPersons) {
			AddressDTO addressDto = new AddressDTO();
			addressDto.setCity(perso.getEmail());
			
		cities.add(addressDto);
			
		}
		return cities;
		
	}*/
	
	/*public List<String> returnAllPersonsWithTheirEmail(String email) {
		List<Person> allPersons = personRepository.findAll();
		List<PersonDTO> allOfThem = new ArrayList<>();
		for(Person perso : allPersons) {
			PersonDTO personDto = new PersonDTO();
			perso.getAddress();
			perso.getEmail();
			perso.getFirstName();
			perso.getLastName();
			
			allOfThem.add(personDto);
		}
			return allOfThem;
	}*/

}
