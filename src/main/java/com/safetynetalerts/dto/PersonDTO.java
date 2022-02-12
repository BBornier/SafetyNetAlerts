package com.safetynetalerts.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.safetynetalert.converterstodto.MedicalRecordsDTOConverter;
import com.safetynetalert.model.Address;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.service.MedicalRecordsService;

public class PersonDTO {

	/*private MedicalRecordsService medicalRecordsService;

	private MedicalRecordsDTOConverter medicalRecordsDTOConverter;*/

	public PersonDTO() {
		super();
	}

	public PersonDTO(Long id, String firstName, String lastName, String phoneNumber, String email,
			Set<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;

	}

	public PersonDTO(String phoneNumber, String email, Set<Address> address) {

		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	/*public PersonDTO(Long id, String firstName, String lastName, String phoneNumber, String email, Set<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.medicalRecordsDTO = medicalRecordsDTO;
	}*/

	private Long id;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String email;

	private Set<Address> address = new HashSet<>();

	//private List<MedicalRecordsDTO> medicalRecordsDTO;

	
	  /*public void fetchMedicalRecords() { 
		  MedicalRecordsDTO mrs = medicalRecordsService.getMedicalRecordsByUserId(id); 
		  mrs.getBirthdate(); 
		  mrs.getMedications(); 
		  mrs.getAllergies();
	  
	  }
	 

	
	  public MedicalRecordsService getMedicalRecordsService() { 
		  return medicalRecordsService; 
	  }
	
	  public void setMedicalRecordsService(MedicalRecordsService medicalRecordsService) { 
		this.medicalRecordsService = medicalRecordsService;
	  }

	
	  public MedicalRecordsDTOConverter getMedicalRecordsDTOConverter() { 
		  return medicalRecordsDTOConverter; 
	  }
	
	  public void setMedicalRecordsDTOConverter(MedicalRecordsDTOConverter medicalRecordsDTOConverter) { 
			  this.medicalRecordsDTOConverter = medicalRecordsDTOConverter; 
	  }*/
			 

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public Set<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Set<Address> address) {
		this.address = address;
	}


}
