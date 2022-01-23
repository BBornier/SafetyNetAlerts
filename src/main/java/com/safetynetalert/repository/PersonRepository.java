package com.safetynetalert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Person;

@Repository
	public interface PersonRepository extends CrudRepository<Person, Long>{

	}

