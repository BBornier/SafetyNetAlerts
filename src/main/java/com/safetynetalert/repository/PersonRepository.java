package com.safetynetalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetynetalert.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByFirstNameAndLastName(String firstName, String lastName);

	public List<Person> findItById(Long id);
		
}

