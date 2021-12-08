package com.safetynetalert.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "allergies")
public class Allergies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergiesId;

	@Column(name = "name")
	private String name;

	@Column(name = "medicalRecords")
	private List<MedicalRecords> medications = new ArrayList<MedicalRecords>();

	/**
	 * @return the allergiesId
	 */
	@ManyToMany
	@JoinTable(name = "medical_records", joinColumns = { @JoinColumn(name = "allergiesId") }, inverseJoinColumns = { @JoinColumn(name = "medicationsId") })
	public int getAllergiesId() {
		return allergiesId;
	}

	/**
	 * @param allergiesId the allergiesId to set
	 */
	public void setAllergiesId(int allergiesId) {
		this.allergiesId = allergiesId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the medications
	 */
	public List<MedicalRecords> getMedications() {
		return medications;
	}

	/**
	 * @param medications the medications to set
	 */
	public void setMedications(List<MedicalRecords> medications) {
		this.medications = medications;
	}

	public Allergies() {
		super();
	}

	public Allergies(int allergiesId, String name, List<MedicalRecords> medications) {
		super();
		this.allergiesId = allergiesId;
		this.name = name;
		this.medications = medications;

	}

}
