package com.safetynetalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Person;
import com.safetynetalerts.dto.PersonDTO;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	Person findByPersonId(Long personId);
	
	void deleteByFirstNameAndLastName(String firstName, String lastName);
		
	List<Person> findAllByFirstNameAndLastName(String firstName, String lastName); 
	
	List<PersonDTO> findByCity(String city);
	
}

