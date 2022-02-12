package com.safetynetalerts.dto;

import java.util.List;

import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;
import com.safetynetalert.model.Person;
import com.safetynetalert.service.MedicalRecordsService;

public class MedicalRecordsDTO {
	
	

	public MedicalRecordsDTO() {
		super();
	}

	public MedicalRecordsDTO(Long medicalRecordId, String birthdate) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.birthdate = birthdate;
	}

	public MedicalRecordsDTO(Long medicalRecordId, String firstName, String lastName, String birthdate, List<Medications> medications, List<Allergies> allergies) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
		
	}
	
	
	private Long medicalRecordId;
	
	private String firstName;
	
	private String lastName;

	//private Person person;

	private String birthdate;
	
	private List<Medications> medications;

	private List<Allergies> allergies;
	

	
	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	
	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*public Person getPerson() {
		return person;
	}

	
	public void setPerson(Person person) {
		this.person = person;
	}*/

	
	public String getBirthdate() {
		return birthdate;
	}

	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	
	public List<Medications> getMedications() {
		return medications;
	}

	
	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

	
	public List<Allergies> getAllergies() {
		return allergies;
	}

	
	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}

}
