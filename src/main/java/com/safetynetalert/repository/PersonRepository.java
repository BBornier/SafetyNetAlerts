package com.safetynetalert.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Person;
import com.safetynetalerts.dto.PersonDTO;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	Person findByPersonId(Long personId);
	
	void deleteByFirstNameAndLastName(String firstName, String lastName);
		
	List<Person> findAllByFirstNameAndLastName(String firstName, String lastName); 
	
	List<PersonDTO> findAllByAddress(String city);
	
	@Query(value = "SELECT PERSON.email from PERSON JOIN PERSON_ADDRESS ON PERSON_ADDRESS.PERSON_PERSON_ID=PERSON.PERSON_ID WHERE city=?1", nativeQuery = true) //?1 premier paramètre soit city.
	List<String> findEmailByCity(String city);
	
	/*@Entity
	public class Product extends AbstractEntity {
	...

	@ElementCollection
	    private Map<String, String> attributes = new HashMap<String, String>();
	...
	}
	The repository query method that allows querying for arbitrary product attributes:

	@Query("select p from Product p where p.attributes[?1] = ?2")
	List<Product> findByAttributeAndValue(String attribute, String value);*/
	
	/*@Query("select p from Product p where p.attributes[?1] = ?2")
	List<Product> findByAttributeAndValue(String attribute, String value);
	
	SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
	FROM Orders
	INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;*/

	/*PERSON_ADDRESS  PERSON_PERSON_ID*/
	
}

