package com.safetynetalerts.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.safetynetalert.convertersdto.MedicalRecordsDTOConverter;
import com.safetynetalert.model.Address;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.service.MedicalRecordsService;

public class PersonDTO {
	
	private MedicalRecordsService medicalRecordsService;
	
	private MedicalRecordsDTOConverter medicalRecordsDTOConverter;
	
	
	public PersonDTO(Long id, String firstName, String lastName, String phoneNumber, String email, Set<Address> address) {
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
	

	public PersonDTO(Long id, String firstName, String lastName, String phoneNumber, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String email;
	
	private Set<Address> address = new HashSet<>();
	
	private List<MedicalRecordsDTO> medicalRecords;
	
	/*public void fetchMedicalRecords() {
		MedicalRecords mrs = medicalRecordsService.getMedicalRecordsByUserId(id);
		for (MedicalRecords mr : mrs) {
			medicalRecords.add(medicalRecordsDTOConverter.toDTO(mr));*/

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


	/**
	 * @return the medicalRecords
	 */
	public List<MedicalRecordsDTO> getMedicalRecords() {
		return medicalRecords;
	}


	/**
	 * @param medicalRecords the medicalRecords to set
	 */
	public void setMedicalRecords(List<MedicalRecordsDTO> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	

}
