package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Person;

import net.bytebuddy.asm.Advice.Return;

@Repository
	public interface PersonRepository extends JpaRepository<Person, Long>{

	public Person findByFirstNameAndLastName(String firstName, String LastName);
		
	}

