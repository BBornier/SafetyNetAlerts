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

	public MedicalRecordsDTO(Long medicalRecordId, String birthdate, List<Medications> medications, List<Allergies> allergies) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
		
	}
	
	
	private Long medicalRecordId;

	private Person person;

	private String birthdate;
	
	private List<Medications> medications;

	private List<Allergies> allergies;
	

	/**
	 * @return the medicalRecordId
	 */
	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	/**
	 * @param medicalRecordId the medicalRecordId to set
	 */
	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the medications
	 */
	public List<Medications> getMedications() {
		return medications;
	}

	/**
	 * @param medications the medications to set
	 */
	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

	/**
	 * @return the allergies
	 */
	public List<Allergies> getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}

}
