package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetynetalert.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByFirstNameAndLastName(String firstName, String lastName);
	
	public Person findByPersonId(Long personId);
		
}

