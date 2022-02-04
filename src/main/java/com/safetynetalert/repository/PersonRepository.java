package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByFirstNameAndLastName(String firstName, String lastName);
	
	public Person findByPersonId(Long personId);
	
	public void deleteByFirstNameAndLastName(String firstName, String lastName);
		
}

