package com.safetynetalert.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Person;
import com.safetynetalerts.dto.FirePersonDTO;
import com.safetynetalerts.dto.PersonDTO;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	Person findByPersonId(Long personId);
	
	void deleteByFirstNameAndLastName(String firstName, String lastName);
		
	List<Person> findAllByFirstNameAndLastName(String firstName, String lastName); 
	
	//List<Person> findListOfPersonByAddress(Address address);
	List<Person> findListOfPersonByAddress(String address);
	
	List<Person> findPersonByAddress(String address);
	
	List<PersonDTO> findAllByAddress(String city);
	
	//@Query(value = "SELECT PERSON.EMAIL from PERSON JOIN PERSON_ADDRESS ON PERSON_ADDRESS.PERSON_PERSON_ID=PERSON.PERSON_ID WHERE city=?1", nativeQuery = true) //?1 premier paramètre soit city.
	List<String> findEmailByCity(String city);
	
	
	
}

