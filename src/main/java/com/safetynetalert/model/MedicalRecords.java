package com.safetynetalert.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medical_records") // PAS DE MAJ !
public class MedicalRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicalRecordId;
	private String person;
	private String medications;
	private String allergies;

	/**
	 * @return the id
	 */
	public int getId() {
		return medicalRecordId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.medicalRecordId = id;
	}

	/**
	 * @return the person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(String person) {
		this.person = person;
	}

	/**
	 * @return the medications
	 */
	public String getMedications() {
		return medications;
	}

	/**
	 * @param medications the medications to set
	 */
	public void setMedications(String medications) {
		this.medications = medications;
	}

	/**
	 * @return the allergies
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public MedicalRecords() {
		super();
	}

	public MedicalRecords(int id, String person, String medications, String allergies) {
		super();
		this.medicalRecordId = id;
		this.person = person;
		this.medications = medications;
		this.allergies = allergies;
	}


}
