package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	Person findByPersonId(Long personId);
	
	void deleteByFirstNameAndLastName(String firstName, String lastName);
		
}

