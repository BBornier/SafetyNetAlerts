package com.safetynetalert.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medical_records")
public class MedicalRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicalRecordId;

	@OneToOne
	private Person person;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Column(name = "medications")
	@OneToMany
	@JoinColumn(name = "Medical_Records_Id")
	private List<Medications> medications;

	@Column(name = "allergies")
	@OneToMany
	@JoinColumn(name = "Mediacal_Records_Id")
	private List<Allergies> allergies;

	/**
	 * @return the medicalRecordId
	 */
	public int getMedicalRecordId() {
		return medicalRecordId;
	}

	/**
	 * @param medicalRecordId the medicalRecordId to set
	 */
	public void setMedicalRecordId(int medicalRecordId) {
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

	public MedicalRecords(int medicalRecordId, Person person, LocalDate birthdate, List<Medications> medications,
			List<Allergies> allergies) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.person = person;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

}
