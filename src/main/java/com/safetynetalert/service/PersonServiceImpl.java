package com.safetynetalert.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordsRepository;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.config.DateHelper;
import com.safetynetalerts.dto.FirePersonDTO;
import com.safetynetalerts.dto.FirestationsDTO;
import com.safetynetalerts.dto.PersonDTO;
import com.safetynetalerts.dto.PersonInfoDTO;

@Service
@Transactional
public class PersonServiceImpl implements IPersonEmail, IPersonInfo, IFirePersonAddress {

	@Autowired
	private PersonRepository personRepository; 
	
	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository;
	
	@Autowired
	private BirthdayCalculationService birthdayCalculationService;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<PersonDTO> returnAllPersonsInDataBase() {
		List<Person> allPersons = personRepository.findAll();
		List<PersonDTO> allOfThem = new ArrayList<>();
		for(Person perso : allPersons) {
			PersonDTO personDto = new PersonDTO(perso.getPersonId(), 
					perso.getFirstName(), 
					perso.getLastName(), 
					perso.getPhoneNumber(), 
					perso.getEmail(), 
					perso.getAddress());
			
			allOfThem.add(personDto);
		}
			return allOfThem;
	}
	
	
	public Person findPersonByHisName(String firstName, String lastName) {
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public PersonDTO findPersonByHisNamesAndShowHisProfile(String firstName, String lastName) {
		Person personNames = personRepository.findByFirstNameAndLastName(firstName, lastName);
		PersonDTO hisProfile = new PersonDTO(personNames.getPersonId(), 
				personNames.getFirstName(), 
				personNames.getLastName(), 
				personNames.getPhoneNumber(), 
				personNames.getEmail(), 
				personNames.getAddress());
		
		return hisProfile; 
	}
	
	
	public PersonDTO exempleUtilisationAvecSettersEtGetters(String firstName, String lastName) {
		Person person = personRepository.findByFirstNameAndLastName(firstName, lastName);
		PersonDTO dTo = new PersonDTO();
			dTo.setFirstName(person.getFirstName());
			dTo.setLastName(person.getLastName());
			dTo.setPhoneNumber(person.getPhoneNumber());
			dTo.setEmail(person.getEmail());
		
		return dTo;
	}
	
	public PersonDTO returnOnePersonWithHisId(Long id) {
		Person person = personRepository.findByPersonId(id);
		PersonDTO oneOfThem = new PersonDTO(person.getPersonId(), 
				person.getFirstName(), 
				person.getLastName(), 
				person.getPhoneNumber(), 
				person.getEmail(), 
				person.getAddress());
		
		return oneOfThem;
	}
	
	
	public Person addNewPersonToTheList(Person strangerInTown) {
		return personRepository.save(strangerInTown);
	}
	
	
	public Person updatePersonById(Person updateThePersonPlease, Long id) {
		Person anyPerson = personRepository.findById(id).get();
			anyPerson.setPhoneNumber(updateThePersonPlease.getPhoneNumber());
			anyPerson.setEmail(updateThePersonPlease.getEmail());
			anyPerson.setAddress(updateThePersonPlease.getAddress());
		
		return personRepository.save(anyPerson);
	}
	
	
	public void deleteOnePerson(String firstName, String lastName) {
		personRepository.deleteByFirstNameAndLastName(firstName, lastName);
		
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> returnAnyPersonByHisInNames(String firstName, String lastName) {
		return personRepository.findAllByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<String> getEmail(String city) {
		return personRepository.findEmailByCity(city);
	}

	
	@Override
	public PersonInfoDTO findPersonInfos(String firstName, String lastName) {
		Person person = personRepository.findByFirstNameAndLastName(firstName, lastName);
		String birthdate = person.getMedicalRecords().getBirthdate();
		LocalDate date = DateHelper.convertStringtoDate(birthdate, "MM/dd/yyyy");
		int age = birthdayCalculationService.pleaseCalculateMyAge(date);
		
		PersonInfoDTO personInfos = new PersonInfoDTO(person.getFirstName(), 
				person.getLastName(),
				age, 
				person.getEmail(), 
				person.getAddress(),
				person.getMedicalRecords().getAllergies(),
				person.getMedicalRecords().getMedications());
		
		return personInfos;
	}

	@Override
	public List<FirePersonDTO> findByAddress(String address) {
		List<Person> person = personRepository.findPersonByAddress(address);
		List<MedicalRecords> medicalR = medicalRecordsRepository.findAll();
		
		List<FirePersonDTO> fireAlertDTO = new ArrayList<>();
		for(Person p : person) {
				
				String birthdate = p.getMedicalRecords().getBirthdate();
				LocalDate date = DateHelper.convertStringtoDate(birthdate, "MM/dd/yyyy");
				int age = birthdayCalculationService.pleaseCalculateMyAge(date);
				
			FirePersonDTO firePersonDTO = new FirePersonDTO(p.getFirstName(),
					p.getLastName(),
					p.getPhoneNumber(),
					age,
					p.getMedicalRecords().getAllergies(),
					p.getMedicalRecords().getMedications());
					fireAlertDTO.add(firePersonDTO);
			
			}
		return fireAlertDTO;
	}

}
	

