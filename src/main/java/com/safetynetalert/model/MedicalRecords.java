package com.safetynetalert.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medical_records")
public class MedicalRecords {
	
	public MedicalRecords() {
		super();
	}

	public MedicalRecords(Person person, String birthdate, List<Medications> medications,
			List<Allergies> allergies) {
		super();
		this.person = person;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicalRecordId;

	@OneToOne
	@JsonIgnore
	private Person person;

	@Column(name = "birthdate")
	private String birthdate;

	@Column(name = "medications")
	@ElementCollection(targetClass = Medications.class)
	private List<Medications> medications;

	@Column(name = "allergies")
	@ElementCollection(targetClass = Allergies.class)
	private List<Allergies> allergies;

	
	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	
	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	
	public Person getPerson() {
		return person;
	}

	
	public void setPerson(Person person) {
		this.person = person;
	}

	
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

	@Override
	public String toString() {
		return "MedicalRecords [medicalRecordId=" + medicalRecordId + ", person=" + person + ", birthdate=" + birthdate
				+ ", medications=" + medications + ", allergies=" + allergies + "]";
	}

}
