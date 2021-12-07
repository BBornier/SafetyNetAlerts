package com.safetynetalert.model;

import java.util.List;

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
	private Person person;
	private List<Medications> medications;
	private List<Allergies> allergies;

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

	public MedicalRecords() {
		super();
	}

	public MedicalRecords(int id, Person person, List<Medications> medications, List<Allergies> allergies) {
		super();
		this.medicalRecordId = id;
		this.person = person;
		this.medications = medications;
		this.allergies = allergies;
	}


}
