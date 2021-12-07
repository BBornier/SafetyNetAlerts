package com.safetynetalert.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medical_records")
public class MedicalRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicalRecordId;
	
	@Column(name = "medications")
	private List<Medications> medications;
	
	@Column (name = "allergies")
	private List<Allergies> allergies;
	
	@Column(name = "birthdate")
	private LocalDate birthdate;

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
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
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

	public MedicalRecords() {
		super();
	}

	public MedicalRecords(int id, LocalDate birthdate, List<Medications> medications, List<Allergies> allergies) {
		super();
		this.medicalRecordId = id;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}


}
